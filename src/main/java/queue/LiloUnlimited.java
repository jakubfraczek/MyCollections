package queue;

import java.util.Arrays;

public class LiloUnlimited<T> implements Lilo<T> {

	private int size = 10;
	private int firstFree;
	private Object[] lilo;
	
	public LiloUnlimited() {
		lilo = new Object[size];
	}
	
	public boolean add(T t) {
		if (firstFree < 10){
			lilo[firstFree++] = t;
			return true;
		} else {
			size *= 2;
			lilo = Arrays.copyOf(lilo, size);
			lilo[firstFree++] = t;
			return true;
		}
	}

	public T poll() {
		return (T) lilo[--firstFree];
	}

	public T peek() {
		return (T) lilo[firstFree - 1];
	}

	public int size() {
		return firstFree;
	}

}