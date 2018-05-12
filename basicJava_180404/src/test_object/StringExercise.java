package test_object;

class StringExercise{
    String getMiddle(String word){
      String sum = "";
      int length = word.length();
      if(word.length()%2 == 0){
         sum = word.charAt(length/2 -1) + "";
         sum += word.charAt(length/2) + "";
      }else{
         sum = word.charAt(length/2) + "";
      }

    	return sum;
    }
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void  main(String[] args){
        StringExercise se = new StringExercise();
        System.out.println(se.getMiddle("powerE"));
    }
}