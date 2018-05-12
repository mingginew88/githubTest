package test_object;

import java.util.Arrays;

public class TryHelloWorld {
	
	public int[] gcdlcm(int a, int b) {
      int[] answer = new int[2];
      answer[0] = a;
      answer[1]	= b;      
      //서로 나누어지지 않는 서로소의 경우를 고려하여 최소값만큼 반복문 해보자
      
      if(a <= b){
    	  int rem = b%a;    	  
    	  if(rem == 0){
    	  }else{
    		  while(rem==0){
    			  b = a;
    			  a = rem;
    		  }
    		  answer[0] = b;
    	      answer[1]	= answer[0]*answer[1]/b;	
    	  }
      }else{
    	  int rem = a%b;
    	  if(rem == 0){
    	  }else{
    		  while(rem==0){
    			  a = b;
    			  b = rem;
    		  }
    		  answer[0] = a;
    	      answer[1]	= answer[0]*answer[1]/a;	
    	  }
      }
        return answer;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        TryHelloWorld c = new TryHelloWorld();
        System.out.println(Arrays.toString(c.gcdlcm(3, 12)));
    }
	

}
