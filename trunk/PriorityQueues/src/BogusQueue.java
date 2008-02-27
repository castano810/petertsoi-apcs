//
//  DoubleQueue.java
//  DoubleQueue
//
//  Created by Justin Uang on 2/25/08.
//  Copyright (c) 2008 __MyCompanyName__. All rights reserved.
//
import java.util.*;

public class BogusQueue {
	
	private ArrayList<BogusLocation> arrayList;
	private PriorityQueue<BogusLocation> pqueue;
	
	public BogusQueue()
	{
		generateBogusLocations(25);
		generatePriorityQueue();
	}
	
	private void generateBogusLocations(int numLocations)
	{
		arrayList = new ArrayList<BogusLocation>();
		for (int i = 0; i < numLocations; i++)
		{
			arrayList.add(new BogusLocation());
		}
	}
	
	public void printArrayList()
	{
		if (arrayList.size() > 0)
		{
			for (BogusLocation num : arrayList)
			{
				System.out.print(num + "\t");
			}
		}
	}
	
	private void generatePriorityQueue()
	{
		pqueue = new PriorityQueue<BogusLocation>();
		if (arrayList.size() > 0)
		{
			for (BogusLocation num : arrayList)
			{
				pqueue.add(num);
			}
		}
	}
	
	public void printPriorityQueue()
	{
		BogusLocation nextLocation = pqueue.poll();
		while (nextLocation != null)
		{
			System.out.println(nextLocation);
			nextLocation = pqueue.poll();
		}
	}
}
