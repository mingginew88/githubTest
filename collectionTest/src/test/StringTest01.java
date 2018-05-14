package test;

public class StringTest01 {
	public static void main(String[] args) {
		
		
		String s;
		s = new String("Hello");
		System.out.println(s);
		
		char[] c = {'H', 'E', 'L', 'L', 'O'};
		s = new String(c);
		System.out.println(s);
		
		StringBuffer sb = new StringBuffer("Hello");
		s = new String(sb);
		System.out.println(s);
		
		
		String s1;
		String s2;
		s1 = "Hello";
		s2 = "Java";
		s = s1.concat(s2);
		System.out.println(s);
		
		if (s.contains("lo")) {
			System.out.println("Wow");
		}
		
		System.out.println(s.endsWith("o"));
		
		s1 = "Hello";
		s2 = "hElLo";
		
		if(s1.equalsIgnoreCase(s2)){
			System.out.println("Great");
		}else{
			System.out.println("Bad");
		}
		
		int a = s1.indexOf('c');
		
		if(a == -1){
			System.out.println("bad");
		}else{
			System.out.println("great");
		}

		
		
	}

}
