package basic;

public class LambdaTest02 {
	public static void main(String[] args) {
		//���ٽ��� ������� ���� ��
		LambdaTestInterface t1 = new LambdaTestInterface() {
			
			@Override
			public void test() {
				System.out.println("�ȳ��ϼ���.");
			}
		};
		t1.test();
		
		//���ٽ�����
		LambdaTestInterface t2 = () -> {
			System.out.println("�ȳ��ϼ���. ���ٽ�!!");
		};		
		t2.test();
		
		
		LambdaTestInterface t3 = () -> System.out.println("�ȳ��ϼ���. ���ٽ� 2!!");
		t3.test();
		
		
		LambdaTestInterface2 lt1 = (int a) -> { 
			int result = a +20;
			System.out.println("result : " + result);
		};
		lt1.test(5);
		
		
		LambdaTestInterface2 lt2 = (a) -> { 
			int result = a*20;
			System.out.println("result : " + result);
		};
		lt2.test(7);		
		
		
		LambdaTestInterface2 lt3 = a -> { 
			int result = a/2;
			System.out.println("result : " + result);
		};
		lt3.test(22);
		
		
		LambdaTestInterface3 tr1 = (int a, int b) -> {
			return a+b; 
			};
		int c = tr1.test(3, 7);
		System.out.println("c : " + c);
		
		
		
		LambdaTestInterface3 tr2 = (a, b) -> { return a+b; };
		int d = tr2.test(3, 7);
		System.out.println("d : " + d);
		
		
		LambdaTestInterface3 tr3 = (a, b) -> a+b;
		int e = tr3.test(3, 7);
		System.out.println("e : " + e);
		
		
		
	}

}
