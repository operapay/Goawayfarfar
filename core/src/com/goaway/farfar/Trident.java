package com.goaway.farfar;

import java.util.Random;
import com.badlogic.gdx.math.Vector2;

public class Trident {
    private Vector2 position;
    public static final int SPEED = 7;
    public Trident(int x,int y) {
        position = new Vector2(x,y);
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
}
