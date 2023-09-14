import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Lab 3 CS 2334, Section 010 February 21, 2017
 * <P>
 * This class models a list of books.
 * </P>
 * Implements Serializable
 * @author Dean Hougen and (your name)
 * @version 1.0
 */

public class BookList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -523773774499921709L;


	private List<Book> bookList = new ArrayList<Book>();

	public void add(Book book) {
		// Check whether book is already in list
		// If so, throw illegal argument exception
		if (bookList.contains(book)) {
			throw new IllegalArgumentException("Cannot add the same book twice");
		}
		// If not, add it
		else {
			bookList.add(book);
		}
	}

	public Book get(int index) {
		if (index >= 0 && index < bookList.size()) {
			return bookList.get(index);
		} else {
			throw new IllegalArgumentException("Index out of bounds");
		}
	}

	/**
	 * This method returns the attributes of this class as a single string with
	 * one resident per line.
	 * 
	 * @return String representing the contents of this object.
	 */
	public String toString() {
		String attributesAsString = "";
		for (Book book : bookList) {
			attributesAsString += book + "\n";
		}
		return (attributesAsString);
	}

	public static void writeBookList(String fileName, BookList bookList) throws FileNotFoundException, IOException{
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(bookList);
		objectOutputStream.close();
	}


	public static BookList readBookList(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream(fileName);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		BookList bookList = (BookList) objectInputStream.readObject();
		objectInputStream.close();
		return bookList;
	}

}
