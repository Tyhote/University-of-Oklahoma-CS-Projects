import java.util.ArrayList;

/**
 * Lab 6, CS 2334, Section 010, 04 April 2017
 * <P>
 * This class represents places, which are named locations that have populations
 * over time.
 * </P>
 * 
 * @version 1.0
 * @author Dean Hougen
 */
public class Place extends NamedLocation {
	private ArrayList<PopulationRecord> populationHistory = new ArrayList<PopulationRecord>();

	/**
	 * Constructor that takes the name of the place and the data needed for a
	 * single population record.
	 * 
	 * @param name
	 *            The name of the place.
	 * @param population
	 *            The population for the initial record.
	 * @param year
	 *            The year for the initial record.
	 */
	public Place(String name, String population, String year) {
		super(name);
		populationHistory.add(new PopulationRecord(population, year));
	}

	/**
	 * Constructor that takes the name of the place and a single population
	 * record.
	 * 
	 * @param name
	 *            The name of the place.
	 * @param populationRecord
	 *            The population record.
	 */
	public Place(String name, PopulationRecord populationRecord) {
		super(name);
		populationHistory.add(populationRecord);
	}

	/**
	 * Constructor that takes the name and an arbitrary set of data for
	 * population records.
	 * 
	 * @param tokens
	 *            The place name followed by pairs of population and year info
	 *            in String array.
	 */
	public Place(String[] tokens) {
		super(tokens[0].trim());
		for (int i = 1; i + 1 < tokens.length; i += 2)
			populationHistory.add(new PopulationRecord(tokens[i].trim(), tokens[i + 1].trim()));
	}

	/**
	 * Copy constructor that takes Place and returns a new one.
	 * 
	 * @param place
	 *            The place to copy.
	 */
	public Place(Place place) {
		super(place);
		populationHistory = new ArrayList<PopulationRecord>(place.getHistory());
	}

	/**
	 * Accessor for the population history.
	 * 
	 * @return The population history for a place..
	 */
	public ArrayList<PopulationRecord> getHistory() {
		// TODO: This really should return a copy rather than a reference to the
		// original.
		return populationHistory;
	}

	/**
	 * Mutator to add a new population record to the existing population
	 * history.
	 * 
	 * @param populationRecord
	 *            The new population record to add to the population history.
	 */
	public void addToHistory(PopulationRecord populationRecord) {
		populationHistory.add(populationRecord);
	}

	/**
	 * Overridden toString method.
	 * 
	 * @return The Place as a String.
	 */
	@Override
	public String toString() {
		return super.toString() + " " + populationHistory;
	}
}
