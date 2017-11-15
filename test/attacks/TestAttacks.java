package attacks;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestAttacks {
	
	private class MockAttack extends Attack {

		@Override
		public double calculateDamage() {
			return 15.0;
		}

		@Override
		public String getDescription() {
			return "Mock Attack";
		}
		
	}
	
	@Test
	public void testAttack() 
	{
		Attack a = new MockAttack();
		
		assertEquals("Mock Attack", a.getDescription());
		assertEquals(15.0, a.calculateDamage(), 0.001);
	}
	

}
