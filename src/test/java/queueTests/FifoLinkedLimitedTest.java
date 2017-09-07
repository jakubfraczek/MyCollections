package queueTests;

import org.junit.Test;

import org.junit.Assert;
import queue.Fifo;
import queue.FifoLinkedLimited;

public class FifoLinkedLimitedTest {
	
	private Fifo<Integer> fifo = new FifoLinkedLimited<Integer>(10);
	
	
	
	@Test
	public void addFirstTest(){
		Assert.assertTrue(fifo.add(2));
	}	
	
	@Test
	public void addAnotherTest(){
		Assert.assertTrue(fifo.add(4));
		Assert.assertTrue(fifo.add(4));
	}	
	
	@Test (expected = StackOverflowError.class)
	public void addToMutchTest(){
		for (int i = 0; i <13; ++i){
			fifo.add(i);
		}
	}
	
	@Test
	public void pollTest(){
		for (int i = 0; i <3; ++i){
			fifo.add(i);
		}
		Assert.assertEquals(3, fifo.size());
		Assert.assertEquals(0, (int) fifo.poll());
		Assert.assertEquals(2, fifo.size());
	}
	
	@Test
	public void peekTest(){
		for (int i = 0; i <3; ++i){
			fifo.add(i);
		}
		Assert.assertEquals(3, fifo.size());
		Assert.assertEquals(0, (int) fifo.peek());
		Assert.assertEquals(3, fifo.size());
	}
	
}
