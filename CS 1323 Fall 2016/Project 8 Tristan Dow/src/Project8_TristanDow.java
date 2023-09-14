import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Project8_TristanDow 
{
	public static void main (String[] args)
	{
		// Declaration of variables
		Scanner keyboard = new Scanner(System.in);
		int playerTokens;
		
		// Play game and get number won
		playerTokens = playTheGame(keyboard);
		
		System.out.println("You left our wonderful slot game with " + playerTokens + " tokens. Thank you for playing, and come again!");
	}
	
	// Calculates winnings for player
	public static int calculateWin(int[] scores)
	{
		if(scores[0] == scores[1] && scores[0] == scores[2])
		{
			if(scores[0] == 7)
			{
				return 750;
			}
			// Implied else
			return 75;			
		}
		
		//Implied else
		if(scores[0] == scores[1] || scores[0] == scores[2] || scores[1] == scores[2])
		{
			if(scores[0] == 7 && scores[1] == 7 || scores[0] == 7 && scores[2] == 7 || scores[1] == 7 && scores[2] ==7)
			{
				return 20;
			}
			
			return 5;
		}
		
		return -1;
	}
	
	//Creates three random numbers, uses calculateWin to evaluate whether they win or lose, and return result
	public static int playTheGame(Scanner keyboard)
	{
		// Declaration of variables
		int[] slotNumbers = new int[3];
		final int HIGH = 10;
		final int LOW = 1;
		int totalTokens = 20;
		int tokenChange = 0;
		
		// Special message on first run of slots
		specialMessage();
		
		// Priming input
		String userInput = keyboard.next();
		keyboard.nextLine();
		
		// Generating random numbers into array
		while(userInput.equalsIgnoreCase("Yes") && totalTokens > 0)
		{
			for(int i = 0; i < slotNumbers.length; ++i)
			{
				slotNumbers[i] = findRandom(LOW, HIGH);
			}
			
			// Change amount of tokens based on win
			tokenChange = calculateWin(slotNumbers);
			totalTokens += tokenChange;
			
			// Display spin, lost tokens, current tokens, and primes input
			try
			{
				for(int i = 0; i < 3; ++i)
					{
						suspenseMachine(LOW, HIGH, i + 1, slotNumbers[i]);
						System.out.println();
					}
			} catch(InterruptedException e){System.out.println(e);}
			System.out.println("Your spin was " + slotNumbers [0] + " " + slotNumbers [1] + " " + slotNumbers [2]);
			if(tokenChange > 0)
			{
				System.out.println("You won " + tokenChange + " tokens.");
			}
			else
			{
				System.out.println("You lost " + tokenChange + " tokens.");
			}
			System.out.println("You have " + totalTokens + " left");
			System.out.println("Would you like to play again? (Yes/No)");
			
			userInput = keyboard.next();
			keyboard.nextLine();
		}
		
		// Return tokens after playing
		return totalTokens;
	}
	
	// Generates random number with a high limit of variable high and a low limit of low
	public static int findRandom(int low, int high)
	{
		int randomNumber = (int)(Math.ceil((Math.random() * high)));
		if(randomNumber == 0)
		{
			randomNumber = low;
		}
		
		return randomNumber;
	}
	
	public static void suspenseMachine(int low, int high, int slotNumber, int actualNumber) throws InterruptedException
		{
		for(int count = 0; count < 5; ++count)
		{
			System.out.print( "\r" + findRandom(low, high) + " "); 
			TimeUnit.MILLISECONDS.sleep(333*slotNumber);
		}
		System.out.print("\r" + actualNumber);
	}
	
	public static void specialMessage()
	{
		System.out.println("" +
				"			    ,--._ \n"+
				"			    `.   `.                      ,-. \n"+
				"			      `.`. `.                  ,'   ) \n"+
				"			        \\`:  \\               ,'    / \n"+
				"			         \\`:  ),.         ,-' ,   / \n"+
				"			         ( :  |:::.    ,-' ,'   ,' \n"+
				"			         `.;: |::::  ,' ,:'  ,-' \n"+
				"			         ,^-. `,--.-/ ,'  _,' \n"+
				"			        (__        ^ ( _,' \n"+
				"			      __((o\\   __   ,-' \n"+
				"			    ,',-.     ((o)  / \n"+
				"			  ,','   `.    `-- ( \n"+
				"			  |'      ,`        \\ \n"+
				"			  |     ,:' `        | \n"+
				"			 (  `--      :-.     | \n"+
				"			 `,.__       ,-,'   ; \n"+
				"			 (_/  `,__,-' /   ,' \n"+
				"			 |\\`--|_/,' ,' _,' \n"+
				"			 \\_^--^,',-' -'( \n"+
				"			 (_`--','       `-. \n"+
				"			  ;;;;'       ::::.`------. \n"+
				"			    ,::       `::::  `:.   `. \n"+
				"			   ,:::`       :::::   `::.  \\ \n"+
				"			  ;:::::       `::::     `::  \\ \n"+
				"			  |:::::        `::'      `:   ; \n"+
				"			  |:::::.        ;'        ;   | \n"+
				"			  |:::::;                   )  | \n"+
				"			  |::::::        ,   `::'   |  \\ \n"+
				"			  |::::::.       ;.   :'    ;   ::. \n"+
				"			  |::::,::        :.  :   ,;:   |:: \n"+
				"			  ;:::;`\"::     ,:::  |,-' `:   |::, \n"+
				"			  /;::|    `--;\"\"';'  |     :. (`\";' \n"+
				"			  \\   ;           ;   |     ::  `, \n"+
				"			   ;  |           |  ,:;     |  : \n"+
				"			   |  ;           |  |:;     |  | \n"+
				"			   |  |           |  |:      |  | \n"+
				"			   |  |           |  ;:      |  | \n"+
				"			  /___|          /____|     ,:__| \n"+
				"			 /    /          /    |     /    ) \n"+
				"			 `---'          '----'      `---' \n");
						System.out.println("Welcome to Donkey's Slot Machine!\nWould you like to take a spin? (Yes/No)");
	}
}
