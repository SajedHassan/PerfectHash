package perfectHash;

import interfaces.INode;

public class NodeN<T extends Comparable<T>> implements INode<T> {
	T value;
	boolean collide = false;

	@Override
	public void add(T key) {
		value = key;
		collide = true;
	}

	@Override
	public T getKey() {
		return value;
	}

	@Override
	public boolean willCollide() {
		return collide;
	}

}
