package model;

import java.util.ArrayList;

public class Shelf {
	
	//Preguntar profe si las estanterias tienen niveles vacios
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
	
}
