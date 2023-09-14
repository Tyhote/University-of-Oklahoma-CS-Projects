import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 * Lab 6, CS 2334, Section 010, 04 April 2017
 * <P>
 * This class represents a view of places with their population records for the
 * MVC lab.
 * </P>
 * 
 * @version 1.0
 * @author Dean Hougen and (Your Names)
 */

public class PlaceView extends JFrame implements ActionListener {
	// Needs a serialVersionUID because the class is Serializable
	private static final long serialVersionUID = 1L;

	// The model for this view.
	private Model model;

	// The GUI elements for this view.
	private DefaultListModel<Place> listModel = new DefaultListModel<Place>();
	private JList<Place> jlSelectedPlaces = new JList<Place>(listModel);
	private JScrollPane jspSelectedPlaces = new JScrollPane(jlSelectedPlaces);

	/**
	 * The default (no arg) constructor.
	 */
	PlaceView() {
		setTitle("Selected Places");
		jlSelectedPlaces.setSelectionBackground(jlSelectedPlaces.getBackground());
		add(jspSelectedPlaces, BorderLayout.CENTER);
	}

	/**
	 * Mutator method that sets the model for this view and registers the view
	 * as a ___ with the ___.
	 * 
	 * @param model
	 *            The model to which this view should listen.
	 */
	public void setModel(Model model) {
		// Set the model.
		this.model = model;
		if (this.model != null) {
			//Register the view as ___ for the ___.
			model.addActionListener(this);
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
		if (actionEvent.getActionCommand().equals("Addition to Selected Places")) {
			listModel.addElement(model.getSelectedPlace());
			pack();
			setVisible(true);
		}
	}
}