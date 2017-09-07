package queue;

public interface Fifo<T> {
	
	public boolean add(T t);
	public T poll();
	public T peek();
	public int size();
}
