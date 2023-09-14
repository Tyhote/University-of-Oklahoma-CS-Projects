import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IterativeExample1 {

	public static int fcn(int p, int q) {
		int aux;
		while(q != 0){
			aux = q;
			q = p%q;
			p = aux;
		}
		return p;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		String inputString1 = "";
		String inputString2 = "";
		int inputInt1 = 0;
		int inputInt2 = 0;
		int returnInt = 0;

		System.out.println("Blank entry at any prompt exits program.");

		while (true) {
			System.out.print("Enter the first (positive) integer: ");
			try {
				inputString1 = inputReader.readLine();
			} catch (IOException e) {
				System.err.println("Error reading from console.");
			}

			if (inputString1.equals("")) {
				System.out.println("Run complete.");
				System.exit(0);
			}

			System.out.print("Enter the second (positive) integer: ");
			try {
				inputString2 = inputReader.readLine();
			} catch (IOException e) {
				System.err.println("Error reading from console.");
			}

			if (inputString2.equals("")) {
				System.out.println("Run complete.");
				System.exit(0);
			}

			try {
				inputInt1 = Integer.valueOf(inputString1);
				inputInt2 = Integer.valueOf(inputString2);
			} catch (NumberFormatException e) {
				System.err.println("Must enter integer values.");
				continue;
			}

			if (inputInt1 <= 0 || inputInt2 <= 0) {
				System.err.println("Both integers must be positive");
			} else {
				returnInt = fcn(inputInt1, inputInt2);
				System.out.println("Return value: " + returnInt);
			}
		}
	}
}
