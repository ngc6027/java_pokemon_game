package gameplay;

import static org.junit.Assert.*;
import org.junit.Test;

import lifeform.*;

public class TestTimer {

	@Test
	public void testAddObservers()
	{
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		
		Timer t = new Timer();
		
		assertEquals(0, t.getNumObservers());
		
		t.register(player1);
		
		assertEquals(1, t.getNumObservers());
		
		t.register(player2);
		
		assertEquals(2, t.getNumObservers());
	}
	
	@Test
	public void testNotifyObservers()
	{
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		
		Timer t = new Timer();
		
		assertEquals(-1, player1.getTurn());
		t.register(player1);
		assertEquals(0, player1.getTurn());
		
		assertEquals(-1, player2.getTurn());
		t.register(player2);
		assertEquals(0, player2.getTurn());
		
		t.update();
		
		assertEquals(1, player1.getTurn());
		assertEquals(1, player2.getTurn());
		
	}
	
	@Test
	public void testRemoveObservers()
	{
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		
		Timer t = new Timer();
		
		t.register(player1);
		t.register(player2);
		
		assertEquals(2, t.getNumObservers());
		
		t.remove(player1);
		assertEquals(1, t.getNumObservers());
		
		t.remove(player2);
		assertEquals(0, t.getNumObservers());
	}
	
}
