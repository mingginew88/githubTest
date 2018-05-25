package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// db.properties������ ������ �о�� �����ϴ� ���
// ���1) Properties��ü�� �̿��ϴ� ���


public class DBUtil2 {
	static Properties prop; //Properties��ü ���� ����
	
	static{
		prop = new Properties();	//��ü ����
		
		File file = new File("res/db.properties");
		
		try {
			FileInputStream fin = new FileInputStream(file);
			prop.load(fin);
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("driver"));
		} catch (IOException e) {
			System.out.println("����� �����Դϴ�.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		}		
	}//static
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pass"));
		} catch (SQLException e) {
			System.out.println("����Ŭ ���� ����");
			return null;
		}
	}
	
	
	

}
