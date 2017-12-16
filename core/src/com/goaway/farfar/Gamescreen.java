package com.goaway.farfar;

//import java.awt.Rectangle;

//import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
    World world;
    WorldRenderer worldRenderer;
    private GoAwayFarFar goawayGame;
    private Charecter charecter;
    private int time;
    //private Random times = new Random();
    private Item garlic;
    private Item blood;
    private Trident trident;
    private Trident trident2;
    private Trident downtrident;
    private Trident downtrident2;
    
    public GameScreen(GoAwayFarFar goawayGame) {
        this.setGoawayGame(goawayGame);
        world = new World(goawayGame);
        worldRenderer = new WorldRenderer(goawayGame, world);
        
        charecter = world.getCharecter();
        garlic = world.getGarlic();
        blood = world.getBlood();
        trident = world.getTrident();
        trident2 = world.getTrident2();
        downtrident = world.getDowntrident();
        downtrident2 = world.getDowntrident2();
    }    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	update(delta);
    	worldRenderer.render(delta);
    }
    
    private void update(float delta) {
    	time += 1;
    	world.increaseScore();
    	Vector2 posup = world.getTrident().getPosition();
        Vector2 posup2 = world.getTrident2().getPosition();
        Vector2 posdown = world.getDowntrident().getPosition();
        Vector2 posdown2 = world.getDowntrident2().getPosition();
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
        	charecter.move(Charecter.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
        	charecter.move(Charecter.DIRECTION_UP);
        }
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
        	charecter.move(Charecter.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	charecter.move(Charecter.DIRECTION_RIGHT);
        }
        if(time%500 == 150) {
        	garlic.gengarlic();
        }
        if((time%500)>300 & (time%500)<500) {
        	garlic.move();
        }
        if(time%500 == 250) {
        	blood.genblood();
        }
        if((time%500)>100 & (time%500)<500) {
        	blood.move2();
        }
        if(posup.x > -200) {
        	trident.move();
        }
    	if(posup2.x > -200) {
    		trident2.move();
    	}
    	if(posup2.x >= -300 && posup2.x <= -200)
        {
    		trident.genTrident();
        	trident2.genTrident2();
        }
    	if(posdown.x < 800)
    	{
    		downtrident.downmove();
    	}
    	if(posdown2.x < 800)
    	{
    		downtrident2.downmove();
    	}
    	if(posdown2.x >= 800 && posdown2.x <= 850)
        {
    		downtrident.genDowntrident();
        	downtrident2.genDowntrident2();
        }
    	if(Intersector.overlaps(charecter.getRectangle(),garlic.getRectangle()))
    	{
    		System.out.println("slow");
    		Charecter.SPEED *= 0.5;
    	}
    	if(Intersector.overlaps(charecter.getRectangle(),blood.getRectangle()))
    	{
    		System.out.println("speed");
    		Charecter.SPEED *= 2;
    	}
    	if(Intersector.overlaps(garlic.getRectangle(),charecter.getRectangle()))
    	{
    		System.out.println("slow");
    		Charecter.SPEED *= 0.5;
    	}
    	if(Intersector.overlaps(blood.getRectangle(),charecter.getRectangle()))
    	{
    		System.out.println("speed");
    		Charecter.SPEED *= 2;
    	}
    }
	public GoAwayFarFar getGoawayGame() {
		return goawayGame;
	}
	public void setGoawayGame(GoAwayFarFar goawayGame) {
		this.goawayGame = goawayGame;
	}
}