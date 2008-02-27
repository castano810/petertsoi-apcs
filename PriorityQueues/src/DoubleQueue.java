//
//  DoubleQueue.java
//  DoubleQueue
//
//  Created by Justin Uang on 2/25/08.
//  Copyright (c) 2008 __MyCompanyName__. All rights reserved.
//
import java.util.*;

public class DoubleQueue {
	
	private ArrayList<Double> arrayList;
	private PriorityQueue<Double> pqueue;
	
	public DoubleQueue()
	{
		generateDoubles(20);
		generatePriorityQueue();
	}
	
	private void generateDoubles(int numDoubles)
	{
		arrayList = new ArrayList<Double>();
		for (int i = 0; i < numDoubles; i++)
		{
			arrayList.add(Math.random() * 100);
		}
	}
	
	public void printArrayList()
	{
		if (arrayList.size() > 0)
		{
			for (Double num : arrayList)
			{
				System.out.print(num + "\t");
			}
		}
	}
	
	private void generatePriorityQueue()
	{
		pqueue = new PriorityQueue<Double>();
		if (arrayList.size() > 0)
		{
			for (Double num : arrayList)
			{
				pqueue.add(num);
			}
		}
	}
	
	public void printPriorityQueue()
	{
		Double nextDouble = pqueue.poll();
		while (nextDouble != null)
		{
			System.out.print(nextDouble + "\t\t");
			nextDouble = pqueue.poll();
		}
	}
}
