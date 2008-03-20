// SparseBoundedGrid with LinkedLists
// Peter Tsoi & Justin Uang
// SparseBoundedGrid.java

package info.gridworld.grid;

import java.util.*;

public class SparseBoundedGrid2<E> extends AbstractGrid<E> {
    public SparseBoundedGrid2(int rows, int cols){
        if (rows <= 0)
            throw new IllegalArgumentException("rows <= 0");
        if (cols <= 0)
            throw new IllegalArgumentException("cols <= 0");
		this.rows = rows;
		this.cols = cols;
		
        occupantArray = new ArrayList< LinkedList<OccupantInCol> >();

        for (int i = 0; i < rows; i++) {
            occupantArray.add(new LinkedList<OccupantInCol>());
        }
    }
    
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        for(int i = 0; i < occupantArray.size(); i++)
		{
			LinkedList<OccupantInCol> currentRow = occupantArray.get(i);
			for (OccupantInCol currentCol : currentRow)
			{
				if (currentCol.getOccupant() != null)
				{
					locs.add(new Location(i, currentCol.getCol()));
				}
			}
		}
        return locs;
    }
    
    public E get(Location loc){
        LinkedList<OccupantInCol> currentRow = occupantArray.get(loc.getRow());
		for (OccupantInCol occInCol : currentRow)
		{
			if (occInCol.getCol() == loc.getCol()){
				return (E) occInCol.getOccupant();
			}
		}
		return null;
    }
    
    public E remove(Location loc){
        LinkedList<OccupantInCol> currentRow = occupantArray.get(loc.getRow());
		for (int i = 0; i < currentRow.size(); i++)
		{
			ListIterator it = currentRow.listIterator();
			while (it.hasNext())
			{
				OccupantInCol nextCol = (OccupantInCol)it.next();
				if (nextCol.getCol() == loc.getCol())
				{
					it.remove();
					return (E) nextCol.getOccupant();
				}
			}
		}
		return null;
		
    }
    
    public E put(Location loc, Object obj){
        LinkedList<OccupantInCol> currentRow = occupantArray.get(loc.getRow());
		currentRow.add(new OccupantInCol(obj, loc.getCol()));
		return (E) obj;
    }
    
    public boolean isValid(Location loc){
        return (loc.getRow() < rows) && (loc.getCol() < cols) && (loc.getRow() >= 0) && (loc.getCol() >= 0);
    }
	
	public int getNumRows()
	{
		return rows;
	}
	
	public int getNumCols()
	{
		return cols;
	}
    
    private ArrayList<LinkedList<OccupantInCol>> occupantArray;
	private int rows, cols;
}
