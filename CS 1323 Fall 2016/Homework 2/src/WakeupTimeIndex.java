import java.util.Scanner;
public class WakeupTimeIndex {
	public static void main (String [] args)
	{
		// Init vars
		Scanner keyboard = new Scanner(System.in);
		String name1;
		int hours1;
		int minutes1;
		String name2;
		int hours2;
		int minutes2;
		
		// Read in first person
		System.out.println("Please enter the first person's first name, last name, hour, and minute "
				+ "of waking, each separated by a space.");
		name1 = keyboard.next() + " " + keyboard.next() + " " + keyboard.next();
		hours1 = keyboard.nextInt();
		minutes1 = keyboard.nextInt();
		keyboard.nextLine();
		
		// Read in second person
		System.out.println("Please do the same for the second person.");
		name2 = keyboard.next() + " " + keyboard.next() + " " + keyboard.next();
		hours2 = keyboard.nextInt();
		minutes2 = keyboard.nextInt();
		keyboard.nextLine();

		System.out.println(name1 + " " + hours1 + " " + minutes1);
		System.out.println(name2 + " " + hours2 + " " + minutes2);
		
		// Makes Eclipse happy
		keyboard.close();
	}
}
