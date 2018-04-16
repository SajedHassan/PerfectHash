package perfectHash;

import interfaces.INode;

public class NodeN2<T extends Comparable<T>> implements INode<T> {

	T value;
	boolean collide = false;

	NodeN2() {
		value = null;
	}

	@Override
	public void add(T key,T value) {
		this.value = value;
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