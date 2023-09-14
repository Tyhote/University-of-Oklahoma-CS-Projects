/**
 * Lab 6, CS 2334, Section 010, 04 April 2017
 * <P>
 * This class represents a record of an place's population over time.
 * </P>
 * 
 * @version 1.0
 * @author Dean Hougen
 */

public class PopulationRecord {
	private String population;
	private String year;

	/**
	 * Constructor that takes the data for a new record.
	 * 
	 * @param population
	 *            The population for the new record.
	 * @param year
	 *            The year for the new record.
	 */
	public PopulationRecord(String population, String year) {
		this.population = population;
		this.year = year;
	}

	/**
	 * Accessor for the population.
	 * 
	 * @return The population in the record.
	 */
	public String getPopulation() {
		return population;
	}

	/**
	 * Mutator for the population.
	 * 
	 * @param population
	 *            The population to set.
	 */
	public void setEvent(String population) {
		// Should really ensure this value is not negative.
		this.population = population;
	}

	/**
	 * Accessor for the year.
	 * 
	 * @return The year in the record.
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Mutator for the year.
	 * 
	 * @param year
	 *            The year to set.
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Overridden toString method.
	 * 
	 * @return The PopulationRecord as a String.
	 */
	@Override
	public String toString() {
		return population + ": " + year;
	}
}