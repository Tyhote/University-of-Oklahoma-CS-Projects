import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

/**
 * Lab 3 CS 2334, Section 010 February 21, 2017
 * <P>
 * This class models a book.
 * </P>
 * Implements Serializable 
 * @author Dean Hougen and (your name)
 * @version 1.0
 */

public class Book implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4988464181586116696L;

	/** The title of the book. */
	private String title;

	/** The name of the book's author. */
	private String authorName;

	/** The year the book was published. */
	private int year;

	/** The genre(s) of the book. */
	private ArrayList<String> genres;

	/**
	 * This is the default constructor for the class.
	 */
	public Book() {
		this.title = "";
		this.authorName = "";
		this.year = -1;
		this.genres = null;
	}

	/**
	 * This is a constructor for the class. It instantiates the class with
	 * user-supplied values. This version of the constructor is used when only
	 * one genre is provided.
	 * 
	 * @param title
	 *            The title of the book
	 * @param authorName
	 *            The name of the book's author
	 * @param year
	 *            The year that the book was published
	 * @param genre
	 *            The genre of the book
	 */
	public Book(String title, String lastName, int year, String genre) {
		this.title = title;
		this.authorName = lastName;
		this.year = year;
		this.genres = new ArrayList<String>();
		genres.add(genre);
	}

	/**
	 * This is a constructor for the class. It instantiates the class with
	 * user-supplied values. This version of the constructor is used when
	 * multiple genres are provided.
	 * 
	 * @param title
	 *            The title of the book
	 * @param authorName
	 *            The name of the book's author
	 * @param year
	 *            The year that the book was published
	 * @param genres
	 *            The genres of the book
	 */
	public Book(String title, String authorName, int year, ArrayList<String> genres) {
		this.title = title;
		this.authorName = authorName;
		this.year = year;
		this.genres = genres;
	}

	/**
	 * This method returns the attributes of this class as a single string.
	 * 
	 * @return String representing the contents of this object
	 */
	public String toString() {
		// Format should be title, author, year, genres (separated by commas, if
		// multiple)
		String genresString = "";
		Iterator<String> iterator = this.genres.iterator();
		while (iterator.hasNext()) {
			genresString += iterator.next();
			if (iterator.hasNext()) {
				genresString += ", ";
			}
		}
		return this.title + ", " + this.authorName + ", " + this.year + ", " + genresString;
	}

	/**
	 * This method checks to see whether two instances of Book are equal by
	 * comparing their fields other than genres.
	 * 
	 * @param obj
	 *            The object to which to compare this book
	 * @return boolean as to whether this book is equal to another object
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Book) {
			Book book = (Book) o;
			boolean equivalent = this.title.equals(book.title);
			if (equivalent) {
				equivalent = this.authorName.equals(book.authorName);
			}
			if (equivalent) {
				equivalent = this.year == book.year;
			}
			return equivalent;
		}

		else {
			return false;
		}
	}

	/**
	 * This method compares an instance of this Book, with another instance of
	 * Book. It should not consider genres.
	 * <P>
	 * Algorithm:<br>
	 * 1. Compare titles 2. If titles are the same, compare authors 3. If
	 * authors are the same, take the difference in years
	 * 
	 * </P>
	 * 
	 * @param book
	 *            The book to which we are comparing this instance of Book
	 * @return A negative, zero, or positive integer depending on whether this
	 *         belongs before, at the same place, or after the book being
	 *         compared to
	 */
	public int compareTo(Book book) {
		int comparison = this.title.compareTo(book.title);
		if (comparison == 0) {
			comparison = this.authorName.compareTo(book.authorName);
		}
		if (comparison == 0) {
			comparison = this.year - book.year;
		}
		return comparison;
	}

	public static void writeBook(String filename, Book book) throws FileNotFoundException, IOException{
		FileOutputStream fileOutputStream = new FileOutputStream(filename);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(book);
		objectOutputStream.close();
	}
	
	public static Book readBook(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream(fileName);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Book book = (Book) objectInputStream.readObject();
		objectInputStream.close();
		return book;
	}

}
