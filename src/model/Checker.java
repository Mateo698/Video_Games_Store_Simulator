package model;

import java.util.ArrayList;

public class Checker {
	private Client currentClient;
	private int purchase;
	private Store store;
	private ArrayList<Integer> gamesCodes;
	
	public Checker(Store s) {
		store = s;
		purchase = 0;
		gamesCodes = new ArrayList<Integer>();
	}
	
	public Client getClient() {
		return currentClient;
	}
	
	public void setClient(Client newC) {
		currentClient = newC;
	}
	
	public void advance() {
		if(currentClient == null) {
			currentClient = store.getNextClient();
		}else {
			Videogame game = currentClient.getNextVideogame();
			if(game != null) {
				purchase += game.getPrice();
				gamesCodes.add(game.getCode());
			}else {
				store.addLeavingClient(new LeftClient(currentClient.getId(),purchase,gamesCodes));
				purchase = 0;
				gamesCodes = new ArrayList<Integer>();
				currentClient = null;
			}
		}
	}
}
