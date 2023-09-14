import java.util.ArrayList;

/**
 * NewsStoryList for CS 2334
 * <P>
 * aggregation of NewsStory.
 * </P>
 * 
 * @author Tristan Dow
 *
 */

public class NewsStoryList {
	/**
	 * An ArrayList of type NewsStory
	 */
	private ArrayList<NewsStory> newsStories = new ArrayList<NewsStory>();

	/**
	 * Adds a story to the list.
	 * 
	 * @param newsStory
	 *            The story to add.
	 */
	public void add(NewsStory newsStory) {
		this.newsStories.add(newsStory);
	}

	/**
	 * Returns the size of the contained array
	 * 
	 * @return Returns an int
	 */
	public int size() {
		return newsStories.size();
	}

	/**
	 * Gets the NewsStory in the specified index
	 * 
	 * @param index
	 *            The index to get from
	 * @return Returns a NewsStory
	 */
	public NewsStory get(int index) {
		return newsStories.get(index);
	}

}
