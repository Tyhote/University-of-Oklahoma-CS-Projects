import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Lab 6, CS 2334, Section 010, 04 April 2017 
 * <P>
 * This is the driver class for the MVC lab. It creates and initializes the
 * variables for the model, views and controller.
 * </P>
 * 
 * @version 1.0
 * @author Dean Hougen, Nick Fox, Clayton Glenn, and Tristan Dow,
 */
public class Lab6Driver {
	private Model model; 
	private StateView stateView = new StateView();
	private PlaceView placeView = new PlaceView();
	private Controller controller = new Controller();

	/**
	 * This method initializes the variables for the model, views, and
	 * controller. It sets the model for the views and controller and also sets
	 * the view in the controller.
	 * <P>
	 * 
	 * @param filename
	 *            String Name of the filename to be read.
	 */
	public Lab6Driver(String filename) {
		model = new Model();
		try{
		model.readFile(filename);
		}catch(FileNotFoundException f){
			System.out.println("File not found. Please enter a valid file name.");
			System.exit(1);
		}catch (IOException e){
			System.out.println("IO Exception.");
			System.exit(2);
		}
		stateView.setModel(model);
		placeView.setModel(model);
		controller.setModel(model);
		controller.setView(stateView);
	}

	/**
	 * This is the main method of the program. It calls the constructor.
	 * <P>
	 * 
	 * @param args
	 *            Command line arguments. This program requires a filename as
	 *            the first argument.  No other arguments are used.
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			new Lab6Driver(args[0]);
		} else {
			System.err.println("Usage: Please specify file name as argument.");
		}
	}
}