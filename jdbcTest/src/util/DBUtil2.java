package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// db.properties파일의 내용을 읽어와 설정하는 방법
// 방법1) Properties객체를 이용하는 방법


public class DBUtil2 {
	static Properties prop; //Properties객체 변수 선언
	
	static{
		prop = new Properties();	//객체 생성
		
		File file = new File("res/db.properties");
		
		try {
			FileInputStream fin = new FileInputStream(file);
			prop.load(fin);
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("driver"));
		} catch (IOException e) {
			System.out.println("입출력 오류입니다.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}		
	}//static
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pass"));
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
			return null;
		}
	}
	
	
	

}
