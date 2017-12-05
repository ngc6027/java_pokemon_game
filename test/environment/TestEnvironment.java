package environment;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

import javax.swing.ImageIcon;

import lifeform.*;

public class TestEnvironment {

	@Test
	public void testInitialization()
	{
		Environment e = Environment.getEnvironment();
		
		e.resetGame();
		
		assertTrue(e.getPlayer(0) instanceof Player);
		assertTrue(e.getPlayer(1) instanceof Player);
		
		for(int i = 0; i < 12; i++) {
			assertTrue(e.getPokemon(i) instanceof Pokemon);
		}
		
		assertEquals(0, e.getTurn());
	}
	
	@Test
	public void testAssignPokemon()
	{
		Environment e = Environment.getEnvironment();
		
		e.resetGame();
		
		assertEquals(0, e.getTurn());
		e.assignPokemon(11);
		
		assertEquals("Poliwag", e.getPlayer(0).getPokemon(0).getDescription());
		assertEquals(1, e.getTurn());
	}
	
	@Test
	public void testUpdateTurn()
	{
		Environment e = Environment.getEnvironment();
		
		e.resetGame();
		
		assertEquals(0, e.getTurn());
		
		e.updateTurn(5);
		
		assertEquals(5, e.getTurn());
	}
	
	@Test
	public void testGetPokemon()
	{
		Environment e = Environment.getEnvironment();
		
		e.resetGame();
		
		assertEquals("Blastoise", e.getPokemon(10).getDescription());
		assertEquals("Vulpix", e.getPokemon(7).getDescription());
		assertEquals("Caterpie", e.getPokemon(3).getDescription());
	}
	
	@Test
	public void testGetImage() throws IOException
	{
		Environment e = Environment.getEnvironment();
		
		e.resetGame();
		
		while(e.hasNext())
		{
			assertTrue(e.getPokemonImage(e.next().getDescription()) instanceof ImageIcon);
		}
	}
	
	@Test
	public void testIterator()
	{
		Environment e = Environment.getEnvironment();
		
		e.resetGame();
		
		for(int i = 0; i < 12; i++)
		{
			assertTrue(e.hasNext());
			assertTrue(e.next() instanceof Pokemon);
		}
		
		assertFalse(e.hasNext());
	}
	
	@Test
	public void testAttack()
	{
		Environment e = Environment.getEnvironment();
		
		e.resetGame();
		
		e.assignPokemon(0);		// Bulbasaur to Player 1
		e.assignPokemon(11);	// Poliwag to Player 2
		
		e.changeActivePokemon(0, 0);
		e.changeActivePokemon(0, 1);
		
		e.attack(2, 0);
		assertEquals(45, e.getPlayer(1).getActivePokemon().getCurrentHealth());
		
	}
}
