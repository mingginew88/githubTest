package basic;

public class ArgsTest {
	/*
	 	������ �μ�==> �޼����� �Ű������� ������ ����� ������ �ٸ��� ����Ѵ�.
	 	- �� ������ �μ��� �޼��� ������ �迭�� ó���ȴ�.
	 	- ������ �μ��� �Ѱ��� �ڷ����� ����� �� �ִ�.
	 */
	public void test(int a, int b){
		
	}
	
	//�迭�� �̿��� �޼��� (�迭�����͵��� �հ踦 ��ȯ)
	public int testArr(int[] arr){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	//������ �μ��� �̿��� �޼���
	public int testArg(int...data){		//data������ ������ ����
		//������ ������ �޼��� �����ȿ��� �迭�� ó���ȴ�.
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;		
	}
	
	//������ �μ��� �Ϲ� �Ű������� ȥ���ؼ� ����� ��쿡�� �������μ��� ���� �������� ��ġ�ؾ� �Ѵ�.
	public void testArg2(String name, int...data){
		
	}
	
//	public void testArg3(int...data, int name){		//����
//	}
	
	public static void main(String[] args) {
		ArgsTest arg = new ArgsTest();
		
		arg.test(10,20);
		
		int[] data = new int[]{10,20,30,40,50,60};
		int rtn = arg.testArr(data);
		System.out.println("�迭 �հ� : " + rtn);
		
		System.out.println(arg.testArr(new int[]{1,2,3,4,5,6,7}));
		System.out.println("====================================");
		
		System.out.println("������ �հ� : " + arg.testArg(data));
		System.out.println("������ �հ� : " + arg.testArg(1,2,3,4,5,6,7));
	}

}
