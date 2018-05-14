package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTest4 {
	Scanner scan = new Scanner(System.in);
	Map<Integer, String> hotelMap = new HashMap<Integer, String>();
	
	
	// �޴��� ����ϰ� ���õ� �޴���ȣ�� ��ȯ�ϴ� �޼���
	public int getMenu(){
		System.out.println();
		System.out.println("� ������ �Ͻðڽ��ϱ�?");
		System.out.println("************************************");		
		System.out.println("1.üũ��  2.üũ�ƿ� 3.���ǻ��� 4.��������");		
		System.out.println("************************************");	
		System.out.println("�޴����� >> ");	
		int num = scan.nextInt();
		return num;
	}
	
	//���α׷��� �۾��� �����ϴ� �޼���
	public void start(){
		System.out.println("**********************");
		System.out.println("ȣ�� ���� �������ϴ�.");
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
						System.out.println("ȣ�� ���� �ݾҽ��ϴ�. �ȳ��� ������");
						System.out.println("*****************************");
						return;
					default:
						System.out.println("�޴��� �ִ� ��ȣ�� �����ϼ���");
						System.out.println();
				}
			}
		} catch (Exception e) {
			System.out.println("����)�߸��Է� ��ȣ�� �Է��ϼ���");
			
		}
	}//start()
	
	
	public static void main(String[] args) {
		new HotelTest4().start();
	}//main()
	
	
	// 1������ ,üũ���ϴ� �޼��� 
	public void checkIn(){
		System.out.println("����濡 üũ�� �Ͻðڽ��ϱ�?");
		System.out.println("���ȣ �Է� : "); //  ���ȣ �Է� => 102 <-- �Է�
		
		int room = scan.nextInt();	
		
		//�Է��� ���ȣ�� �ִ��� �˻� 
		if(hotelMap.containsKey(room)){
			System.out.println(room + "ȣ �濡�� �̹� ����� �ֽ��ϴ�.");
			return;
		}
		System.out.println("������ üũ�� �Ͻðڽ��ϱ�?");
		System.out.println("�̸� �Է� : ");	//		�̸� �Է� : ȫ�浿 <-- �Է�
		String name = scan.next();
		
		//�Է��� ������ Map�� ���� 
		hotelMap.put(room , name);
		System.out.println("üũ�� �Ǿ����ϴ�.");
	}
	
	// 2������ ,üũ�ƿ��ϴ� �޼��� 
	public void checkOut() {
		System.out.println("������� üũ�ƿ� �Ͻðڽ��ϱ�?");
		System.out.println("���ȣ �Է� :");  //101 <-- �Է�
		int roomNum = scan.nextInt();
		
		if(hotelMap.containsKey(roomNum)) {
			System.out.println(roomNum + "ȣ �濡�� üũ���� ����� �����ϴ�."); 
			return;
		}
		hotelMap.remove(roomNum);
		System.out.println("üũ�ƿ� �Ǿ����ϴ�.");		
	}
	
	// 3������ ���ǻ���üũ�ϴ� �޼���
	public void roomCheck() {
		if(hotelMap.size()==0){
			System.out.println("�������� �����ϴ�.");
		}else {
			Set<Integer> keySet = hotelMap.keySet();
			Iterator<Integer> it = keySet.iterator();
		
			while(it.hasNext()) {
				int num = it.next();
				String h = hotelMap.get(num);
				System.out.println("���ȣ : " +num + "������ : " + h );
//		���ȣ : 102, ������ : ������
//		���ȣ : 101, ������ : ȫ�浿
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



