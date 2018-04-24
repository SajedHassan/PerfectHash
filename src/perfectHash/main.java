package perfectHash;

import interfaces.IUniversalHash;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main (String args[]) throws FileNotFoundException {


		ArrayList<Integer> keys = new ArrayList<>();
		String fileName = "test1.txt";
		Scanner src = new Scanner(new File(fileName));

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader =
					new FileReader(fileName);

			while(src.hasNext()) {
				keys.add(src.nextInt());
			}
			PerfectQuadraticHashTable hashTable1 = new PerfectQuadraticHashTable(keys);
			LinearHashTable hashTable2 = new LinearHashTable(keys);
//			System.out.println(hashTable2.contains(66));
//			System.out.println(hashTable2.contains(12));
//			System.out.println(hashTable2.contains(10));
//			System.out.println(hashTable2.contains(5));
//			System.out.println(hashTable2.contains(443));
//			System.out.println(hashTable2.contains(323));
//			System.out.println(hashTable2.contains(545454));
//			System.out.println(hashTable2.contains(7));
//			System.out.println(hashTable2.contains(6));
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" +
							fileName + "'");
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '"
							+ fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}

//    	IUniversalHash universalHash = new UniversalHashMatrix(8);
//    	System.out.println(universalHash.getHashValue(5));
//    	System.out.println(universalHash.getHashValue(5));
//    	System.out.println(universalHash.getHashValue(5));
//    	System.out.println(universalHash.getHashValue(5));
//    	universalHash.generateNewRandomHashFunction();
//    	System.out.println(universalHash.getHashValue(5));
//    	System.out.println(universalHash.getHashValue(5));
//    	System.out.println(universalHash.getHashValue(5));
//    	System.out.println(universalHash.getHashValue(5));


    }
}