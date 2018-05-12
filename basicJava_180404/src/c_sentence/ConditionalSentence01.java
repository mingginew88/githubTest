package c_sentence;

public class ConditionalSentence01 {
	
	public static void main(String[] args) {
		
		/*
		 1. 조건문 (if, switch)
		   - 조건식과 문장을 포함하는 블럭{} 으로 구성되어 있다.
		   - 조건식의 결과에 따라서 프로그램 실행 흐름을 변경할 수 있다.
		   
		 2. if문
		   - 구조
		     1) 기본
		      if(조건식) {
		      	수행될 문장.
		      }
		      
		     2) 변형
		      if(조건식) {
		      	조건식이 true일때 수행될 문장.
		      } else {
		      	조건식이 false일때 수행될 문장.
		      }
		      
		     3) 변형2
		      if(조건식1) {
		      	조건식1이 true일때 수행될 문장.
		      } else if(조건식2) {
		      	조건식1이 false이고 조건식2가 true일떄 수행될 문장.		
		      } else {
		        조건식1이 false이고 조건식2도 false일때 수행될 문장. 
		      }
		      
		      
		  */
		
		int a = 10;
		if(a > 0) {
			System.out.println("양수");
		} else if( a < 0){
			System.out.println("음수");
		} else {
			System.out.println("0");
		}
		
		
		//1. 0~100점사이의 랜덤한 정수값을 저장하세요(score)
		
		//2. score의 값이 90이상이면 "A"를 출력하세요.
		//   score의 값이 80이상이면 "B"를 출력하세요.
		//   score의 값이 70이상이면 "C"를 출력하세요.
		//   score의 값이 60이상이면 "D"를 출력하세요.
		//   score의 값이 60미만이면 "나가"를 출력하세요.
		
		
		int score = (int)(Math.random()*101);
		System.out.println("what's your score? : " + score);
		if(score >= 90) {
			System.out.print("A");
			if(score >= 95) {
				System.out.println("+");
			} else {
				System.out.println("-");
			}
		} else if(score >= 80) {
			System.out.print("B");
			if(score >= 85) {
				System.out.println("+");
			} else {
				System.out.println("-");
			}
		} else if(score >= 70) {
			System.out.print("C");
			if(score >= 75) {
				System.out.println("+");
			} else {
				System.out.println("-");
			}
		} else if(score >= 60) {
			System.out.print("D");
			if(score >= 65) {
				System.out.println("+");
			} else {
				System.out.println("-");
			}			
		} else {
			System.out.println("나가");
		}
		
		/*
		 3. switch문
		   - 조건의 경우의 수가 많을 경우 if문 보다는 switch문을 사용한다.
		   - 조건의 결과값으로 int형 범위의 정수를 허용한다.
		   - 구조
		   
		     switch(조건식) {
		     
		     case 값1 :
		        조건식과 값1이 같을 경우
		       break;
		     case 값2 :
		        조건식과 값2이 같을 경우
		       break;
		     default :
		        조건식과 일치하는 값이 없을경우 수행
		       break;	       
		     }	 
		 */
		
		int b = 2;
		switch(b) {
		case 1 : 
			System.out.println("1");
			break;
		case 2 :
			System.out.println("2");
			break;
		default :
			System.out.println("1 또는 2가 아니다.");
			break;
		}
		
		//1. 1~5사이의 랜덤한 정수값을 저장할수 있는 변수(result)를 선언 및 초기화 하세요.
		
		//2. result의 값이 5인경우에는 "24평 집 당첨"
		//2. result의 값이 4인경우에는 "국산차 당첨"
		//2. result의 값이 3인경우에는 "gram 당첨"
		//2. result의 값이 2인경우에는 "기계식 키보드 당첨"
		//2. result의 값이 1인경우에는 "27평 집 내놔"
		
		int result = (int)(Math.random()*5 + 1);
		System.out.println("당신의 당첨번호는 : " + result);
		switch(result) {
			case 1 :
				System.out.println("27평 집 내놔");
				break;
			case 2 :
				System.out.println("기계식 키보드 당첨");
				break;
			case 3 :
				System.out.println("gram 당첨");
				break;
			case 4 :
				System.out.println("국산차 당첨");
				break;
			default  :
				System.out.println("24평 집 당첨");
				break;			
		}
		
		
		int score2 = (int)(Math.random()*101);
		System.out.println("당신의 점수는 : " + score2);
				
		switch(score2/10) {
		case 6 : 
			System.out.println("D");
			break;
		case 7 : 
			System.out.println("C");
			break;
		case 8 : 
			System.out.println("B");
			break;
		case 9 : case 10 :	
			System.out.println("A");
			break;
		default :
			System.out.println("나가");
			break;					
		}
		

		
	}

}
