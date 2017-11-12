package com.goaway.farfar;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gamescreen extends ScreenAdapter {
    private GoAwayFarFar goaway;
    private Texture characterImg;
    
    public Gamescreen(GoAwayFarFar goaway) {
        this.goaway = goaway;
        characterImg = new Texture("vampire.png");
    }
    
    @Override
    public void render(float delta) {
        SpriteBatch batch = goaway.batch;
        batch.begin();
        batch.draw(characterImg, 100, 100);
        batch.end();
    }
}