package test_object;

public class ScoreTest2 {
	public static void main(String[] args) {
		
		Students sts = new Students(4);
	}
}

class Student{	
	int subject = 4;
	String name;
	Score[] studentScore;
	
	Student(int subject){

	}		
		
	Student(){
		System.out.print(this.name + "\t");
		for(int i = 0; i < subject; i++){
			this.studentScore = new Score[subject];		//a = 과목이 될 예정
			this.studentScore[i] = new Score();
			System.out.print(this.studentScore[i].score + "\t");
		}
		System.out.println();
	}
			
}

class Students extends Student{
	int nameNumber = 5;
	int subjectNumber = 4;
	int studentNumber = nameNumber*subjectNumber;
	
	Students(){
		super();		
	}
	
	Students(int number){
		for(int i =0; i < number; i++){
			new Students();
		}
	}
}


class Score{
	int score;	

	Score(){
		this.score = (int)(Math.random()*101);
	}
}





