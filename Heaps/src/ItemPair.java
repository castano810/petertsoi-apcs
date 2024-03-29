// Project:
// File:
// Authors:
// Date Started:
// Progress:
// Date Completed:
// Notes:
// TODO:

import java.io.FileReader;
import java.io.StreamTokenizer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class ItemPair extends Object implements Comparable
    {
    public ItemPair(StreamTokenizer parser) throws IOException
        {
        super();
        first = second = 0;
        if (parser.ttype == StreamTokenizer.TT_NUMBER)
            {
            first = (int)parser.nval;
            if (parser.nextToken() == StreamTokenizer.TT_NUMBER)
                {
                second = (int)parser.nval;
                }
            }
        }
		public ItemPair(int first, int second)
		{
			this.first = first;
			this.second = second;
		}
		public int heapValue()
		{
			return 50000 - first;
		}
		
		public int compareTo(Object other)
		{
			if (((ItemPair)other).heapValue() > heapValue())
			{
				return -1;
			}
			if (((ItemPair)other).heapValue() < heapValue())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		
		public String toString()
		{
			return "First: " + first + "\tSecond: " + second;
		}
		
    public int getFirst()
        {
        return first;
        }
    public int getSecond()
        {
        return second;
        }
    private int first;
    private int second;
    }

