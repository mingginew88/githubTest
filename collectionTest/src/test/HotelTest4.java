package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTest4 {
	Scanner scan = new Scanner(System.in);
	Map<Integer, String> hotelMap = new HashMap<Integer, String>();
	
	
	// 메뉴를 출력하고 선택된 메뉴번호를 반환하는 메서드
	public int getMenu(){
		System.out.println();
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("************************************");		
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");		
		System.out.println("************************************");	
		System.out.println("메뉴선택 >> ");	
		int num = scan.nextInt();
		return num;
	}
	
	//프로그램의 작업을 시작하는 메서드
	public void start(){
		System.out.println("**********************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**********************");
		System.out.println();
		try {
			while(true) {
				int menuNum = getMenu();
				
				switch(menuNum) {
					case 1:
						checkIn();
						break;
					case 2:
						checkOut();
						break;
					case 3:
						roomCheck();
						break;
					case 4:
						System.out.println("*****************************");
						System.out.println("호텔 문을 닫았습니다. 안녕히 가세요");
						System.out.println("*****************************");
						return;
					default:
						System.out.println("메뉴에 있는 번호를 선택하세요");
						System.out.println();
				}
			}
		} catch (Exception e) {
			System.out.println("오류)잘못입력 번호를 입력하세요");
			
		}
	}//start()
	
	
	public static void main(String[] args) {
		new HotelTest4().start();
	}//main()
	
	
	// 1번선택 ,체크인하는 메서드 
	public void checkIn(){
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.println("방번호 입력 : "); //  방번호 입력 => 102 <-- 입력
		
		int room = scan.nextInt();	
		
		//입력한 방번호가 있는지 검사 
		if(hotelMap.containsKey(room)){
			System.out.println(room + "호 방에는 이미 사람이 있습니다.");
			return;
		}
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 : ");	//		이름 입력 : 홍길동 <-- 입력
		String name = scan.next();
		
		//입력한 정보를 Map에 저장 
		hotelMap.put(room , name);
		System.out.println("체크인 되었습니다.");
	}
	
	// 2번선택 ,체크아웃하는 메서드 
	public void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.println("방번호 입력 :");  //101 <-- 입력
		int roomNum = scan.nextInt();
		
		if(hotelMap.containsKey(roomNum)) {
			System.out.println(roomNum + "호 방에는 체크인한 사람이 없습니다."); 
			return;
		}
		hotelMap.remove(roomNum);
		System.out.println("체크아웃 되었습니다.");		
	}
	
	// 3번선택 객실상태체크하는 메서드
	public void roomCheck() {
		if(hotelMap.size()==0){
			System.out.println("투숙객이 없습니다.");
		}else {
			Set<Integer> keySet = hotelMap.keySet();
			Iterator<Integer> it = keySet.iterator();
		
			while(it.hasNext()) {
				int num = it.next();
				String h = hotelMap.get(num);
				System.out.println("방번호 : " +num + "투숙객 : " + h );
//		방번호 : 102, 투숙객 : 성춘향
//		방번호 : 101, 투숙객 : 홍길동
			}
		}

	}//HotelTest4
}





//class HotelRoom{
//	private String name;
//	private int roomNum;
//	
//	public HotelRoom(int roomNum, String name) {
//		super();
//		this.name = name;
//		this.roomNum = roomNum;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getRoomNum() {
//		return roomNum;
//	}
//
//	public void setRoomNum(int roomNum) {
//		this.roomNum = roomNum;
//	}
//
//	
//	@Override
//	public String toString() {
//		return "HotelRoom [name=" + name + ", roomNum=" + roomNum + "]";
//	}
//	
//}//HotelRoom



