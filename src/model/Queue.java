package model;

import java.util.ArrayList;

public class Queue<T> {
	private Node<T> first;
	
	public Queue() {
		first = null;
	}
	
	public int getSize() {
		int size = 0;
		if(first == null) {
			return size;
		}else {
			return first.size();
		}
	}
	
	public void add(T object) {
		if(first == null) {
			first = new Node<T>(object);
		}else {
			first.add(object);;
		}
	}
	
	public T poll() {
		if(first == null) {
			return null;
		}else {
			T object = first.getObject();
			first = first.getNext();
			return object;
		}
	}
	
	public T peek() {
		if(first == null) {
			return null;
		}else {
			return first.getObject();
		}
	}
	
	public ArrayList<T> toArrayList(){
		ArrayList<T> aux = new ArrayList<>();
		Node<T> nodAux = first;
		while(nodAux != null) {
			aux.add(nodAux.getObject());
			nodAux = nodAux.getNext();
		}
		return aux;
		
	}
	
}
