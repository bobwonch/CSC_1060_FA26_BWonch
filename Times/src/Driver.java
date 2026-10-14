
public class Driver {

	public static void main(String[] args) {
		Time myTime = new Time();
		myTime.setHour(4);
		myTime.setMinute(223);
		myTime.setSecond(100);
		
		Time yourTime = new Time(2,350,100);

		System.out.println(yourTime);
		printTime(myTime);
		System.out.println();
		System.out.println(myTime.equals(yourTime));
		System.out.println(myTime.add(yourTime));
	}

	private static void printTime(Time T) {
		System.out.printf("%02d:%02d:%02d", T.getHour(), T.getMinute(),T.getSecond());
		
	}

}
