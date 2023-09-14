import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Project11_TristanDow 
{

	public static void main(String[] args) 
	{
		/* Everything in main is for general testing of methods.
		 * Normally, I'd make a user interface, but I decided to let the whole thing be, since it took me a lot longer than expected.
		 */
		char[][] testArray = generateDiagonalPattern(1000,1000,40);
		try {
			writePGMFile("test2",testArray,testArray.length,testArray[0].length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}


	// Generates a two-dimensional array with a checker board pattern
	public static char[][] generateCheckerBoard(int height, int width, int checkerSize)
	{
		// declaration of variables
		int checkerSet = 2 * checkerSize; // This variable treats 2 rows as a set
		char[][] array = new char[height][width];
		
		// This loops makes rows of vertical stripes, alternating whether black or white are first, thereby making the checker board
		for(int row = 0; row < array.length; ++row)
		{
			if(row % checkerSet < checkerSize ) // Black first row
			{
				for(int column = 0; column < array.length; ++column)
					{
						if(column%checkerSet > checkerSize)
						{
							array[row][column] = (char)255;
						}
					}
			}
			else
			{
				for(int column = 0; column < array.length; ++column) // White first row
				{
					if(column%checkerSet < checkerSize)
					{
						array[row][column] = (char)255;
					}
				}
			}
		}
		return array;
	}
	
	// Generates a two-dimensional array with a diagonal stripe pattern
	public static char[][] generateDiagonalPattern(int height, int width, int stripeWidth)
	{
		// Declaration of variables
		char[][] array = new char[height][width];
		int stripeSet = stripeWidth * 2; // Again treating two rows as a set
		
		// Cycle through array
		for(int row = 0; row < height; ++row)
		{
			for(int column = 0; column < width; ++column)
			{
				if((column + row)%stripeSet < stripeWidth) // If the column and row add up to the top half of the set, they are white, and if they add up to the bottom of the set, they are black
				{
					array[row][column] = (char)255;
				}
			}
		}
		
		return array;
	}
	
	// Generates a two-dimensional array with a vertical stripe pattern
	public static char[][] createVerticalStripes(int height, int width, int stripeWidth)
	{
		// Declaration of variables
		int stripeSet = 2 * stripeWidth;
		char[][] array = new char[height][width];
		
		// Loop through array
		for(int row = 0; row < array.length; ++row)
		{
				for(int column = 0; column < array.length; ++column)
					{
						if(column%stripeSet < stripeWidth) // Another bottom half/top half check, but now only for column, making it vertical stripes
						{
							array[row][column] = (char)255;
						}
					}
		}
		return array;
	}
	
	// Generates a two-dimensional array with a horizontal stripe pattern
		public static char[][] createHorizontalStripes(int height, int width, int stripeWidth)
		{
			// Declaration of variables
			int checkerSet = 2 * stripeWidth;
			char[][] array = new char[height][width];
			
			// Looping through array
			for(int column = 0; column < array.length; ++column)
			{
					for(int row = 0; row < array.length; ++row)
						{
							if(row%checkerSet < stripeWidth) // Another bottom half/top half check, this time only on row, making horizontal stripes
							{
								array[row][column] = (char)255;
							}
						}
			}
			return array;
		}
	
	// Generates PGM files
	public static void writePGMFile(String fileName, char[][] image, int height, int width) throws FileNotFoundException 
	{
		PrintWriter file = new PrintWriter(new File(fileName));

		file.println("P2");
		file.println(height+ " " + width);
		file.println((int) 255);

		for (int row = 0; row < height; ++row)
			{
				for(int col = 0; col < width; ++col)
				{
					file.print((int)(image[row][col]));
					file.println(' ');
				}
			}

		file.close();
	}
}
