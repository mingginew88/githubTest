package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

public class ListScoreTest {
	
	public static void main(String[] args) {
		View v = new View();
		v.start();

	}
}



class View{
	Database db = new Database();
	void start(){	
		while(true){			
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
				inputScore(db);
				break;
			case 2:
				checkScore(db);
				break;
			case 3:				
				return;
			default:
				break;			
			}
		}

	}	
	
	private void inputScore(Database db){		
		Scanner sc = new Scanner(System.in);
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
		
		db.addScore(scoreMap);
	}
	
	
	private void checkScore(Database db){
		while(true){
			Scanner sc = new Scanner(System.in);	
			
			System.out.println("이름\t 국어\t 영어\t 수학 \t 총점\t 석차\t");
			for (int i = 0; i < db.getScoreList().size(); i++) {
				System.out.print(db.getScoreList().get(i).getName() + "\t");
				System.out.print(db.getScoreList().get(i).getKorean() + "\t");
				System.out.print(db.getScoreList().get(i).getEnglish() + "\t");
				System.out.print(db.getScoreList().get(i).getMath() + "\t");
				System.out.print(db.getScoreList().get(i).getScore() + "\t");	
				System.out.print(i+1 + "\t");
				System.out.println();
			}
			
			System.out.println("1.뒤로가기");
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못 입력하였습니다.");
				continue;
			}
			
			switch (input) {
			case 1:	
				return;
			default:
				System.out.println("목록에 있는 번호를 선택해주세요.");
				continue;
			}
		}
	}
}


class Database{
	private List<ScoreVO> scoreList = new ArrayList<ScoreVO>();
	
	public void addScore(Map<String, Object> scoreMap){
		ScoreVO addscore = new ScoreVO();
		
		addscore.setName((String)scoreMap.get("name"));
		addscore.setKorean((int)scoreMap.get("korean"));
		addscore.setEnglish((int)scoreMap.get("english"));
		addscore.setMath((int)scoreMap.get("math"));	
		
		scoreList.add(addscore);
		Collections.sort(scoreList, new ScoreAsc());
		
		for (int i = 0; i < scoreList.size() -1; i++) {
			if(scoreList.get(i) == scoreList.get(i+1)){
				Collections.sort(scoreList);
			}
		}	
	}

	
	public List<ScoreVO> getScoreList() {
		return scoreList;
	}

	public void setScoreList(List<ScoreVO> scoreList) {
		this.scoreList.add((ScoreVO) scoreList);
	}	
}


class ScoreVO implements Comparable<ScoreVO>{
	private String name;
	private int korean;
	private int english;
	private int math;
	private int score;
	private int rank;
	
	
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
		return this.korean + this.english + this.math;
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
	@Override
	public int compareTo(ScoreVO o) {
		return name.compareTo(o.name);	//일단 이름 오름차순
	}
	
}



class ScoreAsc implements Comparator<ScoreVO>{

	@Override
	public int compare(ScoreVO o1, ScoreVO o2) {
		if(o1.getScore() > o2.getScore()){
			return -1;
		}else if(o1.getScore() < o2.getScore()){
			return 1;
		}else{
			return 0;
		}		
	}	
}




