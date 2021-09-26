package model;

import java.util.ArrayList;

public class Shelf {
	
	private ArrayList<Videogame> stock;
	
	public Shelf() {
		stock = new ArrayList<>();
	}
	
	public boolean hasGame(int gameCode) {
		boolean found = false;
		for (int i = 0; i < stock.size(); i++) {
			if(stock.get(i).getCode() == gameCode) {
				found = true;
			}
		}
		return found;
	}
	
	public boolean hasStock(int gameCode) {
		boolean hastock = false;
		for (int i = 0; i < stock.size() && !hastock; i++) {
			if(stock.get(i).getCode() == gameCode) {
				hastock = true;
			}
		}
		return hastock;
	}
	
	public Videogame takeGame(int code) {
		boolean leave = false;
		Videogame game = null;
		for (int i = 0; i < stock.size() && !leave; i++) {
			if(stock.get(i).getCode() == code) {
				game = stock.get(i);
				stock.get(i).setQuantity(stock.get(i).getQuantity()-1);
				leave = true;
			}
		}
		return game;
	}
	
}
