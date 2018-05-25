package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
����2) ����ڷκ��� 2���� lprod_id���� �Է¹޾Ƽ�
	LPROD���̺��� �� �� �� ���������� ū�� ������ �ڷ���� ����Ͻÿ�.
	(JdbcTest03 Ŭ������ �ۼ�)
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
