package singleton;

public class SingletonTest {
	public static void main(String[] args) {
		// ����(�����ڰ� private�̶� �ܺο��� new����� ������� ���Ѵ�.
//		MySingleton sss1 = new MySingleton();
		
		MySingleton sss2 = MySingleton.getInstance();
		MySingleton sss3 = MySingleton.getInstance();
		MySingleton sss4 = MySingleton.getInstance();
		
		
		//�������� �����ϴ�. �ϳ��� �ν��Ͻ��� ����Ų��.
		System.out.println("sss2 =" + sss2);
		System.out.println("sss3 =" + sss3);
		System.out.println("sss4 =" + sss4);
		
		sss2.printScreen();
		
	}

}
