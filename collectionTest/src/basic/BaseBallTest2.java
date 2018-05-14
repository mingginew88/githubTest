package basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BaseBallTest2 {
	int[] num = new int[3];		//난수를 저장할 배열
	int[] user;		//사용자가 입력한 값을 저장할 배열
	int strike;		//스트라이크 수
	int ball;		//볼의 수
	Scanner sc = new Scanner(System.in);
	
	//1-9 사이의 서로 다른 난수 3개를 만들어서 배열에 저장하는 메서드
	//Set 이용
	public void getNum(){
		Set<Integer> bbNum = new HashSet<Integer>();
		
		//Set을 이용한 3개의 난수 만들기
		while(bbNum.size() < 3){
			bbNum.add((int)(Math.random()*9 + 1));			
		}
		
		//Set의 값들을 배열에 담기
		Iterator<Integer> it = bbNum.iterator();
		int i = 0;		//배열의 첨자 역할을 할 변수
		while(it.hasNext()){
			num[i++] =it.next();
		}
		
		//데이터 섞기
		for (int j = 0; j <= 100; j++) {
			int rnd = (int)(Math.random()*num.length);
			int temp = num[rnd];
			num[rnd] = num[0];
			num[0] = temp;			
		}		
	}//End getNum()
	//------------------------------------------------
	
	//사용자로부터 3개의 정수를 입력받아 배열에 저장하는 메서드
	public void inputNum(){
		int n1, n2, n3;		//입력한 값을 저장할 변수
		
		do{
			System.out.print("중복되지 않은 정수 3개 입력 => ");
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			n3 = sc.nextInt();
			
			if(n1==n2 || n2==n3 || n3==n1){
				System.out.println("중복되는 숫자는 입력할 수 없습니다.");
				System.out.println("다시 입력하세요.");
			}
		}while(n1==n2 || n2==n3 || n3==n1);		//중복검사 정상입력안되면 반복, 정상입력되면 빠져나옴
		
		//입력한 값을 배열에 저장
		user = new int[]{n1, n2, n3};
	}//End inputNum()
	//------------------------------------------------
	
	//스트라이크, 볼을 판정하여 출력하는 메서드
	public void ballCount(){
		strike = 0;
		ball = 0;			//스트라이크와 볼 초기화
		
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < user.length; j++) {
				if(num[i] == user[j]){		//같이 같은지 비교
					if(i==j){
						strike++;
					}else{
						ball++;
					}
				}
			}
		}
		System.out.println(user[0] + " " + user[1] + " " + user[2] + " ==> " + strike + "S " + ball + "B");
		
	}//End ballCount()
	//------------------------------------------------
	
	//게임을 진행하는 메서드
	public void gameStart(){
		getNum();//난수 만드는 메서드 호출
//		System.out.println("확인용 난수 : " + Arrays.toString(num));
		
		int cnt = 0; // 몇번만에 맞췄는지를 저장하는 변수
		
		do{
			cnt++;
			inputNum();		//사용자 입력 메서드 호출
			ballCount();	//볼 카운트하는 메서드 호출
		}while(strike!=3);
		System.out.println(cnt + "번째만에 맞췄군요!!!");
	}
	
	
	public static void main(String[] args) {
		
//		BaseBallTest2 bbt = new BaseBallTest2();
//		bbt.gameStart();
		new BaseBallTest2().gameStart();
		
	}

}
