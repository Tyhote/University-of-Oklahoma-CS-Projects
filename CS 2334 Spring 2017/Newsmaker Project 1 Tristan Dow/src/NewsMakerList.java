import java.util.ArrayList;

public class NewsMakerList {
	/**
	 * The ArrayList of NewsMakers
	 */
	private ArrayList<NewsMaker> newsMakers;

	/**
	 * Empty constructor. Initializes the ArrayList to the default size.
	 */
	public NewsMakerList() {
		newsMakers = new ArrayList<NewsMaker>();
	}

	/**
	 * Adds a NewsMaker into the list.
	 * 
	 * @param newsMaker
	 *            The NewsMaker to add.
	 */
	public void add(NewsMaker newsMaker) throws IllegalArgumentException {
		if (newsMakers.contains(newsMaker)) {
			throw new IllegalArgumentException("Newsmaker already contained in NewsMakerList");
		}
		newsMakers.add(newsMaker);
	}

	/**
	 * Tells if the list contains a certain NewsMaker
	 * 
	 * @param newsMaker
	 *            The NewsMaker to search for
	 * @return Returns a boolean
	 */
	public boolean contains(NewsMaker newsMaker) {
		boolean flag = false;
		for (int i = 0; i < newsMakers.size(); ++i) {
			if (newsMakers.get(i).getName().equals(newsMaker.getName())) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * Gets a NewsMaker from the list, if it is contained in the list.
	 * Otherwise, returns a blank NewsMaker.
	 * 
	 * @param newsMaker
	 *            The NewsMaker to get.
	 * @return Returns a NewsMaker.
	 */
	public NewsMaker get(NewsMaker newsMaker) {
		Integer result = -1;
		for (int i = 0; i < newsMakers.size(); ++i) {
			if (newsMakers.get(i).getName().equals(newsMaker.getName())) {
				result = i;
			}
		}
		if (!(result == null) && (result != -1)) {
			return newsMakers.get(result);
		} else {
			return null;
		}
	}
}
