import java.util.Scanner;

public class StressQuiz 
{
	// Creating user input
	static Scanner keyboard = new Scanner(System.in);
	
	// Declaration of variables
	static int pointTotal = 0;
	static int questionNumber = 0;
	static String userAnswer = "";
	
	
	// This asks the question and increments the points.
	public static void incrementIfTrue ()
	{
		++questionNumber;
		
		// Testing for each question number
		if (questionNumber == 1)
		{
			System.out.println("Do you find yourself less eager to go back to work or to resume your chores after a weekend?");
			userAnswer = keyboard.next();
			keyboard.nextLine();
			
			if (userAnswer.equals("yes"))
			{
				++pointTotal;
			}
			else return;
		}
		
		if (questionNumber == 2)
		{
			System.out.println("Do you feel less and less patient and/or sympathetic listening to other people’s problems?");
			userAnswer = keyboard.next();
			keyboard.nextLine();
				
			if (userAnswer.equals("yes"))
			{
				++pointTotal;
			}
			else return;
		}
		
		if (questionNumber == 3)
		{
			System.out.println("Do you try to get away from people as soon as you can?");
			userAnswer = keyboard.next();
			keyboard.nextLine();
				
			if (userAnswer.equals("yes"))
			{
				++pointTotal;
			}
			else return;
		}
		
		// Return after completion
		return;
	}
	public static void main (String [] args)
	{

		
		// User introduction to program
		System.out.println("Hello, user!\nWelcome to the Psycology Today stress quiz.\nI have a few questions for you, so we can tell how "
				+ "stressed you are.\n\nFor each question, please enter \"yes\" or \"no\", without the quotes.");
		
		// Call method to ask questions
		incrementIfTrue();
		incrementIfTrue();
		incrementIfTrue();
		
		// Displaying results
		switch(pointTotal)
		{
		case 0:
			System.out.println("You appear to be more exhausted thana stressed out.");
			break;
			
		case 1:
			System.out.println("You are beginning to stress out.");
			break;
			
		case 2:
			System.out.println("You are possibly stressed out.");
				
		case 3:
			System.out.println("You are probably stressed out.");
			break;
		
		default:
			System.out.println("ERROR");
		}
		
	}

}
