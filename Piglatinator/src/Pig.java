/* Peter Tsoi
 * Piglatinator
 * Pig Class
 */
public class Pig {
	// Variables
	private static String originalString;
	private static int length;
	private static int spaces;
	private static int reqLoops;
	private static String originalWords[];
	private static String finalWords[];
	private static char[] vowels = new char[] {'a','A','e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
	
	// Finds First Occurance of Char
	public static int firstOccur(String inString, char testChar){
		// Find First Char
		int counter, testvowelAt, wordLength, changed;
		counter = 0;
		testvowelAt = wordLength = inString.length();
		changed = 0;
		int finalchange = 0;
		while (counter < wordLength){
			if (inString.charAt(counter) == testChar){
				testvowelAt = counter + 1;
				counter = wordLength; // Exit loop
				changed = 1;
				counter++;
			} else {
				counter++;
				changed = 0;
			}
		}
		int testval = 0;
		int testval2 = 0;
		if (testvowelAt == wordLength){
			for (char vowel: vowels){
					if (inString.charAt(wordLength - 1) == vowel){
						testval = 1;
						if (testval == 1){
							testvowelAt = wordLength;
							testval2 = 1;
						}
					} else {
						testvowelAt = -1;
					}
			}
		if (testval2 == 1) {
			testvowelAt = wordLength;
		}
		}		
		return testvowelAt;
	}
	
	public static int countSpaces(){
		int counter, mySpaces;
		mySpaces = counter = 0;
		
		while (counter < length){
			if (originalString.charAt(counter) == ' '){
				mySpaces++;
				counter++;
			} else {
				counter++;
			}
		}
		
		return mySpaces;
	}
	
	// Finds the first vowel in a word and returns its location.
	public static int firstVowelWord (String word){
		// Test for Vowels
		int counter, length, vowelAt, testvowelAt, wordLength;
		counter = 0;
		wordLength = word.length();
		vowelAt = 999999;
		for (char vowel: vowels) {
			testvowelAt = firstOccur(word, vowel);
			if (testvowelAt != -1){
				if (testvowelAt < vowelAt){
					vowelAt = testvowelAt;
				} 
			}	
		}
		
		if (vowelAt == wordLength){
			if (word.charAt(wordLength-1) == 'a' || word.charAt(wordLength-1) == 'e' || word.charAt(wordLength-1) == 'i' || word.charAt(wordLength-1) == 'o' || word.charAt(wordLength-1) == 'u'){
				testvowelAt = wordLength;
			}
		}
		if (vowelAt == 999999){
			vowelAt = -1;
		}
		return vowelAt;
	}
	
	// Splits the string into words
	public static void splitWords (){
        String[]words;
        if (originalString.indexOf(" ")>0){
            words = new String[spaces + 1];
        }
        else{
            words = new String[spaces + 2];
        }
		String inString = originalString;
		int spaceLocation = 0;
		int cutindicator = 0;
		int wordLength = inString.length() - 1;
		int loops = 0;
		for (int i=0; i<spaces; i++){
		while (inString.charAt(spaceLocation) != ' '){
			spaceLocation ++;
		}
		words[i] = (inString.substring(cutindicator, spaceLocation).trim());
		cutindicator = spaceLocation++;
		loops = i;
		}
            words[loops+1] = inString.substring(cutindicator, wordLength + 1).trim();
        
		originalWords = words;
		reqLoops = loops+1;
	}
	
	// Changes the Words into PigLatin
	public static void changeWords (){
		String[] newWords = new String[spaces + 1];
		int myCounter = 0;
		int vowelPosition;
		String holder1;
		for (String word: originalWords){
            if (word!=null){
			length = word.length() - 1;
			// If it starts lowercase
			if (word.substring(0, 1).toLowerCase().equals(word.substring(0, 1))){
				
				vowelPosition = firstVowelWord(word);
				// If No Vowels
				if (vowelPosition == -1){
					newWords[myCounter] = word + "ay ";
					vowelPosition = firstVowelWord(word);
				} else if (vowelPosition == 1) {
					newWords[myCounter] = word + "yay ";
					vowelPosition = firstVowelWord(word);
				} else {
					newWords[myCounter] = word.substring(vowelPosition-1, length + 1) + word.substring(0, vowelPosition-1) + "ay ";
					vowelPosition = firstVowelWord(word);
				}
				if (word.equals("-")){
					newWords[myCounter] = word + " ";
				}
			} else {
				
				vowelPosition = firstVowelWord(word);
				// If No Vowels
				if (vowelPosition == -1){
					newWords[myCounter] = word + "ay ";
					vowelPosition = firstVowelWord(word);
				} else if (vowelPosition == 1) {
					newWords[myCounter] = word + "yay ";
					vowelPosition = firstVowelWord(word);
				} else {
					newWords[myCounter] = word.substring(vowelPosition-1, vowelPosition).toUpperCase() + word.substring(vowelPosition, length + 1) + word.substring(0, vowelPosition-1).toLowerCase() + "ay ";
					vowelPosition = firstVowelWord(word);
				}
				if (word.equals("-")){
					newWords[myCounter] = word + " ";
				}
			}
		myCounter++;
            }
		}
		finalWords = newWords;
	}
	
	// Converts to PigLatin
	public static void convert(){
		splitWords();
		changeWords();
		System.out.println("In PigLatin, that would be: ");
		for(String Word: finalWords){
			System.out.print(Word);
		}
		System.out.println("\n\n");
	}
	
	public static void changeString(String inputString){
		originalString = inputString.trim();
		length = inputString.length();
		spaces = countSpaces();
	}
	
	public Pig (String inputString){
		originalString = inputString.trim();
		length = inputString.length();
		spaces = countSpaces();
	}
}