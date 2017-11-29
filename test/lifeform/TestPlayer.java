package lifeform;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the player that the GUI interacts with
 * @author Michael Foreman
 *
 */
public class TestPlayer {

	/**
	 * Ensures a player is initilaized correctly and has no pokemon, 
	 * no opponent and is set to the correct turn
	 */
	@Test
	public void testInitialization()
	{
		Player p1 = new Player(0);
		
		assertEquals(0, p1.getNumPokemon());
		assertNull(p1.getActivePokemon());
		assertNull(p1.getOpponent());
		assertEquals(0, p1.getID());
		assertEquals(-1, p1.getTurn());
	}
	
	/**
	 * Ensures a player can hold three pokemon, that the numpokemon is updated
	 * accordingly, and that a player cannot hold more than three pokemon
	 */
	@Test
	public void testAddPokemon()
	{
		Player p = new Player(0);
		
		assertTrue(p.addPokemon(new Bulbasaur()));
		assertEquals("Bulbasaur", p.getPokemon(0).getDescription());
		assertEquals(1, p.getNumPokemon());
		
		assertTrue(p.addPokemon(new Poliwag()));
		assertEquals("Poliwag", p.getPokemon(1).getDescription());
		assertEquals(2, p.getNumPokemon());
		
		assertTrue(p.addPokemon(new Ivysaur()));
		assertEquals("Ivysaur", p.getPokemon(2).getDescription());
		assertEquals(3, p.getNumPokemon());
		
		assertFalse(p.addPokemon(new Poliwag()));
		assertEquals("Ivysaur", p.getPokemon(2).getDescription());
		assertEquals(3, p.getNumPokemon());
	}
	
	/**
	 * Ensures a player can succesfully switch their active pokemon
	 * during a battle
	 */
	@Test
	public void testChangeActivePokemon()
	{
		Player p = new Player(0);
		
		p.addPokemon(new Bulbasaur());
		p.changeActivePokemon(0);
		
		assertEquals("Bulbasaur", p.getActivePokemon().getDescription());
		
		p.addPokemon(new Poliwag());
		p.changeActivePokemon(1);
		
		assertEquals("Poliwag", p.getActivePokemon().getDescription());
	}
	
	/**
	 * Ensures that players can add each other as opponesnts to that
	 * their pokemon can attack each other
	 */
	@Test
	public void testSetOpponent()
	{
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		
		p1.setOpponent(p2);
		assertEquals(p2, p1.getOpponent());
		
		p2.setOpponent(p1);
		assertEquals(p1, p2.getOpponent());
	}
	
	/**
	 * Tests to verify that all players and pokemon and turns are reset
	 * when the game is over, in order to run the game again
	 */
	public void testResetGame()
	{
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		
		p1.setOpponent(p2);
		p2.setOpponent(p1);
		
		p1.addPokemon(new Bulbasaur());
		p2.addPokemon(new Vulpix());
		
		p1.changeActivePokemon(0);
		p2.changeActivePokemon(0);
		
		p1.resetGame();
		
		assertEquals(0, p1.getNumPokemon());
		assertEquals(0, p2.getNumPokemon());
		
		assertNull(p1.getActivePokemon());
		assertNull(p2.getActivePokemon());
		
		assertEquals(p2, p1.getOpponent());
		assertEquals(p1, p2.getOpponent());
		
	}
	
	/**
	 * Ensures a player is able to attack anothers pokemon
	 * and that the correct damage is done 
	 */
	@Test
	public void testAttack()
	{
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		
		p1.setOpponent(p2);
		p2.setOpponent(p1);
		
		p1.addPokemon(new Ivysaur());
		p2.addPokemon(new Charizard());
		
		p1.changeActivePokemon(0);
		p2.changeActivePokemon(0);
		
		p1.attack(3);
		assertEquals(90, p2.getActivePokemon().getCurrentHealth());
		
	}
	
}
