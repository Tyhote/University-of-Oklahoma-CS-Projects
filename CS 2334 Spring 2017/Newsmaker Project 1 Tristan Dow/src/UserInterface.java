import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interface made to make interaction with the user easier
 * 
 * @author Tristan Dow
 * 
 */
public class UserInterface {
	/**
	 * Queries the name of the NewsMaker the user is looking for
	 * 
	 * @return Returns a String
	 */
	public static String queryNewsMakerName() {
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		input.close();
		return userInput;
	}

	/**
	 * Makes a list of NewspaperStories for the specified NewsMaker
	 * 
	 * @param newsMaker
	 *            The NewsMaker to find the stories about
	 * @return Returns a String
	 */
	public static String createListOfNewspaperStoriesForNewsmaker(NewsMaker newsMaker) {
		StringBuilder result = new StringBuilder();
		NewspaperStoryList list = newsMaker.getNewspaperStories();
		for (int i = 0; i < list.size(); ++i) {
			result.append(convertToOutputFormat(list.get(i)) + "\n");
		}
		int wordCount = 0;
		for (int i = 0; i < list.size(); ++i) {
			wordCount += list.get(i).getWordCount();
		}
		int topicCount = 0;
		ArrayList<String> topicList = new ArrayList<String>();
		for (int i = 0; i < list.size(); ++i) {
			if (!topicList.contains(list.get(i).getTopic())) {
				topicList.add(list.get(i).getTopic());
				++topicCount;
			}
		}
		result.append("Number of Stories: " + list.size() + "; Number of Newspapers: " + list.size()
				+ "; Number of Words: " + wordCount + "; Number of Topics: " + topicCount);

		return result.toString();
	}

	/**
	 * Converts the data in a NewspaperStory object to a human-readable format
	 * 
	 * @param newspaperStory
	 *            The NewspaperStory to convert
	 * @return Returns a String
	 */
	private static String convertToOutputFormat(NewspaperStory newspaperStory) {
		LocalDate date = newspaperStory.getDate();
		String month = date.getMonth().toString().toLowerCase();
		month = Character.toUpperCase(month.charAt(0)) + month.substring(1);
		int day = date.getDayOfMonth();
		int year = date.getYear();
		return month + " " + day + ", " + year + "; " + newspaperStory.getNewspaperName() + "; "
				+ newspaperStory.getWordCount() + " words; " + newspaperStory.getTopic();
	}

	/**
	 * Prints a list of NewspaperStories along with the NewsMaker they are about
	 * 
	 * @param listOfStories
	 *            The stories to print
	 * @param newsMakerName
	 *            The NewsMaker the stories are about
	 */
	public static void presentNewspaperStories(String listOfStories, String newsMakerName) {
		System.out.println(listOfStories);
	}

	/**
	 * Prints that the specified NewsMaker was not found
	 * 
	 * @param queriedNewsMaker
	 *            The NewsMaker to print about
	 */
	public static void reportNewsmakerNotFound(NewsMaker queriedNewsMaker) {
		System.out.println(queriedNewsMaker.getName() + " not found.");
	}
}
