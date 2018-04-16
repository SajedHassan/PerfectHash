package perfectHash;

import interfaces.IHashTable;

import java.util.ArrayList;

public class PerfectQuadraticHashTable<T> implements IHashTable<T> {

	ArrayList<T> keys = new ArrayList<>();
	ArrayList<T> values = new ArrayList<>();
	NodeN2[] table;
	UniversalHashMatrix universalHash;
	int size;
	PerfectQuadraticHashTable(ArrayList<T> keys, int M) {

		this.keys = keys;
		this.values = keys;
		size = M;
		for (int i = 0; i < M; i++) {
			table[i] = new NodeN2();
		}

		universalHash = new UniversalHashMatrix(keys.size() * keys.size());
		hash();

	}

	private void hash() {
		boolean terminated = false;
		while (!terminated) {
			terminated = true;
			universalHash.generateNewRandomHashFunction();
			table = new NodeN2[size];
			int index;
			for (int i = 0; i < keys.size(); i++) {
				index = universalHash.getHashValue(keys.get(i));
				if (!table[index].willCollide()) {
					table[index].add((Comparable) keys.get(i), (Comparable) values.get(i));
				} else {
					terminated = false;
				}
			}
		}
	}

	@Override
	public T contains(T key) {
		int index = universalHash.getHashValue(key);
		return (T) table[index].getKey();
	}

}