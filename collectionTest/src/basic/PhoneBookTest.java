package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
	�̸�, �ּ�, ��ȭ��ȣ �Ӽ��� ���� PhoneŬ������ �����,
	�� PhoneŬ������ �̿��Ͽ� ��ȭ��ȣ ������ �����ϴ�
	���α׷��� �ϼ��Ͻÿ�.
	�� ���α׷����� ��ȭ��ȣ�� ���, ����, ����, �˻�, ��ü����ϴ� ����� �ִ�.
	
	��ü ��ȭ��ȣ ������ Map�� �̿��Ͽ� �����Ѵ�.
	(key�� �̸����� �ϰ� value�� PhoneŬ������ �ν��Ͻ��� �Ѵ�.)

 */

public class PhoneBookTest {
	public static void main(String[] args) {
		new PhoneBookTest().start();
	}	
	List<Phone> phoneList = new ArrayList<Phone>();
//	List<HashMap<String, String>> phoneList = new ArrayList<HashMap<String, String>>();
	Phone p = new Phone();
	
	
	public void start(){
		
		while(true){
			Scanner sc = new Scanner(System.in);
			
			System.out.println("=========================");
			System.out.println("��ȭ��ȣ ���� ���α׷�");
			System.out.println("=========================");
			
			System.out.println("-------------------------");
			System.out.println("1. ��ȭ��ȣ ���");
			System.out.println("2. ��ȭ��ȣ ����");
			System.out.println("3. ��ȭ��ȣ ����");
			System.out.println("4. ��ȭ��ȣ �˻�");
			System.out.println("5. ��ȭ��ȣ ��ü ���");
			System.out.println("6. ���α׷� ����");
			System.out.println("-------------------------");
			
			int input = 0;
			try {
				input = sc.nextInt();				
			} catch (Exception e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				continue;
			}
			
			switch (input) {
			case 1:
				addTel(p);
				break;
			case 2:	
				insertTel();				
				break;
			case 3:
				deleteTel();
				break;
			case 4:
				selectTel();
				break;
			case 5:
				showAllTel();
				break;
			case 6:
				return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				continue;
			}		
		}
	}
	
	public void addTel(Phone p){		//���� map�� �ʿ���� ����
		Scanner sc = new Scanner(System.in);
		Phone addP = new Phone();
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("�̸��� ������ּ���.");
		String name = sc.nextLine();
		map.put("name", name);
		addP.setName(map.get("name"));
		
		System.out.println("��ȭ��ȣ�� ������ּ���.");
		String tel = sc.nextLine();
		map.put("tel", tel);
		addP.setTel(map.get("tel"));
		
		System.out.println("�ּҸ� ������ּ���.");
		String address = sc.nextLine();
		map.put("address", address);
		addP.setAddress(map.get("address"));
		
		phoneList.add(addP);
	}
	
	public void insertTel(){
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ����� �̸��� �Է��ϼ���.");
		String name = sc.nextLine();
		System.out.println("�ٲ� ��ȭ��ȣ�� �Է��ϼ���.");
		String tel = sc.nextLine();
		System.out.println("�ٲ� �ּҸ� �Է��ϼ���.");
		String address = sc.nextLine();
		for (int i = 0; i < phoneList.size(); i++) {
			if(name.equals(phoneList.get(i).getName())){
				phoneList.get(i).setTel(tel);
				phoneList.get(i).setAddress(address);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");			
			}
		}
		
	}
	
	public void deleteTel(){
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ����� �̸��� �Է��ϼ���.");
		String name = sc.nextLine();
		for (int i = 0; i < phoneList.size(); i++) {
			if(name.equals(phoneList.get(i).getName())){
				phoneList.remove(i);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			}
		}
	}
	
	public void selectTel(){
		Scanner sc = new Scanner(System.in);
		System.out.println("�˻��� ����� �̸��� �Է��ϼ���.");
		String name = sc.nextLine();
		for (int i = 0; i < phoneList.size(); i++) {
			if(name.equals(phoneList.get(i).getName())){
				System.out.println("1");
				phoneList.get(i).getName();
				phoneList.get(i).getTel();
				phoneList.get(i).getAddress();
			}
		}
		
	}
	
	public void showAllTel(){
		int count = 1;
		System.out.println("=========================");
		System.out.println("��ȣ" + "\t" + "�̸�" + "\t" + "��ȭ��ȣ" + "\t" + "�ּ�");
		System.out.println("=========================");
		for (Phone phone : phoneList) {
			System.out.print(count++ + "\t");
			System.out.print(phone.getName() + "\t");
			System.out.print(phone.getTel() + "\t");
			System.out.print(phone.getAddress() + "\t");
			System.out.println();
		}
		System.out.println("=========================");
		System.out.println("��¿Ϸ�...");		
	}	
	
}


class Phone{
	private String name;
	private String address;
	private String tel;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}