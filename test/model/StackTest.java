package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {
	
	Videogame game1, game2, game3, game4, game5;
	Stack<Videogame> stack;
	
	public void scenary1() throws Exception {
		game1 = new Videogame(8765, 1, 34000);
		game2 = new Videogame(32145, 3, 28000);
		game3 = new Videogame(6753, 2, 73000);
		game4 = new Videogame(8900, 6, 50000);
		game5 = new Videogame(1234, 1, 90000);
		stack = new Stack<>();
	}
	
	@Test
	public void pushAndPopNullTest() throws Exception {
		scenary1();
		assertNull(stack.pop());
		stack.push(game1);
		stack.push(game2);
		stack.push(game3);
		stack.push(game4);
		stack.push(game5);
		assertEquals(stack.size(),5);
	}
	
	@Test
	public void popTest() throws Exception {
		scenary1();
		stack.push(game1);
		stack.push(game2);
		assertEquals(stack.pop(),game2);
		assertEquals(stack.pop(),game1);
		assertEquals(stack.pop(),null);
	}
	@Test
	public void peekAndPopTest() throws Exception {
		scenary1();
		stack.push(game1);
		stack.push(game2);
		stack.push(game3);
		stack.push(game4);
		assertEquals(stack.pop(),game4);
		assertEquals(stack.pop(),game3);
		assertEquals(stack.peek(),game2);
		assertNotEquals(stack.pop(),null);
	}
	@Test
	public void compareTopTest() throws Exception {
		scenary1();
		stack.push(game1);
		stack.push(game2);
		assertEquals(stack.peek(),game2);
	}

}
