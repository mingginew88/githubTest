package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
��������������������������������������������������������������������������������������
LPROD ���̺� ������ �߰��ϱ� ����				      
��������������������������������������������������������������������������������������
lprod_gu : ���� �Է¹޾� ó��. �ߺ����� ���������� �ٽ� �Է�
lprod_nm : ���� �Է¹޾� ó�� 
lprod_id : ��������� lprod_id�� ���� ū ������ 1 ������ ������ �Ѵ�. 

max()�޼����, count()�޼��带 �̿�


ex)select max(lprod_id) from lprod;  => 103
								

ex)select count(*) from lprod where lprod_gu ='P111';  =>������ 1 ������ 0   
��������������������������������������������������������������������������������������
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
			
			//lprod_id �� ���� ū ���� ���ؿ� �� �װ��� 1 ������Ű��
			String sql = "select max(lprod_id) as maxnum from lprod";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			int num = 0;
			if(rs.next()){
				num = rs.getInt("maxnum");
				//num = rs.getInt("max(lprod_id)");
				//num = rs.getInt(1);
			}
			num++;	//�о�� �� ����
			
			//=====================================================
			//�Է¹��� ��ǰ�з��ڵ�(lprod)gu)�� �ߺ��Ǵ��� ���� ó��
			//�ߺ��Ǵ� ��� �ٽ� �Է� �޴´�.
			String gu;
			int count = 0;
			do{
				System.out.println("��ǰ�з��ڵ� �Է� : ");
				gu = scan.next();
				
				String sql2 = "select count(*) as cnt from lprod where lprod_gu = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, gu);				
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				
				if(count>0){
					System.out.println("�Է��� ��ǰ �з��ڵ� " + gu + "��(��) �̹� �ִ� �ڵ��Դϴ�.");
					System.out.println("�ٽ� �Է��ϼ���.");
					System.out.println();
				}
			}while(count>0);
			//=====================================================
			
			System.out.println("��ǰ �з��� �Է� : ");
			String nm = scan.next();
			
			String sql3 = "insert into lprod (lprod_id, lprod_gu, lprod_nm) " + "values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, num);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			count = pstmt.executeUpdate();
			
			if(count > 0){
				System.out.println("��� ����");
			}else{
				System.out.println("��� ����");
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








