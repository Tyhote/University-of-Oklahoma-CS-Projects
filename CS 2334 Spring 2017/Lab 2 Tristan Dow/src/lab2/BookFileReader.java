/**
 * 
 */
package lab2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Dean Hougen and (your name)
 *
 */
public class BookFileReader {
	private static BookList bookList = new BookList();

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
				bookList.add(new Book(parts[0], parts[1], year, parts[3]));
			} catch (IllegalArgumentException e) {
				System.err.println("Error in input file. Cannot add same book twice.");
			}
		}
	}
}
