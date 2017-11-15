package gameplay;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestObserver {

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
