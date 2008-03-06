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
		heapArray.add(object);
		reHeap(heapArray.size(), object);
		
		
		
		return false;
	}
	public void reHeap(int index, E object)
	{
		int originalSize = index;
		int tempIndex = originalSize;
		E parent = null;
		while (object.compareTo(parent) > 0 && tempIndex != -1)
		{
			System.out.println("Before Swap");
			dumpToTree();
			parent = heapArray.get((tempIndex - 1) / 2);
			E temp = parent;
			heapArray.set((originalSize - 1) / 2, object);
			heapArray.set(originalSize, temp);
			if (tempIndex == 0)
			{
			   tempIndex = -1;
			}
			else
			{
			   tempIndex = (tempIndex - 1) / 2;
			   originalSize = tempIndex;
			}
		}
	}
	
	public E removeMax()
	{
		return null;
	}
	
	public E peekMax()
	{
		return null;
	}
	
	public String toString()
	{
		String returnString = "";
		for (E object : heapArray)
		{
			returnString += object + "\t\t";
		}
		
		return returnString;
	}
	
	public void dumpToTree()
	{
		String returnString = "";
		
		int col = 0, row = 0;
		System.out.println("Tree Dump: ");
		for (int i = 0; i < heapArray.size(); i++)
		{
			System.out.print(heapArray.get(i) + "\t\t\t");
			if (Math.pow(2, row) == col + 1)
			{
				System.out.println();
				row++;
				col = 0;
			}
			else
			{
				col++;
			}
		}
		System.out.println();
	}
	
	private ArrayList<E> heapArray;
}
