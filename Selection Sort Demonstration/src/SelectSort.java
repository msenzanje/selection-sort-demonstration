import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;

//A demonstration of the selection sort algorithm
public class SelectSort{

	public static void main(String args[]){

		//This will move to the next file after each sort
		for(int size = 10; size <= 1000000; size*=10) {

			//Initialize new array
			int [] numbers = new int [size];
			//array index
			int inFileIndex = 0;


			//Read a list of numbers into an array
			try {
				BufferedReader inFile = new BufferedReader(new FileReader("src\\sortme"
						+ size + ".txt"));

				String line  = inFile.readLine();

				while(line!=null) {
					//Use parseInt to change line from String to int
					numbers[inFileIndex] = Integer.parseInt(line);
					inFileIndex++;
					//Read in a new line
					line = inFile.readLine();
				}
				inFile.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Sorting sortme" + size + ".txt...");
			//Timed sorting process
			Instant start = Instant.now();
			selectionSort(numbers);
			Instant finish = Instant.now();
			long sortingTime = Duration.between(start, finish).toMillis();

			//Print data in console
			System.out.println("Time to Sort(in MS): " + sortingTime);
			System.out.println("--------------------------\n\n");

		}

	}//END MAIN


	//Standard selection sort algorithm that will sort an array of int
	public static void selectionSort(int arr[]){

		int arrayLength = arr.length;
		int compCount = 0, swapCount = 0 ; //number of comparisons and swaps

		//Iterates the bound between sorted and unsorted portion 
		for (int i = 0; i < arrayLength-1; i++){
			int min_idx = i;

			//Finds the idx of the min value in the unsorted portion
			for (int j = i+1; j < arrayLength; j++){
				compCount++;
				if (arr[j] < arr[min_idx]){
					min_idx = j;
				}
			}

			// Variable swap
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
			swapCount++;
		}


		//Print the number of comparisons made
		System.out.println("Number of Comparisons: " + compCount);
		System.out.println("Number of Swaps: " + swapCount);

	}//END SELECTIONSORT FUNCTION

}
