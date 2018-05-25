package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	LPROD���̺� ���ο� ������ �߰��ϱ� ����
	
	lprod_gu�� lprod_nm�� ���� �Է¹޾� ó���ϰ�,
	lprod_id�� ��������� lprod_id�� ���� ū ������ 1 ������ ������ �Ѵ�.
	
	lprod_gu���� �ߺ��Ǹ� �ߺ����� ���� �� ���� �ٽ� �Է¹޴´�.
	
	max()�Լ�, count()�Լ� �ߺ�?
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
			System.out.println("�з���ȣ�� �Է����ּ���.");
			String lprod_gu = sc.next();
			System.out.println("�з����� �Է����ּ���.");
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
					System.out.println("����� �Ϸ�Ǿ����ϴ�.");
//					System.out.println("ù��° ��ȯ�� Ȯ��: " + cnt);
					break;
				}
				System.out.println("==========================");
				System.out.println("�����ϴ� �з���ȣ �Ǵ� �з��� �Դϴ�.");
				System.out.println("�з���ȣ�� �ٽ� �Է����ּ���.");
				lprod_gu = sc.next();
				System.out.println("�з����� �ٽ� �Է����ּ���.");
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
