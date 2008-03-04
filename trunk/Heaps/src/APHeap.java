//
//  APHeap.java
//  Heaps
//
//  Created by Justin Uang and Peter Tsoi
//

import java.util.*;

public class APHeap<E extends Comparable> {
	public APHeap()
	{
		heapArray = new ArrayList<E>();
	}
	
	public boolean isEmpty()
	{
		return heapArray.get(0) == null;
	}
	
	public int size()
	{
		return -1;
	}
	
	public boolean add(E object)
	{
		
		return false;
	}
	
	public E removeMin()
	{
		return null;
	}
	
	public E peekMin()
	{
		return null;
	}
	
	private ArrayList<E> heapArray;
}
