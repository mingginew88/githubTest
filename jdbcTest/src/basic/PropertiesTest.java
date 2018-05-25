package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {
	
	//�ܺ� properties������ �о�� Properties��ü�� ó���ϱ�
	public static void main(String[] args) {
		//�о�� ������ ������ Properties��ü ����
		Properties prop = new Properties();
		
		//�о�� ���� ������ ���� File��ü ����
		File file = new File("res/db.properties");
		
		try {
			//���� �б⸦ �����ϱ� ���� FileInputSream��ü ����
			FileInputStream fin = new FileInputStream(file);
			
			//Properties��ü�� �̿��Ͽ� ���� ���� �о����
			prop.load(fin); 	//���� ������ �о�� key�� value�� �з��� �� Properties��ü�� ����ش�.
			
			//�о�� ���� ����� ����
			
			//key���� �о�� enumeration��ü�� ��ȯ�ϱ�
			Enumeration<String> names = (Enumeration<String>) prop.propertyNames();
			
			//key�� ������ŭ �ݺ�
			while(names.hasMoreElements()){
				String key = names.nextElement();
				String value = prop.getProperty(key);
				
				System.out.println(key + " ==> " + value);
			}
			
			System.out.println("��� ��...");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
