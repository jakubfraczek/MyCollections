package queue;

import org.apache.commons.lang3.math.Fraction;

public class FifoArrayLimited<T> implements Fifo<T> {

	private int firstFree = 0;
	private int firstToGo = -1;
	private Object[] fifo;
	private int size;

	public FifoArrayLimited(int size) {
		if (size > 0) {
			fifo = new Object[size];
			this.size = size;
		} else {
			throw new IllegalArgumentException("Illegal value: " + size);
		}
	}

	public boolean add(T t) {
		if (firstFree == 0) {
			fifo[firstFree++] = t;
			firstToGo++;
			return true;
		} else if (firstFree < size) {
			fifo[firstFree++] = t;
			return true;
		} else if (fifo[firstFree % size] == null) {
			fifo[firstFree % size] = t;
			firstFree++;
			return true;
		} else {
			throw new StackOverflowError();
		}
	}

	public T poll() {
		T toReturn = (T) fifo[firstToGo % size];
		fifo[firstToGo % size] = null;
		firstToGo++;
		return toReturn;
	}

	public T peek() {
		return (T) fifo[firstToGo % size];
	}

	public int size() {
		if (firstFree == 0){
			return 0;
			
		} else {
			return firstFree - firstToGo;
		}
	}

}
