import java.util.ArrayList;

/**
 * Project #1 CS 2334, Section 010 February 22, 2017
 * <P>
 * A <code>NewsStoryList</code> is a list of <code>NewsStory</code>
 * objects.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 *
 */
class NewsStoryList {
	/** The list of news stories. */
	private ArrayList<NewsStory> newsStories = new ArrayList<NewsStory>();

	/**
	 * The mutator for adding a news story to the list.
	 * <P>
	 * By using our own class with its own <code>add</code> method, rather than
	 * directly using the <code>add</code> method of <code>ArrayList</code>, we
	 * could ensure that we don't add duplicate <code>NewsStory</code>
	 * objects to our list. However, to keep the project relatively simple, this
	 * requirement was not made in the project description and this check
	 * doesn't need to be made yet.
	 * </P>
	 * 
	 * @param newsStory
	 *            The news story to add.
	 */
	public void add(NewsStory newsStory) {
		// TODO Refine this to prevent duplicates (Eventually)
		this.newsStories.add(newsStory);
	}

	/**
	 * The accessor for determining the number of stories in the list.
	 * <P>
	 * Note that this accessor name violates the convention that accessor names
	 * should start with "get" (or "is" for booleans). However, "size" is an
	 * accepted convention for names serving this particular purpose, so we are
	 * following the second convention rather than the first.
	 * </P>
	 * 
	 * @return The number of stories in the list.
	 */
	public int size() {
		return this.newsStories.size();
	}

	/**
	 * An accessor for getting a story from the list based on its position
	 * (index) in the list.
	 * 
	 * @param index
	 *            The location from which to get the story.
	 * @return The news story at the index, if the index is valid.
	 * @throws IllegalArgumentException
	 *             if the index is not valid.
	 */
	public NewsStory get(int index) {
		if (index >= 0 && index < this.newsStories.size()) {
			return this.newsStories.get(index);
		} else {
			throw new IllegalArgumentException("Index out of bounds: " + index);
		}
	}
}
