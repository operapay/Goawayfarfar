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
    private Texture characterImg;
    private Texture tridentImg;
    private Texture trident2Img;
    private Texture turtleImg;
    private Texture rocketImg;
    private Texture downtridentImg;
    private Texture downtrident2Img;
    private int x;
    private int y;
    private int time;
    private int timesrandom;
    private Random tridentvy = new Random();
    private Random times = new Random();
    private Random turtleY = new Random();
    private Random rocketY = new Random();
    private int charSpeed;
    private Item turtle;
    private Item rocket;
    private Trident trident;
    private Trident trident2;
    private Trident downtrident;
    private Trident downtrident2;
    
    public GameScreen(GoAwayFarFar goaway) {
        this.goaway = goaway;
        turtleImg = new Texture("turtle.png");
        rocketImg = new Texture("rocket.png");
        turtle = new Item(850,turtleY.nextInt(500));
        rocket = new Item(850,rocketY.nextInt(500));
        trident = new Trident(800,-10);
        trident2 = new Trident(800,-10);
        downtrident = new Trident(0,360);
        downtrident2 = new Trident(0,360);
        characterImg = new Texture("vampire.png");
        tridentImg = new Texture("trident.png");
        trident2Img = new Texture("trident.png");
        downtridentImg = new Texture("downtrident.png");
        downtrident2Img = new Texture("downtrident.png");
        x = 350;
        y = 200;
        charSpeed = 12;
    }    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(y<0 || y>500) {
        	charSpeed *= -1;
        }
    	update(delta);
        SpriteBatch batch = goaway.batch;
        batch.begin();
        Vector2 positionturtle = turtle.getPosition();
        Vector2 positionrocket = rocket.getPosition();
        Vector2 posup = trident.getPosition();
        Vector2 posup2 = trident2.getPosition();
        Vector2 posdown = downtrident.getPosition();
        Vector2 posdown2 = downtrident2.getPosition();
        batch.draw(turtleImg, positionturtle.x, positionturtle.y);
        batch.draw(rocketImg, positionrocket.x, positionrocket.y);
        batch.draw(characterImg, x, y);
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
        Vector2 positionturtle = turtle.getPosition();
        Vector2 positionrocket = rocket.getPosition();
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            y -= charSpeed;
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            y += charSpeed;
        }
        if(time%500 == 150) {
        	positionturtle.x = 850;
        	positionturtle.y = turtleY.nextInt(500);
        }
        if((time%500)>300 & (time%500)<500) {
        	turtle.move();
        }
        if(time%500 == 250) {
        	positionrocket.x = 800;
        	positionrocket.y = rocketY.nextInt(500);
        }
        if((time%500)>100 & (time%500)<500) {
        	rocket.move2();
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
    	System.out.println(posdown.x);
    	System.out.println(posdown2.x);
    	System.out.println("------");
    }
}