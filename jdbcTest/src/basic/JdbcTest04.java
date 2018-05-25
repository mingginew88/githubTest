package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest04 {
	/*
	 insert연습
	 
	 lprod_id : 101, lprod_gu: N101, lprod_nm: 농산물
	 lprod_id : 102, lprod_gu: N102, lprod_nm: 수산물
	 lprod_id : 103, lprod_gu: N103, lprod_nm: 축산물	 
	 
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc17", "java");
			
			/*			
			String sql = "insert into lprod(lprod_id, lprod_gu, lprod_nm) " + "values(101, 'N101', '농산물')";
			stmt = conn.createStatement();			
			//SQL문이 'select'문일 경우네느 executeQuery()메서드를 SQL문이 'select'문이 아닐경우에는 executeUpdate()메서드를 사용한다.
			//executeUpdate()메서드의 반환값은 작업이 '성공한 레코드 수'이다.
			int cnt = stmt.executeUpdate(sql);	
			System.out.println("첫번째 성공");
			
			sql = "insert into lprod(lprod_id, lprod_gu, lprod_nm) " + "values(102, 'N102', '수산물')";
			cnt = stmt.executeUpdate(sql);
			System.out.println("두번째 성공");
			
			sql = "insert into lprod(lprod_id, lprod_gu, lprod_nm) " + "values(103, 'N103', '축산물')";
			cnt = stmt.executeUpdate(sql);
			System.out.println("세번째 성공");
			
			if(cnt>0){
				System.out.println("insert작업 성공!!");
			}else{
				System.out.println("insert작업 실패~~");
			}
			*/
			
			//PreparedStatement객체를 이용하기
			//SQL문장에서 셋팅할 데이터가 들어갈 자리에 ?
			String sql = "insert into lprod(lprod_id, lprod_gu, lprod_nm) " + "values(?, ?, ?)";
			
			//PreparedStatement객체를 생성할 때
			pstmt = conn.prepareStatement(sql);
			
			//SQL문의 ?자리에 들어갈 데이터를 셋팅한다. (set으로 시작하는 메서드 이용)
			//형식) set자료형이름(셋팅할 ?의 번호, 셋팅할 값)
			pstmt.setInt(1, 101);	//첫번째 ?자리에 101을 셋팅하라.
			pstmt.setString(2, "N101");
			pstmt.setString(3, "농산물");
			
			int cnt = pstmt.executeUpdate();
			System.out.println("첫번째 반환 값 : " + cnt);
			
			pstmt.setInt(1, 102);
			pstmt.setString(2, "N102");
			pstmt.setString(3, "수산물");
			cnt = pstmt.executeUpdate();
			System.out.println("두번째 반환 값 : " + cnt);
			
			pstmt.setInt(1, 103);
			pstmt.setString(2, "N103");
			pstmt.setString(3, "축산물");
			cnt = pstmt.executeUpdate();
			System.out.println("세번째 반환 값 : " + cnt);
			
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null)try {	stmt.close();} catch (SQLException e2) {}
			if(pstmt!=null)try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null)try {	conn.close();} catch (SQLException e2) {}
		}
		
	}

}
