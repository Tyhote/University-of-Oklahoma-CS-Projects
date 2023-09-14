import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Lab 3 CS 2334, Section 010 February 21, 2017
 * <P>
 * This class provides a static method for reading in books from a text file in
 * which the data is separated by commas. (Such files are generally known as
 * comma-separated values or "csv" files.)
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 */
public class BookFileReader {
	/** The list of books to fill as the file is read in */
	private static BookList bookList = new BookList();

	/**
	 * This method opens the file, reads the data, and closes the file again. It
	 * uses processLine() to turn the text data into book objects and add them
	 * to the book list. It returns the book list created.
	 * 
	 * @param fileName
	 *            The name of the csv file
	 * @return the book list created
	 */
	public static BookList readBookFile(String fileName) {
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.err.println("Usage error. File not found (" + fileName + ").");
			System.exit(1);
		}
		BufferedReader br = new BufferedReader(fr);
		String nextLine = null;
		try {
			nextLine = br.readLine();
		} catch (IOException e) {
			System.err.println("IO Exception while reading " + fileName + ".");
			System.exit(1);
		}
		while (nextLine != null) {
			processLine(nextLine);
			try {
				nextLine = br.readLine();
			} catch (IOException e) {
				System.err.println("IO Exception while reading " + fileName + ".");
				System.exit(1);
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			System.err.println("IO Exception while closing " + fileName + ".");
			System.exit(1);
		}

		return bookList;
	}

	/**
	 * This method takes a line from a csv file of book data, turns it into a
	 * book object, and adds that object to the book list.
	 * 
	 * @param line
	 *            The line to parse
	 */
	private static void processLine(String line) {
		String[] parts = line.split(",");

		if (parts.length < 4) {
			System.err.println("Error in input file. Line too short.");
			return;
		}

		int year = 0;
		try {
			year = Integer.parseInt(parts[2]);
		} catch (NumberFormatException e) {
			System.err.println("Error in input file. Year is not a number.");
			return;
		}

		if (parts.length == 4) {
			try {
				bookList.add(new Book(parts[0], parts[1], year, parts[3]));
			} catch (IllegalArgumentException e) {
				System.err.println("Error in input file. Cannot add same book twice.");
			}
		} else {
			ArrayList<String> genres = new ArrayList<String>();
			for (int i = 3; i < parts.length; i++) {
				genres.add(parts[i]);
			}
			try {
				bookList.add(new Book(parts[0], parts[1], year, genres));
			} catch (IllegalArgumentException e) {
				System.err.println("Error in input file. Cannot add same book twice.");
			}
		}
	}
}