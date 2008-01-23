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


public class WordSource extends FileReader
    {
    public WordSource(String fn) throws FileNotFoundException, IOException
        {
        super(fn);
        at = 0;
        words = new ArrayList<String>();
        StreamTokenizer parser = new StreamTokenizer(this);
        parser.whitespaceChars(10, 32);
        parser.whitespaceChars(';', ';');
        parser.whitespaceChars(':', ':');
        parser.whitespaceChars(',', ',');
        parser.whitespaceChars('.', '.');
        parser.whitespaceChars('?', '?');
        parser.whitespaceChars('!', '!');
        parser.whitespaceChars('"', '"');
        parser.whitespaceChars('\'', '\'');
        while (parser.nextToken() != StreamTokenizer.TT_EOF)
            {
            if (parser.sval != null && parser.sval.length() > 0)
                words.add(parser.sval);
            }
        close();
        }
    public void restart()
        {
        at = 0;
        }
    public String nextWord()
        {
        if (at < words.size())
            return words.get(at++);
        else
            return null;
        }
    public void dump()
        {
        System.out.println("There are " + words.size() + " words available.");
        for (int counter = 0; counter < words.size(); counter++)
            System.out.print(words.get(counter) + "  ");
        System.out.println("......... end of dump.");
        }
    public static void main(String[] args) throws FileNotFoundException, IOException
        {
        WordSource s = new WordSource("agnew.txt");
        s.dump();
        }
    private ArrayList<String> words;
    private int at;
    } // class WordSource