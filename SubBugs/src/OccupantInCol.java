// SparseBoundedGrid with LinkedLists
// Peter Tsoi & Justin Uang
// OccupantinCol.java

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