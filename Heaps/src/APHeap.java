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
		return heapArray.size();
	}
	
	public boolean add(E object)
	{
		
		return false;
	}
	
	public E removeMax()
	{
		return null;
	}
	
	public E peekMax()
	{
		return null;
	}
	
	private ArrayList<E> heapArray;
}
