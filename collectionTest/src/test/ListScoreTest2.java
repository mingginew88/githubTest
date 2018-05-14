package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/*
	������ �Է��ϰ� ��ȸ�ϴ� ���α׷��� ArrayList�� �̿��Ͽ� �ۼ��Ͻÿ�.
	
	���� : �̸�, ��������, ��������, ��������, ����, ����� ������ �� �ִ� ScoreVO�� ���� ó���Ѵ�.
	(�Է��� �̸�, ��������, ��������, ���������� �ϰ� ������ ����Ͽ� �����Ѵ�.)
	(����� �Է��� ��� �Ϸ�� �Ŀ� ó�� �� �� �ֵ��� �޼���� �����Ѵ�.)
	(ScoreVO�� ������ �������� ���ĵǴ� �⺻ ���� ���� �����Ͽ� �ۼ��Ѵ�. 
	�׸��� ������ ������ �̸��� ������������ ���ĵǵ����Ѵ�.)
	
	�޴����� 
	
	==========================
			���� �Է� ��ȸ ���α׷�
	==========================
	1. ���� �Է�
	2. ���� ��ȸ
	3. ����
	==========================
	�޴� ���� >
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
			System.out.println("\t���� �Է� ��ȸ ���α׷�");
			System.out.println("==========================");
			System.out.println("1. ���� �Է�");
			System.out.println("2. ���� ��ȸ");
			System.out.println("3. ����");
			System.out.println("==========================");
			System.out.println("�޴� ���� > ");
			
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
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
		System.out.println("�̸� : ");
		String name = sc.nextLine();
		scoreMap.put("name", name);
		
		System.out.println("���� : ");
		int korean = sc.nextInt();
		scoreMap.put("korean", korean);
		
		System.out.println("���� : ");
		int english = sc.nextInt();
		scoreMap.put("english", english);
		
		System.out.println("���� : ");
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








