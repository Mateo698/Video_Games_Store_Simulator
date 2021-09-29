package model;

import java.util.ArrayList;

public class Client implements Comparable<Client>{
	
	private String id;
	private int time;
	private ArrayList<Videogame>gamesList;
	private Queue<Integer> sortedList;
	private Stack<Videogame> cart;
	
	public Client(String id, ArrayList<Videogame> list) {
		this.id = id;
		gamesList = list;
		cart = new Stack<Videogame>();
		time = 0;
		sortedList = null;
	}
	
	public void addTime() {
		time++;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public void addGame(Videogame game) {
		cart.push(game);
	}
	
	public Videogame getNextVideogame() {
		return cart.pop();
	}
	
	public String getId() {
		return id;
	}
	
	public ArrayList<Videogame> getList(){
		return gamesList;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setSorted(Queue<Integer> sort) {
		sortedList = sort;
	}
	
	public Queue<Integer> getSorted(){
		return sortedList;
	}

	@Override
	public int compareTo(Client o) {
		if(time>o.getTime()) {
			return 1;
		}else if(time<o.getTime()) {
			return -1;
		}else {
			return 0;
		}
	}
}
