package attacks;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestAttacks {
	
	private class MockAttack extends Attack {

		public MockAttack()
		{
			super(3, "Mock Attack");
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
