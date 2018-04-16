package perfectHash;

public class UniversalHash_ON2 implements IUniversalHash {

    int numOfKeys ;
    int lentgthOfIndex_b;

    UniversalHash_ON2(int keys){

        numOfKeys = keys;
        lentgthOfIndex_b = (int)Math.ceil(Math.log(Math.pow(keys,2))/Math.log(2));

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
