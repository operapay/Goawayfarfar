package com.goaway.farfar;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Gamescreen extends ScreenAdapter {
    private GoAwayFarFar goaway;
    private Texture characterImg;
    private Texture tridentImg;
    private Texture turtleImg;
    private Texture downtridentImg;
    private int x;
    private int y;
    private Random tridentvy = new Random();
    private int delta_y;
    private int delta_y2;
    private int charspeed;
    private Item item;
    private Trident trident;
    private Trident downtrident;
    
    public Gamescreen(GoAwayFarFar goaway) {
        this.goaway = goaway;
        turtleImg = new Texture("turtle.png");
        item = new Item(500,100);
        trident = new Trident(250,-50);
        downtrident = new Trident(200,450);
        characterImg = new Texture("vampire.png");
        tridentImg = new Texture("trident.png");
        downtridentImg = new Texture("downtrident.png");
        x = 0;
        y = 0;
        //x1 = 250;
        //x2 = 200;
        //y1 = -50;
       // y2 = 450;
        charspeed = 8;
        //speed = 2;
        //speed2 = 3;
    }    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //checkcharecter
        if(x<0 || x>700) {
        	charspeed *= -1;
        }
        if(y<0 || y>500) {
        	charspeed *= -1;
        }
        //checktrident
        /*
    	y1 += speed;
        if(y1>=0) {
        	speed *= -1;
        }
        if(y1<-100) {
        	speed *= -1;
        }
    	y2 -= speed2;
        if(y2<350) {
        	speed2 *= -1;
        }
        if(y2>500) {
        	speed2 *= -1;
        }*/
    	update(delta);
        SpriteBatch batch = goaway.batch;
        batch.begin();
        Vector2 pos = item.getPosition();
        Vector2 posup = trident.getPosition();
        Vector2 posdown = downtrident.getPosition();
        batch.draw(turtleImg, pos.x, pos.y);
        batch.draw(characterImg, x, y);
        for(int i=0;i<4;i++) {
        	batch.draw(tridentImg,posup.x*i,posup.y);
        	batch.draw(downtridentImg,posdown.x*i,posdown.y);
        }
        batch.end();
    }
    
    private void update(float delta) {
        Vector2 posup = trident.getPosition();
        Vector2 posdown = downtrident.getPosition();
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            x -= charspeed;
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            x += charspeed;
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            y -= charspeed;
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            y += charspeed;
        }
        item.move();
        if(posup.y<=-50) {
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
        posdown.y += delta_y2;
    }
}