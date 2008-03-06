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
		reHeap(heapArray.size() - 1, object);
		
		return true;
	}
	public void reHeap(int tempIndex, E object)
	{
		E parent = heapArray.get((tempIndex - 1) / 2);
		while (object.compareTo(parent) > 0 && tempIndex != -1)
		{
			//System.out.println("Swap: " + object + "\tWith: "+ parent);
			//dumpToTree();
			
			E temp = parent;
			heapArray.set((tempIndex - 1) / 2, object);
			heapArray.set(tempIndex, temp);
			if (tempIndex == 0)
			{
			   tempIndex = -1;
			}
			else
			{
				tempIndex = (tempIndex - 1) / 2;
				parent = heapArray.get((tempIndex - 1) / 2);
			}
			//System.out.println();
		}
	}
    
    public void reHeapDown(int tempIndex)
	{
		if ((tempIndex*2)+2 < heapArray.size()){
            System.out.println("Moving to: " + ((tempIndex*2)+2) + " From: " + tempIndex);
            reHeapDown((tempIndex*2)+2);
        }
        
        if ((tempIndex*2)+1 < heapArray.size()){
            System.out.println("Moving to: " + ((tempIndex*2)+1) + " From: " + tempIndex);
            reHeapDown((tempIndex*2)+1);
        }
        
        reHeap(tempIndex, heapArray.get(tempIndex));
	}
	
	public E removeMax()
	{
        E object = heapArray.get(0);
        int objIndex = 0;
        while ((objIndex*2)+2 < heapArray.size()) {
            heapArray.set(objIndex, heapArray.get((objIndex*2)+2));
            objIndex = (objIndex*2)+2;
        }
        heapArray.remove(objIndex);
        reHeapDown(0);
		return object;
	}
	
	public E peekMax()
	{
		return heapArray.get(0);
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
