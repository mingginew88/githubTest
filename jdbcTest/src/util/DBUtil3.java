package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


//db.properties파일의 내용을 읽어와 설정하는 방법
//방법2) ResourceBundle객체를 이용하는 방법


public class DBUtil3 {
	static ResourceBundle bundle;	//ResourceBundle객체 변수 선언
	
	static{
		//파일 내용 읽어와 객체 생성
		bundle = ResourceBundle.getBundle("db");
		
		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}//static
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"), bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("DB연결 실패");
			return null;
		}
	}
	
	
	
	
}
