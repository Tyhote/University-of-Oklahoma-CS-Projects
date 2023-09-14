
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
	 * The NewspaperStoryList the maker holds of itself.
	 */
	private NewspaperStoryList newspaperStories;

	/**
	 * Empty constructor of NewsMaker. Initializes name to an empty String and
	 * initializes newspaperStories.
	 */
	public NewsMaker() {
		this.name = "";
		newspaperStories = new NewspaperStoryList();
	}

	/**
	 * Constructor for NewsMaker.
	 * 
	 * @param name
	 *            The name of the NewsMaker.
	 */
	public NewsMaker(String name) {
		this.name = name;
		newspaperStories = new NewspaperStoryList();
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
	 * @return returns a NewspaperStoryList.
	 */
	public NewspaperStoryList getNewspaperStories() {
		return this.newspaperStories;
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
	 * @param newspaperStory
	 *            The NewspaperStory to add.
	 */
	public void addNewspaperStory(NewspaperStory newspaperStory) {
		newspaperStories.add(newspaperStory);
	}

}