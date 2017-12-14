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
    private Texture turtleImg;
    private Texture rocketImg;
    private Texture downtridentImg;
    private int x;
    private int y;
    private int time;
    private Random tridentvy = new Random();
    private Random turtleY = new Random();
    private Random rocketY = new Random();
    private int delta_y;
    private int delta_y2;
    private int charSpeed;
    private Item turtle;
    private Item rocket;
    private Trident trident;
    private Trident downtrident;
    
    public GameScreen(GoAwayFarFar goaway) {
        this.goaway = goaway;
        turtleImg = new Texture("turtle.png");
        rocketImg = new Texture("rocket.png");
        turtle = new Item(850,turtleY.nextInt(500));
        rocket = new Item(850,rocketY.nextInt(500));
        trident = new Trident(250,-50);
        downtrident = new Trident(200,450);
        characterImg = new Texture("vampire.png");
        tridentImg = new Texture("trident.png");
        downtridentImg = new Texture("downtrident.png");
        x = 0;
        y = 0;
        charSpeed = 8;
    }    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(x<0 || x>700) {
        	charSpeed *= -1;
        }
        if(y<0 || y>500) {
        	charSpeed *= -1;
        }
    	update(delta);
        SpriteBatch batch = goaway.batch;
        batch.begin();
        Vector2 positionturtle = turtle.getPosition();
        Vector2 positionrocket = rocket.getPosition();
        Vector2 posup = trident.getPosition();
        Vector2 posdown = downtrident.getPosition();
        batch.draw(turtleImg, positionturtle.x, positionturtle.y);
        batch.draw(rocketImg, positionrocket.x, positionrocket.y);
        batch.draw(characterImg, x, y);
        /*for(int i=0;i<4;i++) {
        	batch.draw(tridentImg,posup.x*i,posup.y);
        	batch.draw(downtridentImg,posdown.x*i,posdown.y);
        }*/
    	batch.draw(tridentImg,posup.x,posup.y);
    	batch.draw(downtridentImg,posdown.x,posdown.y);
        batch.end();
    }
    
    private void update(float delta) {
    	time += 1;
        Vector2 posup = trident.getPosition();
        Vector2 posdown = downtrident.getPosition();
        Vector2 positionturtle = turtle.getPosition();
        Vector2 positionrocket = rocket.getPosition();
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            x -= charSpeed;
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            x += charSpeed;
        }
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
        //System.out.println(time);
       /* if(posup.y<=-50) {
        	delta_y = tridentvy.nextInt(10);
        }
        if(posup.y>=0) {
        	delta_y = -(tridentvy.nextInt(10));
        }
        posup.y += delta_y;
        
		if(posdown.y<=350) {
        	delta_y2 = tridentvy.nextInt(10);
        }
        if(posdown.y>=450) {
        	delta_y2 = -(tridentvy.nextInt(10));
        }
        posdown.y += delta_y2;*/
        if(time%100 == 10) {
        trident.moveUp();
        downtrident.moveDown();
        }
    }
}