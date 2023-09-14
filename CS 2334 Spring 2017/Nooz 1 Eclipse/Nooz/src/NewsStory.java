import java.time.LocalDate;

/**
 * Project #1 CS 2334, Section 010 February 22, 2017
 * <P>
 * A <code>NewsStory</code> is composed of the date the story was
 * published, the name of the news in which the story was published, the
 * count of words in the story, the topic for the story, and two lead news
 * makers in the story.
 * </P>
 * 
 * @author Dean Hougen and Tristan Dow
 * @version 2.0
 * 
 */
abstract class NewsStory implements Comparable<NewsStory>{
	/**
	 * The date the story was published as a <code>java.time.LocalDate</code>.
	 */
	private LocalDate date;

	/** The name of the source in which the story was published. */
	private String source;

	/** The count of words in the story. */
	private int length;

	/** The broad topic of the story. */
	private String topic;

	/** The first news maker featured in the story. */
	private NewsMaker newsMaker1;

	/** The second news maker featured in the story. */
	private NewsMaker newsMaker2;

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
	 * @param newsName
	 *            The name of the news in which the story was published.
	 * @param wordCount
	 *            The count of words in the story.
	 * @param topic
	 *            The broad topic of the story.
	 * @param newsMaker1
	 *            The first news maker featured in the story.
	 * @param newsMaker2
	 *            The second news maker featured in the story.
	 */
	protected NewsStory(LocalDate date, String source, int length, String topic, NewsMaker newsMaker1,
			NewsMaker newsMaker2) {
		this.date = date; // Note that LocalDate is immutable
		this.source = source;
		this.length = length; // TODO Restrict to positive values
									// (Eventually)
		this.topic = topic;
		this.newsMaker1 = newsMaker1;
		this.newsMaker2 = newsMaker2;
	}

	/**
	 * The accessor for the date field.
	 * <P>
	 * Note that <code>LocalDate</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The date the story was published.
	 */
	public LocalDate getDate() {
		return date; // Note that LocalDate is immutable
	}

	/**
	 * The accessor for the news name field.
	 * <P>
	 * Note that <code>String</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The name of the news in which the story was published.
	 */
	public String getSource() {
		return source;
	}

	/**
	 * The accessor for the wordCount field.
	 * <P>
	 * Note that <code>int</code>s are passed by value, so it is fine to return
	 * the field itself.
	 * </P>
	 * 
	 * @return The count of the words in the story.
	 */
	public int getLength() {
		return length;
	}
	
	abstract public int getLengthInWords();

	/**
	 * The accessor for the topic field.
	 * <P>
	 * Note that <code>String</code> objects are immutable, so it is fine to
	 * return the field itself.
	 * </P>
	 * 
	 * @return The broad topic of the story.
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * The accessor for the first news maker field.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @return The first news maker featured in the story.
	 */
	public NewsMaker getNewsMaker1() {
		// TODO Have it return a copy instead (Eventually)
		return newsMaker1;
	}

	/**
	 * The accessor for the second news maker field.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @return The second news maker featured in the story.
	 */
	public NewsMaker getNewsMaker2() {
		// TODO Have it return a copy instead (Eventually)
		return newsMaker2;
	}
	
	public boolean equals(Object o){
		if(o instanceof NewsStory){
			NewsStory newsStory = (NewsStory) o;
			if(this.date == newsStory.date && this.length == newsStory.length && this.newsMaker1.equals(newsStory.newsMaker1) && this.newsMaker2.equals(newsStory.newsMaker2) && this.source == newsStory.source && this.topic == newsStory.topic){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(NewsStory newsStory){
		return this.newsMaker1.compareTo(newsStory.newsMaker1);
	}
}
