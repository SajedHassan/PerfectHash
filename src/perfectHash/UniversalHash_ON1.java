package perfectHash;

public class UniversalHash_ON1 implements IUniversalHash {

    int numOfKeys ;
    int lentgthOfIndex_b;

    UniversalHash_ON1(int keys){
        numOfKeys = keys;
        lentgthOfIndex_b = (int)Math.ceil(Math.log(keys)/Math.log(2));
    }
    @Override
    public int[][] generateRandomHashFunction() {

        return new int[0][];
    }

    @Override
    public int[] getHashValue(Comparable key) {
        return new int[0];
    }
}
