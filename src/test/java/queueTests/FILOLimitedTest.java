package queueTests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import queue.Lilo;
import queue.LiloLimited;

public class FILOLimitedTest {
	
	@Test
	public void addTest(){
		Lilo<Integer> liloTest = new LiloLimited<Integer>(10); 
		Assert.assertTrue(liloTest.add(3));
	}
	
	@Test
	public void pollTest(){
		Lilo<Integer> liloTest = new LiloLimited<Integer>(10); 
		liloTest.add(3);
		assertEquals(new Integer(3), liloTest.poll());
	}
	
	@Test
	public void sizeTest(){
		Lilo<Integer> liloTest = new LiloLimited<Integer>(10); 
		for (int i = 0; i < 10; ++i){
			liloTest.add(i);
		}
		assertEquals(10, liloTest.size());
	}
	
	@Test
	public void peekTest(){
		Lilo<Integer> liloTest = new LiloLimited<Integer>(10); 
		liloTest.add(7);
		liloTest.add(5);
		liloTest.add(4);
		assertEquals(new Integer(4), liloTest.peek());
	}

}
