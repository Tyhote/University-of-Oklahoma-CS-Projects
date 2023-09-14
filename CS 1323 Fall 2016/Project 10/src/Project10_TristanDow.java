import java.util.Arrays;

public class Project10_TristanDow 
{

	public static void main(String[] args) 
	{
		// Creating the array
		final int ARRAY_SIZE = 10;
		int[] arrayToScramble = createArray(ARRAY_SIZE);
		
		// Scrambling the array then printing it
		scrambleArray(arrayToScramble);
		System.out.println(Arrays.toString(arrayToScramble));
		
		// Sorting array then printing it
		stepSort(arrayToScramble);
		System.out.println(Arrays.toString(arrayToScramble));

	}

	// Creates array with size of SIZE and fills array with increasing positive integers from 1, then returns that array
	public static int[] createArray(final int SIZE)
	{
		int[] array = new int[SIZE];
		for(int i =0; i < SIZE; ++i)
		{
			array[i] = i+1;
		}
		return array;
	}
	
	// Swaps each index with one random other index in the array
	public static void scrambleArray(int[] array)
	{
		int temp = 0;
		int indexSwapped;
		int range = array.length;
		for(int i = 0; i < array.length; ++i)
		{
			indexSwapped = (int)(Math.random() * range);
			temp = array[indexSwapped];
			array[indexSwapped] = array[i];
			array[i] = temp;
		}
	}
	
	// Steps through selection sort one index at a time
	public static void stepSort(int[] array)
	{
		for(int indexToSort = 0; indexToSort < array.length; ++indexToSort)
		{
			// Utilizing minimumForIndex to find the index of the minimum value after and including this index
			int minIndex = minimumForIndex(array, indexToSort);
			if(minIndex != indexToSort)
			{
				int temp = array[indexToSort];
				array[indexToSort] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}
	
	public static int minimumForIndex(int[] array, int indexToSort)
	{
		int min = indexToSort;
		// Sorting through each index after and including indexToSort
		for(int i = indexToSort+1; i < array.length; ++i)
		{
			if(array[i] < array[min])
			{
				min = i;
			}
		}
		return min;
	}
}
