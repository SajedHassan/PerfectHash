package interfaces;

public interface IUniversalHash<T> {

    public void generateNewRandomHashFunction ();

	public int getHashValue(T key);
}