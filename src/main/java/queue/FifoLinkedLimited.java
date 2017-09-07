package queue;

public class FifoLinkedLimited<T> implements Fifo<T> {

	private Node<T> first = null;
	private Node<T> last = null;
	private int maxSize;
	private int currentSize = 0;

	public FifoLinkedLimited(int size) {
		maxSize = size;
	}

	public boolean add(T t) {
		if (first == null) {
			Node<T> added = new Node<T>(t);
			first = added;
			last = first;
			currentSize++;
			return true;
		} else if (currentSize < maxSize) {
			Node<T> added = new Node<T>(t);
			last.setNext(added);
			last = added;
			currentSize++;
			return true;
		} else {
			throw new StackOverflowError();
		}

	}

	public T poll() {
		T out = first.getValue();
		first = first.getNext();
		currentSize--;
		return out;
	}

	public T peek() {
		return first.getValue();
	}

	public int size() {
		return currentSize;
	}

}
