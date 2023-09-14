/**
 * Lab 6, CS 2334, Section 010, 04 April 2017
 * <P>
 * This class represents a named location. It is a very simple representation
 * that only includes a name.
 * </P>
 * 
 * @version 1.0
 * @author Dean Hougen
 */
public class NamedLocation {
	private String name;

	/**
	 * Constructor that takes the name of the location as a parameter.
	 * 
	 * @param name
	 */
	public NamedLocation(String name) {
		this.name = name;
	}

	/**
	 * "Copy constructor" for making a new named location from an existing one.
	 * 
	 * @param namedLocation
	 *            the namedLocation to copy
	 */
	public NamedLocation(NamedLocation namedLocation) {
		// No actual copy needed for name because Strings are immutable
		this.name = namedLocation.getName();
	}

	/**
	 * Accessor for the name of the location.
	 * 
	 * @return The name of the location.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Mutator for the name of the location.
	 * 
	 * @param name
	 *            The name to set for the location.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Overridden toString method.
	 * 
	 * @return The name as a String (which is kind of funny because the name is
	 *         already a String but oh well).
	 */
	@Override
	public String toString() {
		return name;
	}
}