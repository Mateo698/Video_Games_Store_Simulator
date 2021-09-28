package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class VideoGameSimulationTest {
	
	Store store;
	Client client;
	Shelf shelf;
	Videogame game1, game2, game3, game4, game5;
	ArrayList<Videogame> games = new ArrayList<>();
	ArrayList<Videogame> videogames = new ArrayList<>();
	HashTable<Character, Shelf> hash;
	
	public void scenary1() {
		store = new Store();
		//client = new Client(5678, videogames);
	}

	@Test
	public void testAddShelf() {
		scenary1();
		game1= new Videogame(8765, 1, 34000);
		game2= new Videogame(32145, 3, 28000);
		game3= new Videogame(6753, 2, 73000);
		game4= new Videogame(8900, 6, 50000);
		game5= new Videogame(1234, 1, 90000);
		games.add(game1);
		games.add(game2);
		games.add(game3);
		games.add(game4);
		games.add(game5);
		//String message = store.addNewUser(user.getNameUser(), user.getPassword());
		String msg = "The person was added succesfully";
		//assertEquals(message, msg);
	}

}
