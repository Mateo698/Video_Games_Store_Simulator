package model;

import java.util.ArrayList;

public class Client {
	
	private int id;
	private int time;
	private ArrayList<Integer >gamesList;
	private Stack<Videogame> cart;
	
	public Client(int id, ArrayList<Integer> list) {
		this.id = id;
		this.gamesList = list;
		cart = new Stack<Videogame>();
		time = 0;
	}
	
	public void addTime() {
		time++;
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
}
