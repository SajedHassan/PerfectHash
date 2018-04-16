package perfectHash;

import java.util.ArrayList;

public interface HashTable {

    ArrayList<Comparable> keys  = new ArrayList<Comparable>();

    void hash();

    Comparable get(Comparable key);

}
