package model;

public class Checker {
	private Client currentClient;
	private int purchase;
	private Store store;
	
	public Checker(Store s) {
		store = s;
		purchase = 0;
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
			currentClient.getNextVideogame();
			if(true) {}
		}
	}
}
