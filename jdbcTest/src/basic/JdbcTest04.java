package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest04 {
	/*
	 insert����
	 
	 lprod_id : 101, lprod_gu: N101, lprod_nm: ��깰
	 lprod_id : 102, lprod_gu: N102, lprod_nm: ���깰
	 lprod_id : 103, lprod_gu: N103, lprod_nm: ��깰	 
	 
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc17", "java");
			
			/*			
			String sql = "insert into lprod(lprod_id, lprod_gu, lprod_nm) " + "values(101, 'N101', '��깰')";
			stmt = conn.createStatement();			
			//SQL���� 'select'���� ���״� executeQuery()�޼��带 SQL���� 'select'���� �ƴҰ�쿡�� executeUpdate()�޼��带 ����Ѵ�.
			//executeUpdate()�޼����� ��ȯ���� �۾��� '������ ���ڵ� ��'�̴�.
			int cnt = stmt.executeUpdate(sql);	
			System.out.println("ù��° ����");
			
			sql = "insert into lprod(lprod_id, lprod_gu, lprod_nm) " + "values(102, 'N102', '���깰')";
			cnt = stmt.executeUpdate(sql);
			System.out.println("�ι�° ����");
			
			sql = "insert into lprod(lprod_id, lprod_gu, lprod_nm) " + "values(103, 'N103', '��깰')";
			cnt = stmt.executeUpdate(sql);
			System.out.println("����° ����");
			
			if(cnt>0){
				System.out.println("insert�۾� ����!!");
			}else{
				System.out.println("insert�۾� ����~~");
			}
			*/
			
			//PreparedStatement��ü�� �̿��ϱ�
			//SQL���忡�� ������ �����Ͱ� �� �ڸ��� ?
			String sql = "insert into lprod(lprod_id, lprod_gu, lprod_nm) " + "values(?, ?, ?)";
			
			//PreparedStatement��ü�� ������ ��
			pstmt = conn.prepareStatement(sql);
			
			//SQL���� ?�ڸ��� �� �����͸� �����Ѵ�. (set���� �����ϴ� �޼��� �̿�)
			//����) set�ڷ����̸�(������ ?�� ��ȣ, ������ ��)
			pstmt.setInt(1, 101);	//ù��° ?�ڸ��� 101�� �����϶�.
			pstmt.setString(2, "N101");
			pstmt.setString(3, "��깰");
			
			int cnt = pstmt.executeUpdate();
			System.out.println("ù��° ��ȯ �� : " + cnt);
			
			pstmt.setInt(1, 102);
			pstmt.setString(2, "N102");
			pstmt.setString(3, "���깰");
			cnt = pstmt.executeUpdate();
			System.out.println("�ι�° ��ȯ �� : " + cnt);
			
			pstmt.setInt(1, 103);
			pstmt.setString(2, "N103");
			pstmt.setString(3, "��깰");
			cnt = pstmt.executeUpdate();
			System.out.println("����° ��ȯ �� : " + cnt);
			
			
		
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
