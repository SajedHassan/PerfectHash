package perfectHash;

public interface IUniversalHash {

    int lengthOfKey = 32;

    int[][] generateRandomHashFunction ();

    int[] getHashValue(Comparable key); // return h(x)
}
