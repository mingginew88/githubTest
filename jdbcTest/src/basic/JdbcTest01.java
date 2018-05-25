package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC ==> Java Database  Connectivity
//			자바를 이용하여 DB에 연결하여 사용하는 기술

// JDBC를 사용하려면 해당 프로젝트의 build path에 JDBC라이브러리를 등록해야 한다.
// JDBC 라이브러리는 연결하려는 DB회사에서 제공해 준다.
//

public class JdbcTest01 {
	
	/*
	 데이터베이스 처리순서
	 	1. 드라이버 로딩 ==> DB관련 작업을 수행할 수 있는 클래스를 메모리에 로딩하는 작업
	 		Class.forName("oracle.jdbc.driver.OracleDriver");
	 		
	 	2. DB에 접속하기 ==> 접속이 완료되면 Connection객체를 얻을 수 있다.
	 		DriverManager.getConnection() 메서드를 이용한다.
	 		
	 	3. 질의(SQL문을 실행한다.) ==> Statement객체 또는 PreparedStatement객체를 이용하여 
	 								SQL명령을 DB에 전달하여 실행하고, 실행된 결과를 받아온다.
	 	
	 	4. 질의 결과를 받아서 처리하기
	 		1) SQL문이 'select'문일 경우 ==> ResultSet객체가 만들어지고 이 ResultSet객체에 'select'한 결과가 담긴다.
	 		2) SQL문이 'insert', 'update', 'delete'등 'select'문이 아닐경우 
	 			==> 처리된 결과가 정수값이 반환된다. 이 정수값의 의미는 처리된 '레코드 수'를 의미한다.
	 	
	 	5. 종료 ==> 사용했던 객체들의 자원을 반납한다.
	 			(ResultSet, Statement, PreparedStatement, Connect)
	  */
	
	public static void main(String[] args) {
		//DB작업에 필요한 객체 변수 선언
		Connection conn = null;
		Statement stmt =null;
		ResultSet rs = null;	//쿼리문이 'select'일 경우 필요
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB접속 ==> Connection객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";			//localhost 자신의 컴퓨터		다른컴퓨터의경우 IP주소 쓰면된다.
			String user = "pc17";
			String pass = "java";
			conn = DriverManager.getConnection(url, user, pass);
			
			//3. Statement객체 생성
			//	(Statement객체는 Connection객체를 이용해서 생성한다.)
			stmt = conn.createStatement();
			
			//4. SQL문을 Statement객체를 이용하여 실행하고 실행결과를 ResultSet객체에 저장한다.
			String sql = "select * from lprod";
			rs = stmt.executeQuery(sql);
			
			 //5. 결과 처리 ==> ResultSet객체에 저장되어 있는 자료를 반복문을 이용하여 차례로 읽어와 처리한다.
			System.out.println("== 실행 결과 ==");
			
			//ResultSet객체에 담겨있는 데이터(레코드)에 접근하기위해
			//현재 작업을 진행하는 레코드를 가리키는 것이 있는데 이것을 커서(Cursor)라 한다.
			//next()메서드는 이 커서의 위치를 다음 레코드 위치로 이동시키고
			//그 자리에 데이터가 있으면 true, 없으면 false를 반환한다.
			System.out.println("========================================================");
			while(rs.next()){
				//칼럼의 데이터를 가져오기 위해서는 'get자료형이름()'메서드를 사용하는데
				//이 메서드의 매개값으로 '칼럼명' 또는 '칼럼번호'를 지정하면 된다. (칼럼번혼느 1번부터 시작한다.)
//				System.out.print("Lprod_id : " + rs.getInt("lprod_id") + "\t");
				System.out.print("Lprod_id : " + rs.getInt(1) + "\t");
				System.out.print("Lprod_gu : " + rs.getString("lprod_gu")+ "\t");
				System.out.print("Lprod_nm : " + rs.getString("lprod_nm")+ "\t");
				System.out.println();
			}
			System.out.println("========================================================");
			System.out.println("출력끝....");
			
//			rs.afterLast();
//			rs.beforeFirst();
//			rs.first();
//			rs.last();			
//			rs.previous();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6.사용했던 자원 반납
			if(rs!=null) try {rs.close();} catch (SQLException e2) {}
			if(stmt!=null) try {stmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}
		}

		
	}
}
