package perfectHash;

import interfaces.IHashTable;

import java.util.ArrayList;

public class PerfectQuadraticHashTable implements IHashTable {

	ArrayList<Integer> keys = new ArrayList();
	ArrayList values = new ArrayList();
	NodeN2[] table ;
	UniversalHashMatrix universalHash;

	PerfectQuadraticHashTable(ArrayList keys, int M){

		this.keys = keys;
		table = new NodeN2[M];
		for (int i = 0 ; i < M ; i++){
			table[i] = new NodeN2();
		}

		universalHash = new UniversalHashMatrix(keys.size());
		hash();

	}

	private void hash (){
		universalHash.generateNewRandomHashFunction();
		int index ;
		for (int i = 0 ; i < keys.size(); i++){
			index = universalHash.getHashValue(keys.get(i));
			if(!table[index].willCollide()) {
				table[index].add((Comparable) keys.get(i), (Comparable) values.get(i));
			} else {
				hash();
			}
		}
	}

	@Override
	public int contains(int key) {
		int index = universalHash.getHashValue(key);
		return (int)table[index].getKey();
	}

}