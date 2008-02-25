//  File: Floor.java
//  Author: Justin Uang and Peter Tsoi
//  Date Started: October 18, 2007
//  Date Completed: October 30, 2007
//  Notes: Plane Class

public class Floor {
    
    private static int currentNum = 0;
    
    //Constructs a 2 by 1 or a a by 2 array based on the parameter
    public Floor(boolean isVertical)
    {
        if (isVertical)
        {
            floorConfiguration = new int[2][1];

            floorConfiguration[0][0] = currentNum;
            floorConfiguration[1][0] = currentNum;
        }
        else
        {
            floorConfiguration = new int[1][2];
            
            floorConfiguration[0][0] = currentNum;
            floorConfiguration[0][1] = currentNum;
        }
        
        currentNum++;
    }
    
    //Creates a floor with the floorConfiguration
    public Floor(int[][] floorConfiguration)
    {
        this.floorConfiguration = floorConfiguration;
    }
    
    //Merges to floors together
    //isVertical - direction to merge the floors
    public Floor mergeWith(Floor otherFloor, boolean isVertical)
    {
        int[][] returnArray;
        if (isVertical)
        {
            returnArray = new int[this.getNumRows() + otherFloor.getNumRows()][this.getNumCols()];
            
            int returnArrayNextIndex = 0;
            for(int[] row : this.getFloorConfiguration())
            {
                returnArray[returnArrayNextIndex] = row;
                returnArrayNextIndex++;
            }
            
            for(int[] row : otherFloor.getFloorConfiguration())
            {
                returnArray[returnArrayNextIndex] = row;
                returnArrayNextIndex++;
            }
        }
        else
        {
            returnArray = new int[this.getNumRows()][this.getNumCols() + otherFloor.getNumCols()];
            
            for (int i = 0; i < this.getNumRows(); i++)
            {
                int[] completeRow = new int[this.getNumCols() + otherFloor.getNumCols()];
                
                int nextIndex = 0;
                for(int value : this.getFloorConfiguration()[i])
                {
                    completeRow[nextIndex] = value;
                    nextIndex++;
                }
                for(int value : otherFloor.getFloorConfiguration()[i])
                {
                    completeRow[nextIndex] = value;
                    nextIndex++;
                }
                
                returnArray[i] = completeRow;
            }
        }
        return new Floor(returnArray);
    }
    
    public int getNumRows()
    {
        return floorConfiguration.length;
    }
    
    public int getNumCols()
    {
        return floorConfiguration[0].length;
    }
    
    //Prints out the floor configuration
    public void dump()
    {
        for (int[] row : floorConfiguration)
        {
            for (int value : row)
            {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public int[][] getFloorConfiguration() {
        return floorConfiguration;
    }

    public void setFloorConfiguration(int[][] floorConfiguration) {
        this.floorConfiguration = floorConfiguration;
    }
    
    private int[][] floorConfiguration;
}