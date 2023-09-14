
/**
 * NewsMaker for CS 2334
 * <P>
 * Data holder for the maker of a news story.
 * </P>
 * 
 * @author Tristan Dow
 *
 */
public class NewsMaker {
	/**
	 * The name of the NewsMaker
	 */
	private String name;

	/**
	 * The NewsStoryList the maker holds of itself.
	 */
	private NewsStoryList newsStories;

	/**
	 * Empty constructor of NewsMaker. Initializes name to an empty String and
	 * initializes newsStories.
	 */
	public NewsMaker() {
		this.name = "";
		newsStories = new NewsStoryList();
	}

	/**
	 * Constructor for NewsMaker.
	 * 
	 * @param name
	 *            The name of the NewsMaker.
	 */
	public NewsMaker(String name) {
		this.name = name;
		newsStories = new NewsStoryList();
	}

	/**
	 * Compares Object o to the NewsMaker
	 * 
	 * @param o
	 *            The object to compare to
	 * @return Returns a boolean
	 */
	public boolean equals(Object o) {
		if (o instanceof NewsMaker) {
			if (((NewsMaker) o).getName().equals(this.name)) {
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * Gives the list of stories about the NewsMaker.
	 * 
	 * @return returns a NewsStoryList.
	 */
	public NewsStoryList getNewsStories() {
		return this.newsStories;
	}

	/**
	 * Gives the name of the NewsMaker.
	 * 
	 * @return returns a String.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Adds a story to the NewsMaker's list.
	 * 
	 * @param newsStory
	 *            The NewsStory to add.
	 */
	public void addNewsStory(NewsStory newsStory) {
		newsStories.add(newsStory);
	}

}