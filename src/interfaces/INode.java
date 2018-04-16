package interfaces;

public interface INode<T extends Comparable<T>> {
	void add(T key,T value);

	T getKey();

	
	boolean willCollide();
}