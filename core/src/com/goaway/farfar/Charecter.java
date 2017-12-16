package com.goaway.farfar;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Charecter {
	
    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    private Vector2 position;
    public static int SPEED = 15;
    public int width;
    public int height;
    private Rectangle rectangle;
     
    public Charecter(int x, int y) {
        position = new Vector2(x,y);
        width = 110;
        height = 110;
        rectangle = new Rectangle(x,y,width,height);
    }   
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public Rectangle getRectangle() {
    	return rectangle;
    }
    
    private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    
    public void move(int dir) { 
        position.x += SPEED * DIR_OFFSETS[dir][0];
        position.y += SPEED * DIR_OFFSETS[dir][1];
        rectangle.setPosition(position.x,position.y);
    }
}
