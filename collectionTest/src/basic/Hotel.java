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
		System.out.println("ȣ�� ���� �������ϴ�.");
		System.out.println("**************************");
		
		while(true){
			sc = new Scanner(System.in);
			System.out.println("� ������ �Ͻðڽ��ϱ�?");
			System.out.println("*******************************************");
			System.out.println("1.üũ��  2.üũ�ƿ� 3.���ǻ��� 4.��������");
			System.out.println("*******************************************");
			
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
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
				System.out.println("����Ǿ����ϴ�.");
				return;	
			default:				
				break;
			}
			
		}
	}//End start()
	
	public void checkIn(){
		sc = new Scanner(System.in);
		System.out.println("����濡 üũ�� �Ͻðڽ��ϱ�?");
		System.out.print("���ȣ �Է� : ");		
		String roomNumber = sc.nextLine();		
		for (int i = 0; i < room.size(); i++) {
			if(room.containsKey(roomNumber)){
				System.out.println(roomNumber + "ȣ �濡�� �̹� ����� �ֽ��ϴ�.");
			}
		}
		System.out.println();
		System.out.println("������ üũ�� �Ͻðڽ��ϱ�?");
		System.out.print("�̸� �Է� : ");
		String name = sc.nextLine();		
		room.put(roomNumber, name);		
	}//End checkIn()
	
	public void checkOut(){
		sc = new Scanner(System.in);
		System.out.println("üũ�ƿ� �Ͻ� ���ȣ�� �Է��ϼ���.");
		System.out.print("���ȣ �Է� : ");
		String roomNumber = sc.nextLine();
		for (int i = 0; i < room.size(); i++) {
			if(!(room.containsKey(roomNumber))){
				System.out.println(roomNumber + "ȣ�ǿ� ����� �����ϴ�.");
			}
		}
		room.remove(roomNumber);
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		
		
	}//End checkOut()
	
	public void infoRoom(){
		System.out.println();
		System.out.println("===================");
		System.out.println("���ȣ     �������̸�");
		System.out.println("===================");
		
		if(room.size()==0){
			System.out.println("�������� ���������ʽ��ϴ�.");
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
		System.out.println("��� ��");
		
		
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




