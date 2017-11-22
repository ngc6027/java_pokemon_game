package lifeform;

import static org.junit.Assert.*;
import org.junit.Test;

import attacks.*;
import types.*;
import states.*;

public class TestPokemon {

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
	
	@Test
	public void testSetCurrentState()
	{
		Pokemon p = new MockPokemon(new WaterType());
		
		p.setCurrentState(p.getDamagedState());
		assertTrue(p.getCurrentState() instanceof DamagedState);
		
		p.setCurrentState(p.getFaintedState());
		assertTrue(p.getCurrentState() instanceof FaintedState);
	}
	
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
	
	@Test
	public void testAttackSameType()
	{
		Pokemon p1 = new MockPokemon(new WaterType());
		Pokemon p2 = new MockPokemon(new WaterType());
		
		p1.attack(p2, 0);
		assertEquals(99, p2.getCurrentHealth());
		assertTrue(p2.getCurrentState() instanceof DamagedState);
		
		p2.attack(p1, 3);
		assertEquals(92, p1.getCurrentHealth());
		assertTrue(p1.getCurrentState() instanceof DamagedState);
	}
	
	@Test
	public void testAttackDifferentType()
	{
		Pokemon firePoke =  new MockPokemon(new FireType());
		Pokemon grassPoke = new MockPokemon(new GrassType());
		
		firePoke.attack(grassPoke, 1);
		assertEquals(92, grassPoke.getCurrentHealth());
		assertTrue(grassPoke.getCurrentState() instanceof DamagedState);
		
		grassPoke.attack(firePoke, 1);
		assertEquals(98, firePoke.getCurrentHealth());
		assertTrue(firePoke.getCurrentState() instanceof DamagedState);
	}
	
}
