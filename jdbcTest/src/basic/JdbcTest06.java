package basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import util.DBUtil;

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

public class JdbcTest06 {	
	Scanner sc;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private void start(){
		while(true){
			System.out.println("===== �۾� ���� =====");
			System.out.println("-------------------");
			System.out.println("1. �ڷ��Է�");
			System.out.println("2. �ڷ����");
			System.out.println("3. �ڷ����");
			System.out.println("4. ��ü �ڷ� ���");
			System.out.println("0. �۾� ��");
			System.out.println("-------------------");
			sc = new Scanner(System.in);
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("�ٽ� �Է����ּ���.");
				continue;
			}
			
			switch (input) {
			case 1:
				insert();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				select();
				break;
			case 0:
				System.out.println("�۾��� �����մϴ�.");				
				return;
			default:
				System.out.println("�ٽ� �Է����ּ���.");
				break;
			}			
		}		
	}
	
	private void insert(){
		try {			
			conn = DBUtil.getConnection();
			sc = new Scanner(System.in);
			
			int count = 0;	
			String mem_id ="";
			do{
				System.out.println("��� ID�� �Է����ּ��� => ");
				mem_id = sc.next();
				String checkId = "select count(*) from mymember where mem_id = ?";
				pstmt = conn.prepareStatement(checkId);
				pstmt.setString(1, mem_id);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					count = rs.getInt(1);
				}				
				if(count > 0){
					System.out.println("�ߺ��� ���ID�� �����մϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					System.out.println();
				}
			}while(count>0);			
			
			String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr) " + "values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			System.out.println("��� �̸��� �Է����ּ��� => ");
			String mem_name = sc.next();
			System.out.println("��� ��ȭ��ȣ�� �Է����ּ��� => ");
			String mem_tel = sc.next();
			System.out.println("��� �ּҸ� �Է����ּ��� => ");
			String mem_addr = sc.next();
			
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_name);
			pstmt.setString(3, mem_tel);
			pstmt.setString(4, mem_addr);
			
			count = pstmt.executeUpdate();
			
			if(count > 0){
				System.out.println("��� �Ϸ�");				
			}else{
				System.out.println("��� ����");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e2) {}			
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}			
		}
	}//End insert()
	
	private void delete(){
		sc = new Scanner(System.in);
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			System.out.println("������ �ڷ��� ���ID�� �Է����ּ��� =>");
			String mem_id = sc.next();
			String find_id = "select count(*) from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(find_id);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();		
			
			if(rs.next()){
				count = rs.getInt("count(*)");
			}
			if(count == 0){
				System.out.println("������ �ڷ��� ����� �������� �ʽ��ϴ�.");
			}else{
				String getInfo = "delete from mymember where mem_id = ?";
				pstmt = conn.prepareStatement(getInfo);
				pstmt.setString(1, mem_id);
				count = pstmt.executeUpdate();
				
				System.out.println("���� �Ϸ�");	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e2) {}
			if(stmt!=null) try {stmt.close();} catch (SQLException e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}
		}
	}//End delete()
	
	private void update(){
		sc = new Scanner(System.in);
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			System.out.println("������ �ڷ��� ���ID�� �Է����ּ��� =>");
			String mem_id = sc.next();
			String find_id = "select count(*) from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(find_id);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt("count(*)");
			}
			if(count == 0){
				System.out.println("������ �ڷ��� ����� �������� �ʽ��ϴ�.");
			}else{
				String sql = "update mymember set mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.println("����� �̸��� �������ּ��� => ");
				String mem_name = sc.next();
				System.out.println("��� ��ȭ��ȣ�� �������ּ��� => ");
				String mem_tel = sc.next();
				System.out.println("��� �ּҸ� �������ּ��� => ");
				String mem_addr = sc.next();			
				
				pstmt.setString(1, mem_name);
				pstmt.setString(2, mem_tel);
				pstmt.setString(3, mem_addr);
				pstmt.setString(4, mem_id);
				
				count = pstmt.executeUpdate();
				System.out.println("���� �Ϸ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e2) {}
			if(stmt!=null) try {stmt.close();} catch (SQLException e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}			
		}
	}//End update()
	
	private void select(){
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from mymember";
			rs = stmt.executeQuery(sql);
			System.out.println("����ü ��� ������");
			while(rs.next()){
				System.out.println("I    D : " + rs.getString("mem_id"));
				System.out.println("��    �� : " + rs.getString("mem_name"));
				System.out.println("��ȭ��ȣ : " + rs.getString("mem_tel"));
				System.out.println("��    �� : " + rs.getString("mem_addr"));
				System.out.println("__________________________");
			}
			
		} catch (SQLException e) {
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e2) {}
			if(stmt!=null) try {stmt.close();} catch (SQLException e2) {}			
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}			
		}		
	}//End select()

	public static void main(String[] args) {
		new JdbcTest06().start();
	}

}
