package gameplay;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Observers of the Timer
 * @author Michael Foreman
 */
public class TestObserver {

	/**
	 * Mock Observer class for testing functionality without 
	 * being dependent on a concrete class
	 * @author Michael Foreman
	 */
	private class MockObserver implements Observer
	{

		int turn;
		
		public MockObserver()
		{
			this.turn = 0;
		}
		
		@Override
		public void updateTurn(int turn) {
			this.turn = turn;
			
		}

		@Override
		public int getTurn() {
			return this.turn;
		}
		
	}
	
	/**
	 * Verifies that an added observer is correctly updated to th
	 * current turn
	 */
	@Test
	public void testUpdateTurn()
	{
		Observer o = new MockObserver();
		
		assertEquals(0, o.getTurn());
		
		o.updateTurn(6);
		assertEquals(6, o.getTurn());
		
		o.updateTurn(2987);
		assertEquals(2987, o.getTurn());
		
		o.updateTurn(42);
		assertEquals(42, o.getTurn());
		
	}
	
}
