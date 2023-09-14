import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

/**
 * Lab 6, CS 2334, Section 010, 04 April 2017
 * <P>
 * This class represents a view of all the places for one state (just the name
 * of each place) for the MVC lab.
 * </P>
 * 
 * @version 1.0
 * @author Dean Hougen and (Your Names)
 */
public class StateView extends JFrame implements ActionListener {
	// Needs a serialVersionUID because the class is Serializable
	private static final long serialVersionUID = 1L;

	// The model for this view.
	private Model model;

	// setup GUI for this view.
	private JButton jbtSelectPlace = new JButton("Add place to selected place list");
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> jlStatePlaceList = new JList<String>(listModel);
	private JScrollPane scrollPane = new JScrollPane(jlStatePlaceList);

	/**
	 * The default (no arg) constructor.
	 */
	StateView() {
		setTitle("List of Places in State");
		jlStatePlaceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(scrollPane);
		add(jbtSelectPlace, BorderLayout.EAST);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Mutator method that sets the model for this view and registers the view
	 * as a ___ with the ___.
	 * 
	 * @param model
	 *            The model to be set.
	 */
	public void setModel(Model model) {
		this.model = model;
		populateJList();
		if (this.model != null) {
			//Register the view as ___ for the ___.
			model.addActionListener(this);
		}
	}

	/**
	 * This method pulls the names of the places from the state list and stores
	 * them in the JList of selected places for detailed display.
	 */
	private void populateJList() {
		List<Place> statePlaceList = model.getStatePlaceList();
		if (statePlaceList != null)
			listModel.clear();
		for (int i = 0; i < statePlaceList.size(); i++) {
			listModel.addElement((model.statePlaceList.get(i).getName()));
		}
	}

	/**
	 * Overridden actionPerformed method (called when listener is notified of an
	 * update by the model).
	 * <P>
	 * 
	 * @param actionEvent
	 *            The action that took place.
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getActionCommand().equals("State Place List")) {
			populateJList();
		}
	}

	/**
	 * Accessor method for the index of the selected entry in the state list.
	 * 
	 * @return The index of the state that is selected on the state list.
	 */
	public int getSelectedStateIndex() {
		return jlStatePlaceList.getSelectedIndex();
	}

	/**
	 * Mutator method that allows a listener to be added to the place button.
	 * 
	 * @param selectPlaceButtonListener
	 *            The listener to register with the select place button.
	 */
	public void registerSelectPlaceButtonListener(ActionListener selectPlaceButtonListener) {
		jbtSelectPlace.addActionListener(selectPlaceButtonListener);
	}
}