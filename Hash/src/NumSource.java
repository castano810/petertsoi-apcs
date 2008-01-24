// Peter Tsoi & Justin Uang
// Assignment: Hash Maps
// Finished Jan. 18, 2008
// NumSource.java: Retrieves items from txt file

import java.io.FileReader;
import java.io.StreamTokenizer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class NumSource extends FileReader
    {
    public NumSource(String fn) throws FileNotFoundException, IOException
        {
        super(fn);
        at = 0;
        items = new ArrayList<ItemPair>();
        StreamTokenizer parser = new StreamTokenizer(this);
        parser.whitespaceChars(32, 32);
        while (parser.nextToken() != StreamTokenizer.TT_EOF)
            {
            ItemPair pr = new ItemPair(parser);
            items.add(pr);
           }
        close(); // this
        }    
    public void restart()
        {
        at = 0;
        }
    public ItemPair nextItemPair()
        {
        if (at < items.size())
            {
            return items.get(at++);
            }
        else
            return null;
        }
    public void dump()
        {
        System.out.println("There are " + items.size() + " items available.");
        for (int counter = 0; counter < items.size(); counter++)
            {
            ItemPair pr = items.get(counter);
            System.out.println("( " + pr.getFirst() + ", " + pr.getSecond() + " )");
            }
        System.out.println("......... end of dump.");
        }
    public static void main(String[] args) throws FileNotFoundException, IOException
        {
        NumSource x = new NumSource("GardenItems.txt");
        x.dump();
        }
    
    public int ArraySize(){
        return items.size();
    }
    private int at;
    private ArrayList<ItemPair> items;
    } // class NumSource


