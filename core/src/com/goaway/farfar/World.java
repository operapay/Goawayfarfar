package com.goaway.farfar;

import java.util.Random;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class World {
	private GoAwayFarFar goawayGame;
    private Charecter charecter;
	private Item garlic;
	private Item blood;
	private Trident trident;
	private Trident trident2;
	private Trident downtrident;
	private Trident downtrident2;
	private Heart heart;
	private Heart heart2;
    private Random number = new Random();
    private int score;
    private int time;
    private int count;
    public int gameState = 0;
	
	World(GoAwayFarFar goawayGame){
		this.setGoawayGame(goawayGame);
		charecter = new Charecter(330,200);
		garlic = new Item(850,number.nextInt(500));
		blood = new Item(850,number.nextInt(500));
        trident = new Trident(800,-10);
        trident2 = new Trident(800,-10);
        downtrident = new Trident(0,395);
        downtrident2 = new Trident(0,395);
        heart = new Heart(650,550);
        heart2 = new Heart(700,550);
	}
	public void resetWorld() {
		charecter.getPosition().set(330, 200);
		garlic.getPosition().set(850, number.nextInt(500));
		blood.getPosition().set(850, number.nextInt(500));
		trident.getPosition().set(800, -10);
		trident2.getPosition().set(800, -10);
		downtrident.getPosition().set(-100, 395);
		downtrident2.getPosition().set(-100, 395);
		heart.getPosition().set(650, 550);
		heart2.getPosition().set(700, 550);
		Charecter.SPEED = 12;
		score = 0;
		time = 0;
		count = 0;
	}
	public int getScore() {
		return score;
	}
    public void increaseScore() {
        score += 1;
    }
	Charecter getCharecter() {
		return charecter;
	}
	Item getGarlic() {
		return garlic;
	}
	Item getBlood() {
		return blood;
	}
	Trident getTrident() {
		return trident;
	}
	Trident getTrident2() {
		return trident2;
	}
	Trident getDowntrident() {
		return downtrident;
	}
	Trident getDowntrident2() {
		return downtrident2;
	}
	Heart getHeart() {
		return heart;
	}
	Heart getHeart2() {
		return heart2;
	}
	public GoAwayFarFar getGoawayGame() {
		return goawayGame;
	}
	public void setGoawayGame(GoAwayFarFar goawayGame) {
		this.goawayGame = goawayGame;
	}
	public void update(float delta) {
		time +=1;
    	Vector2 posup = trident.getPosition();
        Vector2 posup2 = trident2.getPosition();
        Vector2 posdown = downtrident.getPosition();
        Vector2 posdown2 = downtrident2.getPosition();
        if(time%500 == 150) {
        	garlic.gengarlic();
        }
        if((time%500)>150 & (time%500)<600) {
        	garlic.move();
        }
        if(time%500 == 250) {
        	blood.genblood();
        }
        if((time%500)>100 & (time%500)<600) {
        	blood.move2();
        }
        if(posup.x > -200) {
        	trident.move();
        }
    	if(posup2.x > -200) {
    		trident2.move();
    	}
    	if(posup2.x >= -300 && posup2.x <= -200)
        {
    		trident.genTrident();
        	trident2.genTrident2();
        }
    	if(posdown.x < 800)
    	{
    		downtrident.downmove();
    	}
    	if(posdown2.x < 800)
    	{
    		downtrident2.downmove();
    	}
    	if(posdown2.x >= 800 && posdown2.x <= 850)
        {
    		downtrident.genDowntrident();
        	downtrident2.genDowntrident2();
        }
    	if(Intersector.overlaps(charecter.getRectangle(),garlic.getRectangle()))
    	{
    		Charecter.SPEED -= 3;
    		if(Charecter.SPEED <= 3)
    		{
    			Charecter.SPEED = 3;
    		}
    		garlic.gengarlic();
    		
    	}
    	if(Intersector.overlaps(charecter.getRectangle(),blood.getRectangle()))
    	{
    		Charecter.SPEED += 4;
    		if(Charecter.SPEED >= 20)
    		{
    			Charecter.SPEED = 20;
    		}
    		blood.genblood(); 		
    	} 
    	if(Intersector.overlaps(charecter.getRectangle(),trident.getRectangle()) || 
    	   Intersector.overlaps(charecter.getRectangle(),trident2.getRectangle()) || 
    	   Intersector.overlaps(charecter.getRectangle(),downtrident.getRectangle()) || 
    	   Intersector.overlaps(charecter.getRectangle(),downtrident2.getRectangle()))
    	{
    		count++;
    		if(count>=20 && count<=40)
    			heart.getPosition().set(800,600);
    		if(count>=45 && count<=65)
    			heart2.getPosition().set(800,600);
    	}
    	if(count>=85) {
    		gameState = 1;
    	}
	}
}
