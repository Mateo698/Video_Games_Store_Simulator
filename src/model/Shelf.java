package model;

import java.util.ArrayList;

public class Shelf<K,V> {
	private K key;
	private V value;
	private int hashCode = 0;
	private ArrayList<Videogame> stock;
	private Shelf<K,V> next;
	
	public Shelf(K key, V value, int hasCode) {
		stock = new ArrayList<Videogame>();
		this.setKey(key);
		this.value = value;
		setHashCode(hasCode);
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



	public K getKey() {
		return key;
	}



	public void setKey(K key) {
		this.key = key;
	}



	public int getHashCode() {
		return hashCode;
	}



	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}



	public Shelf<K,V> getNext() {
		return next;
	}



	public void setNext(Shelf<K,V> next) {
		this.next = next;
	}
	
	
	
	
}
