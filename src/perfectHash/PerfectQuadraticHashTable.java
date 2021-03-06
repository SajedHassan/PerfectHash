package perfectHash;

import interfaces.IHashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PerfectQuadraticHashTable<T> implements IHashTable<T> {

	ArrayList<T> keys = new ArrayList<>();
	Set<T> set = new HashSet<T>();
	ArrayList<T> values = new ArrayList<>();
	NodeN2[] table;
	UniversalHashMatrix universalHash;
	int size;

	PerfectQuadraticHashTable(ArrayList<T> keys) {
		for (T key : keys) {
			set.add(key);
		}
		this.keys = new ArrayList<T>();
		for (T key : set) {
			this.keys.add(key);
		}		this.values = keys;
		size = (int) Math.pow(2, (int) Math.ceil(Math.log(keys.size() * keys.size()) / Math.log(2)));
		if (size == 1) {
			size += 2;
		}
//		System.out.println("table size " + size);
		universalHash = new UniversalHashMatrix(keys.size() * keys.size());
		hash();

	}

	private void hash() {
		boolean terminated = false;
		while (!terminated) {
			System.out.println("2");
//			System.out.println("in");
			terminated = true;
			universalHash.generateNewRandomHashFunction();
			table = new NodeN2[size];
//			System.out.println(keys.size());

			int index;
			for (int i = 0; i < keys.size(); i++) {
				index = universalHash.getHashValue(keys.get(i));
				if (table[index] == null) {
					table[index] = new NodeN2();
				}
				if (!table[index].willCollide()) {
					table[index].add((Comparable) keys.get(i), (Comparable) values.get(i));
				} else if (table[index].getKey().equals(keys.get(i))) {
					continue;
				} else {
					terminated = false;
				}
			}
		}
		System.out.println("======");
	}

	@Override
	public T contains(T key) {
		int index = universalHash.getHashValue(key);
		if (table[index] != null && table[index].getKey() != null && table[index].getKey().compareTo(key) == 0)
			return (T) table[index].getKey();
		return null;
	}
}