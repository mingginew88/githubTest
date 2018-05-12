package h_javaLang;
/**
 * java.lang패키지 내 클래스 공부 * 
 * @author PC17
 * @since 2018. 03. 29
 * 
 */

public class JavaLangBasic {
	public static void main(String[] args) {
		
		/*
		 1. java.lang패키지
		  - java.lang 패키지는 자바프로그래밍에 기본이 되는 클래스를 포함하고 있다.
		    ex) String, System ...
		
		 2. Object클래스
		  - Object클래스는 멤버변수없이 11개의 메서드로 이루어져있다.
		 
		  - equals(Object obj)
		    : 매개변수로 객체의 참조변수를 받아서 비교하여 그 결과를 boolean값으로 알려준다.
		    
		  - 참조변수에 저장된 주소값을 비교하게 되어있다.
		    : equals메서드가 오버라이드 되어있는 클래스들
		      ex) String, Date, File, wrapper클래스
		  
		  - hashCode() - 10진수로 이루어짐
		    : 객체의 주소값을 이용해서 해시코드를 만들어서 반환한다.
		    : String클래스의 문자열의 내용이 같으면 동일한 해시코드를 반환하게끔 hashCode()가 오버라이드 되어있다.
		    
		  - toString()
		    : 인스턴스에 대한 정보를 문자열로 제공할 목적으로 작성
		    : 기본적인 toString()
		      
		      return getClass().getName()+ "@" + Integer.toHexString(hashCode());
		      
		  - clone()
		    : 얕은 복사
		    : 자신을 복제하여 '새로운 인스턴스'를 생성한다.
		      단순히 인스턴스변수의 값만을 복사해준다.
		       
		  - getClass()
		    : 자신이 속한 클래스의 Class객체를 반환하는 메서드
		    : 클래스의 정보가 필요할 때는 먼저 Class의 객체에 대한 참조를 얻어와야 한다.
		    : Class 객체를 얻는 방법
		    	(1) Class obj = new Card().getClass() // 생성된 객체로부터 얻는 방법
		    	(2) Class obj = Card.class;		//클래스리터럴로부터 얻는 방법  (거의안쓰는방법)
		    	(3) Class obj = Class.forName();	//클래스의 이름으로부터 얻는 방법
		      
		 3. String클래스
		  - 문자열의 비교
		    : 문자열 리터럴을 지정하는 방법과 String클래스의 생성자를 이용하는 방법
		    : 문자열 리터럴은 클래스가 로드될때 자동적으로 미리 생성된다.
		  
		  - String클래스의 메서드들
		    : 자주사용되는 것들만 실습해볼게요.
		    
		  - 문자 인코딩 변환
		    : 한글 윈도우 에서는 문자 인코딩으로 CP949를 사용한다.  
		      하지만 우리는 UTF-8
		  
		  - String.format
		    : 기본값을 String으로 변환
		      1) 빈 문자열을 더하는 방식
		        int a = 10;
		        String s = a + "";
		      2) valueOf메서드를 이용한느 방법
		        int c = 20;
		        string s = String.valueOf(c);     
		    : String형을 기본값으로 변환하는 방법
		      1) wrapper클래스를 이용하는 방법
		        String s = "100";
		        int a = Integer.parseInt(s);// try{}catch{}
		        byte b =Byte.parseByte(s);
		        
		        int a = Integer.valueOf(s);
		          
		  	  2) String을 기본형으로 변환시 결과는 10진수이다.
		  	     다른 진수로 표현하는 방법
		  	     String s = "200";
		  	     int a = Integer.parseInt(s,16);	//16진수로 바뀜
		  	     
		  	     
		 4. String Buffer, String Builder클래스
		   - String클래스의 인스턴스를 생성할때 지정된 문장을 변경할 수 없다.
		   - 문자열의 변경을 위해서는 StringBuffer클래스를 이용한다.
		   
		        
		 5. Math
		    
		          
		 6. wrapper클래스
		  - 객체지향은 모든 것을 객체로 다루어야 한다.
		  - 8가지 기본형은 객체로 다루지 않는다.
		  - 때로는 기본형 변수도 객체로 다루어야 할 때가 있다.
		    : 매개변수로 객체를 요구할때
		      void method(Object obj){
		      }
		    : 기본형이 아닌 객체로 저장되어야 할때
		    
		    : boolean | Boolean
		      char	  | Character **
		      byte	  | Byte
		      short   | Short
		      int	  | Integer ** 
		      long 	  | Long
		      float   | Float
		      double  | Double  
		  
		    오토박싱 : 기본형 값을 래퍼클래스의 객체로 변환해 주는 기능
		     Integer i = 100;
		    언박싱 : 래퍼클래스의 객체를 기본형 값으로 변환해 주는 기능
		     int i = new Integer(10);			// int i = new Integer(10).intValue();
		     
		 7. StringTokenizer클래스
		   - 긴 문자열을 지정된 구분자를 기준으로 토큰(token)이라는 여러개의 문자열로 잘라 내는데 사용된다.   
		   - 단 한 문자의 구분자만 사용할 수 있다.  
		     
		 */
		
		String s = "200";
		int a = Integer.parseInt(s, 16);
		System.out.println(a);		
		
		
	}
}
