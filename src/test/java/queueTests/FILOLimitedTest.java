package queueTests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import queue.Lifo;
import queue.LifoLimited;

public class FILOLimitedTest {
	
	@Test
	public void addTest(){
		Lifo<Integer> liloTest = new LifoLimited<Integer>(10); 
		Assert.assertTrue(liloTest.add(3));
	}
	
	@Test
	public void pollTest(){
		Lifo<Integer> liloTest = new LifoLimited<Integer>(10); 
		liloTest.add(3);
		assertEquals(new Integer(3), liloTest.poll());
	}
	
	@Test
	public void sizeTest(){
		Lifo<Integer> liloTest = new LifoLimited<Integer>(10); 
		for (int i = 0; i < 10; ++i){
			liloTest.add(i);
		}
		assertEquals(10, liloTest.size());
	}
	
	@Test
	public void peekTest(){
		Lifo<Integer> liloTest = new LifoLimited<Integer>(10); 
		liloTest.add(7);
		liloTest.add(5);
		liloTest.add(4);
		assertEquals(new Integer(4), liloTest.peek());
	}

}
