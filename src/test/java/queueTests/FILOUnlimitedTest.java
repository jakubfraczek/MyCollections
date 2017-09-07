package queueTests;

import org.junit.Assert;
import org.junit.Test;

import queue.Lifo;
import queue.LiloUnlimited;

public class FILOUnlimitedTest {
	
	@Test
	public void addTest(){
		Lifo<Integer> liloTest = new LiloUnlimited<Integer>();
		for (int i = 0; i < 10; ++i){
			liloTest.add(i);
		}
		Assert.assertTrue(liloTest.add(3));
	}
	
	@Test
	public void pollTest(){
		Lifo<Integer> liloTest = new LiloUnlimited<Integer>(); 
		liloTest.add(3);
		Assert.assertEquals(new Integer(3), liloTest.poll());
	}
	
	@Test
	public void sizeTest(){
		Lifo<Integer> liloTest = new LiloUnlimited<Integer>(); 
		for (int i = 0; i < 20; ++i){
			liloTest.add(i);
		}
		Assert.assertEquals(20, liloTest.size());
	}
	
	@Test
	public void peekTest(){
		Lifo<Integer> liloTest = new LiloUnlimited<Integer>(); 
		liloTest.add(7);
		liloTest.add(5);
		liloTest.add(4);
		Assert.assertEquals(new Integer(4), liloTest.peek());
	}

}
