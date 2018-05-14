package test;

public class TryCatch03 {
	public static void main(String[] args) {
		
		while(true){
			System.out.println("try-catch 실습");
			
			try {
				int a = (int)(Math.random()*10 + 1);
				int b = 0;	
				
				throw new Exception("예외처리해야합니다.");
			} catch (Exception e) {
				System.out.println("예외메시지 : " + e.getMessage());
				e.printStackTrace();
				break;				
			} finally {
				System.out.println("finally는 반드시 실행되어야 한다.");
			}
//			System.out.println("이곳은 실행되어서는 안됩니다.");
		}
		System.out.println("마지막 실행장소");

	}

}
