package model;

import java.util.ArrayList;

public class Client implements Comparable<Client>{
	
	private int id;
	private int time;
	private ArrayList<Integer >gamesList;
	private Queue<Integer> sortedList;
	private Stack<Videogame> cart;
	
	public Client(int id, ArrayList<Integer> list) {
		this.id = id;
		this.gamesList = list;
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
	
	public int getId() {
		return id;
	}
	
	public ArrayList<Integer> getList(){
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
