package com.goaway.farfar;

import com.badlogic.gdx.math.Vector2;

public class Heart {
    private Vector2 position;
    
    public Heart(int x, int y) {
        position = new Vector2(x,y);
    }
    public Vector2 getPosition() {
    	return position;
    }
}
