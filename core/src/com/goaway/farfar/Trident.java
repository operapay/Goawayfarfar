package com.goaway.farfar;

import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Trident {
    private Vector2 position;
    public static final int SPEED = 7;
    private Random times = new Random();
    public int width;
    public int height;
    private Rectangle rectangle;
    
    public Trident(int x,int y) {
        position = new Vector2(x,y);
        width = 140;
        height = 260;
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
		rectangle.setPosition(position.x, position.y);
	}
	public void downmove() {
		position.x += SPEED;
		rectangle.setPosition(position.x, position.y);
	}
	public void genTrident() {
		position.x = 800;
		rectangle.setPosition(position.x, position.y);
	}
	public void genTrident2() {
		position.x = 1050 + (times.nextInt(250));
		rectangle.setPosition(position.x, position.y);
	}
	public void genDowntrident() {
		position.x = -200;
		rectangle.setPosition(position.x, position.y);
	}
	public void genDowntrident2() {
		position.x = -450-(times.nextInt(250));
		rectangle.setPosition(position.x, position.y);
	}
}
