package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "pc17";
			String pw = "java";
			connection = DriverManager.getConnection(url, id, pw);
			statement = connection.createStatement();
			String sql = "select * from prod where prod_lgu = 'P101'";
			resultset = statement.executeQuery(sql);			
			
			while(resultset.next()){
				System.out.println("prod_id : " + resultset.getString(1));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(resultset != null) try {resultset.close();} catch (SQLException e2) {}
			if(statement != null) try {statement.close();} catch (SQLException e2) {}
			if(connection != null) try {connection.close();} catch (SQLException e2) {}
		}
		
		
		
		
		//1. 드라이버 로딩
		
		//2. DB접속 ==> Connection객체 생성
		//3. Statement객체 생성
		//4. SQL문을 Statement객체를 이용하여 실행하고 실행결과를 ResultSet객체에 저장한다.
		//5. 결과 처리 ==> ResultSet객체에 저장되어 있는 자료를 반복문을 이용하여 차례로 읽어와 처리한다.
		//6.사용했던 자원 반납		
	}

}
