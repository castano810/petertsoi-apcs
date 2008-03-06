//  Heaps: Of stuff to do
//  Authors: Justin & Peter


import java.util.*;

public class Heaps {

    public static void main (String args[]) {
        APHeap<ItemPair> aBigHeap = new APHeap<ItemPair>();
		NumSource myNumSource = null;
		try
		{
			myNumSource = new NumSource("GardenItems.txt") ;
		}
		catch(Exception ex)
		{
			System.out.println("File Not Found");
		}
		
		ItemPair ip = myNumSource.nextItemPair();
		while (ip != null)
		{
			aBigHeap.add(ip);
			ip = myNumSource.nextItemPair();
		}
		aBigHeap.dumpToTree();
    }
}
