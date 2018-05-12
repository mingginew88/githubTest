package g_exception;

import java.io.FileNotFoundException;

public class Exception02 {
	public static void main(String[] args) {
		//try catch적어주라고 난리핌.
		FileNotFoundException fnfe = new FileNotFoundException("그냥 심심해서");		//()안에 Exception이 뜨는 이유를 적어준다.
		
		try {
			throw fnfe;
		} catch (FileNotFoundException e) {
			//exception이 발생했을때 프린트해주는 메서드
			e.printStackTrace();		//exception클래스에있는 메서드
			//직장에서 사용하는경우에는
			System.out.println(e.getMessage());		//exception이 발생하는 이유만 적어주는 메세지다.
		}
		System.out.println("끝");
		
		//try catch하라고 안뜸.
//		throw new RuntimeException();
		//하지만 try catch를 써서 알아서 정리해주어야한다.
		
		try {
			throw new RuntimeException();
		} catch (RuntimeException r) {
			r.printStackTrace();
		}
		System.out.println();
		
		//컴파일러가 예외처리를 강제하지않는 경우
		//1. RuntimeException클래스들
		//2. Error와 그 자손들
		
		//이런것들을 'unchecked예외'라 한다.
		
		
		
		
		
		
		
	}

}
