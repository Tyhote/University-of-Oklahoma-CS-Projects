import java.util.Scanner;

public class Project4_TristanDow 
/**CS 1323 Section 1 September 19 2016
 * @AUTHOR Tristan Dow
 */
{
	// Creating user input
	static Scanner keyboard = new Scanner(System.in);
	
	// Declaration of variables
	static int pointTotal = 0;
	static int questionNumber = 0;
	static String userAnswer = "";
	final static int NUM_QUESTIONS = 3;
	
	
	// Declaration of method for incrementing the user's total points if they answer "yes" to a question
	public static void incrementIfTrue ()
	{
		
	// Testing for each question number
		if (questionNumber == 0)
		{
			System.out.println("Do you find yourself less eager to go back to work or to resume your chores after a weekend?");
			userAnswer = keyboard.next();
			keyboard.nextLine();
			
			while (!(userAnswer.equals("yes")) && !(userAnswer.equals("no")))
					{
						System.out.println("Please enter a valid answer.");
						userAnswer = keyboard.next();
						keyboard.nextLine();
					}
			
			if (userAnswer.equals("yes"))
			{
				++pointTotal;
			}
			else;
		}
		
		
		if (questionNumber == 1)
		{
			System.out.println("Do you feel less and less patient and/or sympathetic listening to other people’s problems?");
			userAnswer = keyboard.next();
			keyboard.nextLine();
			
			while (!(userAnswer.equals("yes")) && !(userAnswer.equals("no")))
					{
						System.out.println("Please enter a valid answer.");
						userAnswer = keyboard.next();
						keyboard.nextLine();
					}
				
			if (userAnswer.equals("yes"))
			{
				++pointTotal;
			}
			else;
		}
		
		
		if (questionNumber == 2)
		{
			System.out.println("Do you try to get away from people as soon as you can?");
			userAnswer = keyboard.next();
			keyboard.nextLine();
			
			while (!(userAnswer.equals("yes")) && !(userAnswer.equals("no")))
					{
						System.out.println("Please enter a valid answer.");
						userAnswer = keyboard.next();
						keyboard.nextLine();
					}
				
			if (userAnswer.equals("yes"))
			{
				++pointTotal;
			}
			else;
		}
		
		// Increment question number
		++questionNumber;		
		
		// Return after completion
		return;
	}
	public static void main (String [] args)
	{

		
		// User introduction to program
		System.out.println("Hello, user!\nWelcome to the Psycology Today stress quiz.\nI have a few questions for you, so we can tell how "
				+ "stressed you are.\n\nFor each question, please enter \"yes\" or \"no\", without the quotes.");
		
		// Call method to ask questions
		for (int i = 0; i < NUM_QUESTIONS; ++i)
		{
			incrementIfTrue();
		}
		
		// Displaying results
		switch(pointTotal)
		{
		case 0:
			System.out.println("You appear to be more exhausted than stressed out.");
			break;
			
		case 1:
			System.out.println("You are beginning to stress out.");
			break;
			
		case 2:
			System.out.println("You are possibly stressed out.");
			break;
				
		case 3:
			System.out.println("You are probably stressed out.");
			break;
		
		default:
			System.out.println("ERROR");
		}
		
		// Makes Eclipse happy
		keyboard.close();
	}
	
}
