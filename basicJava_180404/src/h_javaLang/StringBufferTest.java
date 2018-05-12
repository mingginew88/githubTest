package h_javaLang;

public class StringBufferTest {
	public static void main(String[] args) {
		/*
		String s = "a";
		s += "a";
		s += "a";
		s += "a";
		
		 String s = "a";
		 s = new StringBuffer(s).append("a").toString();
		 s = new StringBuffer(s).append("a").toString();
		 */
		  
		 
		
		//문자열 형태로 더하는 방법
//		long start = System.currentTimeMillis();
//		Runtime rt = Runtime.getRuntime();
//		System.out.println(rt.freeMemory());
//		String s = "a";
//		for(int i = 0; i < 30000; i++){
//			s += "a";
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(rt.freeMemory());
//		System.out.println(end-start);
		
		
		//StringBuffer를 이용한 방법. 시간을 엄청나게 단축시킬수있다.  //하나주소만 만들어두고 계속변경만 해준것이다.
//		long start = System.currentTimeMillis();
//		Runtime rt = Runtime.getRuntime();
//		System.out.println(rt.freeMemory());
//		StringBuffer sb = new StringBuffer("a");
//		for(int i = 0; i < 300000000; i++){
//			sb.append("a");
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(rt.freeMemory());
//		System.out.println(end-start);
		
		
		//StringBuilder를 이용한 방법.  StringBuffer의 업그레이드 판  동기화를 안하는 방법 
		//(StringBuffer는 동기화를 해준다 그러기에 StringBuilder보다 조금느리다)
		long start = System.currentTimeMillis();
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.freeMemory());
		StringBuilder sb = new StringBuilder("a");
		for(int i = 0; i < 300000000; i++){
			sb.append("a");
		}
		long end = System.currentTimeMillis();
		System.out.println(rt.freeMemory());
		System.out.println(end-start);
		

	}

}
