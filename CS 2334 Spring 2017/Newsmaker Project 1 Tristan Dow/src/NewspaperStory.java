import java.time.LocalDate;

/**
 * NewspaperStory for CS 2334
 * <P>
 * This class stores information for newspaper articles.
 * </P>
 * 
 * @author Tristan Dow
 *
 */
public class NewspaperStory {
	/**
	 * The date code for the story.
	 */
	private LocalDate date;

	/**
	 * The newspaper code for the story.
	 */
	private String newspaperName;

	/**
	 * The word count of the story
	 */
	private int wordCount;

	/**
	 * The topic code of the story.
	 */
	private String topic;

	/**
	 * The first NewsMaker of the story.
	 */
	private NewsMaker newsMaker1;

	/**
	 * The second NewsMaker of the story.
	 */
	private NewsMaker newsMaker2;

	/**
	 * The constructor for NewspaperStory. All parameters are assigned to their
	 * respective fields.
	 * 
	 * @param date The date of the NewspaperStory in LocalDate format
	 * @param newspaperName The name of the publishing newspaper
	 * @param wordCount The word count of the story
	 * @param topic The topic of the story
	 * @param newsmaker1 The first newsmaker of the story
	 * @param newsmaker2 The second newsmaker of the story
	 */
	public NewspaperStory(LocalDate date, String newspaperName, int wordCount, String topic, NewsMaker newsmaker1,
			NewsMaker newsmaker2) {
		this.date = date;
		this.newspaperName = newspaperName;
		this.wordCount = wordCount;
		this.topic = topic;
		this.newsMaker1 = newsmaker1;
		this.newsMaker2 = newsmaker2;
	}

	/**
	 * Gives the date code.
	 * 
	 * @return returns a String.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Gives the publishing newspaper of the story.
	 * 
	 * @return returns a String.
	 */
	public String getNewspaperName() {
		return this.newspaperName;
	}

	/**
	 * Gives word count of story.
	 * 
	 * @return returns an int.
	 */
	public int getWordCount() {
		return this.wordCount;
	}

	/**
	 * Gets the topic of the article.
	 * 
	 * @return returns a String.
	 */
	public String getTopic() {
		return this.topic;
	}

	/**
	 * Gets the first NewsMaker.
	 * 
	 * @return returns a String
	 */
	public NewsMaker getNewsMaker1() {
		return newsMaker1;
	}

	/**
	 * Gets the second NewsMaker.
	 * 
	 * @return returns a String.
	 */
	public NewsMaker getNewsMaker2() {
		return newsMaker2;
	}

}
