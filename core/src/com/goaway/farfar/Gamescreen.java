package com.goaway.farfar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gamescreen extends ScreenAdapter {
    private GoAwayFarFar goaway;
    private Texture characterImg;
    private Texture tridentImg;
    private Texture downtridentImg;
    private int x;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int y;
    private int speed;
    private int speed2;
    private int charspeed;
    
    public Gamescreen(GoAwayFarFar goaway) {
        this.goaway = goaway;
        characterImg = new Texture("vampire.png");
        tridentImg = new Texture("trident.png");
        downtridentImg = new Texture("downtrident.png");
        x = 0;
        y = 0;
        x1 = 250;
        x2 = 200;
        y1 = -50;
        y2 = 450;
        charspeed = 8;
        speed = 2;
        speed2 = 3;
    }    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
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
        }
        //x1 = speed;
        //x2 += speed2;
    	System.out.println(y2);
    	update(delta);
        SpriteBatch batch = goaway.batch;
        batch.begin();
        batch.draw(characterImg, x, y);
        for(int i=0;i<4;i++) {
        	batch.draw(tridentImg,x1*i,y1);
        	batch.draw(downtridentImg,x2*i,y2);
        }
        batch.end();
    }
    
    private void update(float delta) {
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
        if(x<0) {
        	charspeed *= -1;
        }
        if(x>700) {
        	charspeed *= -1;
        }
        if(y<0) {
        	charspeed *= -1;
        }
        if(y>500) {
        	charspeed *= -1;
        }
    }
}