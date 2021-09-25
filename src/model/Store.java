package model;

import java.util.ArrayList;
import java.util.Collections;

public class Store {
	
	private Queue<Client> clientsQueue;
	private Queue<Client> secondStage;
	private Queue<Client> thirdStage;
	private Queue<LeftClient> leavingQueue;
	private ArrayList<Checker> checkers;
	private HashTable<Character, Shelf> shelfs;
	private ArrayList<Character> shelfKeys;
	
	
	public Store() {}
	
	public void reset() {
		clientsQueue = new Queue<Client>();
		secondStage = new Queue<Client>();
		thirdStage = new Queue<Client>();
		leavingQueue = new Queue<LeftClient>();
		checkers = new ArrayList<Checker>();
		shelfs = new HashTable<Character,Shelf>();
		shelfKeys = new ArrayList<Character>();
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
	
	public void addClient(int id, ArrayList<Videogame> games) {
		clientsQueue.add(new Client(id,games));
	}
	
	public void addLeavingClient(LeftClient cl) {
		leavingQueue.add(cl);
	}
	
	public LeftClient getLeftClient() {
		return leavingQueue.poll();
	}
	
	public Client getNextClient() {
		return thirdStage.poll();
	}
	
	
	public void secondStage(int selected) {
		Queue<Client> secondStage = new Queue<Client>();
		Client currentClient = clientsQueue.poll();
		int time = 1;
		while(currentClient != null) {
			Queue<Integer> sortedList;
			if(selected == 1) {
				sortedList = selectionSort(currentClient.getList());
			}else {
				sortedList = insertionSort(currentClient.getList());
			}
			
			currentClient.setSorted(sortedList);
			currentClient.setTime(time);
			time++;
			secondStage.add(currentClient);
			currentClient = clientsQueue.poll();
		}
		this.secondStage = secondStage;
	}
	
	public void thirdStage() {
		ArrayList<Client> third = new ArrayList<>();
		Client currentClient = secondStage.poll();
		while(currentClient != null) {
			Integer code = currentClient.getSorted().poll();
			while(code != null) {
				boolean leave = false;
				for (int i = 0; i < shelfs.getSize() && !leave; i++) {
					if(shelfs.search(shelfKeys.get(i)).hasGame(code) && shelfs.search(shelfKeys.get(i)).hasStock(code)) {
						currentClient.addGame(shelfs.search(shelfKeys.get(i)).takeGame(code));
						leave = true;
					}
				}
				code = currentClient.getSorted().poll();
			}
			third.add(currentClient);
			currentClient = secondStage.poll();
		}
		
		Collections.sort(third);
		Queue<Client> thirdStage = new Queue<Client>();
		for (int i = 0; i < third.size(); i++) {
			thirdStage.add(third.get(i));
		}
		this.thirdStage = thirdStage;
	}
	
	public void checkers() {
		boolean leave = false;
		while(thirdStage.getSize() != 0) {
			for (int i = 0; i < checkers.size() && !leave; i++) {
				if(thirdStage.peek() == null) {
					leave = true;
				}else {
					checkers.get(i).advance();
				}
			}
		}
		leave = false;
		for (int i = 0; i < checkers.size(); i++) {
			if(checkers.get(i).getClient() == null) {
				checkers.remove(i);
			}
		}
		while(checkers.size() != 0) {
			for (int i = 0; i < checkers.size(); i++) {
				if(checkers.get(i).getClient() == null) {
					checkers.remove(i);
				}else {
					checkers.get(i).advance();
				}
			}
		}
	}
	
	

	private Queue<Integer> selectionSort(ArrayList<Videogame> list) {
		int n = list.size();
        for (int i = 0; i < n-1; i++)        {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
            	if (list.get(j).getPlace() < list.get(min_idx).getPlace()) {
            		min_idx = j;
            	}
            }
            Videogame temp = list.get(min_idx);
            list.set(min_idx, list.get(i));
            list.set(i, temp);
        }
        Queue<Integer> sorted = new Queue<Integer>();
        for (int i = 0; i < list.size(); i++) {
			sorted.add(list.get(i).getCode());
		}
        return sorted;
	}

	private Queue<Integer> insertionSort(ArrayList<Videogame> list) {
		int n = list.size();
        for (int i = 1; i < n; ++i) {
            Videogame key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getPlace() > key.getPlace()) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1,key);
        }
        Queue<Integer> sorted = new Queue<Integer>();
        for (int i = 0; i < list.size(); i++) {
			sorted.add(list.get(i).getCode());
		}
        return sorted;	
	}

}
