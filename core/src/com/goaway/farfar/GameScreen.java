package com.goaway.farfar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {
    World world;
    WorldRenderer worldRenderer;
    private GoAwayFarFar goawayGame;
    private Charecter charecter;
    
    public GameScreen(GoAwayFarFar goawayGame) {
        this.setGoawayGame(goawayGame);
        world = new World(goawayGame);
        worldRenderer = new WorldRenderer(goawayGame, world);
        charecter = world.getCharecter();
    }    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	update(delta);
    	worldRenderer.render(delta);
    	world.update(delta);
    	if(world.gameState == 0) {
    		world.increaseScore();
    	}
    }
    
    private void update(float delta) {
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
        	charecter.move(Charecter.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
        	charecter.move(Charecter.DIRECTION_UP);
        }
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
        	charecter.move(Charecter.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	charecter.move(Charecter.DIRECTION_RIGHT);
        }
        if(Gdx.input.isKeyPressed(Keys.ENTER)) {
        	world.gameState = 0;
        	world.resetWorld();
        } 
    }
	public GoAwayFarFar getGoawayGame() {
		return goawayGame;
	}
	public void setGoawayGame(GoAwayFarFar goawayGame) {
		this.goawayGame = goawayGame;
	}
}