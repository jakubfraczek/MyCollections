package queueTests;

import org.junit.Assert;
import org.junit.Test;

import queue.Fifo;
import queue.FifoArrayLimited;

public class FifoArrayLimitedTest {

	private Fifo<Integer> fifo = new FifoArrayLimited<Integer>(10);

	@Test
	public void addOneTest() {
		Assert.assertTrue(fifo.add(1));
	}

	@Test
	public void addManyTest() {
		Assert.assertTrue(fifo.add(1));
		Assert.assertTrue(fifo.add(2));
		Assert.assertTrue(fifo.add(3));
	}

	@Test(expected = StackOverflowError.class)
	public void addToManyTest() {
		for (int i = 0; i < 13; ++i) {
			Assert.assertTrue(fifo.add(i));
		}
	}

	@Test
	public void pollTest() {
		for (int i = 0; i < 10; ++i) {
			fifo.add(i);
		}
		Assert.assertEquals(0, (int) fifo.poll());
		Assert.assertEquals(1, (int) fifo.poll());
	}

	@Test
	public void addPollTest() {
		for (int i = 0; i < 20; ++i) {
			Assert.assertTrue(fifo.add(i));
			Assert.assertEquals(i, (int) fifo.poll());
		}
	}

	@Test
	public void sizeTest() {
		for (int i = 0; i < 15; i++) {
			fifo.add(i);
			if (i % 2 == 0) {
				fifo.poll();
			}
		}
		Assert.assertEquals(7, fifo.size());
	}

	@Test
	public void peekTest() {
		for (int i = 0; i < 5; ++i) {
			fifo.add(i);
		}
		Assert.assertEquals(5, fifo.size());
		Assert.assertEquals(0, (int) fifo.peek());
		Assert.assertEquals(5, fifo.size());
	}
}
