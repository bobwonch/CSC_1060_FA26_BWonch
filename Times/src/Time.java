public class Time {
	private int hour;
	private int minute;
	private int second;
	//default constructor
	public Time() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0;		
	}
	//values constructor
	public Time(int hour, int minute, int second) {
		while(second >= 60)
		{
			minute++;
			second -= 60;
		}
		this.second = second;
		while(minute >= 60)
		{
			hour++;
			minute -= 60;
		}
		this.minute = minute;
		this.hour = hour;
	}
	public Time add(Time that)
	{
		Time sum = new Time();
		sum.hour = this.hour + that.hour;
		sum.minute = this.minute + that.minute;
		sum.second = this.second + that.second;
		while(sum.second >= 60)
		{
			sum.minute++;
			sum.second -= 60;
		}
		while(sum.minute >= 60)
		{
			sum.hour++;
			sum.minute -= 60;
		}
		return sum;
	}
	
	
	public boolean equals(Time that)
	{
		return this.hour == that.hour &&
			   this.minute == that.minute &&
			   this.second == that.second;
	}
	
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		while(minute > 60)
		{
			this.hour++;
			minute -= 60;
		}
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		while(second > 60)
		{
			this.minute++;
			second -= 60;
		}
		this.second = second;
	}
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
}
