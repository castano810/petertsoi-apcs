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
            // Quint Split
            int quint1 = (int) n/100000;
            int quint2 = (int) n-quint1;
            
            // Multiply quint1's first two digits with last two of quint2
            // Multiply quint1's last two digits with first two from quint2
            // Add together
            // Add middle digit from quint1 to middle digit of quint2, multiply by 37, add to #3
            // Ans%14983
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
