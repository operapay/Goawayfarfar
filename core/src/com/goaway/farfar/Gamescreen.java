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
    private Texture downtridentImg;
    private int x;
    private int y;
    private int time;
    private Random tridentvy = new Random();
    private Random turtleY = new Random();
    private int delta_y;
    private int delta_y2;
    private int charSpeed;
    private Item item;
    private Trident trident;
    private Trident downtrident;
    
    public GameScreen(GoAwayFarFar goaway) {
        this.goaway = goaway;
        turtleImg = new Texture("turtle.png");
        item = new Item(850,turtleY.nextInt(500));
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
    	time += 1;
        Vector2 posup = trident.getPosition();
        Vector2 posdown = downtrident.getPosition();
        Vector2 pos = item.getPosition();
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
        if((time%500)>200 & (time%500)<400) {
        	item.move();
        }
        if(pos.x<-150) {
        	pos.x = 850;
        	pos.y = turtleY.nextInt(500);
        }
        System.out.println(time);
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