package basic;

public class LambdaTest03 {
	
	//�޼����� �Ű������� �� �޼����� ���������̴�.
	public void testMethod(final int temp) {
		final int localVar = 40;		//final�� �ٿ������ʾƵ� �����ϰ������� �������� final�� �ٿ��ִ°��� ����.
		int kor = 100;
		
		kor = 200;
		//localVar = 30;
		//temp = 80;
		//���ٽ� ���ο��� ���Ǵ� ���������� final�̾��� �Ѵ�.
		//���� final�� ������ ������ �����Ϸ��� final�� �ٿ��ش�.
		//�׷����� final�� ������ ���� �������� �����ϸ� final�� �ڵ����� �ٿ����� �ʴ´�.
		
		
		//���ٽ�
		LambdaTestInterface lt = ()->{
			//���ٽ� ���ο��� �������� ����ϱ�
			System.out.println("temp = " + temp);
			System.out.println("localVar = " + localVar);			
		};
		lt.test();
	}
	
	
	
	
	
	public static void main(String[] args) {
		new LambdaTest03().testMethod(50);
	}

}
