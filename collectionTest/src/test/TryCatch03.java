package test;

public class TryCatch03 {
	public static void main(String[] args) {
		
		while(true){
			System.out.println("try-catch �ǽ�");
			
			try {
				int a = (int)(Math.random()*10 + 1);
				int b = 0;	
				
				throw new Exception("����ó���ؾ��մϴ�.");
			} catch (Exception e) {
				System.out.println("���ܸ޽��� : " + e.getMessage());
				e.printStackTrace();
				break;				
			} finally {
				System.out.println("finally�� �ݵ�� ����Ǿ�� �Ѵ�.");
			}
//			System.out.println("�̰��� ����Ǿ�� �ȵ˴ϴ�.");
		}
		System.out.println("������ �������");

	}

}
