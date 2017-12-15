package com.goaway.farfar;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Trident {
    private Vector2 position;
    public static final int SPEED = 7;
    private Random times = new Random();
    public int width;
    public int height;
    
    public Trident(int x,int y) {
        position = new Vector2(x,y);
        width = 220;
        height = 250;
    }
    public Vector2 getPosition() {
        return position;    
    }
	public void move() {
		position.x -= SPEED;
	}
	public void downmove() {
		position.x += SPEED;
	}
	public void genTrident() {
		position.x = 800;
	}
	public void genTrident2() {
		position.x = 1050 + (times.nextInt(250));
	}
	public void genDowntrident() {
		position.x = -200;
	}
	public void genDowntrident2() {
		position.x = -450-(times.nextInt(250));
	}
}
