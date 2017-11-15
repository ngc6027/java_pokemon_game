package gameplay;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestIterator {

	private class MockIterator implements Iterator
	{

		private int ints[];
		private int i;
		
		public MockIterator()
		{
			this.ints = new int[] {0,1,2,3,4,5,6,7,8,9};
			this.i = 0;
		}
		
		@Override
		public boolean hasNext() {
			boolean rc = false;
			
			if(this.i < this.ints.length)
			{
				rc = true;
			}
			else
			{
				this.i = 0;
			}
			
			return rc;
		}

		@Override
		public Object next() {
			int ret = ints[this.i];
			this.i++;
			return ret;
		}
	}
	
	@Test
	public void testIteration()
	{
		Iterator it = new MockIterator();
		
		for (int i = 0; i < 10; i++)
		{
			assertTrue(it.hasNext());
			assertEquals(i, it.next());
		}
		
		assertFalse(it.hasNext());
	}
	
}
