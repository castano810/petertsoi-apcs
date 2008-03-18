//
//  OccupantInCol.java
//  SubBugs
//
//  Created by Justin Uang on 3/18/08.
//  Copyright 2008 __MyCompanyName__. All rights reserved.
//
package info.gridworld.grid;

public class OccupantInCol {
	private Object occupant;
	private int col;
	
	public OccupantInCol(Object occupant, int col)
	{
		this.occupant = occupant;
		this.col = col;
	}
	
	public Object getOccupant()
	{
		return occupant;
	}
	
	public int getCol()
	{
		return col;
	}
	
	public void setOccupant(Object newOccupant)
	{
		occupant = newOccupant;
	}
	
	public void setCol(int newCol)
	{
		col = newCol;
	}
}