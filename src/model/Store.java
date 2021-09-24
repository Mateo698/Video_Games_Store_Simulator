package model;

import java.util.ArrayList;
import java.util.Iterator;

import org.omg.CosNaming.NamingContextPackage.NotFoundReasonHolder;

public class Store {
	
	private Queue<Client> clientsQueue;
	private Queue<Client> leavingQueue;
	private ArrayList<Checker> checkers;
	private HashTable<Character, Shelf> shelfs;
	private ArrayList<Character> shelfKeys;
	
	
	public Store() {}
	
	public void reset() {
		clientsQueue = new Queue<Client>();
		leavingQueue = new Queue<Client>();
		checkers = new ArrayList<Checker>();
		shelfs = new HashTable<Character,Shelf>();
		shelfKeys = new ArrayList<Character>()	;
		}
	
	public void setChecker(int amount) {
		for (int i = 0; i < amount; i++) {
			checkers.add(new Checker(this));
		}
	}
	
	public void setShelf(ArrayList<Character> ids, ArrayList<Shelf> values) throws Exception {
		shelfKeys = ids;
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
	
	public void startSimulation() {
		Queue<Client> secondStage = new Queue<Client>();
		Client currentClient = clientsQueue.poll();
		int time = 1;
		while(currentClient != null) {
			Queue<Integer> sortedList = sortList(currentClient.getList());
			currentClient.setSorted(sortedList);
			currentClient.setTime(time);
			time++;
			secondStage.add(currentClient);
			currentClient = clientsQueue.poll();
		}
		
		//Second stage
		ArrayList<Client> secondStageClients = new ArrayList<Client>();
		for (int i = 0; i < secondStage.getSize(); i++) {
			currentClient = secondStage.poll();
			
		}
	}

	private Queue<Integer> sortList(ArrayList<Integer> list) {
		Queue<Integer> sorted = new Queue<>();
		for (int i = shelfKeys.size()-1; i >= 0; i--) {
			for (int j = 0; j < list.size(); j++) {
				if(shelfs.search(shelfKeys.get(i)).hasGame(list.get(j))){
					sorted.add(list.get(j));
					list.remove(j);
				}
			}
		}
		return sorted;
	}

}
