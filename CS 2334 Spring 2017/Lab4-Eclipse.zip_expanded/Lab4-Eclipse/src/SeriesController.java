import java.awt.event.*;

/**
 * Lab 4, CS 2334, Section 010 07 March 2017
 * <P>
 * The MVC controller for the program.
 * </P>
 * <P>
 * Note that, in addition to the SeriesController class, this file contains
 * three inner classes, one for each listener.
 * 
 * @author Dean Hougen
 * @version 1.0
 * 
 */
public class SeriesController {
	/** The model to modify in response to events. */
	private SeriesModel model;

	/**
	 * The view that provides the events to which the control should respond.
	 */
	private SeriesInputWindow inputView;

	/**
	 * Constructor to create a series controller.
	 */
	public SeriesController() {
		// intentionally empty, do not change
	}

	/**
	 * AddEpisodeListener provides a method to create a new episode. The episode
	 * should then be added to the episode list of the model. The values for the
	 * new episode come from the fields of the inputView using getText(). If the
	 * model is null when the method is called, it returns without taking any
	 * action.
	 */
	private class AddEpisodeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (model == null) {
				return;
			}
			addEpisode();
		}

		private void addEpisode() {
			model.addEpisode(new Episode(inputView.jtfTitle.getText(), inputView.jtfSeasonNumber.getText(),
					inputView.jtfEpisodeNumber.getText(), inputView.jtfYear.getText()));
		}

	}

	/**
	 * ClearEpisodeListener provides a method to clear the episode list of the
	 * model. If the model is null when the method is called, it returns without
	 * taking any action.
	 */
	private class ClearEpisodeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(model == null){
				return;
			}
			model.clearEpisodes();			
		}
	}

	/**
	 * ClearInputFieldsListener provides a method to clear the input fields of
	 * the inputView.
	 */
	private class ClearInputFieldsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clearInputFields();
		}
		
		public void clearInputFields(){
			inputView.clearInputFields();
		}
	}

	/**
	 * Mutator method that sets the model for this controller.
	 * 
	 * @param model
	 *            The model that holds the data we want to modify.
	 */
	public void setModel(SeriesModel model) {
		this.model = model;
	}

	/**
	 * Mutator method that sets the input view (window) for this controller.
	 * 
	 * @param theView
	 *            The view on which the listeners should be set.
	 */
	public void setInputWindow(SeriesInputWindow theView) {
		inputView = theView;

		// Register listeners
		inputView.addAddEpisodeButtonListener(new AddEpisodeListener());
		inputView.clearEpisodeListListener(new ClearEpisodeListener());
		inputView.clearInputFieldsButtonListener(new ClearInputFieldsListener());
		// This next line is for debugging purposes. It would be removed in
		// production code. However, leave it in for this lab.
		System.out.println("listeners registered in controller for input window");
	}
}