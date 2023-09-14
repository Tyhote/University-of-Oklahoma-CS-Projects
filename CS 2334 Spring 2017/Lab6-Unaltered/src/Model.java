import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Lab 6, CS 2334, Section 010, 04 April 2017
 * <P>
 * This class represents the Model for the MVC lab. It contains the data that
 * will be shared among various views and the method to manipulate the data.
 * </P>
 * 
 * @version 1.0
 * @author Dean Hougen and (Your Names)
 */

public class Model {
	// TODO: Add the list of action listeners

	// TODO: Add the list of places in a state (created from the file)

	// TODO: Add the list of places selected for more detailed display

	// The most recently selected place
	Place selectedPlace = null;

	/** The default (no-arg) constructor */
	Model() {
		this.statePlaceList = null;
		this.selectedPlaceList = new ArrayList<Place>();
	}

	/**
	 * The constructor for the class.
	 * <P>
	 * 
	 * @param statePlaceList
	 *            A list of Place objects for a state
	 */
	Model(List<Place> statePlaceList) {
		// set the list of places for the state
		this.statePlaceList = statePlaceList;

		// create the sublist of selected places to display in more detail
		this.selectedPlaceList = new ArrayList<Place>();
	}

	/**
	 * Accessor for the list of places.
	 * 
	 * @return A copy of the list of places in the state.
	 */
	public List<Place> getStatePlaceList() {
		return new ArrayList<Place>(statePlaceList);
	}

	/**
	 * Accessor for a place from the list.
	 * 
	 * @return Returns a copy of the most recently selected places.
	 */
	public Place getSelectedPlace() {
		return new Place(selectedPlace);
	}

	/**
	 * Mutator method to add a place to the sublist of selected places.
	 * <P>
	 * 
	 * @param index
	 *            Index of the place selected in the list.
	 */
	public void addToSelectedList(int index) {
		selectedPlace = statePlaceList.get(index);

		// If place hasn't already been added to the selected list, add it.
		if (!selectedPlaceList.contains(selectedPlace)) {
			selectedPlaceList.add(selectedPlace);

			// TODO: Notify the listener of the change in subList

		}
	}

	/**
	 * Mutator to register an action listener.
	 * 
	 * @param l
	 *            The action listener to add.
	 */
	public synchronized void addActionListener(ActionListener l) {
		if (actionListenerList == null) {
			actionListenerList = new ArrayList<ActionListener>();
		}
		actionListenerList.add(l);
	}

	/**
	 * Mutator to remove an action listener
	 * 
	 * @param l
	 *            The action listener to remove.
	 */
	public synchronized void removeActionListener(ActionListener l) {
		if (actionListenerList != null && actionListenerList.contains(l)) {
			actionListenerList.remove(l);
		}
	}

	/**
	 * Method to notify listeners of an event.
	 * 
	 * @param e
	 *            The event that occurred.
	 */
	private void processEvent(ActionEvent e) {
		ArrayList<ActionListener> list;
		synchronized (this) {
			if (actionListenerList == null)
				return;
			// Do not worry about the cast warning here.
			list = (ArrayList<ActionListener>) actionListenerList.clone();
		}
		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}
	}

	/**
	 * This method reads in a specified comma delimited file. The file is read
	 * one line at a time. The read line is then split and a Place object is
	 * created using the parsed line. The Place object is then added to a List,
	 * which is returned when the entire file has been processed.
	 * <P>
	 * 
	 * @param filename
	 *            String name of the file to be read
	 * @return Returns a List of Place objects
	 */
	public void readFile(String filename) throws FileNotFoundException, IOException {
		// Create file reader and buffered reader to read the file
		FileReader fileReader = new FileReader(filename);
		BufferedReader br = new BufferedReader(fileReader);

		List<Place> statePlaceList = new ArrayList<Place>();

		// read file one line at a time, until end of file
		String line = br.readLine();
		do {
			Place place = new Place(line.split(","));
			statePlaceList.add(place);
			line = br.readLine();
		} while (line != null);

		br.close();

		// Notify the listener of the change in list of places for the state
		this.statePlaceList = statePlaceList;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "State Place List"));
	}
}