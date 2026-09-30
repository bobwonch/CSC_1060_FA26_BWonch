
public class Driver {

	public static void main(String[] args) {
		//declare our arrays
//		int[] counts;
//		double[] values;
//		//initialize
//		counts = new int[4];
//		values = new double[10];
		
		//hardcode it in
		
		//int[] a = {1,2,3,4};
		
		//System.out.println(a[0]);	
		//a[0] = 4;
		//System.out.println(a[0]);
		
//		counts[0] = 7;
//		counts[1] = counts[0] * 2;
//		counts[2]++;
//		counts[3] -= 60;
//		System.out.println();
//		values[0]++;
//		System.out.println(values[0]);
		
//		int i = 0;
//		while(i < 4)
//		{
//			System.out.println(counts[i]);
//			i++;
//		}
//		for(int j = 0; j < counts.length; j++)
//		{
//			System.out.print(counts[j] + ", ");
//		}
//		System.out.println();
//		printArray(values);
//		addArray(values);
//		printArray(values);
//		
//		double [] a = new double[3];
//		double [] b = a;
//		
//		a[0] = 17;
//		printArray(b);
//		 b = new double[3];
//		 for(int i = 0; i < b.length; i++)
//		 {
//			 b[i] = a[i];
//		 }
		
		int[] a = {1,2,3,4,5};
		for(int i = 0; i < a.length; i++)
		{
			a[i] *= a[i];
		}
		int target = 8;
		int temp = search(a, target);
		System.out.println(temp);
		
		int sum = sum(a);
		System.out.println(sum);
		
	}

	private static int sum(int[] a) {
		int sum = 0;
		for(int i = 0; i < a.length; i++)
		{
			sum += a[i];
		}
		return sum;
	}

	private static int search(int[] a, int target) {
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] == target) return i;
		}
		return -1;
	}

	private static void addArray(double[] arr) {
		for(int i = 0; i < arr.length; i++)
		{
			arr[i]++;
		}
		
	}

	private static void printArray(double[] arr) {
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		
	}
}
