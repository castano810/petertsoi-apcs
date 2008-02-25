//
//  BogusLocation.java
//  PriorityQueues
//
//  Created by Justin Uang on 2/25/08.
//  Copyright 2008 __MyCompanyName__. All rights reserved.
//

public class BogusLocation implements Comparable
{
	public BogusLocation(int h, int v)
	{
		this.h = h;
		this.v = v;
	}
	
	public int distFromCenter()
	{
		int distance = 0;
		distance += Math.abs(5 - h);
		distance += Math.abs(5 - v);
		
		return distance;
	}
	
	public int compareTo(Object otherObject)
	{
		if (this.distFromCenter() < otherObject.distFromCenter())
		{
			return -1;
		}
		else if(this.distFromCenter() > otherObject.distFromCenter())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public boolean equals(Object otherObject)
	{
		if (this.h == otherObject.h && this.v == otherObject.v)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private int h, v;
}
