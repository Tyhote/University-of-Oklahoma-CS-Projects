import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedReader;

/**
 * Processes a CSV file for the main Nooz program
 * 
 * @author Tristan Dow
 *
 */
public class NoozFileProcessor {
	/*
	 * public static void main(String[] args) { String line =
	 * "20120104,1,1371,25,99,\"Obama Administration\""; String[] lineQ =
	 * processLine(line); for(int i = 0; i < lineQ.length; ++i){
	 * System.out.println(lineQ[i]); } }
	 */

	/**
	 * The list of NewsMakers that will be eventually given through
	 * readNoozFile()
	 */
	private static NewsMakerList newsMakers = new NewsMakerList();

	/**
	 * Reads a CSV file and puts the data into a NewsMakerList that it then
	 * returns
	 * 
	 * @param fileName
	 *            The CSV file to read
	 * @return Returns a NewsMakerList with the file data
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static NewsMakerList readNoozFile(String fileName) throws IOException, FileNotFoundException {
		// Making the CSVReader
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		reader.readLine();
		String line;
		while ((line = reader.readLine()) != null) {
			processLine(line);
		}
		reader.close();
		return newsMakers;
	}

	/**
	 * Processes each line fed in and adds the information as a NewsMaker to the
	 * newsMakers NewsMakerList
	 * 
	 * @param line
	 *            The line to process
	 */
	private static void processLine(String line) {
		String[] lineList = line.split(",");
		LocalDate date = decodeDate(lineList[0]);
		String newsPublisher = decodePublisher(lineList[1]);
		int wordCount = decodeWordCount(lineList[2]);
		String topic = decodeTopic(lineList[3]);
		String type = determineType(lineList[1]);

		ArrayList<String> modList = new ArrayList<String>();
		for (int i = 0; i < lineList.length; ++i) {
			modList.add(lineList[i]);
		}
		String newsMakerName1 = "";
		String newsMakerName2 = "";
		if (lineList.length == 6) {
			newsMakerName1 = decodeNewsmakerName(lineList, 4);
			newsMakerName2 = decodeNewsmakerName(lineList, 5);
		} else if (lineList.length >= 7) {
			if (decodeNewsmakerName(lineList, 4).equals("None")) {
				newsMakerName1 = "None";
				newsMakerName2 = decodeNewsmakerName(lineList, 5);
			} else if (decodeNewsmakerName(lineList, 4).contains(",")) {
				newsMakerName1 = decodeNewsmakerName(lineList, 4);
				newsMakerName2 = decodeNewsmakerName(lineList, 6);
			}
		}
		NewsMaker newsMaker1 = new NewsMaker(newsMakerName1);
		NewsMaker newsMaker2 = new NewsMaker(newsMakerName2);
		if (newsMakerName1.equals("None") && newsMakerName2.equals("None")) {
			if (!newsMakers.contains(newsMaker1)) {
				newsMaker1.addNewsStory(
						new NewsStory(date, newsPublisher, wordCount, topic, newsMaker1, newsMaker1, type));
				newsMakers.add(newsMaker1);
			} else {
				newsMaker1 = newsMakers.get(newsMaker1);
				newsMaker1.addNewsStory(
						new NewsStory(date, newsPublisher, wordCount, topic, newsMaker1, newsMaker1, type));
			}

		} else if (newsMakerName1.equals("None")) {
			if (!newsMakers.contains(newsMaker2)) {
				newsMaker2.addNewsStory(
						new NewsStory(date, newsPublisher, wordCount, topic, newsMaker1, newsMaker2, type));
				newsMakers.add(newsMaker2);
			} else {
				newsMaker2 = newsMakers.get(newsMaker2);
				newsMaker2.addNewsStory(
						new NewsStory(date, newsPublisher, wordCount, topic, newsMaker1, newsMaker2, type));
			}
		} else if (newsMakerName2.equals("None")) {
			if (!newsMakers.contains(newsMaker1)) {
				newsMaker1.addNewsStory(
						new NewsStory(date, newsPublisher, wordCount, topic, newsMaker1, newsMaker2, type));
				newsMakers.add(newsMaker1);
			} else {
				newsMaker1 = newsMakers.get(newsMaker1);
				newsMaker1.addNewsStory(
						new NewsStory(date, newsPublisher, wordCount, topic, newsMaker1, newsMaker2, type));
			}
		} else if (!newsMakerName1.equals("None") && !newsMakerName2.equals("None")) {
			if (!newsMakers.contains(newsMaker1)) {
				newsMakers.add(newsMaker1);
			}
			if (!newsMakers.contains(newsMaker2)) {
				newsMakers.add(newsMaker2);
			}
			newsMaker1 = newsMakers.get(newsMaker1);
			newsMaker2 = newsMakers.get(newsMaker2);
			NewsStory story = new NewsStory(date, newsPublisher, wordCount, topic, newsMaker1, newsMaker2, type);
			newsMaker1.addNewsStory(story);
			newsMaker2.addNewsStory(story);
		}
	}

	private static String determineType(String string) {
		int aux = Integer.parseInt(string);
		if (aux < 401) {
			return "Newpaper";
		} else {
			return "TV";
		}
	}

