package test_object;

public class TestTime {	
	public static void main(String[] args) {
		Time2 t = new Time2();
		
		System.out.println(t.getHour());
		t.setMinute(150);
		System.out.println(t.getHour());
		t.setSecond(10000);
		System.out.println(t.getHour());
		System.out.println(t);
	}
}

class Time2{	
	private int hour;
	private int minute;
	private int second;
	
	public void setHour(int hour){
		this.hour = hour%24;
	}
	
	public int getHour(){
		return hour;
	}	
	
	public void setMinute(int minute){
		this.minute = minute%60;
		setHour(hour + minute/60);
	}
	
	public int getMinute(){
		return minute;
	}
	
	public void setSecond(int second){
		this.second = second%60;
		setMinute(minute + second/60);
	}	
	
	public int getSecond(){
		return second;
	}	
	@Override
	public String toString(){
		return "Time [hour=" + hour + ", minute=" + minute + ", second =" +second +"]";
	}	
	
}