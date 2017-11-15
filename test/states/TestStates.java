package states;

import org.junit.Test;
import static org.junit.Assert.*;

import lifeform.*;

public class TestStates {

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
