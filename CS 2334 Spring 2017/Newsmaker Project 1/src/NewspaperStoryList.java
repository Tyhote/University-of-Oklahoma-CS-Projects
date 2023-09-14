import java.util.ArrayList;

/**
 * NewspaperStoryList for CS 2334
 * <P>
 * aggregation of NewspaperStory.
 * </P>
 * 
 * @author Tristan Dow
 *
 */

public class NewspaperStoryList {
	/**
	 * An ArrayList of type NewspaperStory
	 */
	private ArrayList<NewspaperStory> newspaperStories = new ArrayList<NewspaperStory>();

	/**
	 * Adds a story to the list.
	 * 
	 * @param newspaperStory
	 *            The story to add.
	 */
	public void add(NewspaperStory newspaperStory) {
		this.newspaperStories.add(newspaperStory);
	}

	/**
	 * Returns the size of the contained array
	 * 
	 * @return Returns an int
	 */
	public int size() {
		return newspaperStories.size();
	}

	/**
	 * Gets the NewspaperStory in the specified index
	 * 
	 * @param index
	 *            The index to get from
	 * @return Returns a NewspaperStory
	 */
	public NewspaperStory get(int index) {
		return newspaperStories.get(index);
	}

}
