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
    private Random number = new Random();
    private int score;
    private int time;
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
        score = 0;
	}
	Charecter getCharecter() {
		return charecter;
	}
	public int getScore() {
		return score;
	}
    public void increaseScore() {
        score += 1;
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
	public boolean overlap() {
		if(trident.getPosition().x + trident.width > charecter.getPosition().x ||
		downtrident.getPosition().x < charecter.getPosition().x + charecter.width ||
		trident2.getPosition().x + trident2.width > charecter.getPosition().x ||
		downtrident2.getPosition().x < charecter.getPosition().x + charecter.width ||
		trident.getPosition().y + trident.height > charecter.getPosition().y ||
		downtrident.getPosition().y < charecter.getPosition().x + charecter.height ||
		trident2.getPosition().y + trident2.height > charecter.getPosition().y ||
		downtrident2.getPosition().y < charecter.getPosition().x + charecter.height) {
			return false;
		}
		else
			return true;
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
        if((time%500)>300 & (time%500)<500) {
        	garlic.move();
        }
        if(time%500 == 250) {
        	blood.genblood();
        }
        if((time%500)>100 & (time%500)<500) {
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
    		Charecter.SPEED = 5;
    		garlic.gengarlic();
    	}
    	if(Intersector.overlaps(charecter.getRectangle(),blood.getRectangle()))
    	{
    		Charecter.SPEED = 20;
    		blood.genblood();
    	} 
    	/*if(Intersector.overlaps(charecter.getRectangle(),trident.getRectangle()))
    	{
    		gameState = 1;
    	}
    	if(Intersector.overlaps(charecter.getRectangle(),trident2.getRectangle()))
    	{
    		gameState = 1;
    	} 
    	if(Intersector.overlaps(charecter.getRectangle(),downtrident.getRectangle()))
    	{
    		gameState = 1;
    	}
    	if(Intersector.overlaps(charecter.getRectangle(),downtrident.getRectangle()))
    	{
    		gameState = 1;
    	} */
    	if(!(overlap())) {
    		System.out.println("hit!");
    		gameState = 1;
    	}
	}
}