	/*
	 * private static String[] lineFixer(String[] line) { ArrayList<String>
	 * fixedLine = new ArrayList<String>(); for (int i = 0; i < line.length;
	 * ++i) { fixedLine.add(line[i]); } for (int i = 0; i < fixedLine.size();
	 * ++i) { if (fixedLine.get(i).charAt(0) ==
	 * '\"' && fixedLine.get(i).charAt(fixedLine.get(i).length() - 1) != '\"') {
	 * fixedLine.set(i, fixedLine.get(i).substring(1) + "," + fixedLine.get(i +
	 * 1).substring(0, fixedLine.get(i + 1).length() - 1)); fixedLine.remove(i +
	 * 1); } else if (fixedLine.get(i).charAt(0) == '\"') { fixedLine.set(i,
	 * fixedLine.get(i).substring(1, fixedLine.get(i).length() - 1)); } }
	 * 
	 * String[] result = new String[fixedLine.size()]; for (int i = 0; i <
	 * fixedLine.size(); ++i) { result[i] = fixedLine.get(i); } return result; }
	 */

	/**
	 * Takes dateString and converts it into a usable LocalDate
	 * 
	 * @param dateString
	 *            The String from the parsed book information
	 * @return Returns a LocalDate in the correct date format
	 */
	private static LocalDate decodeDate(String dateString) {
		String date = dateString.substring(0, 4) + "-" + dateString.substring(4, 6) + "-" + dateString.substring(6);
		return LocalDate.parse(date);
	}

	/**
	 * Converts a newspaper code to a String.
	 * 
	 * @param newspaperCode
	 *            The newspaper code to convert.
	 * @return returns a String
	 */
	private static String decodePublisher(String newspaperCode) {
		int convNewspaperCode = Integer.parseInt(newspaperCode);
		switch (convNewspaperCode) {
		case 1:
			return "New York Times";
		case 2:
			return "Washington Post";
		case 3:
			return "Wall Street Journal";
		case 4:
			return "USA Today";
		case 13:
			return "Los Angeles Times";
		case 117:
			return "Denver Post";
		case 118:
			return "Houston Chronicle";
		case 119:
			return "Orlando Sentinel";
		case 120:
			return "Traverse City Record";
		case 121:
			return "Daily Herald (Everett, WA)";
		case 122:
			return "Eagle Tribune";
		default:
			return "ERROR-Fake Newspaper";
		}

	}

	/**
	 * Decodes the word count in a string
	 * 
	 * @param wordCountString
	 *            The string to decode
	 * @return returns an int
	 */
	private static int decodeWordCount(String wordCountString) {
		return Integer.parseInt(wordCountString);
	}

	/**
	 * Converts the topic code of the story to a string.
	 * 
	 * @param topicCode
	 *            The topic code to convert.
	 * @return returns a String.
	 */
	private static String decodeTopic(String topicCode) {
		int convTopicCode = Integer.parseInt(topicCode);
		switch (convTopicCode) {
		case 1:
			return "Government Agencies/Legislatures";
		case 2:
			return "Campaigns/Elections/Politics";
		case 3:
			return "Defense/Military (Domestic)";
		case 4:
			return "Court/Legal System";
		case 5:
			return "Crime";
		case 6:
			return "Domestic Terrorism";
		case 7:
			return "Business";
		case 8:
			return "Economy/Economics";
		case 9:
			return "Environment";
		case 10:
			return "Development/Sprawl";
		case 11:
			return "Transportation";
		case 12:
			return "Education";
		case 13:
			return "Religion";
		case 14:
			return "Health/Medicine";
		case 15:
			return "Science and Technology";
		case 16:
			return "Race/Gender/Gay Issues";
		case 17:
			return "Immigration";
		case 18:
			return "Additional Domestic Affairs";
		case 19:
			return "Disasters/Accidents";
		case 20:
			return "Celebrity/Entertainment";
		case 21:
			return "Lifestyle";
		case 22:
			return "Sports";
		case 23:
			return "Media";
		case 24:
			return "U.S. Miscellaneous";
		case 25:
			return "U.S. Foreign Affairs";
		case 26:
			return "Foreign (non-U.S.)";
		default:
			return "ERROR - Fake Nooz";

		}
	}

	/**
	 * Decodes a NewsMaker name from a list with a given starting index
	 * 
	 * @param parts
	 *            The list to process
	 * @param startingIndex
	 *            The starting index of the NewsMaker name
	 * @return returns a String
	 */
	private static String decodeNewsmakerName(String[] parts, int startingIndex) {
		String result = "";
		if (parts[startingIndex].equals("99")) {
			result = "None";
		} else if (parts[startingIndex].charAt(0) == '\"' && startingIndex != parts.length - 1
				&& parts[startingIndex + 1].charAt(0) == ' ') {
			result = parts[startingIndex].substring(1) + ","
					+ parts[startingIndex + 1].substring(0, parts[startingIndex + 1].length() - 1);
		} else if (parts[startingIndex].charAt(0) == '\"'
				&& parts[startingIndex].charAt(parts[startingIndex].length() - 1) == '\"') {
			result = parts[startingIndex].substring(1, parts[startingIndex].length() - 1);
		}
		return result;
	}

	/**
	 * Sorts a NewsStoryList by topic
	 * 
	 * @param storyList
	 *            The list to sort
	 * @param primary
	 *            Whether or not this is the primary sorting method
	 */
	private static NewsStoryList sortByTopic(NewsStoryList storyList, boolean primary) {
		// TODO
		return null;
	}

	/**
	 * Sorts a NewsStoryList by length
	 * 
	 * @param storyList
	 *            The list to sort
	 * @param primary
	 *            Whether or not this is the primary sorting method
	 */
	private static NewsStoryList sortByLength(NewsStoryList storyList, boolean primary) {
		// TODO
		return null;
	}
}
