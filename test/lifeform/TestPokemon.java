package lifeform;

import static org.junit.Assert.*;
import org.junit.Test;

import attacks.*;
import types.*;
import states.*;

/**
 * Test class for the pokemon class
 * @author Michael Foreman
 *
 */
public class TestPokemon {

	/**
	 * Mock Pokemon exists to test the functionality all pokemon
	 * should share, so testing is not dependent on implementation
	 * @author jb7656
	 *
	 */
	private class MockPokemon extends Pokemon
	{
		public MockPokemon(Type type) {
			super(type, 100, "Lapras");
			
			attacks.add(new Tackle());
			attacks.add(new VineWhip());
			attacks.add(new PowerWhip());
			attacks.add(new SludgeBomb());
			
		}
	}
	
	/**
	 * Ensures a mock pokemon can be created and is initilaized to the
	 * correct state, has the correct type, has full health, and a full
	 * move set
	 */
	@Test
	public void testInitialization()
	{		
		Pokemon p = new MockPokemon(new WaterType());
		
		assertEquals("Lapras", p.getDescription());
		
		assertTrue(p.getCurrentState() instanceof FullState);
		
		assertTrue(p.getType() instanceof WaterType);
		
		assertEquals(100, p.getCurrentHealth());
		
		assertTrue(p.hasNext());
		assertEquals("Tackle", p.next().getDescription());
		
		assertTrue(p.hasNext());
		assertEquals("Vine Whip", p.next().getDescription());
		
		assertTrue(p.hasNext());
		assertEquals("Power Whip", p.next().getDescription());
		
		assertTrue(p.hasNext());
		assertEquals("Sludge Bomb", p.next().getDescription());
		
		assertFalse(p.hasNext());
	}
	
	/**
	 * Esnures a pokemon can set its state correctly and can transition
	 * to the appropriate states
	 */
	@Test
	public void testSetCurrentState()
	{
		Pokemon p = new MockPokemon(new WaterType());
		
		p.setCurrentState(p.getDamagedState());
		assertTrue(p.getCurrentState() instanceof DamagedState);
		
		p.setCurrentState(p.getFaintedState());
		assertTrue(p.getCurrentState() instanceof FaintedState);
	}
	
	/**
	 * Ensures the iterator for the pokemons moveset operates correctly
	 * and does not go out of bounds
	 */
	@Test
	public void testIterator()
	{
		Pokemon p = new MockPokemon(new WaterType());
		
		for(int i = 0; i < 4; i++)
		{
			assertTrue(p.hasNext());
			assertTrue(p.next() instanceof Attack);
		}
		
		assertFalse(p.hasNext());
	}
	
	/**
	 * Tests the correct damage is done when two pokemon of the same
	 * type attack each other
	 */
	@Test
	public void testAttackSameType()
	{
		Pokemon p1 = new MockPokemon(new WaterType());
		Pokemon p2 = new MockPokemon(new WaterType());
		
		p1.attack(p2, 0);
		assertEquals(95, p2.getCurrentHealth());
		assertTrue(p2.getCurrentState() instanceof DamagedState);
		
		p2.attack(p1, 3);
		assertEquals(84, p1.getCurrentHealth());
		assertTrue(p1.getCurrentState() instanceof DamagedState);
	}
	
	/**
	 * tests the correct damage is done when two pokemon of different 
	 * types attack each other
	 */
	@Test
	public void testAttackDifferentType()
	{
		Pokemon firePoke =  new MockPokemon(new FireType());
		Pokemon grassPoke = new MockPokemon(new GrassType());
		
		firePoke.attack(grassPoke, 1);
		assertEquals(80, grassPoke.getCurrentHealth());
		assertTrue(grassPoke.getCurrentState() instanceof DamagedState);
		
		grassPoke.attack(firePoke, 1);
		assertEquals(96, firePoke.getCurrentHealth());
		assertTrue(firePoke.getCurrentState() instanceof DamagedState);
	}
	
}
