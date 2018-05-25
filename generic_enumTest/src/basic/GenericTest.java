package basic;

/*
	���׸� Ŭ���� ����� ���
	
	���� ) class Ŭ������ <���׸�Ÿ�Ա���>{
			�ڷ����̸� ������;		//���� ������ �� ���
			....
			
			���׸�Ÿ�Ա��� �޼����(){	//�޼����� ��ȯ�� Ÿ�Կ� ���
				....
				return ��;
			}
			
			
			�޼����(���׸�Ÿ�Ա��� ������){	//�޼����� �Ű������� Ÿ�Կ� ���
			
			}
			
		}
 */

//���׸��� ������� �ʴ� ���
class NonGenericClass{
	private Object val;
	
	public void setVal(Object val){
		this.val = val;
	}
	
	public Object getVal(){
		return val;
	}
	
}

//���׸��� ������ Ŭ����
class MyGenericClass<T>{
	private T val;
	
	public void setVal(T val){
		this.val = val;
	}
	
	public T getVal(){
		return val;		
	}
}
/*
	----���׸� Ÿ�� ����----
	T ==> Type
	K ==> Key
	V ==> Value
	E ==> Element
 */


public class GenericTest {
	public static void main(String[] args) {
		NonGenericClass ng1= new NonGenericClass();
		
		ng1.setVal("�����ٶ�");
		String rtn = (String)ng1.getVal();
		System.out.println("���ڿ� ��ȯ�� : " + rtn);
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		Integer irtn = (Integer)ng2.getVal();
		System.out.println("���� ��ȯ�� : " + irtn);
		System.out.println();
		
		MyGenericClass<String> mg1 = new MyGenericClass<String>();
		mg1.setVal("���ѹα�");
//		mg1.setVal(123);		//�ٸ������� ����Ʈ�� ����ϸ� �����߻�
		rtn = mg1.getVal();
		System.out.println("���׸� ���ڿ� ��ȯ�� : " + rtn);
		
		MyGenericClass<Integer> mg2 = new MyGenericClass<Integer>();
		
		mg2.setVal(1000);
		irtn = mg2.getVal();
		System.out.println("���׸� ���� ��ȯ�� : " + irtn);
		
		
	}

}






