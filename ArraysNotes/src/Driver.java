import java.util.Arrays;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		int[] counts = new int[5];
		int[] values = new int[100];
		//int[] counts2 = counts;
		//int[] arr = {1,2,3,4,5};
		
		//counts2[0] = 321;
		counts[0] = 123;
		
		//System.out.println(counts2[0]);
		
		//printArray(values);
		fillArray(values);
		//printArray(values);
		System.out.println(search(values, 73));
		//System.out.println(Arrays.toString(values));
		printArray(values);
		System.out.println();
		counts = makeHistogram(values);
		System.out.println("A's-B's-C's-D's-F's");
		System.out.printf("%2d%4d%4d%4d%4d", counts[4], counts[3],counts[2],counts[1],counts[0]);
		
	}

	private static int[] makeHistogram(int[] values) {
		int[] ret = new int[5];
		for (int i = 0; i < values.length; i++) {
			if(values[i] > 89) ret[4]++;//a's
			else if(values[i] > 79)ret[3]++;//b's
			else if(values[i] > 69)ret[2]++;//c's
			else if(values[i] > 59)ret[1]++;//d's
			else ret[0]++;
		}
		return ret;
	}

	private static int search(int[] values, int target) {
		for (int i = 0; i < values.length; i++) {
			if(values[i] == target)return i;
		}
		return -1;		
	}

	private static void fillArray(int[] vals) {
		Random random = new Random();
		for (int i = 0; i < vals.length; i++) {
			vals[i] = random.nextInt(70)+31;
		}		
	}

	private static void printArray(int[] counts) {
		//traversing an array
		for (int i = 0; i < counts.length; i++) {
			
			if(i % 10 == 0 && i != 0)System.out.println();
			System.out.print(counts[i] + ", ");
		}
		System.out.println();	
	}

}
