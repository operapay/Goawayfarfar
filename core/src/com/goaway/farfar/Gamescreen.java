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
    
    
    public Gamescreen(GoAwayFarFar goaway) {
        this.goaway = goaway;
        characterImg = new Texture("vampire.png");
        tridentImg = new Texture("trident.png");
        downtridentImg = new Texture("downtrident.png");
        x = 0;
        y = 0;
        x1 = 100;
        x2 = 200;
        y1 = -50;
        y2 = 450;
        speed = 2;
        speed2 = 2;
    }
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	y1 += speed;
        if(y1>=0) {
        	speed *= -1;
        	//y1*=-1;
        }
        if(y1<-100) {
        	speed *= -1;
    	//y1 += 1;
        }
    	y2 -= speed2;
        if(y2<350) {
        	speed2 *= -1;
        	//y1*=-1;
        }
        if(y2>500) {
        	speed2 *= -1;
    	//y1 += 1;
        }
    	System.out.println(y2);
    	update(delta);
        SpriteBatch batch = goaway.batch;
        batch.begin();
        batch.draw(characterImg, x, y);
        batch.draw(tridentImg,100,y1);
        batch.draw(downtridentImg,200,y2);
        batch.end();
    }
    
    private void update(float delta) {
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            x -= 5;
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            x += 5;
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            y -= 5;
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            y += 5;
        }
    }
}