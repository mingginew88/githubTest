package basic;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class ThreadTest07 {
/*
	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	컴퓨터의 가위 바위 보는 난수를 이용하여 구하고, 
	사용자의 입력은 showInputDialog()를 이용하여 입력받는다.
	입력시간은 5초로 제한하고 카운트다운을 징행한다.
	5초동안 입력이 없으면 게임을 진것으로 처리한다.
	
	5초안에 입력이 완료된면 승패를 출력한다.
	
	결과 예시>
	---- 결과 ----
	컴퓨터 : 가위
	당  신 : 바위
	결  과 : 당신이 이겼습니다.	
 */
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		DataInput2 th11 =new DataInput2();
		CountDown2 th22 = new CountDown2();
		
		th11.start();
		th22.start();
		
	}
}



class DataInput2 extends Thread{
	@Override
	public void run() {		
		while(true){
			String str = JOptionPane.showInputDialog("가위 바위 보 중 입력하세요.");
			
			System.out.println("나 : " + str);
			if(!(str.equals("가위")||str.equals("바위")||str.equals("보"))){
				System.out.println("잘못입력하였습니다.");
				continue;
			}	
			
			ThreadTest07.inputCheck = true;
			int computer = (int)(Math.random()*3);
			if(computer == 0){
				System.out.println("컴퓨터 : 가위");
			}else if(computer == 1){
				System.out.println("컴퓨터 : 바위");
			}else if(computer ==2){
				System.out.println("컴퓨터 : 보");
			}
			if(str.equals("가위")){
				if(computer == 0){
					System.out.println("비겼습니다.");
				}else if(computer == 1){
					System.out.println("졌습니다.");
				}else if(computer ==2){
					System.out.println("이겼습니다.");
				}
			}else if(str.equals("바위")){
				if(computer == 0){
					System.out.println("이겼습니다.");
				}else if(computer == 1){
					System.out.println("비겼습니다.");
				}else if(computer ==2){
					System.out.println("졌습니다.");
				}
			}else if(str.equals("보")){
				if(computer == 0){
					System.out.println("졌습니다.");
				}else if(computer == 1){
					System.out.println("이겼습니다.");
				}else if(computer ==2){
					System.out.println("비겼습니다.");
				}			
			}
			
			break;			
		}		
	}
}


class CountDown2 extends Thread{
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			if(ThreadTest07.inputCheck==true){
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}	
		System.out.println("졌습니다.");
		System.exit(0);
		//5초동안 입력 없다면.. 패배		
	}
	
}





