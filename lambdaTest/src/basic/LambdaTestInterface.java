package basic;

//���ٽ����� ��ȯ�� �� �ִ� �������̽� => �Լ��� �������̽�
//			==> �߻�޼��尡 1���� �������̽�

@FunctionalInterface	//�Լ��� �������̽��� ��Ÿ���� ������̼�
public interface LambdaTestInterface {
	//��ȯ���� ����, �Ű������� ���� �޼��� ����
	public void test();	
}

@FunctionalInterface
interface LambdaTestInterface2{
	//��ȯ���� ���� �Ű������� �ִ� �޼��� ����
	public void test(int a);
}

@FunctionalInterface
interface LambdaTestInterface3{
	//��ȯ���� �ְ� �Ű������� �ִ� �޼��� ����
	public int test(int a, int b);
}