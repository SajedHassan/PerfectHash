package perfectHash;

import java.util.ArrayList;

import interfaces.INode;

public class NodeN1<T extends Comparable<T>> implements INode<T> {

	T value;
	boolean collide = false;
	int noCollisions = 0;
	ArrayList<T> collideKeys;
	PerfectQuadraticHashTable<T> secondLevel;
	NodeN1() {
		value = null;
	}
	@Override
	public void add(T key,T value) {
		if (!collide) {
			this.value = value;
			collide = true;
		} else if(key != value) {
			if (collideKeys == null) {
				collideKeys = new ArrayList<>();
			}
			if(!collideKeys.contains(key)) {
				collideKeys.add(key);
				noCollisions++;
			}
		}
	}

	@Override
	public T getKey() {
		return value;
	}

	public T getKey(T key) {
		if(key.compareTo(value) == 0)
			return value;
		else if(secondLevel != null)
			return secondLevel.contains(key);
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
		secondLevel = new PerfectQuadraticHashTable<>(collideKeys);
	}
}
