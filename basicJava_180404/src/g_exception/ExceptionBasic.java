package g_exception;

public class ExceptionBasic {
	public static void main(String[] args) {
		/*
		 1. 프로그램 오류
		  - 프로그램이 실행중 어떤 원인에 의해서 오작동을 하거나 비정상적으로 종료되는 경우
		  - 컴파일 오류 : 컴파일시에 생기는 발생하는 에러
		  - 런타임 오류 : 실행시에 발생하는 에러
		  - 에러 : 프로그램 코드에 의해서 수습할 수 없는 심각한 오류
		  - 예외 : 프로그램 코드에 의해서 수습할 수 있는 경미한 오류
		  
		  //Exception 은 RuntimeException 과 그외Exception
		 2. 모든 예외의 최고조상은 Exception이다.
		  - RuntimeException클래스들은 주로 프로그래머의 실수에 의해서 발생 할 수 있는 예외
		  	ex) indexOutOfBoundsException, NullpointException
		  - 그 외 Exception들은 주로 외부의 영향으로 발생할 수 있는 것들
		  	ex) FileNotFoundException(파일을 찾을 수없어서 나는 오류), ClassNotFoundException(클래스를 찾을수없을 때 생기는 오류)
		  	
		 3. 예외처리(try- catch)
		  - 프로그램 실행시 발생할 수 있는 예외의 발생에 대바한 코드를 작성			//예외가 여러개일 경우에는 하나씩 처리해 나가야한다.
		  
		   	try{
		   		예외가 발생할 수도 있는 문장
		   	}catch(Exception1 e1){
		   		Exception1이 발생하였을때 처리할 문장
		  	}catch(Exception2 e2){
		  		Exception2이 발생하였을때 처리할 문장
		  	}
		  	
		 4. 예외발생시키기
		  - 연산자 new를 이용해서 발생시키고자 하는 예외이 객체를 만든다.
		    Exception e = new Exception();
		  - 키워드 throw를 이용해서 예외를 발생시킨다.
		  	throw e;
		  	
		  		 
		 //자바 Controller (콘솔창에 값을 받거나 찍거나), Service(나머지는 여기서) , Dao(데이터베이스에서 주고받고)		 
		 5. 예외던지기
		  - 메서드의 선언부에 키워드 'throws'를 사용해서 메서드 내에서 발생할 수 있는 예외를 적어주기만 하면 된다.
		  	처리는 메서드를 호출한 쪽에서 해주면 된다.
		  		  
		 6. finally
		  - try-catch블럭의 예외발생에 상관없이 실행되어야 할 코드를 작성한다.
		  	try{
		  		예외가 발생할 수 있는 문장
		  	}catch(Exception2 e){
		  		예외가 발생핼을 때 처리될 문장
		  	}finally{
		  		무조건 마지막에 수행
		  	}
		  	
		  - try -> catch -> finally
		  	try -> finally
		 */
		
		
		
		
		
		
		
		
		
	}

}
