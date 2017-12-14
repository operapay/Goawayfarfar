package com.goaway.farfar;

import java.util.Random;

public class World {
	private GoAwayFarFar goaway;
    private Charecter charecter;
	private Item garlic;
	private Item blood;
	private Trident trident;
    private Random number = new Random();
	
	World(GoAwayFarFar goaway){
		this.goaway = goaway;
		charecter = new Charecter(330,200);
		garlic = new Item(850,number.nextInt(500));
		blood = new Item(850,number.nextInt(500));
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
}
