package f_oop2;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnnoInner01 {
	public static void main(String[] args) {
		Button bt = new Button();
		ActionListener al = new EventHandler();
		bt.addActionListener(al);
	}

}

class EventHandler implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼눌림");		
	}	
}


