import java.util.Arrays;
import java.util.Scanner;
public class Project9_TristanDow {
	
	// Declaration of class variables
	public static final int ADD = 1;
	public static final int SEARCH = 2;
	public static final int QUIT = 3;
	
	public static void main(String[] args)
	{
		// Declaration of variables
		final int EMAIL_SIZE = 100;
		Scanner keyboard = new Scanner(System.in);
		int userInput = 0;
		String[] emails = new String[EMAIL_SIZE];
		int numberOfEmails = 0;
		
		
		// Getting user input
		userInput = menuChoice(keyboard);
		// Feeding input to while loop
		while(userInput != QUIT)
		{
			if(userInput == ADD)
			{
				System.out.println("Enter the email address");
				numberOfEmails += addNewEmail(emails, numberOfEmails, keyboard.nextLine());
			}
			if(userInput == SEARCH)
			{
				System.out.println("Enter the partial address");
				search(emails, numberOfEmails, keyboard.nextLine());
			}
			// Another priming
			userInput = menuChoice(keyboard);
		}
	}
	
	// This method searches for a partial match of target and prints out any element of data (from 0 to size-1) that starts with the same characters as target.
	public static void search(String[] data, int size, String target)
	{
		if(size > 0)
			{
				int printIndex = 1;
				for(int i = 0; i < size; ++i)
				{
					if(data[i].startsWith(target))
					{
						System.out.println(printIndex + ". " + data[i]);
						++printIndex;
					}
				}
				System.out.println();
			}
		else
		{
			System.out.println("No emails to search for");
		}
	}
	
	/* This method prints out the menu, allows the user to enter a choice, and checks to see that this choice is one of the legal ones.  If the choice is not legal, the user should be 
	 * given a chance to enter it again.  If it is legal, the computation should proceed.
	 */
	public static int menuChoice(Scanner keyboard)
	{
		String userInput = "";
		
		// Prompting and priming
		System.out.println("Please choose from the following menu of choices:\n1. Enter a new email address\n2. Find an existing email address\n3. Quit.\nWhat is your choice?");
		userInput = keyboard.nextLine();
		while(!(userInput.matches("^[1-3]$")))
		{
			// Prompt and prime until correct answer
			System.out.println("Please choose from the following menu of choices:\n1. Enter a new email address\n2. Find an existing email address\n3. Quit.\nWhat is your choice?");
			userInput = keyboard.nextLine();
		}
		return Integer.parseInt(userInput);
	}
	
	/* This method should add insertMe to the array data if the String value is not already in the array.  The int that is returned is the size of the array after the insertion.
	 * This size could be the same as it was previously (for example, if insertMe is already in the array) or may be one larger.
	 */
	public static int addNewEmail(String[] data, int size, String insertMe)
	{
		
						
		if(size > 0)
		{
			int searchResult = Arrays.binarySearch(Arrays.copyOfRange(data, 0, size), insertMe);
			if(searchResult < 0)
			{
				if(-(searchResult+1) < size)
				{
					for(int i = size; i > -(searchResult+1); --i)
					{
						data[i] = data[i-1];
					}
				}
				data[-(searchResult + 1)] = insertMe;
				return 1;
			}
			// Implied else
			System.out.println("That email address has already been inserted");
			return 0;
		}
		else
		{
			data[0] = insertMe;
			return 1;
		}
	}
}
