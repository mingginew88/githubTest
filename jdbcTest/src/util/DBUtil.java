package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//JDBC����̹��� �ε��ϰ� Connection��ü�� �����ϴ� �޼���� ������ class

public class DBUtil {
	
	//����̹� �ε��ϴ� �κ��� static�ʱ�ȭ ������ ó���Ѵ�.
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		}		
	}
	
	//Connection��ü�� �����ؼ� ��ȯ�ϴ� �޼���
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc17", "java");
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	

}
