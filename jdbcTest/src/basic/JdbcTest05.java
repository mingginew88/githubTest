package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	LPROD테이블에 새로운 데이터 추가하기 문제
	
	lprod_gu와 lprod_nm은 직접 입력받아 처리하고,
	lprod_id는 현재까지의 lprod_id중 제일 큰 값보다 1 증가된 값으로 한다.
	
	lprod_gu값은 중복되면 중복되지 않을 때 까지 다시 입력받는다.
	
	max()함수, count()함수 중복?
	select count(*) from lprod where lprod_gu ='P111';
	select max(lprod_id) from lprod;
 */
public class JdbcTest05 {	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;		
		Scanner sc;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "pc17";
			String pw = "java";
			conn = DriverManager.getConnection(url, id, pw);			
			
			String sql = "insert into lprod(lprod_id, lprod_gu, lprod_nm) " + "values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			sc = new Scanner(System.in);
			System.out.println("분류번호를 입력해주세요.");
			String lprod_gu = sc.next();
			System.out.println("분류명을 입력해주세요.");
			String lprod_nm = sc.next();
			
			stmt = conn.createStatement();
			String all_lprod = "select * from lprod where lprod_gu = '" + lprod_gu + "' and lprod_nm = '" + lprod_nm + "'";
			rs = stmt.executeQuery(all_lprod);
			String lprod = "select * from lprod";
			rs2 = stmt.executeQuery(lprod);
			while(rs2.next()){
				if(!(rs2.getString("lprod_gu").equals(lprod_gu) || rs2.getString("lprod_nm").equals(lprod_nm))){
					String a = "select lprod_id from lprod";
					rs3 = stmt.executeQuery(a);
					int num = 0;
					while(rs3.next()){
						num++;
					}
					pstmt.setInt(1, num+1);
					pstmt.setString(2, lprod_gu + "");
					pstmt.setString(3, lprod_nm + "");
					int cnt = pstmt.executeUpdate();
					System.out.println("등록이 완료되었습니다.");
//					System.out.println("첫번째 반환값 확인: " + cnt);
					break;
				}
				System.out.println("==========================");
				System.out.println("존재하는 분류번호 또는 분류명 입니다.");
				System.out.println("분류번호를 다시 입력해주세요.");
				lprod_gu = sc.next();
				System.out.println("분류명을 다시 입력해주세요.");
				lprod_nm = sc.next();
			}			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null)try {rs.close();} catch (SQLException e2) {}
			if(stmt!=null)try {stmt.close();} catch (SQLException e2) {}
			if(pstmt!=null)try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null)try {conn.close();} catch (SQLException e2) {}			
		}	
	}
}
