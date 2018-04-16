package perfectHash;

import interfaces.IUniversalHash;

public class main {

    public static void main (String args[]){
    	IUniversalHash universalHash = new UniversalHashMatrix(8);
    	System.out.println(universalHash.getHashValue(5));
    	System.out.println(universalHash.getHashValue(5));
    	System.out.println(universalHash.getHashValue(5));
    	System.out.println(universalHash.getHashValue(5));

    }
}
