package f_oop2;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnnoInner02 {
	public static void main(String[] args) {
		Button bt = new Button();
		bt.addActionListener(new ActionListener() {			//클래스만들고 인터페이스 구현하고 객체를 만들어 넣은것을 한꺼번에 처리해준다.  - 익명클래스
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼");
				
			}
		});
			
		Button bt1 = new Button();
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("눌러");
				
			}
		});
		
		
		
		
		
	}
}
