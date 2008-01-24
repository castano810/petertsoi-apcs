// Peter Tsoi & Justin Uang
// Assignment: Hash Maps
// Finished Jan. 18, 2008
// main.java: The Runner class

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        Hash table = new Hash("GardenItems.txt");
        Scanner input = new Scanner(System.in);
        System.out.print("Search for ID: ");
        ItemPair item = table.search(input.nextInt());
        
        if (item == null){
            System.out.println("This item does not exist in our records.");
        } else {
            System.out.println("Item: " + item.getFirst() + "\tQty: " + item.getSecond());
        }
        
        table.dump();
    }
}
