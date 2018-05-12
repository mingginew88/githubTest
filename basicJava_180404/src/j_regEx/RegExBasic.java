package j_regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExBasic {
	public static void main(String[] args) {
		/*
		 1. 정규식이란?
		   - 텍스트 데이터중에 원하는 조건과 일치하는 문자열을 찾기 위해 사용하는 것.
		   - 정규식의 구성
		     : Pattern이라는 클래스를 이용하여 정규식을 정의한다.
		     : Matcher라는 클래스를 이용하여 Pattern과 일치하는 데이터가 있는지 확인한다.		 
		 */
		//패턴등록
		Pattern p = Pattern.compile("[a-z]*");		//  * : 없을수도있고 무한정있어도된다.
		
		//대상비교
		Matcher m = p.matcher("dnifdddAfi");
		System.out.println(m.matches());
		
	}
}
