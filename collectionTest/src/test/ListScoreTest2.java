package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/*
	성적을 입력하고 조회하는 프로그램을 ArrayList를 이용하여 작성하시오.
	
	조건 : 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 저장할 수 있는 ScoreVO를 만들어서 처리한다.
	(입력은 이름, 국어점수, 영어점수, 수학점수만 하고 총점은 계산하여 저장한다.)
	(등수는 입력이 모두 완료된 후에 처리 할 수 있도록 메서드로 구현한다.)
	(ScoreVO는 총점의 역순으로 정렬되는 기본 정렬 기준 적용하여 작성한다. 
	그리고 총점이 같으면 이름의 오름차순으로 정렬되도록한다.)
	
	메뉴예시 
	
	==========================
			성적 입력 조회 프로그램
	==========================
	1. 성적 입력
	2. 성적 조회
	3. 종료
	==========================
	메뉴 선택 >
*/

public class ListScoreTest2 {
	public static void main(String[] args) {
		View v = new View();
		v.start();

	}
}



class View{
	void start(){		
		while(true){
			ScoreVO sv = new ScoreVO();
			Scanner sc = new Scanner(System.in);
			System.out.println("==========================");
			System.out.println("\t성적 입력 조회 프로그램");
			System.out.println("==========================");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 조회");
			System.out.println("3. 종료");
			System.out.println("==========================");
			System.out.println("메뉴 선택 > ");
			
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못 입력하였습니다.");
			}
			
			switch (input) {
			case 1:
				inputScore();
				break;
			case 2:
				checkScore();
				break;
			case 3:
//			End();
				break;
			default:
				break;			
			}			
		}
		
		
	}	
	
	private void inputScore(){
		Scanner sc = new Scanner(System.in);
		Database db = new Database();
		Map<String, Object> scoreMap = new HashMap<String, Object>();
		System.out.println("이름 : ");
		String name = sc.nextLine();
		scoreMap.put("name", name);
		
		System.out.println("국어 : ");
		int korean = sc.nextInt();
		scoreMap.put("korean", korean);
		
		System.out.println("영어 : ");
		int english = sc.nextInt();
		scoreMap.put("english", english);
		
		System.out.println("수학 : ");
		int math = sc.nextInt();
		scoreMap.put("math", math);
		db.inputScore(scoreMap);		
	}
	
	private void checkScore(){		
		ScoreVO sv = new ScoreVO();
		Map<String, Object> scoreMap = new HashMap<String, Object>();

		System.out.println(scoreMap.get("name"));
		System.out.println(scoreMap.get("korean"));
		System.out.println(scoreMap.get("english"));
		System.out.println(scoreMap.get("math"));
		System.out.println(scoreMap.get("score"));
		
		System.out.println(sv.getName());
		System.out.println(sv.getKorean());
	}

}


class Database{
	Map<String, Object> scoreMap = new HashMap<String, Object>();
	
	public void inputScore(Map<String, Object> scoreMap){
		ScoreVO sv = new ScoreVO();
		sv.setName((String)scoreMap.get("name"));
		sv.setKorean((int)scoreMap.get("korean"));
		sv.setEnglish((int)scoreMap.get("english"));
		sv.setMath((int)scoreMap.get("math"));
		int score = (int)scoreMap.get("korean") +(int)scoreMap.get("english") + (int)scoreMap.get("math");
		sv.setScore(score);		
	}	
	
}


class ScoreVO{
	private String studentNo;
	private String name;
	private int korean;
	private int english;
	private int math;
	private int score;
	private int rank;


	public String getStudnetNo() {
		return studentNo;
	}
	public void setStudnetNo(String studnetNo) {
		this.studentNo = studnetNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	@Override
	public String toString() {
		return "ScoreVO [name=" + name + ", korean=" + korean + ", english="
				+ english + ", math=" + math + ", score=" + score + ", rank="
				+ rank + "]";
	}
	
}








