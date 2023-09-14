import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Lab 5, CS 2334, Section 010, 21 March 2017
 * <P>
 * This class models a series (such as a TV series). A series consists of a
 * title, a start year for the series, an end year for the series (if any; 0 if
 * the series is still going), and a collection of episodes.
 * </P>
 * 
 * @author Dean Hougen and (Your Name)
 * @version 2.0
 */
public class Series implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5841581279362598478L;

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
	 * <P>
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
	public Series(String title, int startYear, int endYear, LinkedHashMap<String, Episode> episodeMap) {
		// We ought to add suitability checks to ensure endYear >= startYear,
		// for example. However, you are not required to do that for your lab.
		this.title = title;
		this.startYear = startYear;
		this.endYear = endYear;
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
	 * @param name
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
	 * Accessor method for the collection of episodes.
	 * <P>
	 * Note that returning a reference to the episode map itself does NOT help
	 * to preserve encapsulation.
	 * </P>
	 * 
	 * @return An array of the episodes in the episodeMap.
	 */
	public LinkedHashMap<String, Episode> getEpisodeMap() {
		return this.episodeMap;
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
	 *            The collection of episodes to set.
	 */
	public void setEpisodeMap(LinkedHashMap<String, Episode> episodeMap) {
		this.episodeMap = episodeMap;
	}

	/**
	 * A method to determine whether an episode with a specified title is in the
	 * collection of episodes.
	 * 
	 * @param title
	 *            The title of the episode to look for in the collection.
	 * @return true if the episode name is already in the collection, false
	 *         otherwise.
	 */
	public boolean contains(String title) {
		return this.episodeMap.containsKey(title);
	}

	/**
	 * An accessor that gets an episode based on title and returns the
	 * information on that episode as a <code>String</code>.
	 * <P>
	 * Note that if an episode with the given title does not exist in the map,
	 * this method will throw a null pointer exception.
	 * </P>
	 * 
	 * @param title
	 *            The title of the episode to look for in the collection.
	 * @return The found episode converted to a String.
	 */
	public String getEpisodeString(String title) {
		return this.episodeMap.get(title).toString();
	}

	/**
	 * A mutator method for the collection of episodes. This one adds a single
	 * episode, then returns a boolean value of <code>true</code> to indicate
	 * that the episode was successfully added. If the episode was already
	 * present, adding fails, so a boolean value of <code>false</code> is
	 * returned.
	 * 
	 * @param episode
	 *            The episode to add to the episodeMap.
	 */
	public boolean addEpisode(Episode episode) {
		if (!this.episodeMap.containsKey(episode.getTitle())) {
			this.episodeMap.put(episode.getTitle(), episode);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * A mutator method for the collection of episodes. This one replaces a
	 * single episode, then returns a boolean value of <code>true</code> to
	 * indicate that the episode was successfully replaced. If the episode was
	 * not already present, replacing fails, so a boolean value of
	 * <code>false</code> is returned.
	 * 
	 * @param episode
	 *            The episode to replace in the episodeMap.
	 */
	public boolean replaceEpisode(Episode episode) {
		if (this.episodeMap.containsKey(episode.getTitle())) {
			this.episodeMap.put(episode.getTitle(), episode);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * A mutator method for the collection of episodes. This one throws away any
	 * existing collection of episodes and puts an empty collection in its
	 * place.
	 */
	public void clearEpisodes() {
		this.episodeMap = new LinkedHashMap<String, Episode>();
	}

	/**
	 * Saves the current episode map to a file named "Startrek.dat"
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveEpisodeMap() throws FileNotFoundException, IOException{
		String fileName = "StarTrek.dat";
		FileOutputStream fOut = new FileOutputStream(fileName);
		ObjectOutputStream oOut = new ObjectOutputStream(fOut);
		oOut.writeObject(episodeMap);
		oOut.close();
	}
	
	/**
	 * Loads an episode map from a file named "Startrek.dat"
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void loadEpisodeMap() throws FileNotFoundException, IOException, ClassNotFoundException{
		String fileName = "StarTrek.dat";
		FileInputStream fIn = new FileInputStream(fileName);
		ObjectInputStream oIn = new ObjectInputStream(fIn);
		Object aux = oIn.readObject();
		episodeMap = (LinkedHashMap<String, Episode>) aux;
		oIn.close();
	}

	/**
	 * Prints all episodes in the episode map in a human-readable format
	 */
	public void printEpisodes(){
		for(String key : episodeMap.keySet()){
			Episode episode = episodeMap.get(key);
			System.out.println(episode.getTitle() + " (#" + episode.getSeasonNumber() + ", " + episode.getEpisodeNumber() + ") " + episode.getYear());
		}
	}
}