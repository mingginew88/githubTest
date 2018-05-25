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
		
		
		
		
		//1. ����̹� �ε�
		
		//2. DB���� ==> Connection��ü ����
		//3. Statement��ü ����
		//4. SQL���� Statement��ü�� �̿��Ͽ� �����ϰ� �������� ResultSet��ü�� �����Ѵ�.
		//5. ��� ó�� ==> ResultSet��ü�� ����Ǿ� �ִ� �ڷḦ �ݺ����� �̿��Ͽ� ���ʷ� �о�� ó���Ѵ�.
		//6.����ߴ� �ڿ� �ݳ�		
	}

}
