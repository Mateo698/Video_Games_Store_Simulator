package model;

public class Stack <T>{
	private Node<T> last;
	
	public Stack() {
	}
	
	public void push(T newOb) {
		if(last == null) {
			last = new Node<T>(newOb);
		}else {
			Node<T> newLast = new Node<T>(newOb);
			newLast.setNext(last);
			last = newLast;
		}
	}
	
	public T pop() {
		if(last == null) {
			return null;
		}else {
			T pop = last.getObject();
			last = last.getNext();
			return pop;
		}
	}
	
	public T peek() {
		if(last == null) {
			return null;
		}else {
			return last.getObject();
		}
	}
	
	public int size() {
		int size = 0;
		if (last == null) {
			return size;
		}else {
			return last.size();
		}
	}
}
