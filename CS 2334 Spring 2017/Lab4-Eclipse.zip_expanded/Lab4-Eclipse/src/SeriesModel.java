import java.awt.event.*;
import java.util.*;

/**
 * Lab 4, CS 2334, Section 010, 07 March 2017
 * <p>
 * Each object of this class represents a GUI-enhanced model of a series. This
 * serves as the model of an MVC GUI.
 * </p>
 * 
 * @author Dean Hougen
 * @version 1.0
 *
 */
public class SeriesModel extends Series {

	/**
	 * List to keep track of which objects are registered to listen for events
	 * from the SeriesModel.
	 */
	private ArrayList<ActionListener> actionListenerList;

	/**
	 * A constructor for the series model taking parameters for title, start
	 * year, and end year.
	 * 
	 * @param title
	 *            The title of the Series.
	 * @param startYear
	 *            The first year that the Series aired.
	 * @param endYear
	 *            The last year that the Series aired.
	 */
	public SeriesModel(String title, int startYear, int endYear) {
		super(title, startYear, endYear);
	}

	/**
	 * A constructor for the series model taking parameters for title, start
	 * year, end year, and a linked hash map of episodes.
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
	public SeriesModel(String title, LinkedHashMap<String, Episode> episodes) {
		super(title, episodes);
	}

	/**
	 * A mutator method for the collection of episode. This one adds (or
	 * replaces) a single episode.
	 * <P>
	 * This method is overridden to notify any possible listeners of changes to
	 * the episode collection.
	 * </P>
	 * 
	 * @param episode
	 *            The episode to add to (or replace in) the episodeMap.
	 */
	@Override
	public void addEpisode(Episode episode) {
		super.addEpisode(episode);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "add episode"));
	}

	/**
	 * A mutator method for the collection of episodes. This one throws away any
	 * existing collection of episodes and puts an empty collection in its
	 * place.
	 * <P>
	 * This method is overridden to notify any possible listeners of changes to
	 * the episode collection.
	 * </P>
	 */
	@Override
	public void clearEpisodes() {
		super.clearEpisodes();
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "clear episode list"));
	}

	/**
	 * Method to register an action event listener.
	 * 
	 * @param l
	 *            The action listener to add.
	 */
	public synchronized void addActionListener(ActionListener l) {
		if (actionListenerList == null)
			actionListenerList = new ArrayList<ActionListener>();
		actionListenerList.add(l);
	}

	/**
	 * Method to remove an action event listener.
	 * 
	 * @param l
	 *            The action listener to remove.
	 */
	public synchronized void removeActionListener(ActionListener l) {
		if (actionListenerList != null && actionListenerList.contains(l))
			actionListenerList.remove(l);
	}

	/**
	 * Method to fire event. This consists of telling any and all listeners of
	 * changes to the data.
	 * 
	 * @param e
	 *            The event to fire.
	 */
	private void processEvent(ActionEvent e) {
		ArrayList<ActionListener> list;

		synchronized (this) {
			if (actionListenerList == null)
				return;
			list = (ArrayList<ActionListener>) actionListenerList.clone();
		}

		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}
	}
}