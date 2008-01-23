//  File: primeArray.java
//  Author: Justin Uang && Peter Tsoi
//  Date Started: September 14, 2007
//  Date Completed: September 14, 2007
//  Notes: Prime Array Class

package factoringarray;
public class Array2D2Primes
{
    private int[][] primeArray;
    private int[][] testArray;
    
    // Constructor (Exer 04)
    // Constructs an array with the desired rows and columns
    public Array2D2Primes (int rows, int cols)      
    {
        primeArray = new int[rows][cols];
        populate(primeArray);
    }
    
    // Returns the next prime #
    // previousPrime = the prime number before the one to be returned
    public int nextPrime(int previousPrime)         
    {
        for (int i = previousPrime + 1; true; i++)
        {
            if (isPrime(i))
            {
                return i;
            }
        }
    }
    
    // True if number is prime
    private boolean isPrime(int input)              
    {
        if (input < 2)
        {
            return false;
        }
        for (int i = 1; i < input; i++)
        {
            if (input % i == 0)
            {
                if (i != 1)
                {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    // Here we go.. Populates the array with the proper numbers
    // Pass in a 2D array and it will fill the array with proper numbers
    private void populate(int[][] array) 
    {
        int lastPrime = 1;
        // Populate the first column
        for (int i = 0; i < array.length; i++)     
        {
            lastPrime = nextPrime(lastPrime);
            array[i][0] = lastPrime;
        }
        
        // Populate the other columns
        for (int i = 0; i < array.length; i++) // Row Loop
        {
            int currentMultiple = array[i][0]; 
            int j = 1;                      // Start with second column
            while(j < array[i].length) // Loop through columns
            {
                boolean shouldInsert = true;    // Escape variable
                while (shouldInsert)
                {
                    currentMultiple += primeArray[i][0];    // Next multiple
                    for (int row = i + 1; row < array.length; row++)
                    {
                        if (currentMultiple % array[row][0] == 0)
                        {
                            shouldInsert = false;
                        }
                    }

                    if (shouldInsert){      // Escape and go to next column
                        array[i][j] = currentMultiple;
                        j++;
                        shouldInsert = false;
                    }
                }
            }
        }
    }
    
    // Prints the value of the array
    public void dump()
    {
        for (int i = 0; i < primeArray.length; i++)
        {
            for (int j = 0; j < primeArray[i].length; j++)
            {
                System.out.print(primeArray[i][j] + "\t");
            }
            
            System.out.println();
        }
    }
    
    // Exer 03
    // Populates testArray with proper numbers and then checks to see if it 
    // matches the array created in primeArray
    public boolean test()
    {
        testArray = new int[primeArray.length][primeArray[0].length];
        populate(testArray);
        for (int i = 0; i < primeArray.length; i++)
        {
            for (int j = 0; j < primeArray[i].length; j++)
            {
                if (primeArray[i][j] != testArray[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
}

/*
 *  Exer 01
 *      We will first populate the first column in each row using a loop,
 *      and inside that loop, we will have another one that goes through each
 *      multiple and checks if it is valid. If it is, then we will put it into 
 *      the row. If it isn't, then we will go on to the next multiple.
 *
 *  Exer 02
 *      Constructor, populate(), and associated methods are included in this 
 *      file. The main() method is contained in main.java.
 *
 *  Exer 03
 *      See public boolean test(). Creates a new array named testArray with 
 *      the correct values and checks them against arrayPrime
 *
 *  Exer 04
 *      Our code was built to this specification the first time around. No 
 *      changes are needed.
 *
 *  Exer 05
 *      See public void dump(). It is reusable because it will print any size 
 *      of array.
 *
 *  Exer 06
 *      The program implemented follows the specification in Exer 01 almost 
 *      exactly. There were two design proposals between the two of us (Justin &
 *      Peter). In one design, there would be a second array to hold the used 
 *      prime numbers and that array would be used to check subsequent values to
 *      see if they were valid. In the current design, the number being inserted
 *      is checked by a modulus opperation to determine whether or not it is a 
 *      valid number. The loop runs on boolean shouldInsert which flags the loop
 *      once the number has been inserted and must move on to the next column or 
 *      row. 
 */