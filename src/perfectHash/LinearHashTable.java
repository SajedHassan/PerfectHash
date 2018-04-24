package perfectHash;

import java.util.ArrayList;


import interfaces.IHashTable;
import interfaces.INode;

public class LinearHashTable<T extends Comparable<T>> implements IHashTable<T> {
	private final ArrayList<T> staticKeys;
	private INode<T> hashTable[];
	private UniversalHashMatrix<T> uniHash;
	public LinearHashTable(ArrayList<T> newKeys) {
		staticKeys = newKeys;
		uniHash = new UniversalHashMatrix<>(staticKeys.size());
		createHashTable();
		hashSecondLevel();
	}
	private void createHashTable() {
		boolean terminated = false;
		int size = (int) Math.pow(2, Math.ceil(Math.log(staticKeys.size())/Math.log(2)));
		System.out.println("table size" + size);
		while(!terminated) {
			hashTable = new INode[size];
			uniHash.generateNewRandomHashFunction();
			for (T k : staticKeys) {
				int i = uniHash.getHashValue(k);
				if(hashTable[i] == null) {
					hashTable[i] = new NodeN1<T>();
				}
				hashTable[i].add(k,k);
			}
			int allCollisions = getAllCollisions();
			terminated = allCollisions < 4 * size;
		}
	}
	private int getAllCollisions() {
		int allCollisions = 0;
		for (INode<T> n : hashTable) {
			if(n != null) {
				NodeN1<T> cN = (NodeN1<T>) n;
				allCollisions += Math.pow(cN.getCollisions(),2);
			}
		}
		return allCollisions;
	}
	private void hashSecondLevel() {
		for (INode<T> n : hashTable) {
			if(n != null) {
				NodeN1<T> cN = (NodeN1<T>) n;
				if(cN.getCollisions() > 0) {
					cN.hashSecondLevel();
				}
			}
		}
	}
	
	/*
	 * 			if (table[index].getKey() != null && table[index].getKey().compareTo(keys.get(i)) == 0) {
					continue;
				}
				quadratic solution for similar keys.
	 * @see interfaces.IHashTable#contains(java.lang.Object)
	 */
	@Override
	public T contains(T k) {
		int i = uniHash.getHashValue(k);
		NodeN1<T> node = (NodeN1<T>) hashTable[i];
		if (node != null) {
			return node.getKey(k);
		}
		return null;
	}

}