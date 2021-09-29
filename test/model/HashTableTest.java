package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HashTableTest {
	
	Store store;
	Shelf shelf1;
	Shelf shelf2;
	Shelf shelf3;
	Videogame game1, game2, game3, game4, game5;
	ArrayList<Videogame> games1 = new ArrayList<>();
	ArrayList<Videogame> games2 = new ArrayList<>();
	ArrayList<Videogame> videogames = new ArrayList<>();
	HashTable<Character, Shelf> hash;
	
	public void scenary1() throws Exception {
		shelf1 = new Shelf();
		shelf2 = new Shelf();
		shelf3 =new Shelf();
		hash = new HashTable<>();
		
		game1 = new Videogame(8765, 1, 34000);
		game2 = new Videogame(32145, 3, 28000);
		game3 = new Videogame(6753, 2, 73000);
		game4 = new Videogame(8900, 6, 50000);
		game5 = new Videogame(1234, 1, 90000);
		
		shelf1.addGame(game1);
		shelf1.addGame(game2);
		
		shelf2.addGame(game3);			
		shelf2.addGame(game4);	
		shelf2.addGame(game5);	

		shelf3.addGame(game1);
		shelf3.addGame(game2);		
		shelf3.addGame(game3);			
		shelf3.addGame(game4);	
		shelf3.addGame(game5);	

	}
	@Test
	public void addTest() throws Exception {
		scenary1();
		hash.insert('A', shelf1);
		hash.insert('B', shelf2);
		assertEquals(2,hash.getSize());
		
	}
	
	@Test
	public void searchTest() throws Exception {
		scenary1();
		hash.insert('A', shelf1);
		hash.insert('B', shelf2);
		Shelf shelf3= hash.search('A');
		assertEquals(shelf1,shelf3);
		shelf3= hash.search('B');
		assertEquals(shelf2,shelf3);
	}
	
	@Test
	public void searchTest2() throws Exception {
		scenary1();
		hash.insert('A', shelf1);
		hash.insert('B', shelf2);
		Shelf shelf3= hash.search('C');
		assertEquals(null,shelf3);
	}
	
	@Test
	public void deleteAndSearchTest() throws Exception {
		scenary1();
		hash.insert('A', shelf1);
		hash.insert('B', shelf2);
		hash.insert('C', shelf3);
		Shelf shelf4= hash.search('C');
		assertEquals(shelf3,shelf4);
		hash.delete('C');
		assertFalse(3==hash.getSize());
	}
	
	@Test
	public void getIndexTest() throws Exception {
		scenary1();
		hash.insert('A', shelf1);
		hash.insert('B', shelf2);
		hash.insert('C', shelf3);
		assertFalse(hash.getIndex('A')==hash.getIndex('B'));
		assertFalse(hash.getIndex('B')==hash.getIndex('C'));
		assertFalse(hash.getIndex('C')==hash.getIndex('A'));
	}
	
	@Test
	public void duplicatedKeyTest() throws Exception {
		scenary1();
		hash.insert('A', shelf1);
		hash.insert('B', shelf2);
		hash.insert('C', shelf3);
		hash.insert('C', shelf2);
		assertEquals(hash.search('C'),shelf3);
		assertTrue(hash.getSize()==3);
	}
	
}
