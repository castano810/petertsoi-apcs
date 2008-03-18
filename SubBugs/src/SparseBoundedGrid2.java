// SparseBoundedGrid with LinkedLists
// Peter Tsoi & Justin Uang

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
            occupantArray.set(i, null);
        }
    }
    
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
            
        return locs;
    }
    
    public E get(Location loc){
        LinkedList<OccupantInCol> currentRow = occupantArray.get(loc.getRow());
		return (E) currentRow.get(loc.getCol()).getOccupant();
    }
    
    public E remove(Location loc){
        LinkedList<OccupantInCol> currentRow = occupantArray.get(loc.getRow());
		return (E) currentRow.remove(loc.getCol());
    }
    
    public E put(Location loc, Object obj){
        LinkedList<OccupantInCol> currentRow = occupantArray.get(loc.getRow());
		currentRow.add(loc.getCol(), new OccupantInCol(obj, loc.getCol()));
		
		return (E) obj;
    }
    
    public boolean isValid(Location loc){
        return true;
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
