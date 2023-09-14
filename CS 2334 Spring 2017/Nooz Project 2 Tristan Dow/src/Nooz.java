import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The main Nooz program. Reads a CSV file specified by the user and allows the
 * user to search for specific newsmakers in those stories
 * 
 * @author Tristan Dow
 *
 */
public class Nooz {
	/**
	 * The list of NewsMakers that contains the story information
	 */
	private static NewsMakerList newsMakers = new NewsMakerList();

	public static void main(String[] args) {
		if (args.length > 1) {
			System.exit(args.length);
		}
		try {
			newsMakers = NoozFileProcessor.readNoozFile(args[0]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String userQuery = UserInterface.queryNewsMakerName(null); // TODO
		NewsMaker queriedNewsMaker = newsMakers.get(new NewsMaker(userQuery));
		if (newsMakers.contains(queriedNewsMaker)) {
			String newspaperStories = UserInterface.createListOfNewspaperStoriesForNewsmaker(queriedNewsMaker);
			UserInterface.presentNewsStories(newspaperStories, queriedNewsMaker.getName());
		} else {
			UserInterface.reportNewsmakerNotFound(queriedNewsMaker);
		}

	}

}
