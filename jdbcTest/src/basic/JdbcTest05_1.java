package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
───────────────────────────────────────────
LPROD 테이블에 데이터 추가하기 문제				      
───────────────────────────────────────────
lprod_gu : 직접 입력받아 처리. 중복되지 않을때까지 다시 입력
lprod_nm : 직접 입력받아 처리 
lprod_id : 현재까지의 lprod_id중 제일 큰 값보다 1 증가된 값으로 한다. 

max()메서드와, count()메서드를 이용


ex)select max(lprod_id) from lprod;  => 103
								

ex)select count(*) from lprod where lprod_gu ='P111';  =>있으면 1 없으면 0   
───────────────────────────────────────────
*/


public class JdbcTest05_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "pc17";
			String pw = "java";
			conn = DriverManager.getConnection(url, id, pw);
			
			//lprod_id 중 제일 큰 값을 구해온 후 그값을 1 증가시키기
			String sql = "select max(lprod_id) as maxnum from lprod";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			int num = 0;
			if(rs.next()){
				num = rs.getInt("maxnum");
				//num = rs.getInt("max(lprod_id)");
				//num = rs.getInt(1);
			}
			num++;	//읽어온 값 증가
			
			//=====================================================
			//입력받은 상품분류코드(lprod)gu)가 중복되는지 여부 처리
			//중복되는 경우 다시 입력 받는다.
			String gu;
			int count = 0;
			do{
				System.out.println("상품분류코드 입력 : ");
				gu = scan.next();
				
				String sql2 = "select count(*) as cnt from lprod where lprod_gu = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, gu);				
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				
				if(count>0){
					System.out.println("입력한 상품 분류코드 " + gu + "은(는) 이미 있는 코드입니다.");
					System.out.println("다시 입력하세요.");
					System.out.println();
				}
			}while(count>0);
			//=====================================================
			
			System.out.println("상품 분류명 입력 : ");
			String nm = scan.next();
			
			String sql3 = "insert into lprod (lprod_id, lprod_gu, lprod_nm) " + "values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, num);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			count = pstmt.executeUpdate();
			
			if(count > 0){
				System.out.println("등록 성공");
			}else{
				System.out.println("등록 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e2) {}
			if(stmt!=null) try {stmt.close();} catch (SQLException e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}			
		}	
	}

}








