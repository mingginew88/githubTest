package basic;
/*
	������(enum) ==> ���� �����ִ� ������� ����
	����) enum �������̸�{ �����1, �����2, ...}
 */


public class EnumTest {
	
	//City ������ ��ü ����
	public enum City { ����, �λ�, �뱸, ����, ����}
	
	//Season������ ��ü ����
	//==> ��, ����, ���� , �ܿ� �̶�� ����� �����ϰ� 
	//���� '3������ 5������' ������ '6������ 8������'
	//������ '9������ 11������' �ܿ��� '12������ 2������ ��� �ΰ������� �����ϰ����Ѵ�.
	
	public enum Season{
		��("3������ 5������"),
		����("6������ 8������"),
		����("9������ 11������"),
		�ܿ�("12������ 2������");
		
		//�ΰ����� �����Ͱ��� ������ ��쿡�� �����ڸ� ���� ��ȣ���� ���� ������ ����ǵ��� �ؾ��Ѵ�.
		
		//��ȣ���� ���� ����� ���� ����
		private String span;
		
		//������ �ۼ� ==> �����ڴ� ���������� 'private'�̴�.
		Season(String months){//private Season(String months)�� ����.
			span = months;
		}
		
		//�ΰ����� �����͸� �ܺο��� �����ϴ� �޼��� ����
		public String getSpan(){
			return span;
		}	
	}
	
	
	public static void main(String[] args) {
		
		//������ ��ü�� ����ϱ�		
		City city1 = City.����; //City���������� "����" ����� ������
		//name()�޼��� ==> �������� ��� �̸��� ���ڿ��� ��ȯ�Ѵ�.
		System.out.println("city1 : " + city1.name());
		
		//ordinal()�޼��� ==> ������ ����� ���ǵ� �������� ��ȯ�Ѵ�.( 0���� ����)
		System.out.println("city1. ordinal : " + city1.ordinal());
		System.out.println();
		
		// valueOf("�����������"); ==> ������ ���������� '�����������'�� ��ġ�ϴ� ������ ����� ��ȯ�Ѵ�.
		City city2 = City.valueOf("�뱸");	//City.�뱸 �� ����.
		System.out.println("name : " + city2.name());
		System.out.println("ordinal : " + city2.ordinal());
		System.out.println("=====================================");
		System.out.println();
		
		Season ss = Season.valueOf("����");
		System.out.println("name : " + ss.name());
		System.out.println("ordinal : " + ss.ordinal());
		System.out.println("span : " + ss.getSpan());
		System.out.println("=====================================");
		System.out.println();
		
		//��������.values() ==> �������� ��� ������� �迭�� ��� ��ȯ�Ѵ�.
		for (Season time : Season.values()) {
			System.out.println(time + " : " + time.getSpan());
			System.out.println(time + " : " + time.ordinal());
		}
		
		
		
		
	}

}
