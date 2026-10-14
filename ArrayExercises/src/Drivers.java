import java.util.Random;

public class Drivers {

	public static void main(String[] args) {
		int[] arr = new int[10];
		fillArray(arr);
		//printArray(arr);
		
		int max = findMax(arr);
		int min = findMin(arr);
				
		bubbleSortArray(arr);
		int med = findMedian(arr);
		
		System.out.println();
		//printArray(arr);
		System.out.println();
		
		int[] revArr = reverseArray2(arr);
		
		//reverseArray(arr);
		
		
		printArray(arr);
		System.out.println();
		printArray(revArr);
		System.out.println("\n" + med + "\n" + max + "\n" + min);

	}

	private static void reverseArray(int[] arr) {
		for (int i = 0; i < arr.length/2; i++) {
			swap(arr, i, arr.length - i - 1);
		}
		
	}

	private static int[] reverseArray2(int[] arr) {
		int[] ret = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ret[arr.length - 1 - i] = arr[i];
		}
		return ret;
	}
	
	private static int findMedian(int[] arr) {
		if(arr.length % 2 == 0)
		{
			int sum = arr[arr.length/2] + arr[arr.length/2 - 1];
			return sum / 2;
		}else
		{
			return arr[arr.length/2];
		}	
	}

	private static void bubbleSortArray(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j + 1])swap(arr, j, j + 1);
			}			
		}		
	}

	private static void printArray(int[] arr) {
		for(int num : arr)
		{
			System.out.print(num +", ");
		}
		
	}

	private static int findMin(int[] arr) {
		int min = arr[0];
		for (int num : arr) {
			if (num < min)
				min = num;
		}
		return min;
	}

	private static void fillArray(int[] arr) {
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100) - 50;
		}

	}

	private static int findMax(int[] arr) {
		int max = arr[0];
		for (int num : arr) {
			if (num > max)
				max = num;
		}
		return max;
	}

	// helper method
	private static void swap(int[] arr, int a, int b) 
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
