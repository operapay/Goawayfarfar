package com.goaway.farfar;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

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
        Vector2 poschar = world.getCharecter().getPosition();
        Vector2 positiongarlic = world.getGarlic().getPosition();
        Vector2 positionblood = world.getBlood().getPosition();
        Trident posup = world.getTrident();
        Trident posup2 = world.getTrident2();
        Trident posdown = world.getDowntrident();
        Trident posdown2 = world.getDowntrident2();
        if(poschar.y<0 || poschar.y>500) {
        	Charecter.SPEED *= -1;
        }
        batch.draw(backgroundImg, 0, 100);
        batch.draw(garlicImg, positiongarlic.x, positiongarlic.y);
        batch.draw(bloodImg, positionblood.x, positionblood.y);
        batch.draw(characterImg, poschar.x, poschar.y);
    	batch.draw(tridentImg,posup.getPosition().x,posup.getPosition().y,posup.width,posup.height);
    	batch.draw(trident2Img,posup2.getPosition().x,posup2.getPosition().y,posup2.width,posup2.height);
    	batch.draw(downtridentImg,posdown.getPosition().x,posdown.getPosition().y,posdown.width,posdown.height);
    	batch.draw(downtrident2Img,posdown2.getPosition().x,posdown2.getPosition().y,posdown2.width,posdown2.height);
    	font.draw(batch, "score " + world.getScore(), 620, 70);
        batch.end();
	}
}
