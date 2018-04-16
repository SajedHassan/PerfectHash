package perfectHash;

import java.util.ArrayList;

import interfaces.INode;

public class NodeN2<T extends Comparable<T>> implements INode<T> {
	T value;
	boolean collide = false;
	int noCollisions = 0;
	ArrayList<T> collideKeys;
	T hashedArray[];

	@Override
	public void add(T key) {
		if (!collide) {
			value = key;
			collide = true;
		} else {
			if (noCollisions == 0) {
				collideKeys = new ArrayList<>();
			}
			collideKeys.add(key);
			noCollisions++;
		}
	}

	@Override
	public T getKey() {
		return value;
	}

	public T getKey(T key) {
		// TODO
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		return null;
	}

	@Override
	public boolean willCollide() {
		return collide;
	}

	public int getCollisions() {
		return noCollisions;
	}
	
	public void hashSecondLevel() {
		//TODO <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	}
}
