package perfectHash;

import interfaces.IUniversalHash;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main (String args[]) throws FileNotFoundException {


		ArrayList<Integer> keys = new ArrayList<>();
		String fileName = "temp.txt";
		Scanner src = new Scanner(new File(fileName));

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader =
					new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader =
					new BufferedReader(fileReader);

			while(src.hasNext()) {
				keys.add(src.nextInt());
				

			}
			PerfectQuadraticHashTable hashTable1 = new PerfectQuadraticHashTable(keys,keys.size() * keys.size());
			LinearHashTable hashTable2 = new LinearHashTable(keys);
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

    	IUniversalHash universalHash = new UniversalHashMatrix(8);
    	System.out.println(universalHash.getHashValue(5));
    	System.out.println(universalHash.getHashValue(5));
    	System.out.println(universalHash.getHashValue(5));
    	System.out.println(universalHash.getHashValue(5));
    	universalHash.generateNewRandomHashFunction();
    	System.out.println(universalHash.getHashValue(5));
    	System.out.println(universalHash.getHashValue(5));
    	System.out.println(universalHash.getHashValue(5));
    	System.out.println(universalHash.getHashValue(5));


    }
}