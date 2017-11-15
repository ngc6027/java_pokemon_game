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
	
}
