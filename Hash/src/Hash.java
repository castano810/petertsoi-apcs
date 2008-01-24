// Peter Tsoi & Justin Uang
// Assignment: Hash Maps
// Finished Jan. 18, 2008
// Hash.java: The HashMap

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Hash {
    public Hash (String fileName) throws FileNotFoundException, IOException {
        NumSource file = new NumSource(fileName);
        size = (int)(file.ArraySize()*1.25);
        table = new LinkedList[size];
        for (int i = 0; i<size; i++)
            table[i] = new LinkedList();
        for (int i = 0; i<size; i++)
            addItem(file.nextItemPair()); 
    }
    
    public void dump(){
        int nulls = 0;
        int avgSize = 0;
        int largest = 0;
        for(LinkedList ll : table){
            
            if (ll.size() != 0){
                if (ll.size()>largest)
                    largest = ll.size();
                avgSize+= ll.size();
            } else {
                nulls++;
            }
            
        }
        avgSize = avgSize/(size - nulls);
        System.out.println("Nulls: " + nulls + "\tAvg. Size : " + avgSize + "\tLargest List: " + largest);
    }
    
    public ItemPair search(int id){
        ItemPair returnVal = null;
        for (int i = 0; i<table[hasher(id)].size(); i++){
            if ((table[hasher(id)].get(i).getFirst()==id) && (returnVal == null))
                returnVal = table[hasher(id)].get(i);
        }
        return returnVal;
    }
    
    private int hasher(int id){
        int returnVal = 0;
        returnVal = id%size;
        return returnVal;
    }
    
    private void addItem (ItemPair e){
        if (e != null){
            table[hasher(e.getFirst())].add(e);  
        }
    }
    
    private LinkedList<ItemPair> table[];
    private int size;
}
