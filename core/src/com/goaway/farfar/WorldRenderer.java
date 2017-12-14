package com.goaway.farfar;

//import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
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
    
    public WorldRenderer(GoAwayFarFar goaway, World world) {
    	this.goaway = goaway;
    	this.world = world;
    	
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
        Vector2 posup = world.getTrident().getPosition();
        Vector2 posup2 = world.getTrident2().getPosition();
        Vector2 posdown = world.getDowntrident().getPosition();
        Vector2 posdown2 = world.getDowntrident2().getPosition();
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
}
