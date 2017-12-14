package com.goaway.farfar;

public class World {
	private GoAwayFarFar goaway;
    private Charecter charecter;
	private Item item;
	private Trident trident;
	
	World(GoAwayFarFar goaway){
		this.goaway = goaway;
		charecter = new Charecter(330,200);
	}
	Charecter getCharecter() {
		return charecter;
	}
}
