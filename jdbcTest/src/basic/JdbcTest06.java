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
	회원을 관리하는 프로그램을 작성하시오. (MYMEMBER테이블 이용)
	아래메뉴의 기능을 모두 구현하시오.
	(CRUD기능 구현하기)
	
	**자료 삭제는 회원ID를 입력받아 삭제한다.
	**수정은 회원ID는 변경 불가
	메뉴예시)
	===== 작업 선택 =====
	-------------------
	1. 자료입력			---> insert	(Create)
	2. 자료삭제			---> delete	(Delete)
	3. 자료수정			---> update	(Update)
	4. 전체 자료 출력		---> select (Read)
	0. 작업 끝	
 */

public class JdbcTest06 {	
	Scanner sc;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private void start(){
		while(true){
			System.out.println("===== 작업 선택 =====");
			System.out.println("-------------------");
			System.out.println("1. 자료입력");
			System.out.println("2. 자료삭제");
			System.out.println("3. 자료수정");
			System.out.println("4. 전체 자료 출력");
			System.out.println("0. 작업 끝");
			System.out.println("-------------------");
			sc = new Scanner(System.in);
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("다시 입력해주세요.");
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
				System.out.println("작업을 종료합니다.");				
				return;
			default:
				System.out.println("다시 입력해주세요.");
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
				System.out.println("멤버 ID를 입력해주세요 => ");
				mem_id = sc.next();
				String checkId = "select count(*) from mymember where mem_id = ?";
				pstmt = conn.prepareStatement(checkId);
				pstmt.setString(1, mem_id);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					count = rs.getInt(1);
				}				
				if(count > 0){
					System.out.println("중복된 멤버ID가 존재합니다.");
					System.out.println("다시 입력해주세요.");
					System.out.println();
				}
			}while(count>0);			
			
			String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr) " + "values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			System.out.println("멤버 이름을 입력해주세요 => ");
			String mem_name = sc.next();
			System.out.println("멤버 전화번호를 입력해주세요 => ");
			String mem_tel = sc.next();
			System.out.println("멤버 주소를 입력해주세요 => ");
			String mem_addr = sc.next();
			
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_name);
			pstmt.setString(3, mem_tel);
			pstmt.setString(4, mem_addr);
			
			count = pstmt.executeUpdate();
			
			if(count > 0){
				System.out.println("등록 완료");				
			}else{
				System.out.println("등록 실패");
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
			System.out.println("삭제할 자료의 멤버ID를 입력해주세요 =>");
			String mem_id = sc.next();
			String find_id = "select count(*) from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(find_id);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();		
			
			if(rs.next()){
				count = rs.getInt("count(*)");
			}
			if(count == 0){
				System.out.println("삭제할 자료의 멤버가 존재하지 않습니다.");
			}else{
				String getInfo = "delete from mymember where mem_id = ?";
				pstmt = conn.prepareStatement(getInfo);
				pstmt.setString(1, mem_id);
				count = pstmt.executeUpdate();
				
				System.out.println("삭제 완료");	
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
			System.out.println("수정할 자료의 멤버ID를 입력해주세요 =>");
			String mem_id = sc.next();
			String find_id = "select count(*) from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(find_id);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt("count(*)");
			}
			if(count == 0){
				System.out.println("수정할 자료의 멤버가 존재하지 않습니다.");
			}else{
				String sql = "update mymember set mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				System.out.println("멤버의 이름을 변경해주세요 => ");
				String mem_name = sc.next();
				System.out.println("멤버 전화번호를 변경해주세요 => ");
				String mem_tel = sc.next();
				System.out.println("멤버 주소를 변경해주세요 => ");
				String mem_addr = sc.next();			
				
				pstmt.setString(1, mem_name);
				pstmt.setString(2, mem_tel);
				pstmt.setString(3, mem_addr);
				pstmt.setString(4, mem_id);
				
				count = pstmt.executeUpdate();
				System.out.println("수정 완료");
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
			System.out.println("※전체 멤버 정보※");
			while(rs.next()){
				System.out.println("I    D : " + rs.getString("mem_id"));
				System.out.println("이    름 : " + rs.getString("mem_name"));
				System.out.println("전화번호 : " + rs.getString("mem_tel"));
				System.out.println("주    소 : " + rs.getString("mem_addr"));
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
