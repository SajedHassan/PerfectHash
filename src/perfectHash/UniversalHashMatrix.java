package perfectHash;

import java.util.BitSet;
import java.util.Random;

import interfaces.IUniversalHash;

public class UniversalHashMatrix<T> implements IUniversalHash<T> {
	private int numOfRows;
	private final int NUMOFCOLUMNS = 32;
	BitSet[] hMatrix;

	public UniversalHashMatrix(int numOfElements) {
		this.numOfRows = (int) Math.ceil(Math.log(numOfElements) / Math.log(2));
		hMatrix = new BitSet[numOfRows];
		for (int i = 0; i < hMatrix.length; i++) {
			hMatrix[i] = new BitSet(NUMOFCOLUMNS);
		}
		this.generateNewRandomHashFunction();
	}

	@Override
	public void generateNewRandomHashFunction() {
		Random randomNumbersGenerator = new Random();
		for (int i = 0; i < this.hMatrix.length; i++) {
			for (int j = 0; j < this.NUMOFCOLUMNS; j++) {
				this.hMatrix[i].set(j, randomNumbersGenerator.nextBoolean());
			}
		}
	}

	@Override
	public int getHashValue(T key) {
		int hashedValue = 0;

		for (int i = 0; i < this.numOfRows; i++) {
			int bitOfOperations = 0;
			for (int j = this.NUMOFCOLUMNS - 1; j >= 0 ; j--) {
				int maskedValue = (int)key & (int)Math.pow(2, j);
				if (maskedValue > 0 && hMatrix[i].get(j)) {
					bitOfOperations++;
				}
			}
			bitOfOperations %= 2;
			hashedValue += bitOfOperations * Math.pow(2, this.numOfRows - 1 - i);
		}
		return hashedValue;
	}

}