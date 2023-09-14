import java.awt.event.*;

/**
 * Lab 6, CS 2334, Section 010, 04 April 2017
 * <P>
 * This class represents the controller for the MVC lab.
 * </P>
 * 
 * @version 1.0
 * @author Dean Hougen and (Your Names)
 */

public class Controller {
	private Model model;
	private StateView stateView;

	/**
	 * Constructor for the controller.
	 */
	Controller() {
		// empty
	}

	/**
	 * Listener as inner class.
	 */
	private class SelectPlaceButtonListener implements ActionListener {
		/**
		 * Overridden actionPerformed method (called when listener is notified
		 * of a user gesture by a view).
		 * 
		 * @param actionEvent
		 *            The action that took place.
		 */
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			// No model associated. Can't do anything.
			if (model == null)
				return;

			// Get the index of the selected item.
			int index = stateView.getSelectedStateIndex();

			// Update the sublist, add the selected contact to the sublist.
			if (index > -1)
				model.addToSelectedList(index);
		}
	}

	/**
	 * Mutator to set the model (so that the controller can use model mutators).
	 * 
	 * @param model
	 *            The model on which this controller should call mutators.
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * Mutator to set the view (so that the controller can listen for user
	 * gestures).
	 * 
	 * @param masterView
	 *            The view to which this controller should be listening.
	 */
	public void setView(StateView masterView) {
		// Set the master view.
		this.stateView = masterView;

		//Register listener
		stateView.registerSelectPlaceButtonListener(new SelectPlaceButtonListener());

	}
}
