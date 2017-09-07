package queue;

public class LifoLimited<T> implements Lifo<T> {

	private int firstFree;
	private Object[] lifo;

	public LifoLimited(int maxSize) {
		if (maxSize > 0) {
			lifo = new Object[maxSize];
		} else {
			throw new IllegalArgumentException();
		}
	}

	public boolean add(T t) {
		lifo[firstFree++] = t;
		return true;
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
