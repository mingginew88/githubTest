package basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;
import util.DBUtil2;
import util.DBUtil3;

/*
ȸ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�. (MYMEMBER���̺� �̿�)
�Ʒ��޴��� ����� ��� �����Ͻÿ�.
(CRUD��� �����ϱ�)

**�ڷ� ������ ȸ��ID�� �Է¹޾� �����Ѵ�.
**������ ȸ��ID�� ���� �Ұ�
�޴�����)
===== �۾� ���� =====
-------------------
1. �ڷ��Է�			---> insert	(Create)
2. �ڷ����			---> delete	(Delete)
3. �ڷ����			---> update	(Update)
4. ��ü �ڷ� ���		---> select (Read)
0. �۾� ��	
*/
public class JdbcTest06_1 {
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		new JdbcTest06_1().startMember();
	}
	
	public int displayMenu(){
		System.out.println("===== �۾� ���� =====");
		System.out.println("-------------------");
		System.out.println("1. �ڷ��Է�");
		System.out.println("2. �ڷ����");
		System.out.println("3. �ڷ����");
		System.out.println("4. ��ü �ڷ� ���");
		System.out.println("0. �۾� ��");
		System.out.println("-------------------");
		System.out.println(" �۾����� >>");
		int choice  = scan.nextInt();
		
		return choice;		
	}
	
	
	//�۾��� �����ϴ� �޼���
	public void startMember(){
		int choice;
		do{
			choice = displayMenu();
			switch(choice){
			case 1: //�ڷ��Է�
				insertMember();
				break;
			case 2: //�ڷ����
				deleteMember();
				break;
			case 3: //�ڷ����
				updateMember();
				break;
			case 4: //��ü�ڷ� ���
				displayAllMember();
				break;
			case 0:
				System.out.println("�۾��� ��Ĩ�ϴ�.");
				break;
			default :
				System.out.println("��ȣ�� �߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}while(choice!=0);
	}//End startMember()
	
	
	//��üȸ�������� ����ϴ� �޼���
	public void displayAllMember(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("---------------------------------------------------");
		System.out.println(" ID     �̸�      ��ȭ��ȣ    �ּ�");
		System.out.println("---------------------------------------------------");
		
		try {
			//conn = DBUtil.getConnection();
			//conn = DBUtil2.getConnection();
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				System.out.println(memId + "\t" + memName + "\t" + memTel + "\t" + memAddr);				
			}
			System.out.println("---------------------------------------------------");
			System.out.println("�ڷ� ��� �Ϸ�...");	
			
		} catch (SQLException e) {
			System.out.println("��ü �ڷ� �������� ����");
			e.printStackTrace();
		}
	}
	
	//ȸ�������� �����ϴ� �޼���
	public void updateMember(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println();
		System.out.print("������ ȸ��ID �Է� >> ");
		String memId = scan.next();
		
		int cnt = getMemberCount(memId);
		if(cnt==0){
			System.out.println(memId + "��(��) ���� ȸ��ID �Դϴ�.");
			return;
		}
		
		System.out.print("���ο� ȸ���̸� >> ");
		String memName = scan.next();
		
		System.out.print("���ο� ȸ����ȭ��ȣ >> ");
		String memTel = scan.next();
		
		scan.nextLine();
		System.out.print("���ο� ȸ���ּ� >> ");
		String memAddr = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update mymember set mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memName);
			pstmt.setString(2, memTel);
			pstmt.setString(3, memAddr);
			pstmt.setString(4, memId);
			
			cnt = pstmt.executeUpdate();
			if(cnt > 0){
				System.out.println(memId + "ȸ���� ������ �����߽��ϴ�.");
			}
		} catch (SQLException e) {
			System.out.println("ȸ�� ���� ���� ����");
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}
		}
	}
	
	
	//ȸ�������� �����ϴ� �޼���
	public void deleteMember(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println();
		System.out.println("������ ȸ��ID �Է� >> ");
		String memId = scan.next();
		
		int cnt = getMemberCount(memId);
		if(cnt==0){
			System.out.println(memId + "��(��) ���� ȸ��ID�Դϴ�." );
			return;
		}
		
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
			if(cnt>0){
				System.out.println(memId + "ȸ���������� ����");
			}
			
		} catch (SQLException e) {
			System.out.println("���� �۾� ����");
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}
		}
		
	}
	
	
	//ȸ�������� �߰�(�Է�)�ϴ� �޼���
	public void insertMember(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			System.out.println();
			System.out.println("�߰��� ȸ�� ������ �Է��ϼ���.");
			int cnt = 0;
			String memId = "";
			//ȸ��ID�� �Է¹޾� �ߺ��Ǵ��� ���θ� �˻��Ѵ�.
			do{
				System.out.println("ȸ��ID >> ");
				memId = scan.next();
				cnt = getMemberCount(memId);
				if(cnt > 0){
					System.out.println(memId + "�� �̹� ��ϵ� ȸ��ID�Դϴ�.");
					System.out.println("�ٽ� �Է��ϼ���.");
				}
			}while(cnt > 0);
			
			System.out.print("ȸ���̸� >> ");
			String memName = scan.next();
			
			System.out.print("ȸ����ȭ��ȣ >> ");
			String memTel = scan.next();
			
			scan.nextLine();	//�Է¹��� �����
			System.out.print("ȸ���ּ� >> ");
			String memAddr = scan.nextLine();
			
			conn = DBUtil.getConnection();
			
			String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr) values( ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);
			
			cnt = pstmt.executeUpdate();
			
			if(cnt > 0){
				System.out.println("ȸ��ID�� " + memId + "�� ȸ�� �߰��Ϸ�");
			}
		} catch (SQLException e) {
			System.out.println("�ڷ� �߰� ����");
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}
		}		
	}
	
	
	//ȸ������ ��ȯ�ϴ� �޼���
	public int getMemberCount(String memId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int cnt = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) as cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally{
			if(rs!=null) try {rs.close();} catch (SQLException e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}
		}	
		
		return cnt;
	}
	
	
	
	
	
	
	
	
	
	

}
