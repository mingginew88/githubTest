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
		
		db.addScore(scoreMap);
	}
	
	
	private void checkScore(Database db){
		while(true){
			Scanner sc = new Scanner(System.in);	
			
			System.out.println("�̸�\t ����\t ����\t ���� \t ����\t ����\t");
			for (int i = 0; i < db.getScoreList().size(); i++) {
				System.out.print(db.getScoreList().get(i).getName() + "\t");
				System.out.print(db.getScoreList().get(i).getKorean() + "\t");
				System.out.print(db.getScoreList().get(i).getEnglish() + "\t");
				System.out.print(db.getScoreList().get(i).getMath() + "\t");
				System.out.print(db.getScoreList().get(i).getScore() + "\t");	
				System.out.print(i+1 + "\t");
				System.out.println();
			}
			
			System.out.println("1.�ڷΰ���");
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (Exception e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				continue;
			}
			
			switch (input) {
			case 1:	
				return;
			default:
				System.out.println("��Ͽ� �ִ� ��ȣ�� �������ּ���.");
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
		return name.compareTo(o.name);	//�ϴ� �̸� ��������
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




