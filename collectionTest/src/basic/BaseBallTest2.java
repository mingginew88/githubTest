package basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BaseBallTest2 {
	int[] num = new int[3];		//������ ������ �迭
	int[] user;		//����ڰ� �Է��� ���� ������ �迭
	int strike;		//��Ʈ����ũ ��
	int ball;		//���� ��
	Scanner sc = new Scanner(System.in);
	
	//1-9 ������ ���� �ٸ� ���� 3���� ���� �迭�� �����ϴ� �޼���
	//Set �̿�
	public void getNum(){
		Set<Integer> bbNum = new HashSet<Integer>();
		
		//Set�� �̿��� 3���� ���� �����
		while(bbNum.size() < 3){
			bbNum.add((int)(Math.random()*9 + 1));			
		}
		
		//Set�� ������ �迭�� ���
		Iterator<Integer> it = bbNum.iterator();
		int i = 0;		//�迭�� ÷�� ������ �� ����
		while(it.hasNext()){
			num[i++] =it.next();
		}
		
		//������ ����
		for (int j = 0; j <= 100; j++) {
			int rnd = (int)(Math.random()*num.length);
			int temp = num[rnd];
			num[rnd] = num[0];
			num[0] = temp;			
		}		
	}//End getNum()
	//------------------------------------------------
	
	//����ڷκ��� 3���� ������ �Է¹޾� �迭�� �����ϴ� �޼���
	public void inputNum(){
		int n1, n2, n3;		//�Է��� ���� ������ ����
		
		do{
			System.out.print("�ߺ����� ���� ���� 3�� �Է� => ");
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			n3 = sc.nextInt();
			
			if(n1==n2 || n2==n3 || n3==n1){
				System.out.println("�ߺ��Ǵ� ���ڴ� �Է��� �� �����ϴ�.");
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		}while(n1==n2 || n2==n3 || n3==n1);		//�ߺ��˻� �����Է¾ȵǸ� �ݺ�, �����ԷµǸ� ��������
		
		//�Է��� ���� �迭�� ����
		user = new int[]{n1, n2, n3};
	}//End inputNum()
	//------------------------------------------------
	
	//��Ʈ����ũ, ���� �����Ͽ� ����ϴ� �޼���
	public void ballCount(){
		strike = 0;
		ball = 0;			//��Ʈ����ũ�� �� �ʱ�ȭ
		
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < user.length; j++) {
				if(num[i] == user[j]){		//���� ������ ��
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
	
	//������ �����ϴ� �޼���
	public void gameStart(){
		getNum();//���� ����� �޼��� ȣ��
//		System.out.println("Ȯ�ο� ���� : " + Arrays.toString(num));
		
		int cnt = 0; // ������� ��������� �����ϴ� ����
		
		do{
			cnt++;
			inputNum();		//����� �Է� �޼��� ȣ��
			ballCount();	//�� ī��Ʈ�ϴ� �޼��� ȣ��
		}while(strike!=3);
		System.out.println(cnt + "��°���� ���豺��!!!");
	}
	
	
	public static void main(String[] args) {
		
//		BaseBallTest2 bbt = new BaseBallTest2();
//		bbt.gameStart();
		new BaseBallTest2().gameStart();
		
	}

}
