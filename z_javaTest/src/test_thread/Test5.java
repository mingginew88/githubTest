package test_thread;

import javax.swing.JOptionPane;

//가위바위보 게임 만들기


public class Test5 {
	public static boolean inputCheck = false;
	public static String inputValue = "";
	
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new Test12());
		Test13 th2 = new Test13();
		
		int com = (int)(Math.random()*3);
		String strCom = "";
		if(com == 0){
			strCom = "가위";
		}else if(com == 1){
			strCom = "바위";
		}else{
			strCom = "보";
		}
				
		th2.start();
		th1.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {}
		
		System.out.println("결과");
		System.out.println("컴퓨터 : " + strCom);
		System.out.println("본   인 : " + Test5.inputValue);
		
		if(Test5.inputValue.equals(strCom)){
			System.out.println("비겼습니다.");
		}else if(strCom.equals("가위")&&Test5.inputValue.equals("바위")||strCom.equals("바위")&&Test5.inputValue.equals("보")||strCom.equals("보")&&Test5.inputValue.equals("가위")){
			System.out.println("이겼습니다.");
		}else{
			System.out.println("졌습니다.");
		}
	}
}

//카운트다운 하는클래스
class Test12 implements Runnable{
	@Override
	public void run() {
		for (int i = 10; i > 0 ; i--) {
			if(Test5.inputCheck == true){
				return;
			}			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		System.exit(0);		
	}
}

//입력하는 곳 
class Test13 extends Thread{
	@Override
	public void run() {
		String str = null;
		do{
			str = JOptionPane.showInputDialog("가위 바위 보 중에 입력해주세요.");
		}while(str==null||!(str.equals("가위")||str.equals("바위")||str.equals("보")));
		Test5.inputCheck = true;
		Test5.inputValue = str;		
				
	}
}


