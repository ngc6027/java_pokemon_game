package types;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestType {

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
