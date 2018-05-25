package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	����1) PROD���̺��� ��ǰ�з��ڵ�(Prod_Lgu)�� P101�� ��ǰ�� ����Ͻÿ�.
	����2) ����ڷκ��� 2���� lprod_id���� �Է¹޾Ƽ�
	 	LPROD���̺��� �� �� �� ���������� ū�� ������ �ڷ���� ����Ͻÿ�.
	 	(JdbcTest03 Ŭ������ �ۼ�)
 */

public class JdbcTest02 {
	
	
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;				
		
		try {
			//1. ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DB���� ==> Connection��ü ����
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "pc17";
			String pass = "java";
			connection = DriverManager.getConnection(url, id, pass);
			//3. Statement��ü ����
			statement = connection.createStatement();
			//4. SQL���� Statement��ü�� �̿��Ͽ� �����ϰ� �������� ResultSet��ü�� �����Ѵ�.
			
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			
			String sql = "select * from prod where prod_lgu= '"+ str +"'";
			result = statement.executeQuery(sql);
			//5. ��� ó�� ==> ResultSet��ü�� ����Ǿ� �ִ� �ڷḦ �ݺ����� �̿��Ͽ� ���ʷ� �о�� ó���Ѵ�.
			while(result.next()){
				System.out.println("__________________");
				System.out.println("prod_id    : " + result.getString("prod_id"));
				System.out.println("prod_name  : " + result.getString(2));
				System.out.println("prod_lgu   : " + result.getString(3));
				System.out.println("prod_buyer : " + result.getString("prod_buyer"));
				System.out.println("__________________");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//6.����ߴ� �ڿ� �ݳ�
			if(result!=null) try { result.close(); } catch (SQLException e2) {}
			if(statement!=null) try { statement.close(); } catch (SQLException e2) {}
			if(connection!=null) try { connection.close(); } catch (SQLException e2) {}					
		}
		
	}
}
