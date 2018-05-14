package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
	이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고,
	이 Phone클래스를 이용하여 전화번호 정보를 관리하는
	프로그램을 완성하시오.
	이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
	
	전체 전화번호 정보는 Map을 이요하여 관리한다.
	(key는 이름으로 하고 value는 Phone클래스의 인스턴스로 한다.)

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
			System.out.println("전화번호 관리 프로그램");
			System.out.println("=========================");
			
			System.out.println("-------------------------");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("6. 프로그램 종료");
			System.out.println("-------------------------");
			
			int input = 0;
			try {
				input = sc.nextInt();				
			} catch (Exception e) {
				System.out.println("잘못 입력하였습니다.");
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
				System.out.println("잘못 입력하였습니다.");
				continue;
			}		
		}
	}
	
	public void addTel(Phone p){		//현재 map이 필요없는 상태
		Scanner sc = new Scanner(System.in);
		Phone addP = new Phone();
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("이름을 등록해주세요.");
		String name = sc.nextLine();
		map.put("name", name);
		addP.setName(map.get("name"));
		
		System.out.println("전화번호를 등록해주세요.");
		String tel = sc.nextLine();
		map.put("tel", tel);
		addP.setTel(map.get("tel"));
		
		System.out.println("주소를 등록해주세요.");
		String address = sc.nextLine();
		map.put("address", address);
		addP.setAddress(map.get("address"));
		
		phoneList.add(addP);
	}
	
	public void insertTel(){
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 멤버의 이름을 입력하세요.");
		String name = sc.nextLine();
		System.out.println("바꿀 전화번호를 입력하세요.");
		String tel = sc.nextLine();
		System.out.println("바꿀 주소를 입력하세요.");
		String address = sc.nextLine();
		for (int i = 0; i < phoneList.size(); i++) {
			if(name.equals(phoneList.get(i).getName())){
				phoneList.get(i).setTel(tel);
				phoneList.get(i).setAddress(address);
				System.out.println("수정이 완료되었습니다.");			
			}
		}
		
	}
	
	public void deleteTel(){
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 멤버의 이름을 입력하세요.");
		String name = sc.nextLine();
		for (int i = 0; i < phoneList.size(); i++) {
			if(name.equals(phoneList.get(i).getName())){
				phoneList.remove(i);
				System.out.println("삭제가 완료되었습니다.");
			}
		}
	}
	
	public void selectTel(){
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 멤버의 이름을 입력하세요.");
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
		System.out.println("번호" + "\t" + "이름" + "\t" + "전화번호" + "\t" + "주소");
		System.out.println("=========================");
		for (Phone phone : phoneList) {
			System.out.print(count++ + "\t");
			System.out.print(phone.getName() + "\t");
			System.out.print(phone.getTel() + "\t");
			System.out.print(phone.getAddress() + "\t");
			System.out.println();
		}
		System.out.println("=========================");
		System.out.println("출력완료...");		
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