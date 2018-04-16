package perfectHash;

import java.util.ArrayList;

import interfaces.INode;

public class NodeN1<T extends Comparable<T>> implements INode<T> {

	T value;
	boolean collide = false;
	int noCollisions = 0;
	ArrayList<T> collideKeys;
	T hashedArray[];

	NodeN1() {
		value = null;
	}
	@Override
	public void add(T key,T value) {
		if (!collide) {
			this.value = value;
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