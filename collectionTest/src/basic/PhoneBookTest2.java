package basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
	Scanner의 자료 입력관련 정보
	
	- next(), next자료형이름()등의 메서드들을 화이트스페이스(엔터키, 탭키, 공백)을 기준으로 데이터를 분해해서 입력받는다.
	- 입력한 데이터들은 변수에 저장되기 전에 입력버퍼에 먼저 기억된 후에 처리된다.
	
	- nextLine() => 입력버퍼에 있는 모든 데이터를 가져온다.(엔터키값도 읽어온다.)
	
	- 전화번호 정보가 저장될 파일명 : "D:/D_Other/phoneBook.dat"
	- 이 프로그램이 시작되면 우선 전화번호 정보를 읽어와 phoneBookMap에 저장한다.
	- 6.전화번호 정보 저장메뉴를 선택하면 Map에 있는 정보를 파일로 저장한다.
 */


public class PhoneBookTest2 {
	private Scanner scan;
	private HashMap<String, Phone2> phoneBookMap;
	
	public PhoneBookTest2(){
		scan = new Scanner(System.in);
		phoneBookMap = new HashMap<String, Phone2>();
	}
	
	//메뉴를 출력하고 선택된 메뉴 번호를 반환하는 메서드
	public int getMenu(){
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println(" 1. 전화번호 등록");
		System.out.println(" 2. 전화번호 수정");
		System.out.println(" 3. 전화번호 삭제");
		System.out.println(" 4. 전화번호 검색");
		System.out.println(" 5. 전화번호 전체 출력");
		System.out.println(" 6. 전화번호 정보 저장");
		System.out.println(" 0. 프로그램 종료");
		System.out.println("-----------------------------");
		System.out.print("   번호 입력 >>  ");
		int num = scan.nextInt();
		return num;
	}
	
	//프로그램의 작업을 시작하는 메서드
	public void start(){		
		readData();	
		
		System.out.println("=============================");
		System.out.println("전화번호 관리 프로그램");
		System.out.println("=============================");
		
		while(true){
			int menuNum = getMenu();
			
			switch (menuNum) {
			case 1:	
				insert();	//등록하는 메서드
				break;
			case 2:	
				update();	//수정하는 메서드
				break;
			case 3:
				delete();	//삭제하는 메서드
				break;
			case 4:
				search();	//검색하는 메서드
				break;
			case 5:
				displayAll();	//전체자료 출력하는 메서드
				break;
			case 6:
				savaData();	//전화번호 정보 저장
				break;				
			case 0:		//프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시 입력하세요.");
			}					
		}
	}
	//====================================
	
	//새로운 전화번호 정보를 등록하는 메서드
	//이미 등록된 사람은 등록되지 않는다.
	public void insert(){
		System.out.println("등록할 새로운 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		//입력한 이름이 등록되었는지 검사
		if(phoneBookMap.containsKey(name)){
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
		}
		
		System.out.println("전화번호 >> ");
		String tel = scan.next();
		
		scan.nextLine();		//입력버퍼의 내용을 비워주는 역할을 한다.
		System.out.println("주소 >> ");
		String addr = scan.nextLine();
		
		//입력한 정보를 Map에 추가한다.
//		phoneBookMap.put(name, new Phone2(name, addr, tel));
		Phone2 p = new Phone2(name, addr, tel);
		phoneBookMap.put(name, p);
		
	}
	//====================================
	
	// 전화번호 정보를 수정하는 메서드
	public void update(){
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		System.out.println("이름 >> ");
		String name = scan.next();
		
		if(!(phoneBookMap.containsKey(name))){
			System.out.println(name + "씨는 등록되지 않았습니다.");
			return;
		}
		
		System.out.println("수정할 전화번호 >> ");
		String tel = scan.next();
		
		System.out.println("수정할 주소 >> ");
		String addr = scan.next();
		
		phoneBookMap.put(name, new Phone2(name, addr, tel));
		System.out.println(name + "씨의 정보 수정완료...");
	}
	
	public void displayAll(){
		System.out.println();
		System.out.println("=============================");
		System.out.println("번호    이름     전화번호       주소");
		System.out.println("=============================");
		
		if(phoneBookMap.size()==0){
			System.out.println("등록된 정보가 하나도 없습니다.");
		}else{
			Set<String> keyset = phoneBookMap.keySet();
			
			Iterator<String> it = keyset.iterator();
			
			int cnt = 0;
			while(it.hasNext()){
				cnt++;
				String name = it.next();
				Phone2 p = phoneBookMap.get(name);
				System.out.println(cnt + "\t" + p.getName() + "\t" + p.getTel() + "\t" + p.getAddr());
			}//while
		}//if
		System.out.println("=============================");
		System.out.println("출력 끝...");
	}
	//====================================
	
	//전화번호 정보를 삭제하는 메서드
	public void delete(){
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.println("이름 >> ");
		String name = scan.next();
		
		if(!phoneBookMap.containsKey(name)){
			System.out.println(name + "씨 데이터는 없습니다.");
			return;
		}
		
		phoneBookMap.remove(name);
		
		System.out.println(name + "씨 정보 삭제완료...");
	}
	
	//전화번호 정보를 검색하는 메서드
	public void search(){
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.println("이름 >> ");
		String name = scan.next();
		
		if(phoneBookMap.containsKey(name)){
			System.out.println(name + "씨 데이터는 없습니다.");
			return;
		}
		
		Phone2 p = phoneBookMap.get(name);
		System.out.println(name + "씨의 전화번호 정보");
		System.out.println("이    름 : " + p.getName());
		System.out.println("전화번호 : " + p.getTel() );
		System.out.println("주    소 : " + p.getAddr());
		System.out.println("=============================");
		System.out.println("출력 끝...");
	}
	
	//전체전화번호 정보를 읽어오는 메서드
	public void readData(){
		File file = new File("D:/D_Other/phoneBook.dat");
		if(file.exists()){
			try {
				ObjectInputStream ois =new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
				
				Object obj = ois.readObject();
				if(obj==null){
					phoneBookMap = new HashMap<String, Phone2>();
				}else{
					phoneBookMap = (HashMap<String, Phone2>) obj;
				}
				System.out.println("읽기 작업 완료");
				System.out.println();
				
			} catch (IOException | ClassNotFoundException e) {
			}
		}		
	}	
	
	//전체 전화번호 정보를 저장하는 메서드
	public void savaData(){
		try {
			if(phoneBookMap==null){
				System.out.println("저장할 자료가 없습니다.");
				return;
			}
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:/D_Other/phoneBook.dat")));
			
			oos.writeObject(phoneBookMap);
			System.out.println("전화번호 정보를 저장했습니다.");			
			oos.close();
		} catch (IOException e) {}
	}

	
	public static void main(String[] args) {	
		new PhoneBookTest2().start();
	}

}

//하나의 전화번호 정보 즉, 이름, 주소, 전화번호를 가지는 클래스 정의
class Phone2 implements Serializable{
	private String name;
	private String addr;
	private String tel;
	
	
	public Phone2(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}	
	
	@Override
	public String toString() {
		return "Phone2 [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}
	
}