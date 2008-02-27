//
//  BogusLocation.java
//  PriorityQueues
//
//  Created by Justin Uang on 2/25/08.
//  Copyright 2008 __MyCompanyName__. All rights reserved.
//

import java.util.*;

public class BogusLocation implements Comparable
{
	public BogusLocation(int h, int v)
	{
		this.h = h;
		this.v = v;
	}
	
	public BogusLocation()
	{
		Random gen = new Random();
		this.h = gen.nextInt(11);
		this.v = gen.nextInt(11);
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
		if (otherObject instanceof BogusLocation)
		{
			if (this.distFromCenter() < ((BogusLocation)otherObject).distFromCenter())
			{
				return -1;
			}
			else if(this.distFromCenter() > ((BogusLocation)otherObject).distFromCenter())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		
		return -2;
	}
	
	public boolean equals(Object otherObject)
	{
		if (this.h == ((BogusLocation)otherObject).h && this.v == ((BogusLocation)otherObject).v)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		return "H: " + h + "\tV: " + v + "\tDistance From Center: " + distFromCenter();
	}
	
	private int h, v;
}
