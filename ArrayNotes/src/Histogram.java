import java.util.Random;

public class Histogram {

	public static void main(String[] args) {
		int arr[] = new int[100];
		
		radomizeArray(arr);
		printArray(arr);
		
		int[]numCounts = countNums(arr);
		
		printArray(numCounts);
		
	}

	private static int[] countNums(int[] arr) {
		int[] counts = new int[arr.length];
		int index = 0;
		for(int i : arr)
		{
			for(int j : arr)
			{
				if(i == j) counts[index]++;
			}
			index ++;
		}
		
		
		return counts;
	}

	private static void printArray(int[] arr) {
		for(int i : arr)
		{
			System.out.printf("%3d,", i);
		}
		System.out.println();
	}

	private static void radomizeArray(int[] arr) {
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100);
		}		
	}

}
