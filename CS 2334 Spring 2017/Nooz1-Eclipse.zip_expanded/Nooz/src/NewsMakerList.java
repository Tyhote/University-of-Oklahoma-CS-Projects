import java.util.ArrayList;
import java.util.Collections;

/**
 * Project #1 CS 2334, Section 010 February 22, 2017
 * <P>
 * A <code>NewsMakerList</code> is a list of <code>NewsMaker</code> objects.
 * Each <code>NewsMaker</code> in the list must have a unique name.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 *
 */
class NewsMakerList {
	/** The list of news makers. */
	private ArrayList<NewsMaker> newsMakers;

	/**
	 * The no-argument constructor initializes the list to be an empty
	 * <code>ArrayList</code> of <code>NewsMaker</code> objects.
	 */
	NewsMakerList() {
		this.newsMakers = new ArrayList<NewsMaker>();
	}

	/**
	 * The mutator for adding news makers to the list.
	 * <P>
	 * By using our own class with its own <code>add</code> method, rather than
	 * directly using the <code>add</code> method of <code>ArrayList</code>, we
	 * can ensure that we don't add multiple <code>NewsMaker</code> objects with
	 * the same name to our list (thereby keeping the names unique).
	 * </P>
	 * 
	 * @param newsMaker
	 *            The news maker to add.
	 * @throws IllegalArgumentException
	 *             if the news maker to add is already in the list
	 */
	void add(NewsMaker newsMaker) {
		if (!this.newsMakers.contains(newsMaker)) {
			this.newsMakers.add(newsMaker);
		} else {
			throw new IllegalArgumentException("NewsMaker " + newsMaker.getName() + " already in list.");
		}
	}

	/**
	 * An accessor method to test whether the list already contains a news
	 * maker.
	 * <P>
	 * Simply makes use of the <code>contains</code> method of
	 * <code>ArrayList</code>.
	 * </P>
	 * 
	 * @param newsMaker
	 *            The news maker to check for in the list.
	 * @return The boolean value true if the news maker is in the list, false
	 *         otherwise.
	 */
	public boolean contains(NewsMaker newsMaker) {
		return this.newsMakers.contains(newsMaker);
	}

	/**
	 * An accessor method to get a news maker from the list.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @param newsMaker
	 *            The news maker to get from the list.
	 * @return The news maker found, if any. Otherwise, null.
	 */
	public NewsMaker get(NewsMaker newsMaker) {
		int index = newsMakers.indexOf(newsMaker);
		if (index >= 0) {
			// TODO Have it return a copy instead (Eventually)
			return this.newsMakers.get(index);
		} else {
			return null;
		}
	}
	
	public NewsMaker getExactMatch(String exactName){
		return get(new NewsMaker(exactName));
	}
	
	
	public NewsMaker getPartialMatch(String partialName){
		for(int i = 0; i < newsMakers.size(); ++i){
			String name = newsMakers.get(i).getName();
			if(name.contains(partialName)){
				return get(new NewsMaker(name));
			}
		}
		return null;
	}
	
	public void sort(){
		Collections.sort(newsMakers);
	}
}
