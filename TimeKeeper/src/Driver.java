
public class Driver {

	public static void main(String[] args) {
		Time myTime = new Time();
		Time yourTime = new Time(12, 0, 0);
		
		myTime.setHour(2);
		System.out.println(myTime);
		System.out.println(yourTime);
		System.out.println(myTime.equals(yourTime));
		
		Time sum = myTime.add(yourTime);
		System.out.println(sum);
				
	}

	private static void printTime(Time t) {
		System.out.printf("%02d", t.getHour());
		System.out.print(":");
		System.out.printf("%02d", t.getMinute());
		System.out.print(":");
		System.out.printf("%02d\n", t.getSecond());
		
	}

}
