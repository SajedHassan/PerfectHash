package interfaces;

public interface IUniversalHash<T> {

    public void generateRandomHashFunction ();

	public int getHashValue(T key);
}
