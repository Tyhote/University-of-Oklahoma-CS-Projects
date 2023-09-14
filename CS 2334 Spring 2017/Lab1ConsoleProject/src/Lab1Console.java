import java.util.Random;
import java.util.Scanner;

/**
 * Lab 1 Console for CS 2334
 * <P>
 * This class creates a sample program with a console UI.
 * </P>
 * 
 * @version 1.0
 */
public class Lab1Console {
	/** An integer array. */
	private int[] myArray;

	/**
	 * Constructor for class Lab1Spring2017. Initializes and manipulates the
	 * array of integers, then initializes the main window of the program and
	 * sets up event handling for the program.
	 * <P>
	 * 
	 * 
	 * @param iSize
	 *            The size of the integer array to create/manipulate.
	 */
	public Lab1Console(int iSize) {
		/* Initialize an array. */
		myArray = new int[iSize];

		/* Assign some random integer to each cell of the array. */
		init();

		/* Send the contents of the array to standard out. */
		display();

		/* Further process the array. */
		work();

		/* Print out the sum of all the values */
		System.out.println("Sum is " + myArray[iSize - 1]);
	}

	/**
	 * Assign some pseudo-random integer [0-99] to each cell of the array.
	 * (Pseudo-random because random numbers are too important to leave to
	 * chance.)
	 */
	private void init() {
		Random rand = new Random(51); // Seed of 51 must be left alone

		for (int index = 0; index < myArray.length; index++) {
			myArray[index] = rand.nextInt(100);
		}
	}

	/**
	 * Display all cells, starting with 0 and working up to the end.
	 */
	private void display() {
		for (int index = 0; index < myArray.length; index++) {
			System.out.println("myArray[" + index + "] is " + myArray[index]);
		}
	}

	/**
	 * Work through all cells, modifying the contents of each cell (except the
	 * first).
	 *
	 * 
	 */
	private void work() {
		for (int index = 1; index < myArray.length; index++) {
			myArray[index] = myArray[index - 1] + myArray[index];
		}
	}

	/**
	 * Main method. Instantiate an object of type Lab1Console and pass it an
	 * array size. This program should get the array size from the first command
	 * line argument sent to it by the user. If no command line argument is
	 * given, it should query the user for that value.
	 * <P>
	 * 
	 * @param args
	 *            Contains the command line arguments.
	 */
	public static void main(String args[]) {
		int firstArg = 0;

		if (args.length > 1) {
			System.err.println("Too many arguments provided. Must provide one integer (for array size).");
			System.exit(1);
		}

		if (args.length == 1) {
			try {
				firstArg = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Wrong argument provided. Argument (" + args[0] + ") is not an integer.");
				System.exit(1);
			}
		}

		if (args.length == 0) {
			System.out.println("No argument provided. Enter the size for the array (an integer).");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			scanner.close();
			try {
				firstArg = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.err.println("Wrong input provided. Input (" + input + ") is not an integer.");
				System.exit(1);
			}
		}

		/* ADD CODE HERE */
		new Lab1Console(firstArg);

	}
}