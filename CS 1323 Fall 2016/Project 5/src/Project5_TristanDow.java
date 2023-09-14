import java.util.Scanner;
public class Project5_TristanDow {

	public static void main (String [] args)
	{

		// Initializing keyboard
		Scanner keyboard = new Scanner(System.in);	
		
		// Initializing variables
		int numPositiveChanges = 0;
		int numNegativeChanges = 0;
		int numNoChange = 0;
		int numChoiceOne = 0;
		int numChoiceTwo = 0;
		int numChoiceThree = 0;
		int numChoiceFour = 0;
		int numChoiceFive = 0;
		
		// Declaration of temp variables		
		int currentInput = 0;
		int prevInput = 0;
	
	
		// Asking user for input and priming and entering loop
		System.out.println("Enter the polling data or enter -1 to stop");
		currentInput = keyboard.nextInt();
		keyboard.nextLine();
		while(currentInput != -1)
		{
			
			// Counting number of each choice made
			switch(currentInput)
			{
			case 1:
				++numChoiceOne;
				break;
			case 2:
				++numChoiceTwo;
				break;
			case 3:
				++numChoiceThree;
				break;
			case 4:
				++numChoiceFour;
				break;
			case 5:
				++numChoiceFive;
				break;
			}
			
			// Testing for change in answer
			if(prevInput != 0)
			{
				if(prevInput < currentInput)
				{
					++numPositiveChanges;
				}
				else if(prevInput > currentInput)
				{
					++numNegativeChanges;
				}
				else
				{
					++numNoChange;
				}
			}
			else if(currentInput < 3)
			{
				++numNegativeChanges;
			}
			else if(currentInput > 3)
			{
				++numPositiveChanges;
			}
			else
			{
				++numNoChange;
			}
			
			// Priming and getting input for next run of loop
			System.out.println("Enter the polling data or enter -1 to stop");
			prevInput = currentInput;
			currentInput = keyboard.nextInt();
			keyboard.nextLine();
		}
		
		// Displaying results
		System.out.println("1 was chosen " + numChoiceOne + " times.");
		System.out.println("2 was chosen " + numChoiceTwo + " times.");
		System.out.println("3 was chosen " + numChoiceThree + " times.");
		System.out.println("4 was chosen " + numChoiceFour + " times.");
		System.out.println("5 was chosen " + numChoiceFive + " times.");
		System.out.println("There were:\n" + numPositiveChanges + " Positive changes\n" + numNegativeChanges + " Negative changes\n"
				+ numNoChange + " No Changes");
	
		// Making Eclipse happy
		keyboard.close();
	}
}
