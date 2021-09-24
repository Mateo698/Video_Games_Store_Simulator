package model;

import java.util.ArrayList;

public class Store {
	
	private Queue<Client> clientsQueue;
	private Queue<Client> leavingQueue;
	private ArrayList<Checker> checkers;
	private HashTable<Character, Shelf> shelfs;
	
	
	public Store() {}
	
	public void reset() {
		clientsQueue = new Queue<Client>();
		leavingQueue = new Queue<Client>();
		checkers = new ArrayList<Checker>();
		shelfs = new HashTable<Character,Shelf>();
	}
	
	public void setChecker(int amount) {
		for (int i = 0; i < amount; i++) {
			checkers.add(new Checker(this));
		}
	}
	
	public void setShelf(ArrayList<Character> ids, ArrayList<Shelf> values) throws Exception {
		for (int i = 0; i < ids.size(); i++) {
			shelfs.insert(ids.get(i), values.get(i));
		}
	}
	
	public void addClient(int id, ArrayList<Integer> gamesId) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < gamesId.size(); i++) {
			list.add(gamesId.get(i));
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
