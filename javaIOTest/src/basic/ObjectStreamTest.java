package basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreamTest {
	public static void main(String[] args) {
		
		Member mem1 = new Member("홍길동", 40, "서울");
		Member mem2 = new Member("이순신", 20, "부산");
		Member mem3 = new Member("일지매", 30, "공주");
		Member mem4 = new Member("강감찬", 50, "옥천");
		
		//객체를 파일에 저장하기
		try {
			//출력용 스트림 객체 생성
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:/D_Other/memObj.bin")));
			
			//쓰기 작업(파일에 저장하기)
			oos.writeObject(mem1);
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			
			System.out.println("쓰기 작업 완료...");
			oos.close();		//스트림닫기
			
			//저장된 객체 읽어오기
			
			//입력용 스트림객체 생성			
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("D:/D_Other/memObj.bin")));
			
			Object obj = null;		//읽어올 객체를 저장할 변수
			
			while((obj=ois.readObject()) != null){
				// 읽어온 데이터를 원래의 객체형으로 변환한 후 사용한다.
				Member mem = (Member)obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("-------------------");
			}			
			ois.close();	//스트림닫기
			
		} catch (IOException | ClassNotFoundException e) {}
	}
}

//저장용 클래스 만들기(직렬화가 가능한 클래스 만들기)
class Member implements Serializable{
	private String name;
	private int age;
	private String addr;
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
