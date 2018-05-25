package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
문제2) 사용자로부터 2개의 lprod_id값을 입력받아서
	LPROD테이블에서 두 값 중 작은값부터 큰값 사이의 자료들을 출력하시오.
	(JdbcTest03 클래스로 작성)
*/
public class JdbcTest03 {	
	public static void main(String[] args) {
		Scanner sc;
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
			
			sc = new Scanner(System.in);
			int input1 = sc.nextInt();
			int input2 = sc.nextInt();
			
			if(input1 > input2){
				int tmp = input1;
				input1 = input2;
				input2 = tmp;
			}
			
			String sql = "select * from lprod where lprod_id between'"+ input1 + "'and'"+ input2 + "'";	
			
			resultset = statement.executeQuery(sql);
			
			while(resultset.next()){
				System.out.println("lprod_id : " + resultset.getInt("lprod_id"));
				System.out.println("lprod_gu : " + resultset.getString("lprod_gu"));
				System.out.println("lprod_nm : " + resultset.getString("lprod_nm"));
				System.out.println("________________________________");
			}
			
		} catch (SQLException | ClassNotFoundException e) {
		} finally {
			if(resultset != null) try {resultset.close();} catch (SQLException e2) {}
			if(statement != null) try {statement.close();} catch (SQLException e2) {}
			if(connection != null) try {connection.close();} catch (SQLException e2) {}
		}
		
	}

	private static int parseInt(String str) {
		// TODO Auto-generated method stub
		return 0;
	}
}
