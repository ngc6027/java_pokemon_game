package attacks;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestAttacks {
	
	@Test
	public void testTackle() 
	{
		Attack a = new Tackle();
		
		assertEquals("Tackle", a.getDescription());
		assertEquals(1.0, a.calculateDamage(), 0.001);
	}
	
	@Test
	public void testVineWhip() 
	{
		Attack a = new VineWhip();
		
		assertEquals("Vine Whip", a.getDescription());
		assertEquals(4.0, a.calculateDamage(), 0.001);
	}
	
	@Test
	public void testPowerWhip() 
	{
		Attack a = new PowerWhip();
		
		assertEquals("Power Whip", a.getDescription());
		assertEquals(2.0, a.calculateDamage(), 0.001);
	}
	
	@Test
	public void testSludgeBomb() 
	{
		Attack a = new SludgeBomb();
		
		assertEquals("Sludge Bomb", a.getDescription());
		assertEquals(3.0, a.calculateDamage(), 0.001);
	}
	
	@Test
	public void testSolarBeam() 
	{
		Attack a = new SolarBeam();
		
		assertEquals("Solar Beam", a.getDescription());
		assertEquals(5.0, a.calculateDamage(), 0.001);
	}

}
