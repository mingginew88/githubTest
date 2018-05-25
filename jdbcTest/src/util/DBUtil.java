package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//JDBC드라이버를 로딩하고 Connection객체를 생성하는 메서드로 구성된 class

public class DBUtil {
	
	//드라이버 로딩하는 부분은 static초기화 블럭에서 처리한다.
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}		
	}
	
	//Connection객체를 생성해서 반환하는 메서드
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc17", "java");
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	

}
