import java.util.Scanner;
public class Project6_TristanDow {
	/** CS 1323 Section 1 Fall 2016
	 * @Author Tristan Dow
	 */
	public static void main(String[] args)
	{
		// Declaration of variables and initialization of keyboard
		Scanner keyboard = new Scanner(System.in);
		final int SQUARE_FEET_PER_BOX = 155;
		int remainingBoxes = 100;
		int numBoxesToBuy = 0;
		String userConfirmation = "";
		
		// Prompt user for input
		while(remainingBoxes > 0)
		{
			System.out.println("We now have " + remainingBoxes + " boxes left.");
			System.out.println("What is the size of your room: enter the width and depth in feet");
			numBoxesToBuy = calculateFlooring(keyboard.nextInt(), keyboard.nextInt(), SQUARE_FEET_PER_BOX);
			
			// Subtract boxes bought and display amount bought and left if there are enough, otherwise ask if too few is okay
			if(numBoxesToBuy <= remainingBoxes)
			{
				remainingBoxes -= numBoxesToBuy;
				System.out.println("Your " + numBoxesToBuy + " boxes will be shipped to you");
			}
			else
			{
				// Checking user input and responding
				System.out.println("We only have " + remainingBoxes + " boxes left.\nDo you want to purchase all of them? Yes or No");
				userConfirmation = keyboard.next();
				if (userConfirmation.equalsIgnoreCase("yes"))
				{
					System.out.println("Your " + remainingBoxes + " boxes will be shipped to you");
					remainingBoxes -= numBoxesToBuy;
				}
				else{}
			}
		}
		System.out.println("I'm sorry, but we're now sold out of Bamboo Dream flooring");
		
		// Make Eclipse happy
		keyboard.close();
	}
	// calculates the number of boxes needed for the width and depth entered
	public static int calculateFlooring(int width, int height, int squareFeetPerBox)
	{
		double SquareFootage = ((double)width*height);
		double AdjustedSquareFootage = (SquareFootage * 0.05) + SquareFootage;
		int boxesToBuy = (int)Math.ceil(AdjustedSquareFootage/squareFeetPerBox);
		return boxesToBuy;		
	}
}
