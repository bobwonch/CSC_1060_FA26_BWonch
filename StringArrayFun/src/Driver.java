
public class Driver {
	public static void main(String [] args) {
		String line = "The 2  quick red 32 f oxes each 32 jumped over 3 lazy 4 brown 7 dogs.";
		String[] words = line.split(" ");
		//printArray(words);
		
		String[] letters = words[1].split("");
		//printArray(letters);
		
		int[] nums = findNums(words);
		System.out.println();
		printInts(nums);
		
	}

	private static void printInts(int[] nums) {
		for(int num : nums)
		{
			System.out.println(num);
		}
		
	}

	private static int[] findNums(String[] words) {
		int count = 0;
		for(String word : words)
		{
			try {
				Integer.parseInt(word);
				count++;
			}catch(NumberFormatException e)
			{
				System.out.print("*");
			}
		}
		int[] nums = new int[count];
		count = 0;
		for(int i = 0; i < words.length; i++)
		{
			try {
				nums[count] = Integer.parseInt(words[i]);
				count++;
				
			}catch(NumberFormatException e)
			{
				//System.out.println("That'sa word...");
			}
		}
		return nums;
	}

	private static void printArray(String[] words) {
		for(String word : words)
		{
			System.out.println(word);
		}
		
	}
}
