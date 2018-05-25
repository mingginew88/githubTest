package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	문제1) PROD테이블에서 상품분류코드(Prod_Lgu)가 P101인 제품만 출력하시오.
	문제2) 사용자로부터 2개의 lprod_id값을 입력받아서
	 	LPROD테이블에서 두 값 중 작은값부터 큰값 사이의 자료들을 출력하시오.
	 	(JdbcTest03 클래스로 작성)
 */

public class JdbcTest02 {
	
	
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;				
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DB접속 ==> Connection객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "pc17";
			String pass = "java";
			connection = DriverManager.getConnection(url, id, pass);
			//3. Statement객체 생성
			statement = connection.createStatement();
			//4. SQL문을 Statement객체를 이용하여 실행하고 실행결과를 ResultSet객체에 저장한다.
			
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			
			String sql = "select * from prod where prod_lgu= '"+ str +"'";
			result = statement.executeQuery(sql);
			//5. 결과 처리 ==> ResultSet객체에 저장되어 있는 자료를 반복문을 이용하여 차례로 읽어와 처리한다.
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
			//6.사용했던 자원 반납
			if(result!=null) try { result.close(); } catch (SQLException e2) {}
			if(statement!=null) try { statement.close(); } catch (SQLException e2) {}
			if(connection!=null) try { connection.close(); } catch (SQLException e2) {}					
		}
		
	}
}
