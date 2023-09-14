import java.util.Scanner;

public class Project3_TristanDow {
	/* @AUTHOR Tristan Dow
	 * CS 1323 Section 1 Fall 2016
	 */

	public static void main (String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		// Declaration of variables for number of books to order
		int numHitchHikersGuide;
		int numBible;
		int numQuran;
		
		
		// Declaration of variables for price of books and total price and tax rate
		double priceHitchHikersGuide = 8.48;
		double priceBible = 21.22;
		double priceQuran = 26.48;
		double totalPrice;
		double salesTax;
		final double TAX_RATE = 0.065;
		
		
		//Input of number of books
		System.out.println("Enter number of copies you'd "
				+ "like to purchase of" + "\n" + "The Hitchhiker's Guide to the Galaxy.");
		numHitchHikersGuide = keyboard.nextInt();
		
		System.out.println("Enter number of copies you'd "
				+ "like to purchase of" + "\n" + "The Bible.");
		numBible = keyboard.nextInt();
		
		System.out.println("Enter number of copies you'd "
				+ "like to purchase of" + "\n" + "The Quran.");
		numQuran = keyboard.nextInt();
		
		
		//Calculation and displaying total price and sales tax
		totalPrice = (numHitchHikersGuide * priceHitchHikersGuide) + (numBible * priceBible) + (numQuran * priceQuran);
		salesTax = TAX_RATE * totalPrice;
		
		System.out.println("The total cost of your purchases is: " + totalPrice + "\nSales tax is: " + salesTax);
		System.out.println("The total cost of your order is: " + (totalPrice + salesTax));
		
		
		// Makes Eclipse stop yelling at me
		keyboard.close();
	}
}
