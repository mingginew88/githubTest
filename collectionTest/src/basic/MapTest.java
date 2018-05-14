package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest {
	/*
		Map ==> key���� value���� �� ������ �����ϴ� ��ü
			==> key���� �ߺ��� ������� �ʰ� ������ ����. (Set�� Ư¡)
			==> value���� �ߺ��� ����Ѵ�.
	 */
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		
		map.put("name", "ȫ�浿");
		map.put("address", "����");
		map.put("tel", "010-1234-5678");
		
		map2.put("name", "������");
		map2.put("address", "�ȸ鵵");
		map2.put("tel", "010-1234-9999");
		
//		List<HashMap<String, String>> memList = new ArrayList<HashMap<String, String>>();
//		memList.add(map);
//		memList.add(map2);
//		System.out.println(memList);
		
		System.out.println("map => " + map);
		
		//�ڷ���� ==> �����͸� ������ �� key���� ������ ���߿� �Է��� ���� ����ȴ�.
		map.put("address", "����");
		System.out.println("map => " + map);
		System.out.println();
		
		//�ڷ���� ==> remove(key��)
		map.remove("tel");
		System.out.println("map => " + map);
		System.out.println();
		
		//�ڷ��б� ==> get(key��); ==> key���� �ѽ��� value���� �о�´�.
		System.out.println("name : " + map.get("name"));
		System.out.println("address : " + map.get("address"));
		System.out.println();
		
		//key���� �о�� �ڷḦ ����ϴ� ���
		//��� 1 => keySet()�޼��� �̿��ϱ�
		//		=> key���� �о�� Set������ ��ȯ�Ѵ�.
		Set<String> keySet = map.keySet();
		
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key + " => " + map.get(key));
		}
		System.out.println();
		
		//��� 1-2
		for (String key : keySet) {
			System.out.println(key + " => " + map.get(key));
		}
		System.out.println();
		
		//���2 ==> value���� �о����
		//		   value()�޼��带 �̿��ϱ�
		for (String value : map.values()) {
			System.out.println(value);
		}
		System.out.println();
		
		/*
	 	���3 ==> Map���� Entry��� ����class�� ������� �ִ�.
	 			�� EntryŬ������ key�� value��� ��������� �����Ǿ� �ִ�.
	 			Map������ �� EntryŬ���� ��ü���� Set�������� �����Ͽ� �����Ѵ�.
		 */
		//	Entry��ü ��ü�� �����ͼ� ó���ϱ�
		//	==> entrySet()�޼��� ==> ������ Entry��ü���� Set�������� ��ȯ�Ѵ�.
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		//������ Entry��ü���� ������� ó���ϱ� ���� Iterator��ü�� ��ȯ�Ѵ�.
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		
		while(entryIt.hasNext()){
			Map.Entry<String, String> entry = entryIt.next();
			System.out.println("key �� : " + entry.getKey());
			System.out.println("value �� : " + entry.getValue());
			System.out.println();
		}

		for (Map.Entry<String, String> entry : mapSet) {
			System.out.println("key �� : " + entry.getKey());
			System.out.println("value �� : " + entry.getValue());
			System.out.println();
		}		
		
		//containsKey(key��); ==> ������ key���� ������ true ������ false�� ��ȯ�Ѵ�.
		//get(key��); ==> �ش� �����Ͱ� ������ null�� ��ȯ�Ѵ�.
		//remove(key��); ==> ������ �����Ǹ� ������ �����͸� ��ȯ�ϰ� �����ϸ� null�� ��ȯ�Ѵ�.
		
		System.out.println(map.containsKey("name"));
		System.out.println(map.containsKey("key"));

		

	}
}
