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
		hashConstants = new int[5];
		hashConstants[0] = 1;
		hashConstants[1] = 11;
		hashConstants[2] = 29;
		hashConstants[3] = 73;
		hashConstants[4] = 97;
		generateNumbers(10000);
        hashType1(UPCArray);
        hashType2(UPCArray);
        hashType3(UPCArray);
		oneMoreHash(UPCArray);
        //hashType1(new long[] {1234567890});
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
        loadfactor = new int[14983];
        hashArr = new int[3];
        int hci = 0;
        for (long n : arr)
        {
            // Quint Split
            long quint1 = n/100000;
            long quint2 = n-(quint1*100000);
            long code;
            
            code = ((quint1/1000) * (quint2-((quint2/100)*100))) + ((quint2/1000) * (quint1-((quint1/100)*100)));
            
            code = (code + (37 * (((quint1 - (quint1/1000)*1000)/100) + ((quint2 - (quint2/1000)*1000)/100))))%14983;
            //System.out.print(code);
            if (!hashCodes1.add((int)code))
                //collisions++;
                collisions = 0;
            else
                buckets++;
            loadfactor[(int)code]++;
            hashArr[hci] = (int)code;
            hci++;
            if (hci == 3)
                hci=0;
        }
        for(int i : loadfactor)
        {
            if (i >1){
                collisions++;
            }
        }
        System.out.println("Hash Algorithm #1 ******************");
        double lf = ((double)buckets)/14983;
        System.out.println("\t" + buckets + " buckets of 14983 used. Load Factor: " + lf);
        int cp = (int)((((double)collisions)/((double)buckets))*100);
        System.out.println("\t" + collisions + " buckets contain more than 1 element (collisions) " + cp + "%");
        System.out.print("\tLast 3 Hash Codes: ");
        for (int hc : hashArr)
            System.out.print(hc + ", ");
        System.out.println();
    }
    
    private void hashType2(long[] arr)
    {
        int collisions = 0;
        int buckets = 0;
        loadfactor = new int[14983];
        hashArr = new int[3];
        int hci = 0;
        for (long n : arr)
        {
            // Quint Split
            long quint1 = n/100000000;
            long quint2 = (n-(quint1*100000000))/1000000;
            long quint3 = (n-(quint1*100000000)-(quint2*1000000))/10000;
            long quint4 = (n-(quint1*100000000)-(quint2*1000000)-(quint3*10000))/100;
            long quint5 = (n-(quint1*100000000)-(quint2*1000000)-(quint3*10000)-(quint4*100));
            long code;
            
            code = (quint1 * quint3 * quint5) + (7*quint2) + (31*quint4);
            
            code = code%14983;
            if (!hashCodes2.add((int)code))
                collisions = 0;
            else
                buckets++;
            
            loadfactor[(int)code]++;
            hashArr[hci] = (int)code;
            hci++;
            if (hci == 3)
                hci=0;
        }
        for(int i : loadfactor)
        {
            if (i >1){
                collisions++;
            }
        }
        System.out.println("Hash Algorithm #2 ******************");
        double lf = ((double)buckets)/14983;
        System.out.println("\t" + buckets + " buckets of 14983 used. Load Factor: " + lf);
        int cp = (int)((((double)collisions)/((double)buckets))*100);
        System.out.println("\t" + collisions + " buckets contain more than 1 element (collisions) " + cp + "%");
        System.out.print("\tLast 3 Hash Codes: ");
        for (int hc : hashArr)
            System.out.print(hc + ", ");
        System.out.println();
    }
    
    private void hashType3(long[] arr)
    {
        
        int collisions = 0;
        int buckets = 0;
        loadfactor = new int[14983];
        hashArr = new int[3];
        int hci = 0;
        
        for (long n : arr)
        {
            // Quint Split
            long quint1 = n/100000000;
            long quint2 = (n-(quint1*100000000))/1000000;
            long quint3 = (n-(quint1*100000000)-(quint2*1000000))/10000;
            long quint4 = (n-(quint1*100000000)-(quint2*1000000)-(quint3*10000))/100;
            long quint5 = (n-(quint1*100000000)-(quint2*1000000)-(quint3*10000)-(quint4*100));
            long code;
            
            code = (quint5*quint1) + 100*(quint4*quint3) + 1000000*(quint2);
            
            code = code%14983;
            
            if (!hashCodes3.add((int)code))
                collisions = 0;
            else
                buckets++;
            
            loadfactor[(int)code]++; 
            hashArr[hci] = (int)code;
            hci++;
            if (hci == 3)
                hci=0;
        }
        for(int i : loadfactor)
        {
            if (i >1){
                collisions++;
            }
        }
        System.out.println("Hash Algorithm #3 ******************");
        double lf = ((double)buckets)/14983;
        System.out.println("\t" + buckets + " buckets of 14983 used. Load Factor: " + lf);
        int cp = (int)((((double)collisions)/((double)buckets))*100);
        System.out.println("\t" + collisions + " buckets contain more than 1 element (collisions) " + cp + "%");
        System.out.print("\tLast 3 Hash Codes: ");
        for (int hc : hashArr)
            System.out.print(hc + ", ");
        System.out.println();
    }
    
    private void oneMoreHash(long[] arr)
    {
        int collisions = 0;
        int buckets = 0;
        loadfactor = new int[14983];
        hashArr = new int[3];
        int hci = 0;
        
        for (long n : arr)
        {
            // Quint Split
            long quint1 = n/100000000;
            long quint2 = (n-(quint1*100000000))/1000000;
            long quint3 = (n-(quint1*100000000)-(quint2*1000000))/10000;
            long quint4 = (n-(quint1*100000000)-(quint2*1000000)-(quint3*10000))/100;
            long quint5 = (n-(quint1*100000000)-(quint2*1000000)-(quint3*10000)-(quint4*100));
            long code;
            
            code = quint1 * hashConstants[0] + quint2 * hashConstants[1] + quint3 * hashConstants[2] + quint4 * hashConstants[3] + quint5 * hashConstants[4]; 
            code = code % 14983;
			if (!oneMoreHashCodes.add((int)code))
                collisions = 0;
            else
                buckets++;
            
            loadfactor[(int)code]++; 
            hashArr[hci] = (int)code;
            hci++;
            if (hci == 3)
                hci=0;
        }
        for(int i : loadfactor)
        {
            if (i >1){
                collisions++;
            }
        }
        System.out.println("One More Hash ******************");
        double lf = ((double)buckets)/14983;
        System.out.println("\t" + buckets + " buckets of 14983 used. Load Factor: " + lf);
        int cp = (int)((((double)collisions)/((double)buckets))*100);
        System.out.println("\t" + collisions + " buckets contain more than 1 element (collisions) " + cp + "%");
        System.out.print("\tLast 3 Hash Codes: ");
        for (int hc : hashArr)
            System.out.print(hc + ", ");
        System.out.println();
    }
	
    private long[] UPCArray;
	private HashSet<Long> UPCs;
    private HashSet<Integer> hashCodes1 = new HashSet(14983);
    private HashSet<Integer> hashCodes2 = new HashSet(14983);
    private HashSet<Integer> hashCodes3 = new HashSet(14983);
    private HashSet<Integer> oneMoreHashCodes = new HashSet(14983);
    private int[] hashArr;
    private int[] loadfactor;
	private int hashConstants[];
}
