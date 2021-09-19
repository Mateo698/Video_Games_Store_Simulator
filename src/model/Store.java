package model;

import java.util.ArrayList;

public class Store {
	
	private Queue<Client> clientsQueue;
	private Queue<Client> leavingQueue;
	private ArrayList<Checker> checkers;
	
	
	public Store() {}
	
	public void reset() {
		clientsQueue = new Queue<Client>();
		leavingQueue = new Queue<Client>();
		checkers = new ArrayList<Checker>();
	}
	
	public void setChecker(int amount) {
		for (int i = 0; i < amount; i++) {
			checkers.add(new Checker(this));
		}
	}
	
	public void setShelf() {
		//aqui va el codigo para iniciar estanterias
	}
	
	public void addClient(int id, int[] gamesId) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < gamesId.length; i++) {
			list.add(gamesId[i]);
		}
		clientsQueue.add(new Client(id,list));
	}
	
	public void addLeavingClient(Client cl) {
		leavingQueue.add(cl);
	}
	
	public Client getLeftClient() {
		return leavingQueue.poll();
	}
	
	public Client getNextClient() {
		return clientsQueue.poll();
	}

}
