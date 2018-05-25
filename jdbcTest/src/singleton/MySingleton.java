package singleton;

/*
	singleton ���� Ŭ����
		- �ܺο��� new�� ������� �ʰ� ������ ��ü�� ��ȯ��Ű�� ���� Ŭ����
		(��, �ν��Ͻ��� �ϳ��� ��������� Ŭ����)
		
	singleton Ŭ������ �����ϴ� ���
	    - �ܺο��� new����� ������� ���Ѵ�.
	    (��� : ������ �Լ��� �������� ���ϵ��� �Ѵ�.)
	    1. �ڱ��ڽ��� �������� �����ϴ� ��������� �����.
	      (private static���� �����Ѵ�.)
	    
	    2. �������� ���������ڸ� private���� �Ѵ�.
	      
	    3. �ܺο��� �������� ���� �� �ִ� �޼��带 �ۼ��Ѵ�.
	      (���� �޼������ getInstance()�� �ϰ� �� �޼���� public static���� �����Ѵ�.)	 
 */


//�ּ�ó���ص� 3������ �ʼ�����̴�. 
public class MySingleton {
	//1) �ڱ� �ڽ��� �������� ������ �� �ִ� ���� ����
	private static MySingleton single = new MySingleton();
	
	//2) private������ �ۼ�
	private MySingleton(){
		System.out.println("�̱��� ��ü �������Դϴ�.");
	}
	
	//3) �ܺο��� �������� �� �� �ִ� �޼����ۼ�
	//(�� �޼����� ��ȯ���� ���� Ŭ������ �������̾�� �ȴ�.)
	public static MySingleton getInstance(){
		if(single == null){
			single = new MySingleton();
		}
		return single;
	}	
	
	
	//��Ÿ ����� �޼��峪 ����������� �����Ͽ� ����Ѵ�.
	public void printScreen(){
		System.out.println("�̱����� �ν��Ͻ� �޼����Դϴ�.");
	}
	
	
}











