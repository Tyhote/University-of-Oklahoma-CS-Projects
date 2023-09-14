import java.time.LocalDate;

/**
 * Project #1 CS 2334, Section 010 February 22, 2017
 * <P>
 * A <code>NewspaperStory</code> is composed of the date the story was
 * published, the name of the newspaper in which the story was published, the
 * count of words in the story, the topic for the story, and two lead news
 * makers in the story.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 * 
 */
class NewspaperStory extends NewsStory {
	/**
	 * The constructor for the class which takes objects of appropriate types to
	 * initialize all of the fields.
	 * <P>
	 * Note that in the world the count of words in a story cannot be negative,
	 * so our class should model that fact. However, to keep the project
	 * relatively simple, this requirement was not made in the project
	 * description and this check doesn't need to be made yet.
	 * </P>
	 * 
	 * @param date
	 *            The date the story was published as a java.time.LocalDate.
	 * @param newspaperName
	 *            The name of the newspaper in which the story was published.
	 * @param wordCount
	 *            The count of words in the story.
	 * @param topic
	 *            The broad topic of the story.
	 * @param newsMaker1
	 *            The first news maker featured in the story.
	 * @param newsMaker2
	 *            The second news maker featured in the story.
	 */
	public NewspaperStory(LocalDate date, String source, int length, String topic, NewsMaker newsMaker1,
			NewsMaker newsMaker2) {
		super(date, source, length, topic, newsMaker1, newsMaker2);
	}

	@Override
	public int getLengthInWords(){
		return this.getLength();
	}
}
