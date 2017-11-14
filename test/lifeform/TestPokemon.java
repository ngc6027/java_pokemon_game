package lifeform;

import static org.junit.Assert.*;
import org.junit.Test;

import attacks.*;
import types.*;
import states.*;

public class TestPokemon {

	private class MockPokemon extends Pokemon
	{
		public MockPokemon() {
			super(new WaterType(), 100, "Lapras");
			
			attacks.add(new Tackle());
			attacks.add(new VineWhip());
			attacks.add(new PowerWhip());
			attacks.add(new SludgeBomb());
			
		}
	}
	
	@Test
	public void testInitialization()
	{		
		Pokemon p = new MockPokemon();
		
		assertEquals("Lapras", p.getDescription());
		
		assertTrue(p.getCurrentState() instanceof FullState);
		
		assertTrue(p.getType() instanceof WaterType);
		
		assertEquals(100, p.getCurrentHealth());
		
		assertTrue(p.hasNextPokemon());
		assertEquals("Tackle", p.nextPokemon().getDescription());
		
		assertTrue(p.hasNextPokemon());
		assertEquals("Vine Whip", p.nextPokemon().getDescription());
		
		assertTrue(p.hasNextPokemon());
		assertEquals("Power Whip", p.nextPokemon().getDescription());
		
		assertTrue(p.hasNextPokemon());
		assertEquals("Sludge Bomb", p.nextPokemon().getDescription());
		
		assertFalse(p.hasNextPokemon());
	}
	
}
