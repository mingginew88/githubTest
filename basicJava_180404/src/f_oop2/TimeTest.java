package f_oop2;

public class TimeTest {
	
	public static void main(String[] args) {
		
		Time t = new Time();
		System.out.println(t.getHour());
		t.setHour(100);
		System.out.println(t.getHour());
		t.setMinute(150);
		System.out.println(t);
		t.setSecond(10000);
		System.out.println(t);
		
	}

}

//get set


class Time{
	
	private int hour;
	private int minute;
	private int second;
	
	//시간 계산
	public void setHour(int hour){			
			this.hour = hour%24;		
	}
	
	public int getHour(){
		return hour;
	}	
	
	//분 계산
	public void setMinute(int minute){			
//			this.hour += minute/60;
			this.minute = minute%60;
			setHour(hour + minute/60);
		
//		setHour(this.hour);		//분 계산 하고 나서 바뀐 시간을 '시간 계산 메서드'에 가서 처리
	}
	
	public int getMinute(){
		return minute;
	}	
	
	//초 계산
	public void setSecond(int second){
//			this.minute += second/60;
			setMinute(minute + second/60);	//초를 분으로 바꾼것과 기존의 분과 더해서 '분계산메서드'에서 치리
			this.second = second%60;
//		setMinute(this.minute);		//초 계산 후 바뀐 분을 '분 계산 메서드'에 가서 처리
	}
	
	public int getSecond(){
		return second;
	}	
	
	
	//toString()은 맨 마지막에 기술해준다.
	@Override
	public String toString(){
		return "Time [hour=" + hour + ", minute=" + minute + ", second =" +second +"]";
	}	
	
}