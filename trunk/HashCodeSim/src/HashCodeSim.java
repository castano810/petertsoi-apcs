// Authors: Peter Tsoi & Justin Uang
// HashCodeSim

import java.util.*;

public class HashCodeSim {
    public static void main (String args[]) {
	
    }
	
	private void generateNumbers(int n)
	{
		Random gen = new Random();
		
		int addCounter = 0;
		while (addCounter < 10000)
		{
			long newNum = gen.nextLong();
			if (UPCs.add(newNum))
			{
				addCounter++;
			}
		}
	}
    
    private void hashType1(long[] arr)
    {
        for (long n : arr)
        {
            
        }
    }
    
    private void hashType2()
    {
    }
    
    private void hashType3()
    {
    }
	
    private long[] UPCArray;
	private HashSet<Long> UPCs;
    private HashSet<Integer> hashCodes1;
    private HashSet<Integer> hashCodes2;
    private HashSet<Integer> hashCodes3;
}
