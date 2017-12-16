package com.goaway.farfar;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
    private Texture heartImg;
    private Texture heart2Img;
    private Texture heart3Img;
    WorldRenderer worldrenderer;
    private BitmapFont font;
    
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
        heartImg = new Texture("like.png");
        heart2Img = new Texture("like.png");
        heart3Img = new Texture("like.png");
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
        Heart posheart = world.getHeart();
        Heart posheart2 = world.getHeart2();
        if(poschar.getPosition().y<0 || poschar.getPosition().y>500) {
        	Charecter.SPEED *= -1;
        }
        if(poschar.getPosition().x<0 || poschar.getPosition().x>700) {
        	Charecter.SPEED *= -1;
        }
        batch.draw(backgroundImg, 0, 100);
        if(world.gameState == 0) {
        	batch.draw(heart3Img,750,550);
        	batch.draw(heartImg,posheart.getPosition().x,posheart.getPosition().y);
        	batch.draw(heart2Img,posheart2.getPosition().x,posheart2.getPosition().y);
	        batch.draw(garlicImg, positiongarlic.getPosition().x, positiongarlic.getPosition().y,positiongarlic.width,positiongarlic.height);
	        batch.draw(bloodImg, positionblood.getPosition().x, positionblood.getPosition().y,positionblood.width,positionblood.height);
	        batch.draw(characterImg, poschar.getPosition().x, poschar.getPosition().y,poschar.width,poschar.height);
	    	batch.draw(tridentImg,posup.getPosition().x,posup.getPosition().y,posup.width,posup.height);
	    	batch.draw(trident2Img,posup2.getPosition().x,posup2.getPosition().y,posup2.width,posup2.height);
	    	batch.draw(downtridentImg,posdown.getPosition().x,posdown.getPosition().y,posdown.width,posdown.height);
	    	batch.draw(downtrident2Img,posdown2.getPosition().x,posdown2.getPosition().y,posdown2.width,posdown2.height);
	    	font.draw(batch, "score " + world.getScore(), 620, 70);
        }
		if(world.gameState == 1) {
			font.draw(batch, "GAMEOVER", 340,400);
			font.draw(batch, "highscore  " + world.getScore(),330,350);
			font.draw(batch, "Enter To Play Agian", 300,300);
		}
        batch.end();
	}
}
