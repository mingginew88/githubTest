package j_regEx;

import java.util.regex.Pattern;

public class RegExTest {
	public static void main(String[] args) {
		/*
		 ^ : 문자열의 시작
		 $ : 문자열의 끝
		 . : 임의의 한문자 (단,  \ 는 넣을수 없다.)
		 * : 문자가 없거나 무한정있을수도 있다.
		 + : 앞문자가 하나이상
		 ? : 앞문자가 없거나 하나있음
		 [] : 문자의 집합이나 범위를 나타내며 문자사이는 - 기호를 범위로 나타낸다.
		 [^ ] : not의 의미로 사용된다. (내용을 제외한)
		 {} : 횟수 또는 범위를 나타낸다.
		 () : 소괄호 안의 문자를 하나의 문자로 인지한다.
		 | : 패턴안에서 or연산을 수행할때 사용한다.
		 \s : 공백문자
		 \S : 공백을 제외한 모든문자
		 \w : 알파벳이나 숫자
		 \W : 알파벳이나 숫자를 제외한 모든 문자
		 \d : 숫자만을 의미
		 \D : 숫자를 제외한 모든 문자
		 
		 영어대문자 [A-Z]{2} 2회반복
		 		  [A-Z]{2,4} 2회 이상 4회이하 반복 (2,3,4)
		 		  [A-Z]{2,} 2회이상 반복		 		  
		 
		 */
		
		String regEx01 = "[a-zA-Z]{2,3}";
		System.out.println(Pattern.matches(regEx01, "asd"));
		
		//영문자가 3회 반복되고 숫자가 하나이상 존재하는 정규식을 만들고 검사하세요.
		String s = "[a-zA-Z]{3}[0-9]+";
		System.out.println(Pattern.matches(s, "asd35"));
		
		//핸드폰번호 000-0000-0000
		String phoneNumber = "[0-9]{3}-[0-9]{4}-[0-9]{4}";
		System.out.println(Pattern.matches(phoneNumber, "010-9820-3292"));
		
		//010, 1,6,7,8,9 - 1~9 숫자3개 - 숫자4개
		String phoneNumber2 = "01[^2-5]-[1-9][0-9]{3}-[0-9]{4}";
		System.out.println(Pattern.matches(phoneNumber2, "010-9820-3292"));
		
		//주민번호
		String regNo1 = "[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])-[1-4]";
		System.out.println(Pattern.matches(regNo1, "880115-1"));
		
		//구글 - 정규식테스트
		
	}

}
