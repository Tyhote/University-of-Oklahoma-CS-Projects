import java.awt.event.*;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Lab 5, CS 2334, Section 010, 21 March 2017
 * <P>
 * The MVC controller for the program.
 * </P>
 * <P>
 * Note that, in addition to the SeriesController class, this file contains
 * three inner classes, one for each listener.
 * </P>
 * 
 * @author Dean Hougen and (Your Name)
 * @version 2.0
 */
public class SeriesController{
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
	 * <code>AddEpisodeListener</code> provides a method to create a new
	 * episode. The episode should then be added to the episode list of the
	 * model. The values for the new episode come from the fields of the input
	 * view using <code>getText()</code>. If the model is null when the method
	 * is called, it returns without taking any action.
	 */
	private class AddEpisodeListener implements ActionListener {

		/**
		 * This overridden <code>actionPerformed</code> method is only supposed
		 * to respond to one kind of action - adding an episode. For that
		 * reason, it ignores the action event handed to it as a parameter and
		 * simply gets the text from the fields of the input view, creates an
		 * episode from them, and adds that episode to the model.
		 * 
		 * @param e
		 *            The action event that triggered this method. (Ignored.)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (model == null)
				return; // No model associated. Can't do anything.

			String title = inputView.jtfTitle.getText();

			if (model.contains(title)) {
				String[] options = {"Replace Episode", "Cancel"};
				int aux = JOptionPane.showOptionDialog(inputView, "An episode entitled " + title + " already exists.", "Replace Episode?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

				int response = aux; // assign returned value of JOptionPane to
								// response

				if (response == 0) {
					model.replaceEpisode(new Episode(inputView.jtfTitle.getText(), inputView.jtfSeasonNumber.getText(),
							inputView.jtfEpisodeNumber.getText(), inputView.jtfYear.getText()));
				} else if (response == 1) {
					
				} else {
					// Should handle error case here (we won't for this lab).
				}
			} else { 
				model.addEpisode(new Episode(inputView.jtfTitle.getText(), inputView.jtfSeasonNumber.getText(),
						inputView.jtfEpisodeNumber.getText(), inputView.jtfYear.getText()));
			}
		}
}

/**
 * <code>ClearEpisodeListener</code> provides a method to clear the episode list
 * of the model. If the model is null when the method is called, it returns
 * without taking any action.
 */
private class ClearEpisodeListener implements ActionListener {

	/**
	 * This overridden <code>actionPerformed</code> method is only supposed to
	 * respond to one kind of action - clearing the list of episodes. For that
	 * reason, it ignores the action event handed to it as a parameter and
	 * simply calls the <code>clearEpisodes</code> method of the model.
	 * 
	 * @param e
	 *            The action event that triggered this method. (Ignored.)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (model == null)
			return;
		model.clearEpisodes();
	}
}

/**
 * <code>ClearInputFieldsListener</code> provides a method to clear the input
 * fields of the inputView.
 */
private class ClearInputFieldsListener implements ActionListener {

	/**
	 * This overridden <code>actionPerformed</code> method is only supposed to
	 * respond to one kind of action - clearing the input fields of the input
	 * view. For that reason, it ignores the action event handed to it as a
	 * parameter and simply calls the <code>clearInputFields</code> method of
	 * the input view.
	 * 
	 * @param e
	 *            The action event that triggered this method. (Ignored.)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (model == null)
			return;
		inputView.clearInputFields();
	}

	}

private class LoadFileListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			model.loadEpisodeMap();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
	}
}

private class SaveFileListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			model.saveEpisodeMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

private class ExitListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
	
}

private class PrintListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		model.printEpisodes();
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
		inputView.addClearEpisodesButtonListener(new ClearEpisodeListener());
		inputView.addClearInputButtonListener(new ClearInputFieldsListener());

		// Register additional listeners for menu and toolbar.
		inputView.loadOption.addActionListener(new LoadFileListener());
		inputView.saveOption.addActionListener(new SaveFileListener());
		inputView.exitOption.addActionListener(new ExitListener());
		inputView.printButton.addActionListener(new PrintListener());
		System.out.println("listeners registered in controller for input window");
	}
}