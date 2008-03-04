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


public class ItemPair extends Object
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
    public int heapValue()
	{
	return 50000 - first;
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

