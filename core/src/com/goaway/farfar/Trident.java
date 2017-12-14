package com.goaway.farfar;

import java.util.Random;
import com.badlogic.gdx.math.Vector2;

public class Trident {
    private Vector2 position;
    private Random tridentvy = new Random();
    public Trident(int x,int y) {
        position = new Vector2(x,y);
    }
    public Vector2 getPosition() {
        return position;    
    }
	public void moveUp() {
		//position.y += 5;
		position.x += tridentvy.nextInt(10);
	}
	public void moveDown() {
		//position.y += 5;
		position.x += -(tridentvy.nextInt(10));
	}
}
