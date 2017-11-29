package states;

import org.junit.Test;
import static org.junit.Assert.*;

import lifeform.*;

/**
 * Test class for a pokemon's states
 * @author Michael Foreman
 *
 */
public class TestStates {

	/**
	 * Tests that a pokemon with full health is in the full healthstate,
	 * and that it transitions accordingly when hit 
	 */
	@Test
	public void testFullState()
	{
		Pokemon p = new Bulbasaur();
		HealthState s = new FullState(p);
		
		s.checkState(50, 100);
		assertTrue(p.getCurrentState() instanceof DamagedState);
		
		p.setCurrentState(p.getFullState());
		
		s.checkState(0, 100);
		assertTrue(p.getCurrentState() instanceof FaintedState);
	}
	
	/**
	 * Tests that a damaged pokemon is in the correct state, 
	 * and transitions accordingly 
	 */
	@Test
	public void testDamagedState()
	{
		Pokemon p = new Bulbasaur();
		HealthState s = new DamagedState(p);
		
		s.checkState(50, 100);
		
		s.checkState(0, 100);
		assertTrue(p.getCurrentState() instanceof FaintedState);
		
		p.setCurrentState(p.getDamagedState());
		s.checkState(100, 100);
		assertTrue(p.getCurrentState() instanceof FullState);
	}
	
	/**
	 * Tests that a pokemon with 0 health is in the fainted state, and that
	 * it will transition accordingly when healed
	 */
	@Test
	public void testFaintedState()
	{
		Pokemon p = new Bulbasaur();
		HealthState s = new FaintedState(p);
		
		s.checkState(0, 100);
		
		s.checkState(50, 100);
		assertTrue(p.getCurrentState() instanceof DamagedState);
		
		p.setCurrentState(p.getFaintedState());
		s.checkState(100, 100);
		assertTrue(p.getCurrentState() instanceof FullState);
	}
	
}
