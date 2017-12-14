package com.goaway.farfar;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
    private GoAwayFarFar goaway;
    private Charecter charecter;
    World world;
    private Texture characterImg;
    private Texture tridentImg;
    private Texture trident2Img;
    private Texture garlicImg;
    private Texture bloodImg;
    private Texture downtridentImg;
    private Texture downtrident2Img;
    private Texture backgroundImg;
    private int time;
    private int timesrandom;
    private Random tridentvy = new Random();
    private Random times = new Random();
    private Random garlicY = new Random();
    private Random bloodY = new Random();
    private int charSpeed;
    private Item garlic;
    private Item blood;
    private Trident trident;
    private Trident trident2;
    private Trident downtrident;
    private Trident downtrident2;
    
    public GameScreen(GoAwayFarFar goaway) {
        this.goaway = goaway;
        world = new World(goaway);
        garlicImg = new Texture("garlic.png");
        bloodImg = new Texture("blood.png");
        garlic = new Item(850,garlicY.nextInt(500));
        blood = new Item(850,bloodY.nextInt(500));
        trident = new Trident(800,-10);
        trident2 = new Trident(800,-10);
        downtrident = new Trident(0,360);
        downtrident2 = new Trident(0,360);
        characterImg = new Texture("vampire.png");
        tridentImg = new Texture("trident.png");
        trident2Img = new Texture("trident.png");
        downtridentImg = new Texture("downtrident.png");
        downtrident2Img = new Texture("downtrident.png");
        backgroundImg = new Texture("2.jpg");
        charecter = world.getCharecter();
    }    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	update(delta);
        SpriteBatch batch = goaway.batch;
        batch.begin();
        Vector2 poschar = charecter.getPosition();
        Vector2 positiongarlic = garlic.getPosition();
        Vector2 positionblood = blood.getPosition();
        Vector2 posup = trident.getPosition();
        Vector2 posup2 = trident2.getPosition();
        Vector2 posdown = downtrident.getPosition();
        Vector2 posdown2 = downtrident2.getPosition();
        if(poschar.y<0 || poschar.y>500) {
        	Charecter.SPEED *= -1;
        }
        batch.draw(backgroundImg, 0, 100);
        batch.draw(garlicImg, positiongarlic.x, positiongarlic.y);
        batch.draw(bloodImg, positionblood.x, positionblood.y);
        batch.draw(characterImg, poschar.x, poschar.y);
    	batch.draw(tridentImg,posup.x,posup.y);
    	batch.draw(trident2Img,posup2.x,posup2.y);
    	batch.draw(downtridentImg,posdown.x,posdown.y);
    	batch.draw(downtrident2Img,posdown2.x,posdown2.y);
        batch.end();
    }
    
    private void update(float delta) {
    	time += 1;
        Vector2 posup = trident.getPosition();        
        Vector2 posup2 = trident2.getPosition();
        Vector2 posdown = downtrident.getPosition();
        Vector2 posdown2 = downtrident2.getPosition();
        Vector2 positiongarlic = garlic.getPosition();
        Vector2 positionblood = blood.getPosition();
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
        	charecter.move(Charecter.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
        	charecter.move(Charecter.DIRECTION_UP);
        } 
        if(time%500 == 150) {
        	positiongarlic.x = 850;
        	positiongarlic.y = garlicY.nextInt(500);
        }
        if((time%500)>300 & (time%500)<500) {
        	garlic.move();
        }
        if(time%500 == 250) {
        	positionblood.x = 800;
        	positionblood.y = bloodY.nextInt(500);
        }
        if((time%500)>100 & (time%500)<500) {
        	blood.move2();
        }
        if(posup.x > -200) {
        	trident.move();
        }
    	if(posup.x >= -300 && posup.x <= -200)
        {
        	posup.x = 700 + (times.nextInt(50));
        }
    	if(posup2.x > -200) {
    		trident2.move();
    	}
    	if(posup2.x >= -300 && posup2.x <= -200)
        {
        	posup2.x = 800 + (times.nextInt(100));
        }
    	if(posdown.x < 800)
    	{
    		downtrident.downmove();
    	}
    	if(posdown.x >= 800 && posdown.x <= 850)
        {
        	posdown.x = -100;
        }
    	if(posdown2.x < 800)
    	{
    		downtrident2.downmove();
    	}
    	if(posdown2.x >= 800 && posdown2.x <= 850)
        {
        	posdown2.x = -250;
        }
    }
}