package basic;

import java.util.Enumeration;
import java.util.ResourceBundle;

/*
 	ResourceBundle��ü ==> Ȯ���ڰ� properties���� ������ �о�� key���� value������ �и��� ������ ���� �ִ� ��ü
 					  ==> �о�� ������ 'key��=value��' ���·� �Ǿ� �־�� �Ѵ�.
 */
// properties��� ���ٴ� resourceBundle�� �� ���� ����ϴ� �߼��̴�.

public class ResourceBundleTest {
	
	//ResourceBundle��ü�� �̿��Ͽ� ���� ���� �о�� ����ϱ�
	public static void main(String[] args) {
		//ResourceBundle��ü ����
		// ==> ������ ������ ���� '���ϸ�'�� �����ϰ� Ȯ���ڴ� �������� �ʴ´�.( ���� : Ȯ���ڴ� �׻� 'properties'�̱� �����̴�.)
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		
		//key���鸸 �о����
		Enumeration<String> keys = bundle.getKeys();
		
		//key�� ������ŭ �ݺ�
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			
			//key���� �̿��ؼ� value���� ���ϴ� ���
			//����) bundle.getString("key��");
			String value = bundle.getString(key);
			
			System.out.println(key + " ==> " + value);
		}
		System.out.println("��� ��...");
		
	}

}
