 import java.util.ArrayList;
//  File: TilesTwo.java
//  Author: Justin Uang and Peter Tsoi
//  Date Started: October 18, 2007
//  Date Completed: October 30, 2007
//  Notes: Main Method / Testing Class
 
 // Peter Was Here
 
public class TilesTwo
{   
    //method that tiles the floor and prints out the results
    public static void tileFloor(int rows, int cols)
    {
        TilesTwo tester = new TilesTwo();
        Floor[] results = tester.split(rows, cols);
        int floorCounter = 0;
        results = checkRepeats(results);
        for (Floor oneFloor : results)
        {
            if (oneFloor != null)
            {
                floorCounter++;
                oneFloor.dump();
            }
        }
        System.out.println("Patterns: " +  floorCounter);
    }
    
    //Method that takes in an array, assigns new numbers using a consistent
    //numbering scheme, and then deletes the duplicates
    public static Floor[] checkRepeats(Floor[] results)
    {
        for (int h = 0; h < results.length; h++)
        {
            Floor oneFloor = results[h];
            if (oneFloor != null)
            {
                int[][] configuration = oneFloor.getFloorConfiguration();
                int currentInt = 0;
                for (int i = 0; i < configuration.length; i++)
                {
                    for (int j = 0; j < configuration[i].length; j++)
                    {
                        int thisInt = configuration[i][j];
                        if (thisInt >= currentInt)
                        {
                            configuration[i][j] = currentInt;
                            
                            if (replaceOne(thisInt, currentInt, configuration))
                            {
                                currentInt++;
                            }
                        }
                    }
                }
                results[h].setFloorConfiguration(configuration);
            }
        }
        ArrayList<Floor> returnArrayList = new ArrayList<Floor>();
        for (Floor oneFloor : results) // Delete Repeats
        {
            boolean exists = false;
            for (Floor twoFloor : returnArrayList)
            {
                if (oneFloor != null && twoFloor !=null)
                {
                    if (arrayEquals(oneFloor.getFloorConfiguration(), twoFloor.getFloorConfiguration()))
                    {
                        exists = true;
                    }
                }
            }
            
            if (!exists)
            {
                returnArrayList.add(oneFloor);
            }
        }
        
        Floor[] returnFloor = new Floor[returnArrayList.size()];
        return returnArrayList.toArray(returnFloor);
    }
    
    //Replaces the first instance of a oldNum with a newNum inside a numArray
    private static boolean replaceOne(int oldNum, int newNum, int[][] numArray)
    {
        for (int i = 0; i < numArray.length; i++)
        {
            for (int j = 0; j < numArray[i].length; j++)
            {
                if (numArray[i][j] == oldNum)
                {
                    numArray[i][j] = newNum;
                    return true;
                }
            }
        }
        return false;
    }
    
    //Checks if two arrays are equal
    private static boolean arrayEquals(int[][] array1, int[][] array2)
    {
        if (array1.length == array2.length && array1[0].length == array2[0].length)
        {
            for (int i = 0; i < array1.length; i++)
            {
                for (int j = 0; j < array1[i].length; j++)
                {
                    if (array1[i][j] != array2[i][j])
                    {
                        return false;
                    }
                }
            }
        }
        else
        {
            return false;
        }
        
        return true;
    }
    
    //Starts the tile Floor process
    public static void main (String[] args)
    {
        tileFloor(4, 6);
    }
    
    //Recursive method that splits the array in every possible way
    public Floor[] split(int rows, int cols)
    {
        Floor[] returnFloor = null;
        if ((rows * cols) % 2 == 1) 
        {
            returnFloor = null;
        }
        else if((rows * cols) == 2)
        {
            returnFloor = new Floor[1];
            if(rows == 2)
            {
                returnFloor[0] = new Floor(true);
            }
            else
            {
                returnFloor[0] = new Floor(false);
            }
        }
        else
        {
            Floor[] floor1;
            Floor[] floor2;
            
            ArrayList<Floor> horizontalReturnFloor = new ArrayList<Floor>();
            ArrayList<Floor> verticalReturnFloor = new ArrayList<Floor>();
            
            for (int r = 1; r < rows; r++)
            {
                if ((r * cols) % 2 != 1 && ((rows - r) * cols) % 2 != 1)
                {
                    floor1 = split(r, cols);
                    floor2 = split(rows-r, cols);
                    
                    Floor[] additionalFloors = merge(floor1, floor2, true);
                    for(Floor newFloor : additionalFloors)
                    {
                        if (newFloor != null)
                        {
                            horizontalReturnFloor.add(newFloor);
                        }
                    }
                }
            }
            
            for (int c = 1; c < cols; c++)
            {
                if ((rows * c) % 2 != 1 && ((cols - c) * rows) % 2 != 1)
                {
                    floor1 = split(rows, c);
                    floor2 = split(rows, cols - c);
                    
                    Floor[] additionalFloors = merge(floor1, floor2, false);
                    for(Floor newFloor : additionalFloors)
                    {
                        if (newFloor != null)
                        {
                            verticalReturnFloor.add(newFloor);
                        }
                    }
                }
            }
            
            ArrayList<Floor> returnArrayList = new ArrayList<Floor>();
            returnArrayList.addAll(horizontalReturnFloor);
            returnArrayList.addAll(verticalReturnFloor);
            returnFloor = new Floor[returnArrayList.size()];
            returnArrayList.toArray(returnFloor);
        }
        return returnFloor;
    }
    
    //Merges arrays containing split floors together and returns an array
    //containing every possible combination
    private Floor[] merge(Floor[] floorArray1, Floor[] floorArray2, boolean isVertical)
    {
        Floor[] returnArray;
        returnArray = new Floor[floorArray1.length * floorArray2.length];

        int nextIndex = 0;
        for (int i = 0; i < floorArray1.length; i++)
        {
            for (int j = 0; j < floorArray2.length; j++)
            {
                if (floorArray1[i] != null && floorArray2[j] != null)
                {
                    returnArray[nextIndex] = floorArray1[i].mergeWith(floorArray2[j], isVertical);
                    nextIndex++;
                }
            }
        }
        
        return returnArray;
    }
}