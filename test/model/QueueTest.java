package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class QueueTest {
	
	Client client1, client2, client3, client4, client5;
	Queue<Client> clients;
	ArrayList<Videogame> games;
	
	public void scenary1() throws Exception {
		games = new ArrayList<>();
		clients = new Queue<>();
		client1 = new Client ("pdr34",games);
		client2= new Client ("sdio29n",games);
		client3= new Client ("opsdf893",games);
		client4= new Client ("op6op2",games);
		client5= new Client ("mds3j",games);
	}
	
	@Test
	public void addTest() throws Exception {
		scenary1();
		clients.add(client1);
		clients.add(client2);
		clients.add(client3);
		clients.add(client4);
		clients.add(client5);
		assertTrue(clients.getSize()==5);
		assertEquals(clients.peek(),client1);
	}
	
	@Test
	public void pollTest() throws Exception {
		scenary1();
		clients.add(client1);
		clients.add(client2);
		assertTrue(clients.getSize()==2);
		assertEquals(clients.poll(),client1);
		assertEquals(clients.poll(),client2);
		assertNull(clients.poll());
	}
	
	@Test
	public void peekTest() throws Exception {
		scenary1();;
		clients.add(client2);
		clients.add(client3);
		clients.add(client4);
		assertTrue(clients.getSize()==3);
		assertEquals(clients.poll(),client2);
		assertEquals(clients.peek(),client3);
		assertNotNull(clients.poll());
	}
	
	@Test
	public void sizeTest() throws Exception {
		scenary1();;
		clients.add(client2);
		clients.add(client3);
		clients.add(client4);
		assertTrue(clients.getSize()==3);
		clients.add(client1);
		clients.add(client2);
		clients.add(client3);
		clients.add(client4);
		clients.add(client5);
		assertTrue(clients.getSize()==8);
	}
	
}
