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
        hashType1(UPCArray);
        hashType2(UPCArray);
        hashType3(UPCArray);
	}
	
	private void generateNumbers(int n)
	{
		int addCounter = 0;
		while (addCounter < n)
		{
			Long newNum = generateLong(10);
			
			if (UPCs.add(newNum))
			{
				//System.out.println(newNum);
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
            long quint1 = n/100000;
            long quint2 = n-(quint1*100000);
            long code;
            
            code = (quint1/1000) * (quint2 - (quint2/1000));
            code = (code + (37 * (((quint1 - (quint1/1000)*1000)/100) + ((quint2 - (quint2/1000)*1000)/100))))%14983;
            if (!hashCodes1.add((int)code))
                collisions++;
            else
                buckets++;
        }
        System.out.println("Hash Algorithm #1 ******************");
        double lf = ((double)buckets)/14983;
        System.out.println("\t" + buckets + " buckets of 14983 used. Load Factor: " + lf);
        int cp = (int)((((double)collisions)/((double)14983))*100);
        System.out.println("\t" + collisions + " buckets contain more than 1 element (collisions) " + cp + "%");
    }
    
    private void hashType2(long[] arr)
    {
        int collisions = 0;
        int buckets = 0;
        for (long n : arr)
        {
            // Quint Split
            long quint1 = n/100000000;
            long quint2 = (n-(quint1*100000000))/1000000;
            long quint3 = (n-(quint1*100000000)-(quint2*1000000))/10000;
            long quint4 = (n-(quint1*100000000)-(quint2*1000000)-(quint3*10000))/100;
            long quint5 = (n-(quint1*100000000)-(quint2*1000000)-(quint3*10000)-(quint4*100));
            long code;
            
            code = (quint1 * quint3 * quint5) + 7*(quint2 + 31*quint4);
            code = code%14983;
            if (!hashCodes1.add((int)code))
                collisions++;
            else
                buckets++;
        }
        System.out.println("Hash Algorithm #2 ******************");
        double lf = ((double)buckets)/14983;
        System.out.println("\t" + buckets + " buckets of 14983 used. Load Factor: " + lf);
        int cp = (int)((((double)collisions)/((double)14983))*100);
        System.out.println("\t" + collisions + " buckets contain more than 1 element (collisions) " + cp + "%");
    }
    
    private void hashType3(long[] arr)
    {
        
        int collisions = 0;
        int buckets = 0;
        for (long n : arr)
        {
            // Quint Split
            long quint1 = n/100000000;
            long quint2 = (n-(quint1*100000000))/1000000;
            long quint3 = (n-(quint1*100000000)-(quint2*1000000))/10000;
            long quint4 = (n-(quint1*100000000)-(quint2*1000000)-(quint3*10000))/100;
            long quint5 = (n-(quint1*100000000)-(quint2*1000000)-(quint3*10000)-(quint4*100));
            long code;
            //code = (quint1*37)+(quint4*6)+(quint3/7)-(quint2*91)-(quint5*29);
            code = n;
            code = code%999999999;
            if (!hashCodes1.add((int)code))
                collisions++;
            else
                buckets++;
        }
        System.out.println("Hash Algorithm #3 ******************");
        double lf = ((double)buckets)/14983;
        System.out.println("\t" + buckets + " buckets of 14983 used. Load Factor: " + lf);
        int cp = (int)((((double)collisions)/((double)14983))*100);
        System.out.println("\t" + collisions + " buckets contain more than 1 element (collisions) " + cp + "%");
    }
	
    private long[] UPCArray;
	private HashSet<Long> UPCs;
    private HashSet<Integer> hashCodes1 = new HashSet(14983);
    private HashSet<Integer> hashCodes2 = new HashSet(14983);
    private HashSet<Integer> hashCodes3 = new HashSet(14983);
}
