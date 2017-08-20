package queue;

public class LiloLimited<T> implements Lilo<T> {

	private int firstFree;
	private Object[] lilo;

	public LiloLimited(int maxSize) {
		lilo = new Object[maxSize];
	}

	public boolean add(T t) {
		lilo[firstFree++] = t;
		return true;
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
