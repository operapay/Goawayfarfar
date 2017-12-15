package com.goaway.farfar;

import java.util.Random;

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
	public GoAwayFarFar getGoawayGame() {
		return goawayGame;
	}
	public void setGoawayGame(GoAwayFarFar goawayGame) {
		this.goawayGame = goawayGame;
	}
}
