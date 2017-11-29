package types;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class for the 3 different types of pokemon 
 * @author Michael Foreman
 *
 */
public class TestType {

	/**
	 * Tests that a water type pokemon's damage is modified according 
	 * to what type of pokemon it is attacking
	 */
	@Test
	public void testWaterType()
	{
		Type typeToTest = new WaterType();
		Type waterType = new WaterType();
		Type fireType = new FireType();
		Type grassType = new GrassType();
		
		double epsilon = 0.001;
		/* Test water attacking each other type */
		assertEquals(Type.NORMAL_DAMAGE, typeToTest.getFraction(waterType), epsilon);
		assertEquals(Type.DOUBLE_DAMAGE, typeToTest.getFraction(fireType), epsilon);
		assertEquals(Type.HALF_DAMAGE, typeToTest.getFraction(grassType), epsilon);
	}
	
	/**
	 * Tests that a fire type pokemon's damage is modified according 
	 * to what type of pokemon it is attacking
	 */
	@Test
	public void testFireType()
	{
		Type typeToTest = new FireType();
		Type waterType = new WaterType();
		Type fireType = new FireType();
		Type grassType = new GrassType();
		
		double epsilon = 0.001;
		/* Test water attacking each other type */
		assertEquals(Type.NORMAL_DAMAGE, typeToTest.getFraction(fireType), epsilon);
		assertEquals(Type.DOUBLE_DAMAGE, typeToTest.getFraction(grassType), epsilon);
		assertEquals(Type.HALF_DAMAGE, typeToTest.getFraction(waterType), epsilon);
	}
	
	/**
	 * Tests that a grass type pokemon's damage is modified according 
	 * to what type of pokemon it is attacking
	 */
	@Test
	public void testGrassType()
	{
		Type typeToTest = new GrassType();
		Type waterType = new WaterType();
		Type fireType = new FireType();
		Type grassType = new GrassType();
		
		double epsilon = 0.001;
		/* Test water attacking each other type */
		assertEquals(Type.NORMAL_DAMAGE, typeToTest.getFraction(grassType), epsilon);
		assertEquals(Type.DOUBLE_DAMAGE, typeToTest.getFraction(waterType), epsilon);
		assertEquals(Type.HALF_DAMAGE, typeToTest.getFraction(fireType), epsilon);
	}
}
