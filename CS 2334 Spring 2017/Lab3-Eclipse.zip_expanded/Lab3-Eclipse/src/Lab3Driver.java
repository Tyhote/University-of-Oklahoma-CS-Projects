import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Lab 3 CS 2334, Section 010 February 21, 2017
 * <P>
 * This class implements a program that tests the Book and BookList classes.
 * </P>
 * 
 * @author Dean Hougen and Tristan Dow
 * @version 1.0
 */
public class Lab3Driver {
	private static BookList bookList = null;

	/**
	 * This is the main method for this test program. Since this is a simple
	 * test program, a lot of our code will be in the main method. Typically
	 * this would be a bad design, but we are just testing out some features of
	 * Java.
	 * <P>
	 * 
	 * @param args
	 *            Contains the command line arguments.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the name of the book file: ");
		String input = inputReader.readLine();

		bookList = BookFileReader.readBookFile(input);
		
		Book book0 = bookList.get(0);
		
		Book.writeBook("BookFile", book0);

		book0 = null;

		System.out.println("First book: " + book0);

		book0 = Book.readBook("BookFile");

		System.out.println("First book: " + book0);

		BookList.writeBookList("BookListFile", bookList);

		bookList = null;

		System.out.println("Book list:\n" + bookList);

		bookList = BookList.readBookList("BookListFile");

		System.out.println("Book list:\n" + bookList);
	}
}
