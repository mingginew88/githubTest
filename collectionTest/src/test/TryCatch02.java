package test;

public class TryCatch02 {
	public static void main(String[] args) {
		
		try {
//			Exception e = new Exception("���Ƿ� �߻�������");
//			throw e;
			throw new Exception("�����Դϴ�");	//�������� ���ٷ� ��ģ��.
		} catch (Exception e) {
			System.out.println("�����޽��� : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
