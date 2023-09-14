import java.util.Scanner;

public class Factor 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number you want the largest factor of");
		int userNumber = input.nextInt();
		int factor = userNumber - 1;
		
		while(userNumber%factor != 0)
		{
			factor--;
		}
		System.out.println("The largest factor of " + userNumber + " is " + factor);

		input.close();
	}

}
