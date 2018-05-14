package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 	회원번호, 회원이름, 전화번호를 멤버변수로 갖고
 	회원이름을 기준으로 오름차순 정렬이 되는 Member클래스를 작성해 보자.
 */

public class ListSortTest2 {
	public static void main(String[] args) {
		
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "변학도", "010-2222-2222"));
		memList.add(new Member(9, "성춘향", "010-3333-3333"));
		memList.add(new Member(3, "이순신", "010-4444-4444"));
		memList.add(new Member(6, "강감찬", "010-5555-5555"));
		memList.add(new Member(2, "일지매", "010-6666-6666"));
		
		System.out.println("정렬전");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("----------------------------------------------");
		
		System.out.println("이름의 오름차순 정렬후");
		Collections.sort(memList);
		for (Member mem : memList) {
			System.out.println(mem);
		}
		
		//회원번호의 내림차순으로 정렬되는 외부정렬 기준을 적용하여 정렬한 후 결과를 출력하시오.
		System.out.println("회원번호 내림차순 정렬 후");
		Collections.sort(memList, new MemberDesc());
		for (Member mem : memList) {
			System.out.println(mem);
		}
		

	}
}

/*
	정렬과 관련된 interface는 Comparator와 Comparable 이렇게 두가지가 있다.
	
	보통 객체 자체에 정렬기능을 넣기 위해서는 Comparable을 구현하고 
	정렬기준을 별도로 구현하고 싶을 때는 Comparator를 구현하여 사용하면 된다.
	
	Comparable에서는 compareTo()메서드를 구현해야 하고,
	Comparator에서는 compare()메서드를 구현해야 한다.
 */

//회원 이름을 기준으로 오름차순 정렬이 될 수 있는 클래스 만들기
//Member클래스 자체에 정렬 기준을 넣는다.
class Member implements Comparable<Member>{			//애초에 클래스내에 정렬기준 넣어주는 방식이 있고, 외부정렬을 만들어서 해주는방식도 있다.
	private int num;
	private String name;
	private String te;
	
	public Member(int num, String name, String te) {
		super();
		this.num = num;
		this.name = name;
		this.te = te;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTe() {
		return te;
	}

	public void setTe(String te) {
		this.te = te;
	}
	
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", te=" + te + "]";
	}
	
	//이름을 기준으로 오름차순 정렬이 되도록 설정한다.
	@Override
	public int compareTo(Member mem) {
		return name.compareTo(mem.getName());
	}
}

//회원번호의 내림차순을 정렬할 수 있는 외부 정렬 기준
class MemberDesc implements Comparator<Member>{
	
	@Override
	public int compare(Member mem1, Member mem2) {
		
		/*
		// 이 메서드가 양수를 반환하면 두 값의 순서가 바뀐다.		
		if(mem1.getNum() > mem2.getNum()){
			return -1;
		}else if(mem1.getNum() < mem2.getNum()){
			return 1;
		}else{
			return 0;
		}
		*/
		
		//wrapper클래스를 이용하는 방법1
//		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		
		//wrapper클래스를 이용하는 방법2
		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;
		
	}
}


