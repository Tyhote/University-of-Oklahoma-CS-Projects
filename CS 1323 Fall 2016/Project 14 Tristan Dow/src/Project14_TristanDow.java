import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Project14_TristanDow {

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		
		// Generating dictionary based off of fed in arguments
		ArrayList<String> combinedDictionary = combineDictionaries(args);
		
		System.out.println("Enter a word or QUIT to exit");
		checkDictionary(combinedDictionary, keyboard);
		
		
		
		keyboard.close();
	}
	
	// Combines all dictionaries fed in through arguments and returns and ArrayList<String> with all items
	private static ArrayList<String> combineDictionaries(String[] dictionaries) throws FileNotFoundException
	{
		ArrayList<String> combinedDictionary = new ArrayList<String>();
		for(int dictionaryIndex = 0; dictionaryIndex < dictionaries.length; ++dictionaryIndex)
		{
			Scanner dictionaryFile = new Scanner(new File(dictionaries[dictionaryIndex]));
			while(dictionaryFile.hasNextLine())
			{
				combinedDictionary.add(dictionaryFile.nextLine());
			}
			dictionaryFile.close();
		}
		Collections.sort(combinedDictionary);
		return combinedDictionary;
	}
	
	// Checks to see if the user input word is in the combined dictionary
	private static void checkDictionary(ArrayList<String> combinedDictionary, Scanner keyboard) throws IOException
	{
		String userInput = keyboard.nextLine();
		while(!userInput.equals("QUIT"))
		{
			if(combinedDictionary.contains(userInput))
			{
				System.out.println("That word is typed correctly.");
			}
			else
			{
				System.out.println("That word is typed incorrectly.\nWould you like to add it to your private dictionary Yes/No");
				String storedWord = userInput;
				userInput = keyboard.nextLine();
				while (!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no"))
				{
					System.out.println("Please enter yes or no");
					userInput = keyboard.nextLine();
				}
				if(userInput.equalsIgnoreCase("yes"))
				{
					addWord(storedWord, combinedDictionary);
				}
			}
			System.out.println("Enter a word or QUIT to exit");
			userInput = keyboard.nextLine();
		}
	}
	
	// Adds the word to both the private dictionary for further use and puts the word into the ArrayList in sorted order
	private static void addWord(String wordToAdd, ArrayList<String> combinedDictionary) throws IOException
	{
		// Used FileWriter because PrintWriter was acting strange and overwriting my file so I got lazy
		FileWriter privateDictionary = new FileWriter(new File("PrivateDictionary.txt"), true);
		privateDictionary.write(wordToAdd + System.lineSeparator());
		privateDictionary.close();
		
		int insertIndex = -(Collections.binarySearch(combinedDictionary,wordToAdd) + 1);
		combinedDictionary.add(insertIndex, wordToAdd);
	}

}
