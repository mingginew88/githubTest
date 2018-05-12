package h_javaLang;

public class StringMethod {
	public static void main(String[] args) {
		// char charAt(int index) : 지정된 index번째 문자를 리턴한다.
		String s1 = "Hello";
		char c = s1.charAt(1);
		System.out.println(c);
		
		//oracle에서도 사용되는 것들
		//1. String concat(String str) : 문자열 뒤에 문자열을 덧붙인다.
		String s2 = s1.concat(" JAVA");
		System.out.println(s2);
		
		//2. boolean contains() : 지정된 문자열이 포함되어 있는지 확인한다.
		System.out.println(s2.contains("JA"));
		
		//확장자 처리에 유용한것
		// boolean endsWith() : 지정된 문자열로 끝나는 확인
		System.out.println(s2.endsWith(".jpg"));
		
		//그 외
		//1. int lastIndexOf() : 지정된 문자가 무자열의 오른쪽 끝부터 찾아서 찾은 문자의 index를 반환한다. 없으면 -1을 반환한다
		System.out.println(s2.lastIndexOf("J"));
		
		//2. String replace(String oldValue, String newValue)
		//   : 문자열중의 문자를 새로운 문자로 변환
		String s3 = s2.replace("JAVA", "HighJava");
		System.out.println(s3);
		
		//3. String[] split() : 문자열을 지정된 분리자로 나누어 문자열배열에 저장한다.
		String s4 = "100,200,300,400";
		String[] s5 = s4.split(",");
		for (int j = 0; j < s5.length; j++) {
			System.out.println(s5[j]);
		}
		
		//4. String subString() : 주어진 문자열을 시작부터 끝 위치 범위에 포함된 문자열을 반환한다.
		// start <= x < end
		String s6 = s4.substring(3, 6);  // 3, 4 , 5
		System.out.println(s6);
			
		//5. String trim() : 문자열의 양끝의 공백을 제거한다.
		String s7 = "       my         Trim        ";
		String s8 = s7.trim();
		System.out.println(s8);		
		
		//6. String(String s) : 주어진 문자열(s)를 갖는 String인스턴스를 생성한다.
		String s = new String("Hi");
		System.out.println(s);		
		
		//7. String(char[] value) : 주어진 문자열(value)를 갖는 String인스턴스를 생성한다.
		char[] ch = {'A', 'B', 'C'};
		String sv = new String(ch);
		System.out.println(sv);
		
		//8. String(StringBuffer buf) : StringBuffer인스턴스가 갖고 있는 문자열과 같은 내용의 String인스턴스를 생성한다.
		StringBuffer sb = new StringBuffer("안녕하세요");
		String s9 = new String(sb);
		System.out.println(s9);
		
		//9. int compareTo(String str) : 문자열(str)과 사전순서로 비교한다. 같으면 0을 사전순으로 이전이면 음수를 이후면 양수를 반환한다.		
		int i = "aaa".compareTo("ddd");
		System.out.println(i);
		
		//10. equals(Object obj) : 매개변수로 받은 문자열(obj)과 String인스턴스의 문자열을 비교한다. obj가 String이 아니거나 문자열이 다르면 false를 반환한다.
		String s10 = "hello";
		String s11 = "Hello";
		System.out.println(s10.equals(s11));
		
		//11. boolean equalsIgnoreCase(String str) : 문자열과 String인스턴스의 문자열을 대소문자 구분없이 비교한다.
		System.out.println(s10.equalsIgnoreCase(s11));
		
		//12. int indexOf(int ch) : 주어진 문자(ch)가 문자열에 존재하는지확인하여 위치(index)를 알려준다. 못찾으면 -1을 반환한다(index는 0부터 시작)
		int ch2 = s10.indexOf('l');
		System.out.println(ch2);
		
		//13. int indexOf(int ch, int pos) : 주어진 문자(ch)가 문자열에 존재하는지 지정된 위치(pos)부터 확인하여 위치(index)를 알려준다. 못찾으면 -1을 반환한다.
		String s12 = "Hello Java, Good bye Java";		
		System.out.println(s12.indexOf('b', 13));
		
		//14. int indexOf(String str) : 주어진 문자열이 존재하는지 확인하여 그 위치를 알려준다. 없으면 -1을 반환한다.
		System.out.println(s12.indexOf("Good"));
		
		//15. String intern() : 문자열을 상수풀(constant pool)에 등록한다. 이미 상수풀에 같은 내용의 문자열이 있을 경우 그 문자열의 주소값을 반환한다.
		String s13 = new String("hello");
		String s14 = new String("Hello");
		boolean b = (s13.intern() == s14.intern());
		System.out.println((s13.intern() == s14.intern()));
		
		//16. int lastIndexOf(String str) :지정된 문자열을 인스턴스의 문자열 끝에서부터 찾아서 위치를 알려준다 못찾으면 -1을 반환한다.
		int i3 = s14.lastIndexOf("ll");
		System.out.println(i3);
		
		//17. int length() : 문자열의 길이를 알려준다.
		String s15 = "abcdef";
		int i4 = s15.length();
		System.out.println(i4);
		
		//18. String replace(CharSequence old, CharSequence nw) : 문자열 중의 문자열(old)를 새로운 문자열(nw)로 모두 바꾼 문자열을 반환한다.
		String s16 = "Hi Hi";
		String s17 = s16.replace("Hi", "Hello");
		System.out.println(s17);
				
		//19. String replaceAll(String regex, String replacement) : 문자열 중에서 지정된 문자열과 일치하는 것을 새로운 문자열로 모두 변경한다.
		System.out.println(s16.replaceAll("Hi", "Hello"));
		
		//20. String replaceFirst(String regex, String replacement) : 문자열중에서 지정된 문자열과 일치하는 것중 첫번째것만 새로운 문자열로 변경한다.
		String s18 = "aabbccAAbbCc";
		String s19 = s18.replaceFirst("bb", "BB");
		System.out.println(s19);
		
		//21. String[] split(String regex) : 문자열을 지정된 분리자로 나누어 문자열 배열에 반환한다.
		
		//22. String[] split(String regex, int limit) :문자열을 지정된 분리자로 나누어 문자열배열에 담아 반환한다. 단, 문자열전체를 지정된 수로 자른다.
		String s20 = "a,b,c,d,e,f";
		String[] s21 = s20.split(",", 2);
		System.out.println(s21);
		
		//23. boolean startsWith(String prefix) :주어진 문자열로 시작하는지 검사한다.
		String s22 = "java.util.Scanner";
		System.out.println(s22.startsWith("java"));
		
		//24. String substring(int begin) : 주어진 시작위치부터 끝위치범위에 포함된 문자열을 얻는다.
		//이때, 시작위치의 문자는 범위에 포함되지만, 끝 위치의 문자는 포함되지 않는다. 
		System.out.println(s22.substring(6));
		
		//25. String substring(int begin, int end) : 주어진 시작위치부터 끝위치범위에 포함된 문자열을 얻는다.
		//이때, 시작위치의 문자는 범위에 포함되지만, 끝 위치의 문자는 포함되지 않는다. 
		System.out.println(s22.substring(6, 10));
		
		//26. String toLowerCase() : String인스턴스에 저장되어있는 모든 문자열을 소문자로 변환하여 반환한다.
		System.out.println(s22.toLowerCase());
		
		//27. String toString() : String 인스턴스에 저장되어 있는 문자열을 반환한다.
		System.out.println(s22.toString());
		
		//28. String toUpperCase() : String인스턴스에 저장되어있는 모든 문자열을 대문자로 변환하여 반환한다.
		System.out.println(s22.toUpperCase());
		
		//29. static String valueOf(boolean b)
		//static String valueOf(char c)
		//static String valueOf(int i)
		//static String valueOf(long l)
		//static String valueOf(float f)
		//static String valueOf(double d)
		//static String valueOf(Object o)
		//지정된 값을 문자열로 변환하여 반환한다. 참조변수의 경우, toString()을 호출한 결과를 반환한다.
		String s23 = String.valueOf(true);
		System.out.println(s23);
		String s24 = String.valueOf('a');
		System.out.println(s24);
		String s25 = String.valueOf(3);
		System.out.println(s25);
		String s26 = String.valueOf(3.0f);
		System.out.println(s26);
		String s27 = String.valueOf(3L);
		System.out.println(s27);
		String s28 = String.valueOf(20);
		System.out.println(s28);
		java.util.Date dd = new java.util.Date();
		System.out.println(dd);
		String date = String.valueOf(dd);
		System.out.println(date);
		
		
		//regex 정규식 표현
		//replace 와 replaceAll의 차이
		//replaceAll은 정규식표현이 가능해서 패턴내에 적용되는 값들을 다 찾아서 대체해준다.
		//replace는 그냥 값을 비교하여 대체해준다.
		
		//intern의 경우는  만약 값이 같은 참조변수가 두개가 있다면 굳이 두개를 같이 둘 필요가없기때문에 클래스에어리어에있는 상수풀에 값을올려주어 주소를 공유해준다.
		//그렇기때문에 비교를 한다면 true가 나오게된다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
