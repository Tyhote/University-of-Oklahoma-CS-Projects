/**
 * 
 */
package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Dean Hougen and (your name)
 *
 */
public class BookList {
	private ArrayList<Book> bookList = new ArrayList<Book>();

	public void add(Book book) {
		// Check whether book is already in list
		// If so, throw illegal argument exception
		if (bookList.contains(book)) {
			throw new IllegalArgumentException("Book already in list");
		}
		// If not, add it
		else {
			bookList.add(book);
		}

	}

	public void printBooks() {
		Iterator<Book> iterator = bookList.iterator();

		while (iterator.hasNext()) {
			// Note: This line of code will automatically call the toString
			// method of the Book class.
			System.out.println(iterator.next());
		}
	}

	public void sortBooks() {
		// Call Collections.sort which will use compareTo
		Collections.sort(bookList);
	}

	public Book findBook(Book book) {
		// Call Collections.binarySearch
		int index = Collections.binarySearch(bookList, book);

		// If the book is found, return it
		if (index > -1) {
			return bookList.get(index);
		}

		// If not, return null
		return null;
	}
}