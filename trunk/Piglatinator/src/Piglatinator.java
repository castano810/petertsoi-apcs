/* Peter Tsoi
 * November 4, 2005
 * Piglatinator
 * Main Method
 */

import java.util.*;

public class Piglatinator {
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Pig phrase = new Pig("String Here");
		String loop = "y";
		String inString;
		
		// Print Intro Phrase
		System.out.println("I can translate English sentences and phrases into Pig Latin.");
		System.out.println("Please type an English sentence or phrase and then press <Enter>.\n");
		
		while (loop.equalsIgnoreCase("y")){
			inString = input.nextLine();
			phrase.changeString(inString);
			phrase.convert();
			System.out.print("Would you like to translate another phrase? ");
			loop = input.nextLine();
		}
	}	
}
