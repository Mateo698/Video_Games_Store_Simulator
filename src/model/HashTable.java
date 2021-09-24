package model;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable<K,V> implements InterfaceHashTable<K, V>{
	private ArrayList<HashNode<K,V>> nodes;
	private int bucket;
	private int size;
	
	public HashTable() {
		nodes = new ArrayList<>();
		size = 0;
		bucket = 10;
		for (int i = 0; i < nodes.size(); i++) {
			nodes.add(null);
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public int hashCode(K key) {
		int code = Objects.hashCode(key);
		return code;
	}
	
	public int getIndex(K key) {
		int hashCode = hashCode(key);
		int index = hashCode % bucket;
        index = index < 0 ? index*-1 : index;
        return index;
	}
	
	@Override
	public void insert(K key, V value) throws Exception {
		int hashCode = hashCode(key);
		int index = getIndex(key);
		HashNode<K, V> head = nodes.get(index);
		HashNode<K,V> newNode = new HashNode<K, V>(key, value, hashCode);
		while(head != null) {
			if(head.getKey().equals(newNode.getKey()) && head.getCode() == hashCode) {
				return;
			}
			head = head.getNext();
		}
		head = nodes.get(index);
		size++;
		newNode.setNext(head);
		nodes.set(index, newNode);
		
		if((1.0*size)/bucket >= 0.7) {
			ArrayList<HashNode<K,V>> aux = nodes;
			nodes = new ArrayList<>();
			bucket*=2;
			size = 0;
			for (int i = 0; i < bucket; i++) {
				nodes.add(null);
			}
			for (HashNode<K,V> headNode : aux) {
				insert(headNode.getKey(),headNode.getValue());
				headNode = headNode.getNext();
			}
		}
		
		
		
	}

	@Override
	public V search(K key) {
		int bucketIndex = getIndex(key);
		int hashCode = hashCode(key);

		HashNode<K, V> head = nodes.get(bucketIndex);

		while (head != null) {
			if (head.getKey().equals(key) && head.getCode() == hashCode)
				return head.getValue();
			head = head.getNext();
		}
		return null;
	}

	@Override
	public V delete(K key) {
        int bucketIndex = getIndex(key);
        int hashCode = hashCode(key);
        // Get head of chain
        HashNode<K, V> head = nodes.get(bucketIndex);
 
        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.getKey().equals(key) && hashCode == head.getCode()) {
                break;
            }
            prev = head;
            head = head.getNext();
        }
        if (head == null) {
            return null;
        }
        size--;
        if (prev != null) {
            prev.setNext(head.getNext());
        }else {
            nodes.set(bucketIndex, head.getNext());
        }
        return head.getValue();
	}
	

}
