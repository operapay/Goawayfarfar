package com.goaway.farfar;

//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Rectangle;

public class WorldRenderer {
	private World world;
	private GoAwayFarFar goaway;
    private Texture characterImg;
    private Texture tridentImg;
    private Texture trident2Img;
    private Texture garlicImg;
    private Texture bloodImg;
    private Texture downtridentImg;
    private Texture downtrident2Img;
    private Texture backgroundImg;
    WorldRenderer worldrenderer;
    private BitmapFont font;
    //private int gameState;
    
    public WorldRenderer(GoAwayFarFar goaway, World world) {
    	this.goaway = goaway;
    	this.world = world;
    	font = new BitmapFont();
    	font.getData().setScale(2);
    	
        garlicImg = new Texture("garlic.png");
        bloodImg = new Texture("blood.png");
        characterImg = new Texture("vampire.png");
        tridentImg = new Texture("trident.png");
        trident2Img = new Texture("trident.png");
        downtridentImg = new Texture("downtrident.png");
        downtrident2Img = new Texture("downtrident.png");
        backgroundImg = new Texture("2.jpg");
    }
	public void render (float delta) {
        SpriteBatch batch = goaway.batch;
        batch.begin();
        Charecter poschar = world.getCharecter();
        Item positiongarlic = world.getGarlic();
        Item positionblood = world.getBlood();
        Trident posup = world.getTrident();
        Trident posup2 = world.getTrident2();
        Trident posdown = world.getDowntrident();
        Trident posdown2 = world.getDowntrident2();
        if(poschar.getPosition().y<0 || poschar.getPosition().y>500) {
        	Charecter.SPEED *= -1;
        }
        if(poschar.getPosition().x<0 || poschar.getPosition().x>700) {
        	Charecter.SPEED *= -1;
        }
        batch.draw(backgroundImg, 0, 100);
        batch.draw(garlicImg, positiongarlic.getPosition().x, positiongarlic.getPosition().y,positiongarlic.width,positiongarlic.height);
        batch.draw(bloodImg, positionblood.getPosition().x, positionblood.getPosition().y,positionblood.width,positionblood.height);
        batch.draw(characterImg, poschar.getPosition().x, poschar.getPosition().y,poschar.width,poschar.height);
    	batch.draw(tridentImg,posup.getPosition().x,posup.getPosition().y,posup.width,posup.height);
    	batch.draw(trident2Img,posup2.getPosition().x,posup2.getPosition().y,posup2.width,posup2.height);
    	batch.draw(downtridentImg,posdown.getPosition().x,posdown.getPosition().y,posdown.width,posdown.height);
    	batch.draw(downtrident2Img,posdown2.getPosition().x,posdown2.getPosition().y,posdown2.width,posdown2.height);
    	//batch.draw(new Rectangle(10,100,50,30));
    	font.draw(batch, "score " + world.getScore(), 620, 70);
		if(world.gameState == 1) {
			font.draw(batch, "gameOver", 320,300);
			font.draw(batch, "highscore  " + world.getScore(),300,250);
		}
        batch.end();
	}
}
