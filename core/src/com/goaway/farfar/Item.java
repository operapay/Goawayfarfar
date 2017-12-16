package com.goaway.farfar;

import java.util.Random;
//import java.awt.Rectangle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Item {
	
    private Vector2 position;
    public static final int SPEED = 5;
    public static final int SPEED2 = 7;
    private Random number = new Random();
    public int width;
    public int height;
    private Rectangle rectangle;
    
    public Item(int x, int y) {
        position = new Vector2(x,y);
        width = 70;
        height = 70;
        rectangle = new Rectangle(x,y,width,height);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public Rectangle getRectangle() {
    	return rectangle;
    }
   
    public void move() { 
        position.x -= SPEED;
    }
    public void move2() { 
        position.x -= SPEED2;
    }
	public void gengarlic() {
    	position.x = 850;
    	position.y = number.nextInt(500);
	}
	public void genblood() {
    	position.x = 800;
    	position.y = number.nextInt(500);
	}
}
