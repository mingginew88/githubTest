package basic;
/*
	���ٽ�(java 1.8���ĺ��� �����Ǵ� ���)
	
	���ٽ��̶�? ==> �͸��Լ��� �����ϱ� ���� ��
	
		�ڹٿ����� '�Ű������� ���� �ڵ� ��'�̶� �θ��� 
				��Ÿ�ӽÿ��� '�͸�����ü'�� �����ȴ�.
				
	�⺻����)
		�������̽��� ������ = ���ٽ�;
		
	���ٽ� ����)
		(�ڷ����̸� ������, ...) -> {���๮;}
		
	**���ٽ����� ��ȯ�� �� �ִ� �������̽�(�Լ��� �������̽�)
		==> �ϳ��� �߻�޼��尡 ����� �������̽�
		
	**���ٽ� ����Ģ
	1. '�ڷ����̸�'�� ������ �� �ִ�.
		(int a) -> { System.out.println(a); }
		(a) -> { System.out.println(a); }
	
	2. �Ű������� 1���̸� '(',')' (��ȣ)�� ������ �� �ִ�.
		a -> { System.out.println(a); }		
	
	3. ���๮�� 1���̸� '{', '}'�� ������ �� �ִ�.
		a -> System.out.println(a)
		
	4. �Ű������� �ϳ��� ������ ()������ �� ����.
		() -> System.out.println("�ȳ�")
		
	5. ��ȯ���� ������ return����� ����Ѵ�.
		(a, b) -> { return a+b; }
		(a, b) -> return a+b
		
	6. ���๮�� return��� 1���� ����� ��� {} �� return����� ������ �� �ִ�.
		(a, b) -> a+b
		
		
	
	function kk(){
		alert('');
	}
	
	(�͸��Լ�)
	var aa = function(){
		alert('');
	}
 */
public class LambdaTest01 {
	public static void main(String[] args) {
		//�����带 ó���ϴ� ���� ���ٽ����� �ۼ��ϱ�
		
		//���ٽ��� ������� ���� ���
		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println(i);
					
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {	}
				}				
			}
		});		
		
		th1.start();
		
		//���ٽ��� ����� ���
		Thread th2 = new Thread( ()->{
			for (int i = 1; i <= 10; i++) {
				System.out.println("����-" + i);
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {	}
			}
		});	
		
		th2.start();
		
		
		
//		Runnable aa = new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}
//		};
	}	
}
