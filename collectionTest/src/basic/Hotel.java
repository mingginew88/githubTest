package basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	Scanner sc;
	Map<String, String> room = new HashMap<String, String>();
	
	public void start(){
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		
		while(true){
			sc = new Scanner(System.in);
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("*******************************************");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");
			
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못 입력하였습니다.");
				continue;
			}
			
			switch (input) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				infoRoom();
				break;
			case 4:
				System.out.println("종료되었습니다.");
				return;	
			default:				
				break;
			}
			
		}
	}//End start()
	
	public void checkIn(){
		sc = new Scanner(System.in);
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 : ");		
		String roomNumber = sc.nextLine();		
		for (int i = 0; i < room.size(); i++) {
			if(room.containsKey(roomNumber)){
				System.out.println(roomNumber + "호 방에는 이미 사람이 있습니다.");
			}
		}
		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();		
		room.put(roomNumber, name);		
	}//End checkIn()
	
	public void checkOut(){
		sc = new Scanner(System.in);
		System.out.println("체크아웃 하실 방번호를 입력하세요.");
		System.out.print("방번호 입력 : ");
		String roomNumber = sc.nextLine();
		for (int i = 0; i < room.size(); i++) {
			if(!(room.containsKey(roomNumber))){
				System.out.println(roomNumber + "호실에 사람이 없습니다.");
			}
		}
		room.remove(roomNumber);
		System.out.println("삭제가 완료되었습니다.");
		
		
	}//End checkOut()
	
	public void infoRoom(){
		System.out.println();
		System.out.println("===================");
		System.out.println("방번호     투숙객이름");
		System.out.println("===================");
		
		if(room.size()==0){
			System.out.println("투숙객이 존재하지않습니다.");
		}else{
			Set<String> roomSet = room.keySet();			
			Iterator<String> it = roomSet.iterator();
			
			while(it.hasNext()){
				String roomNumber = it.next();
				System.out.println(roomNumber + "\t" + room.get(roomNumber));
				
				System.out.println();
			}
		}
		System.out.println("===================");
		System.out.println("출력 끝");
		
		
	}//End infoRoom()

	
	public static void main(String[] args) {
		new Hotel().start();
		
	}

}


class Room{
	private String roomNum;
	private String name;
	
	public Room(String roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
}




