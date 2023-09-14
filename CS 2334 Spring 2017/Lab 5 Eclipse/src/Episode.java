/**
 * Lab 5, CS 2334, Section 010, 21 March 2017
 * <P>
 * Each object of this class represents a episode, such as an episode of a TV
 * series. An episode consists of a title, the number of the season to which the
 * episode belongs, and the year that the episode was originally broadcast.
 * </P>
 * 
 * @author Dean Hougen and (Your Name)
 * @version 2.0
 *
 */

import java.io.Serializable;
public class Episode implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3198934659223971787L;

	/** Title (name) of the Episode */
	private String title;

	/** Season number of the Episode */
	String seasonNumber;

	/** Episode number of the Episode */
	String episodeNumber;

	/** Year of the Episode */
	String year;

	/**
	 * A constructor for episodes that takes parameters corresponding to all
	 * instance fields and uses the classes mutator methods to set the instance
	 * fields based on the parameter values.
	 * <P>
	 * Note: There isn't a good reason for this class to use it's mutator
	 * methods within it's constructor. However, for some classes there may be
	 * good reasons to use their mutator methods in their constructors. Can you
	 * figure out such a reason?
	 * </P>
	 * 
	 * @param title
	 *            The title of the episode.
	 * @param seasonNumber
	 *            The number of the season during which the episode was
	 *            broadcast.
	 * @param episodeNumber
	 *            The number of the episode within the season.
	 * @param year
	 *            The year the episode was originally broadcast.
	 */
	public Episode(String title, String seasonNumber, String episodeNumber, String year) {
		this.setTitle(title);
		this.setSeasonNumber(seasonNumber);
		this.setEpisodeNumber(episodeNumber);
		this.setYear(year);
	}

	/**
	 * Accessor method for title.
	 * 
	 * @return The title of the episode.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Mutator method for title.
	 * 
	 * @param title
	 *            The title to set as the episode title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Accessor method for season number.
	 * 
	 * @return The season number of the episode.
	 */
	public String getSeasonNumber() {
		return seasonNumber;
	}

	/**
	 * Mutator method for season number.
	 * 
	 * @param seasonNumber
	 *            The season number to set for the episode.
	 */
	public void setSeasonNumber(String seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	/**
	 * Accessor method for episode number.
	 * 
	 * @return The episode number.
	 */
	public String getEpisodeNumber() {
		return episodeNumber;
	}

	/**
	 * Mutator method for episode number.
	 * 
	 * @param episodeNumber
	 *            The episode number to set.
	 */
	public void setEpisodeNumber(String episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	/**
	 * Accessor method for episode broadcast year.
	 * 
	 * @return The year the episode was originally broadcast.
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Mutator method for episode broadcast year.
	 * 
	 * @param year
	 *            The original broadcast year to set for the episode.
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Overridden toString method for episodes.
	 * 
	 * @return The episode as a String.
	 */
	@Override
	public String toString() {
		return title + " (#" + seasonNumber + ", " + episodeNumber + ") " + year;
	}
}