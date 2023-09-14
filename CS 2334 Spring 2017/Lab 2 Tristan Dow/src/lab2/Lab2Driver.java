package lab2;

/**
 * Lab 2 CS 2334, Section 010 7 February 2017
 * <P>
 * This class implements a program that tests the Book class code.
 * </P>
 * 
 * @author Dean Hougen and (your name)
 * @version 1.0
 */
public class Lab2Driver {
	private static BookList bookList = new BookList();

	/**
	 * This is the main method for this driver program.
	 * <P>
	 * Algorithm<br>
	 * Test out the Book class and an ArrayList of them to help your
	 * understanding of creating, sorting, and searching lists.
	 * </P>
	 * 
	 * @param args
	 *            Contains the command line arguments.
	 */

	public static void main(String[] args) {
		// Get the name of the file to read using program arguments
		if (args.length != 1) {
			System.err.println("Usage error. Must provide one program argument (name of data file to read).");
			System.exit(1);
		}

		// Read file putting NewsMakers in the NewsMakerList
		bookList = BookFileReader.readBookFile(args[0]);

		// Print out the unsorted list of books
		System.out.println("\n\nUnsorted List:");
		bookList.printBooks();
		System.out.println();
		bookList.sortBooks();

		// Print out the sorted list of Books
		System.out.println("Sorted List:");
		bookList.printBooks();
		System.out.println();

		// Search for a particular Book in the list and print it
		System.out.println("\n\nSearching");
		// First, create the book to search for
		Book key = new Book("Analysis: The Arrakeen Crisis", "Princess Irulan", 10282, "");
		System.out.println("Key is " + key);
		// Second, search for that book
		Book result = bookList.findBook(key);
		// Third, print it out
		System.out.println(result);
	}
}