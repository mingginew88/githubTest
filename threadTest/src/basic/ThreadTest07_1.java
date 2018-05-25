package basic;

import javax.swing.JOptionPane;

public class ThreadTest07_1 {
	//입력여부를 나타내는 변수
	public static boolean inputCheck = false;
	
	
	public static void main(String[] args) {
		GameTimer gt = new GameTimer();
		
		//난수를 이용하여 컴퓨터의 가위, 바위, 보 정하기
		String[] data = {"가위", "바위", "보"};
		int index = (int)(Math.random()*3); //0~2사이의 난수 만들기
		String com = data[index];
		
		//사용자로부터 가위 바위 보 입력 받기
		String man = null;
		gt.start();
		
		do{
			man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
		}while(man == null || (!man.equals("가위") && !man.equals("바위") && !man.equals("보")));
		
		inputCheck = true;
		
		//결과판정하기
		String result = "";
		if(com.equals(man)){
			result = "비겼습니다.";
		}else if(man.equals("가위") && com.equals("보") || man.equals("바위") && com.equals("가위") || man.equals("보") && com.equals("바위")){
			result = "당신이 이겼습니다.";
		}else{
			result = "당신이 졌습니다.";
		}
		
		//결과 출력
		System.out.println("--- 결  과 ---");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + man);
		System.out.println("결  과 : " + result);		
	}

}

//카운트다운
class GameTimer extends Thread{	
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {			
			System.out.println(i);
			if(ThreadTest07_1.inputCheck==true){
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {				
			}
		}
		System.out.println("시간이 초과되어 당;신이 졌습니다.");
		System.exit(0);
	}//End run()
}
