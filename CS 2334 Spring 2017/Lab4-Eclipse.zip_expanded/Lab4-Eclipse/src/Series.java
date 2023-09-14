import java.util.LinkedHashMap;

/**
 * Lab 4, CS 2334, Section 010, 07 March 2017
 * <P>
 * This class models a series (such as a TV series). A series consists of a
 * title, a start year for the series, an end year for the series (if any; 0 if
 * the series is still going), and a collection of episodes.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 *
 */
public class Series {
	/** Name of the Series */
	private String title;

	/** Year that the Series started */
	private int startYear;

	/** Year that the Series ended */
	private int endYear;

	/** Episodes of the Series */
	private LinkedHashMap<String, Episode> episodeMap;

	/**
	 * This is the default constructor for Series. It instantiates the class
	 * with default values for the fields.
	 */
	public Series() {
		title = "";
		startYear = 0;
		endYear = 0;
		this.episodeMap = new LinkedHashMap<String, Episode>();
	}

	/**
	 * This is the basic constructor for Series. It instantiates the class with
	 * user supplied values for series title and start and end years.
	 * 
	 * @param title
	 *            The title of the Series.
	 * @param startYear
	 *            The first year that the Series aired.
	 * @param endYear
	 *            The last year that the Series aired.
	 */
	public Series(String title, int startYear, int endYear) {
		// We ought to add suitability checks to ensure endYear >= startYear,
		// for example. However, you are not required to do that for your lab.
		this.title = title;
		this.startYear = startYear;
		this.endYear = endYear;
		this.episodeMap = new LinkedHashMap<String, Episode>();
	}

	/**
	 * This is an advanced constructor for Series. It instantiates the class
	 * with user supplied values for series title and start and end years and
	 * also a LinkedHashMap of Episodes.
	 * 
	 * @param title
	 *            The title of the Series.
	 * @param startYear
	 *            The first year that the Series aired.
	 * @param endYear
	 *            The last year that the Series aired.
	 * @param episodeMap
	 *            The LinkedHashMap of Episodes.
	 */
	public Series(String title, LinkedHashMap<String, Episode> episodeMap) {
		this.title = title;
		this.episodeMap = episodeMap;
	}

	/**
	 * Accessor method for title.
	 * 
	 * @return The series title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Mutator method for title.
	 * 
	 * @param title
	 *            The title to set for the series.
	 */
	public void setTitle(String name) {
		this.title = name;
	}

	/**
	 * Accessor method for start year.
	 * 
	 * @return The year the series started.
	 */
	public int getStartYear() {
		return startYear;
	}

	/**
	 * Mutator method for start year.
	 * 
	 * @param startYear
	 *            The year to set as the starting year.
	 */
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	/**
	 * Accessor method for the end year.
	 * 
	 * @return The year the series ended.
	 */
	public int getEndYear() {
		return endYear;
	}

	/**
	 * Mutator method for end year.
	 * 
	 * @param endYear
	 *            The year to set as the ending year.
	 */
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	/**
	 * Accessor method for the collection of episodes.
	 * <P>
	 * Note that returning an array of the episode values, rather than a
	 * reference to the map itself, helps to preserve encapsulation.
	 * </P>
	 * 
	 * @return An array of the episodes in the episodeMap.
	 */
	public Episode[] getEpisodeArray() {
		Episode[] templateEpisodeArray = new Episode[1];
		return episodeMap.values().toArray(templateEpisodeArray);
	}

	/**
	 * A mutator method for the collection of episodes. This one sets the entire
	 * map of episodes to be the map passed in.
	 * <P>
	 * Note that simply allowing our map of episodes to be replaced by another
	 * map does NOT help to preserve encapsulation.
	 * </P>
	 * 
	 * @param episodeMap
	 *            the collection of episodes to set
	 */
	public void setEpisodeMap(LinkedHashMap<String, Episode> episodeMap) {
		this.episodeMap = episodeMap;
	}

	/**
	 * A mutator method for the collection of episode. This one adds (or
	 * replaces) a single episode.
	 * 
	 * @param episode
	 *            The episode to add to (or replace in) the episodeMap.
	 */
	public void addEpisode(Episode episode) {
		this.episodeMap.put(episode.getTitle(), episode);
	}

	/**
	 * A mutator method for the collection of episodes. This one throws away any existing
	 * collection of episodes and puts an empty collection in its place.
	 */
	public void clearEpisodes() {
		this.episodeMap = new LinkedHashMap<String, Episode>();
	}
}