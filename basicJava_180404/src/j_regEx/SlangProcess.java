package j_regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SlangProcess {
	
	public static void main(String[] args) {		
		String str = "야이 개나리 십장생아 이런 조카신발 같은 경우를 봤나";		
		System.out.println(filterText(str));
	}
	
	public static String filterText(String text){			//비속어 찾는 메서드
		Pattern p = Pattern.compile("개나리|십장생|조카신발|병일신|피융신", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(text);
		
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			m.appendReplacement(sb, maskWord(m.group()));
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	public static String maskWord(String word){		//비속어를 변경 메서드
		StringBuffer sb = new StringBuffer();
		char[] ch = word.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if(i==0){
				sb.append(ch[i]);
			}else{
				sb.append("*");
			}
		}
		return sb.toString();		
	}
}
