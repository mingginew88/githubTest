package basic;

public class ArgsTest {
	/*
	 	가변형 인수==> 메서드의 매개변수의 개수가 실행될 때마다 다를때 사용한다.
	 	- 이 가변형 인수는 메서드 내에서 배열로 처리된다.
	 	- 가변형 인수는 한가지 자료형만 사용할 수 있다.
	 */
	public void test(int a, int b){
		
	}
	
	//배열을 이용한 메서드 (배열데이터들의 합계를 반환)
	public int testArr(int[] arr){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	//가변형 인수를 이용한 메서드
	public int testArg(int...data){		//data변수가 가변형 변수
		//가변형 변수가 메서드 역역안에서 배열로 처리된다.
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;		
	}
	
	//가변형 인수와 일반 매개변수를 혼합해서 사용할 경우에는 가변형인수를 제일 마지막에 배치해야 한다.
	public void testArg2(String name, int...data){
		
	}
	
//	public void testArg3(int...data, int name){		//오류
//	}
	
	public static void main(String[] args) {
		ArgsTest arg = new ArgsTest();
		
		arg.test(10,20);
		
		int[] data = new int[]{10,20,30,40,50,60};
		int rtn = arg.testArr(data);
		System.out.println("배열 합계 : " + rtn);
		
		System.out.println(arg.testArr(new int[]{1,2,3,4,5,6,7}));
		System.out.println("====================================");
		
		System.out.println("가변형 합계 : " + arg.testArg(data));
		System.out.println("가변형 합계 : " + arg.testArg(1,2,3,4,5,6,7));
	}

}
