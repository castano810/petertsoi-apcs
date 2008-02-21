// Authors: Peter Tsoi & Justin Uang
// HashCodeSim

import java.util.*;

public class HashCodeSim {
    public static void main (String args[]) {
		HashCodeSim simulator = new HashCodeSim();
    }
	
	public HashCodeSim()
	{
		UPCs = new HashSet();
		UPCArray = new long[10000];
		generateNumbers(10000);
	}
	
	private void generateNumbers(int n)
	{
		int addCounter = 0;
		while (addCounter < n)
		{
			Long newNum = generateLong(10);
			
			if (UPCs.add(newNum))
			{
				System.out.println(newNum);
				UPCArray[addCounter] = newNum;
				addCounter++;
			}
		}
	}
	
	private Long generateLong(int numDigits)
	{
		String longString = "";
		Random generate = new Random();
		
		for (int i = 0; i < numDigits; i++)
		{
			if (i == 0)
			{
				longString += generate.nextInt(9) + 1;
			}
			else
			{
				longString += generate.nextInt(10);
			}
		}
		
		return new Long(longString);
	}
    
    private void hashType1(long[] arr)
    {
        int collisions = 0;
        int buckets = 0;
        for (long n : arr)
        {
            // Quint Split
            int quint1 = (int) n/100000;
            int quint2 = (int) n-quint1;
            int code;
            
            // Multiply quint1's first two digits with last two of quint2
            // Multiply quint1's last two digits with first two from quint2
            // Add together
            code = (quint1/1000) * (quint2 - (quint2/1000));
            // Add middle digit from quint1 to middle digit of quint2, multiply by 37, add to #3
            // Ans%14983
            code = (code + (37 * (((quint1 - (quint1/1000)*1000)/100) + ((quint2 - (quint2/1000)*1000)/100))))%14983;
            if (!hashCodes1.add((Integer)code))
                collisions++;
            else
                buckets++;
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
    private HashSet<Integer> hashCodes1 = new HashSet(14983);
    private HashSet<Integer> hashCodes2 = new HashSet(14983);
    private HashSet<Integer> hashCodes3 = new HashSet(14983);
}
