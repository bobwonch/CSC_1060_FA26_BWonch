
public class Time {
	private int hour;
	private int minute;
	private int second;
	
	//default constructor
	public Time()
	{
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
	}
	//value constructor
	public Time(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
//	public boolean equals(Time that) {
//	    final double DELTA = 0.001;
//	    return this.hour == that.hour
//	        && this.minute == that.minute
//	        && Math.abs(this.second - that.second) < DELTA;
//	}
	
	public Time add(Time that)
	{
		Time sum = new Time();
		sum.hour = this.hour + that.hour;
		sum.minute = this.minute + that.minute;
		sum.second = this.second + that.second;
		if(sum.second >= 60)
		{
			sum.minute++;
			sum.second -= 60;
		}
		if(sum.minute >= 60)
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
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
		
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d\n", this.hour, this.minute, this.second); 
	}	
	
}
