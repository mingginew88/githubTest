package basic;

import java.util.Properties;

public class PropertiesTest {
	/*
	 	Properties�� Map���� ��ҵ� ����� ��ü��� �� �� �ִ�.
	 	
	 	Map�� ��� ������ �����͸� key�� value������ ���� �� ������
	 	Properties�� key�� value������ String�� ����� �� �ִ�.
	 	
	 	Map�� put, get �޼��带 �̿��Ͽ� �����͸� �����������
	 	Properties�� setProperty, getProperty �޼��带 �̿��Ѵ�.
	 */
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("name", "������");
		prop.setProperty("tel", "010-2222-2222");
		prop.setProperty("address", "����");
		
		String name = prop.getProperty("name");
		String tel = prop.getProperty("tel");
		String address = prop.getProperty("address");
		
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);
		
		
	}
}
