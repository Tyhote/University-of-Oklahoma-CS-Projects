import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Project7_TristanDow {

	public static void main (String[] args)
	{
		// Initialize variables
		Scanner keyboard = new Scanner(System.in);
		String userInput;
		
		// Prompt user for input and prime loop
		System.out.println("Please enter the name of the file you want to analyze or \"Quit\" without the quotes to stop.");
		userInput = keyboard.next();
		keyboard.nextLine();
		
		while(!userInput.equalsIgnoreCase("Quit"))
		{
			// Feed input to method
			analyzeText(userInput);
			
			// Prime again
			System.out.println("Please enter the name of the file you want to analyze or \"Quit\" without the quotes to stop.");
			userInput = keyboard.next();
			keyboard.nextLine();
		}
			
		// Make Eclipse happy
		keyboard.close();
	}
	
	// 
	public static void analyzeText(String fileName)
	{
		// Declaring local variables
		int numberOfPeriods = 0;
		int numberOfQuestionMarks = 0;
		int numberOfExclamationMarks = 0;
		int numberOfCommas = 0;
		int numberOfSemicolons = 0;
		int numberOfColons = 0;
		
		try
		{
			// Scanning file in based on parameter
			Scanner file = new Scanner(new File(fileName));
			int numberOfLines = file.nextInt();
			file.nextLine();
		
			// Scan in each line to array
			String[] userInput = new String[numberOfLines];
			for(int i = 0; i < numberOfLines; ++i)
			{
				userInput[i] = file.nextLine();
			}
		
			// Safety in closing
			file.close();
		
			// Call method to count punctuation and increment variables by return value
			System.out.println("The analysis of " + fileName );
			
			for(int i = 0; i < userInput.length; ++i)
			{
				numberOfPeriods += countOccurences(userInput[i], '.');
				numberOfQuestionMarks += countOccurences(userInput[i], '?');
				numberOfExclamationMarks += countOccurences(userInput[i], '!');
				numberOfCommas += countOccurences(userInput[i], ',');
				numberOfSemicolons += countOccurences(userInput[i], ';');
				numberOfColons += countOccurences(userInput[i], '.');
			}
			
			// Print results
			System.out.println("There were " + (double)numberOfPeriods/numberOfLines + " periods per sentence.");
			System.out.println("There were " + (double)numberOfQuestionMarks/numberOfLines + " question marks per sentence.");
			System.out.println("There were " + (double)numberOfExclamationMarks/numberOfLines + " exclamation marks per sentence.");
			System.out.println("There were " + (double)numberOfCommas/numberOfLines + " commas per sentence.");
			System.out.println("There were " + (double)numberOfSemicolons/numberOfLines + " semicolons per sentence.");
			System.out.println("There were " + (double)numberOfColons/numberOfLines + " colons per sentence.");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		
		
	}
	
	public static int countOccurences(String line, char punctuation)
	{
		// Declare local variable
		int numberCharacter = 0;
		
		// Go through string and increment if character found
		for(int k = 0; k < line.length(); ++k)
		{
			if (line.charAt(k) == punctuation)
			{
				++numberCharacter;
			}
		}
		
		// Return value
		return numberCharacter;
	}
		

}
