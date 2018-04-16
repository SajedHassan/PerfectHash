package perfectHash;

public class UniverdalHashMatrix<T> implements IUniversalHash<T> {
	private int numOfRows;
	private final int NUMOFCOLUMNS = 32;
	int[][] hMatrix = new int[numOfRows][NUMOFCOLUMNS];

	public UniverdalHashMatrix(int numOfElements) {
		this.numOfRows = (int) Math.ceil(Math.log(numOfElements) / Math.log(2));
	}

	@Override
	public void generateRandomHashFunction() {
		
	}

	@Override
	public int getHashValue(T key) {

		return 0;
	}

}
