package h_javaLang;

import java.util.Date;
import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		String text = "100,200,300,400,500";
		//delim 구분자 라는 것
		StringTokenizer st = new StringTokenizer(text, ",");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());			
		}
		System.out.println("hi");
		//토큰은 한번 끊으면 없어지기때문에 아래의 문장을 수행할 수 없다.
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());			
		}	
		
		
		System.out.println("==========split============");
		String data = "100,,,,200,,,300,,400,500";
		String[] result = data.split(",");			// 만족해야 구분자로 생각한다. , 할경우 11개  0,인경우 5개
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
				
		System.out.println("=======Stringtokenizer==========");
		StringTokenizer st2 = new StringTokenizer(data, ",");		//0, 이것도 0과 , 를 둘다 구분자로 인식해서 1 2 3 4 5 가 나온다.
		while(st2.hasMoreTokens()){
			System.out.println(st2.nextToken());
		}	
		
		
		int s = st.countTokens();
		System.out.println(s);
		
		Date d = new Date();
		System.out.println(d);
				
		
		
	}
}
