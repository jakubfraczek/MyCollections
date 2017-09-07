package queue;

import java.util.Arrays;

public class LiloUnlimited<T> implements Lifo<T> {

	private int size = 10;
	private int firstFree;
	private Object[] lifo;
	
	public LiloUnlimited() {
		lifo = new Object[size];
	}
	
	public boolean add(T t) {
		if (firstFree < 10){
			lifo[firstFree++] = t;
			return true;
		} else {
			size *= 2;
			lifo = Arrays.copyOf(lifo, size);
			lifo[firstFree++] = t;
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	public T poll() {
		return (T) lifo[--firstFree];
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) lifo[firstFree - 1];
	}

	public int size() {
		return firstFree;
	}

}