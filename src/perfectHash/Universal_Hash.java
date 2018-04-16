package perfectHash;

public interface Universal_Hash {

    int lengthOfKey = 32;

    int[][] generateRandomHashFunction ();

    int[] getHashValue(Comparable key); // return h(x)
}
