package com.goaway.farfar;

import com.badlogic.gdx.math.Vector2;

public class Item {
	
    private Vector2 position;
    public static final int SPEED = 5;
    public static final int SPEED2 = 5;
    
    public Item(int x, int y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public void move() { 
        position.x -= SPEED;
    }
    public void move2() { 
        position.x -= SPEED2;
    }
}
