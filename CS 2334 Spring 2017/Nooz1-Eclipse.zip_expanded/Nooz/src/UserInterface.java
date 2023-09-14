import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.JOptionPane;

/**
 * Project #1 CS 2334, Section 010 February 22, 2017
 * <P>
 * This class provided helper methods to interact with the user.
 * </P>
 * <P>
 * Note that all methods in this class are static because we don't need to make
 * several <code>UserInterface</code> objects and have them maintain their own
 * data. Instead, we simply need a collection of useful methods to create
 * windows that pop up one at a time, are used, and then are discarded.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 *
 */
class UserInterface {
	static Scanner sc = new Scanner(System.in);

	public static String queryMediaType() {
		System.out.println("Search newspapers, TV news, or both (n, t, or b)?");
		return getInput();

	}

	public static String queryMatchType() {
		String result = "";
		do {
			System.out.println("Search newsmakers by exact or partial matches (e or p)?");
			result = sc.nextLine();
		} while (!(result.equals("e") || result.equals("p")));
		return result;
	}

	/**
	 * This method asks the user for the name of a news maker using a
	 * <code>JOptionPane</code> and returns it.
	 * 
	 * @return The name provided by the user (or "None" if none provided).
	 */
	public static String queryNewsMakerName() {
		String newsMakerName = "";
		String matchType = queryMatchType();
		if (matchType.equals("e")) {
			System.out.println("Newsmaker (exact)?");
			newsMakerName = getInput();
		} else if (matchType.equals("p")) {
			System.out.println("Newsmaker (partial)?");
			newsMakerName = getInput();
		}
		return newsMakerName;

	}

	public static String querySortCriterion(String primarySortCriterion, String secondarySortCriterion) {
		String result = "";
		do {
			if (primarySortCriterion.equals("s")) {
				System.out.println("Secondary sort criterion is topic or length (t or l)?");
				result = getInput();
			} else if (primarySortCriterion.equals("t")) {
				System.out.println("Secondary sort criterion is source or length (s or l)?");
				result = getInput();
			} else if (primarySortCriterion.equals("l")) {
				System.out.println("Secondary sort criterion is source or topic (s or t)?");
				result = getInput();
			} else {
				System.out.println("Primary sort criterion is source, topic, or length (s, t, or l)?");
				result = getInput();
			}
		} while (result == "" || result == primarySortCriterion);
		return result;

	}

	private static String getInput() {
		String result = sc.nextLine();
		return result;
	}

	public static String queryFileName(String message) {
		System.out.println(message);
		return getInput();
	}

	public static boolean queryBoolean(String message) {
		String result = "";
		do {
			System.out.println(message);
			result = getInput();
		} while (!(result.toLowerCase().equals("y") || result.toLowerCase().equals("n")));
		if (result.toLowerCase().equals("y")) {
			return true;
		} else if (result.toLowerCase().equals("n")) {
			return false;
		} else
			return false;
	}
	
	/**
	 * Queries the user the desired filetype.
	 * @param message 
	 * The message to display.
	 * @return 
	 * Returns a String
	 */
	private static String queryFileType(String message){
		return null;
	}
	
	/**
	 * Queries how the user wants the data displayed
	 * @return
	 * Returns a String
	 */
	public static String queryDisplayType(){
		return null;
	}

