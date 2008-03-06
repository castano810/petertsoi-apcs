//  Heaps: Of stuff to do
//  Authors: Justin & Peter


import java.util.*;

public class Heaps {

    public static void main (String args[]) {
        APHeap aBigHeap = new APHeap<Double>();
		aBigHeap.add(new Double(25));
		aBigHeap.add(new Double(23));
		aBigHeap.add(new Double(15));
		aBigHeap.add(new Double(8));
		aBigHeap.add(new Double(9));
		aBigHeap.add(new Double(10));
		aBigHeap.add(new Double(11));
		aBigHeap.dumpToTree();
    }
}
