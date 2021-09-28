package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class VideoGameSimulationTest {
	
	Store store;
	Client client1;
	Client client2;
	Checker checker1;
	Checker checker2;
	Shelf shelf1;
	Shelf shelf2;
	Videogame game1, game2, game3, game4, game5;
	ArrayList<Videogame> games1 = new ArrayList<>();
	ArrayList<Videogame> games2 = new ArrayList<>();
	ArrayList<Videogame> videogames = new ArrayList<>();
	HashTable<Character, Shelf> hash;
	
	public void scenary1() throws Exception {
		store = new Store();
		game1= new Videogame(8765, 1, 34000);
		game2= new Videogame(32145, 3, 28000);
		game3= new Videogame(6753, 2, 73000);
		game4= new Videogame(8900, 6, 50000);
		game5= new Videogame(1234, 1, 90000);
		shelf1.getGames().add(game1);
		shelf1.getGames().add(game2);		
		shelf2.getGames().add(game3);			
		shelf2.getGames().add(game4);	
		shelf2.getGames().add(game5);	
		hash.insert('A', shelf1);
		hash.insert('B', shelf2);
		videogames.add(game1);
		videogames.add(game3);
		client1 = new Client("45678", videogames);
		videogames.clear();
		videogames.add(game4);
		videogames.add(game5);
		client2= new Client("88987", videogames);
		checker1= new Checker(store);
		checker2= new Checker(store);
	}

	@Test
	public void testAddShelf() {
		scenary1();
		
		String message = store.addNewUser(user.getNameUser(), user.getPassword());
		String msg = "The person was added succesfully";
		//assertEquals(message, msg);
	}

}
