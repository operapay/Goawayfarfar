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
    private int y;
    
    public Gamescreen(GoAwayFarFar goaway) {
        this.goaway = goaway;
        characterImg = new Texture("vampire.png");
        tridentImg = new Texture("trident.png");
        downtridentImg = new Texture("downtrident.png");
        x = 50;
        y = 50;
    }
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	//x += 5;
    	update(delta);
        SpriteBatch batch = goaway.batch;
        batch.begin();
        batch.draw(characterImg, x, y);
        batch.draw(tridentImg,100,0);
        batch.draw(downtridentImg,200,350);
        batch.end();
    }
    
    private void update(float delta) {
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            x -= 10;
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            x += 10;
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            y -= 10;
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            y += 10;
        }
    }
}