	/**
	 * This method takes a news maker and turns its list of newspaper stories
	 * into a string formated for display to the user. At the end it includes
	 * line summarizing the number of stories found, the number of different
	 * newspapers in which these stories were published, the total number of
	 * words in these articles, and the number of different topics found.
	 * 
	 * @param newsMaker
	 *            The news maker for which to create the story list as a string
	 * @return The list of stories as one (potentially very large) string
	 */
	public static String createListOfNewsStoriesForNewsmaker(NewsMaker newsMaker, String mediaType,
			String[] sortCriteria) {
		/* The list of stories as a String */
		String listOfStories = "";

		/*
		 * Lists to keep track of the distinct newspaper names and topics found
		 * (for the summary line).
		 */
		// TODO Switch these from ArrayLists to a data structure that
		// automatically excludes duplicates
		TreeSet<String> distinctSources = new TreeSet<String>();
		TreeSet<String> distinctTopics = new TreeSet<String>();

		/* The running total of the words in the stories. */
		int totalWords = 0;

		/*
		 * A local reference to the story list so that we don't have use the
		 * accessor method repeatedly (wasting time).
		 */
		ArrayList<NewsStory> newsStoryList = new ArrayList<NewsStory>();
		NewsStoryList aux = newsMaker.getNewsStories();
		for (int i = 0; i < aux.size(); ++i) {
			newsStoryList.add(aux.get(i));
		}
		SourceComparator sComp = new SourceComparator();
		if (sortCriteria[0].equals("s")) {
			Collections.sort(newsStoryList, sComp);
		}

		LengthComparator lComp = new LengthComparator();
		if (sortCriteria[0].equals("l")) {
			Collections.sort(newsStoryList, lComp);
		}
		
		TopicComparator tComp = new TopicComparator();
		if (sortCriteria[0].equals("t")) {
			Collections.sort(newsStoryList, tComp);
		}
		
		lComp = new LengthComparator();
		if (sortCriteria[1].equals("l")) {
			Collections.sort(newsStoryList, lComp);
		}
		
		sComp = new SourceComparator();
		if (sortCriteria[1].equals("s")) {
			Collections.sort(newsStoryList, sComp);
		}
		
		tComp = new TopicComparator();
		if (sortCriteria[1].equals("t")) {
			Collections.sort(newsStoryList, tComp);
		}

		// Cycle through the stories one at a time
		// TODO Switch this to a for each loop
		for (int i = 0; i < newsStoryList.size(); i++) {
			NewsStory newsStory = newsStoryList.get(i);

			// Add any new newspaper name encountered to the list of names
			String source = newsStory.getSource();
			distinctSources.add(source);

			// Add any new topic encountered to the list of topics
			String topic = newsStory.getTopic();
			distinctTopics.add(topic);

			// Add to the running total of words
			totalWords += newsStory.getLengthInWords();

			// Convert the story to the display format and add it to the end of
			// the list
			listOfStories += convertToOutputFormat(newsStory, checkMediaType(newsStory), topic) + "\n";
		}

		// Construct the summary line
		listOfStories += "Number of Stories: " + newsStoryList.size() + "; Number of Newspapers: "
				+ distinctSources.size() + "; Number of Words: " + totalWords + "; Number of Topics: "
				+ distinctTopics.size();

		return listOfStories;
	}

	/**
	 * This method converts an individual story to the desired display format.
	 * 
	 * @param newspaperStory
	 *            The story to convert to the display format.
	 * @return The story in the display format.
	 */
	private static String convertToOutputFormat(NewsStory newsStory, String mediaType, String displayType) {
		String storyString = "";
		LocalDate date = newsStory.getDate();
		if (mediaType.equals("TV")) {
			storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLengthInWords()
					+ " word equivalents; " + newsStory.getTopic();
		} else if (mediaType.equals("Newspaper")) {
			storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLengthInWords() + " words; "
					+ newsStory.getTopic();
		}
		return storyString;
	}

	/**
	 * This method displays the list of newspaper stories to the user using a
	 * <code>JOptionPane</code>.
	 * <P>
	 * Note that a <code>JOptionPane</code> works fine for small messages but
	 * isn't suitable for large messages, such as those that can be generated
	 * for news makers for whom there are many stories. However, to keep this
	 * project relatively simple, we have gone with a <code>JOptionPane</code>
	 * here. We'll learn how to develop more suitable graphical user interfaces
	 * in later assignments.
	 * </P>
	 * 
	 * @param listOfStories
	 *            The list of stories to display, all as one (potentially very
	 *            large) String.
	 * @param newsMakerName
	 *            The name of the news maker (which is put into the title of the
	 *            JOptionPane).
	 */
	public static void presentNewspaperStories(String listOfStories, String newsMakerName) {
		System.out.println("News stories for " + newsMakerName + "\n" + listOfStories);
	}

	public static void reportNewsmakerNotFound(NewsMaker queriedNewsMaker) {
		JOptionPane.showMessageDialog(null,
				"There are no newspaper stories about " + queriedNewsMaker.getName() + " in this database.",
				queriedNewsMaker.getName(), JOptionPane.PLAIN_MESSAGE);
	}

	private static String checkMediaType(NewsStory newsStory) {
		if (newsStory instanceof NewspaperStory) {
			return "Newspaper";
		} else if (newsStory instanceof TVNewsStory) {
			return "TV";
		} else {
			return null;
		}
	}
	
	/**
	 * Saves the file in a format specified by the user
	 * @param fileType
	 * The specified file type
	 */
	public static void saveFile(String fileType){
		
	}
	
	/**
	 * Sanitizes user input for later use in the program
	 * @param input
	 * The input from the user
	 * @return
	 * Returns a String that has been sanitized
	 */
	private static String sanitizeInput(String input){
		return null;
	}
}
