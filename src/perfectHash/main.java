package perfectHash;

import interfaces.IUniversalHash;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.management.RuntimeErrorException;

public class main {

	public static void main(String args[]) throws FileNotFoundException {

		ArrayList<Integer> keys = new ArrayList<>();
		Set<Integer> set = new HashSet<Integer>();
		String fileName = "test4.txt";
		Scanner src = new Scanner(new File(fileName));
		Scanner src2 = new Scanner(new File(fileName));
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			while (src.hasNext()) {
				set.add(src.nextInt());
			}

			for (Integer integer : set) {
				keys.add(integer);
			}
			LinearHashTable hashTable2 = new LinearHashTable(keys);
			PerfectQuadraticHashTable hashTable1 = new PerfectQuadraticHashTable(keys);

			System.out.println("size " + keys.size());

			System.out.println("Hash size " + set.size());
			for (int i = 0; i < keys.size(); i++) {
				
				if (hashTable1.contains(keys.get(i)) == null) {
					throw new RuntimeErrorException(null, "Hash1 error");
				} else {
					System.out.println("Ok1");
				}
			}
				while (src2.hasNext()) {
					if (hashTable2.contains(src2.nextInt()) == null) {
						throw new RuntimeErrorException(null, "Hash2 error");
					} else {
						System.out.println("Ok2");
					}
				}
				// System.out.println(hashTable2.contains(66));
				// System.out.println(hashTable2.contains(12));
				// System.out.println(hashTable2.contains(10));
				// System.out.println(hashTable2.contains(5));
				// System.out.println(hashTable2.contains(443));
				// System.out.println(hashTable2.contains(323));
				// System.out.println(hashTable2.contains(545454));
				// System.out.println(hashTable2.contains(7));
				// System.out.println(hashTable2.contains(6));

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}

		// IUniversalHash universalHash = new UniversalHashMatrix(8);
		// System.out.println(universalHash.getHashValue(5));
		// System.out.println(universalHash.getHashValue(5));
		// System.out.println(universalHash.getHashValue(5));
		// System.out.println(universalHash.getHashValue(5));
		// universalHash.generateNewRandomHashFunction();
		// System.out.println(universalHash.getHashValue(5));
		// System.out.println(universalHash.getHashValue(5));
		// System.out.println(universalHash.getHashValue(5));
		// System.out.println(universalHash.getHashValue(5));

	}
}