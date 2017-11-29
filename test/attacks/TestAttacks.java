package attacks;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class for the abstract attack class
 * @author Michael Foreman
 *
 */
public class TestAttacks {
	
	/**
	 * Mock attack to verify that attacks work without depending
	 * on concrete implementation
	 * @author Michael Foreman
	 *
	 */
	private class MockAttack extends Attack {

		public MockAttack()
		{
			super(3, "Mock Attack");
		}
		
	}
	
	/**
	 * Ensures an attack has the correct description and that
	 * when called it calculates the correct damage
	 */
	@Test
	public void testAttack() 
	{
		Attack a = new MockAttack();
		
		assertEquals("Mock Attack", a.getDescription());
		assertEquals(15.0, a.calculateDamage(), 0.001);
	}
	

}
