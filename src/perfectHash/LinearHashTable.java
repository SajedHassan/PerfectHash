package perfectHash;

import java.util.ArrayList;


import interfaces.IHashTable;
import interfaces.INode;

public class LinearHashTable implements IHashTable {
	private final ArrayList<Integer> staticKeys;
	private INode hashTable[];
	private UniversalHashMatrix uniHash;
	public LinearHashTable(ArrayList newKeys) {
		staticKeys = newKeys;
		uniHash = new UniversalHashMatrix(staticKeys.size());
		createHashTable();
		hashSecondLevel();
	}
	private void createHashTable() {
		boolean terminated = false;
		while(!terminated) {
			hashTable = new INode[staticKeys.size()];
			uniHash.generateNewRandomHashFunction();
			for (int k : staticKeys) {
				int i = uniHash.getHashValue(k);
				if(hashTable[i] == null) {
					hashTable[i] = new NodeN1();
				}
				hashTable[i].add(k,k);
			}
			int allCollisions = getAllCollisions();
			terminated = allCollisions < 4 * staticKeys.size();
		}
	}
	private int getAllCollisions() {
		int allCollisions = 0;
		for (INode n : hashTable) {
			if(n != null) {
				NodeN1 cN = (NodeN1) n;
				allCollisions += Math.pow(cN.getCollisions(),2);
			}
		}
		return allCollisions;
	}
	private void hashSecondLevel() {
		for (INode n : hashTable) {
			if(n != null) {
				NodeN1 cN = (NodeN1) n;
				if(cN.getCollisions() > 0) {
					cN.hashSecondLevel();
				}
			}
		}
	}
	@Override
	public int contains(int k) {
		int i = uniHash.getHashValue(k);
		NodeN1 node = (NodeN1) hashTable[i];
		return (int)node.getKey(k);
	}

}
