package perfectHash;

public interface INode<T extends Comparable<T>> {
	
	void add(T key);
	T get(T key);
	boolean exisit(T key);
	T getNoCollisions();
	
}
