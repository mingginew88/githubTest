package g_exception;

import java.io.FileNotFoundException;

public class Exception03 {
	public static void main(String[] args) throws FileNotFoundException{
		method1();
	
		
		
	}
	
	static void method1() throws FileNotFoundException{
		method2();
	}
	
	static void method2() throws FileNotFoundException{
		throw new FileNotFoundException();
		
		
	}
	
	
	
	
	
	
	
	
}


