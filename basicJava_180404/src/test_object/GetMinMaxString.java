package test_object;

public class GetMinMaxString {
    public String getMinMaxString(String str) {
    	
    	String[] arr = str.split(" ");
    	String a = arr.toString();
    	char[] arr2 = new char[arr.length];
    	for(int i = 0; i < arr.length; i++){
    		arr2[i] = a.charAt(i);	
    	}
    for(int j = 0; j < arr2.length - 1 ; j++){
    	int min = arr2[0];
    	int max = arr2[0];
    	for(int i = 0; i < arr2.length - 1 - j; i++){    		
    		if(arr2[i] < arr2[i+1]){
    			char tmp = arr2[i];
    			arr2[i] = arr2[i+1];  
    			arr2[i+1] = tmp;    			
    		}
    	}
    	min = arr2[0];
    	max = arr2[arr2.length];
    }
//    String result =min + "" + max;
  
    	
    	
        return "";
    }

    public static void main(String[] args) {
        String str = "1 2 3 4";
        GetMinMaxString minMax = new GetMinMaxString();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println("최대값과 최소값은?" + minMax.getMinMaxString(str));
    }
}
