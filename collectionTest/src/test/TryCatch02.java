package test;

public class TryCatch02 {
	public static void main(String[] args) {
		
		try {
//			Exception e = new Exception("고의로 발생시켰음");
//			throw e;
			throw new Exception("고의입니다");	//위두줄을 한줄로 합친거.
		} catch (Exception e) {
			System.out.println("에러메시지 : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
