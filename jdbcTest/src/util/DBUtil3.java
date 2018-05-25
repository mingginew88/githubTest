package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


//db.properties������ ������ �о�� �����ϴ� ���
//���2) ResourceBundle��ü�� �̿��ϴ� ���


public class DBUtil3 {
	static ResourceBundle bundle;	//ResourceBundle��ü ���� ����
	
	static{
		//���� ���� �о�� ��ü ����
		bundle = ResourceBundle.getBundle("db");
		
		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		}
	}//static
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("DB���� ����");
			return null;
		}
	}
	
	
	
	
}
