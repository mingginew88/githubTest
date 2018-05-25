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
public class JdbcTest06_1 {
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		new JdbcTest06_1().startMember();
	}
	
	public int displayMenu(){
		System.out.println("===== 작업 선택 =====");
		System.out.println("-------------------");
		System.out.println("1. 자료입력");
		System.out.println("2. 자료삭제");
		System.out.println("3. 자료수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println("-------------------");
		System.out.println(" 작업선택 >>");
		int choice  = scan.nextInt();
		
		return choice;		
	}
	
	
	//작업을 시작하는 메서드
	public void startMember(){
		int choice;
		do{
			choice = displayMenu();
			switch(choice){
			case 1: //자료입력
				insertMember();
				break;
			case 2: //자료삭제
				deleteMember();
				break;
			case 3: //자료수정
				updateMember();
				break;
			case 4: //전체자료 출력
				displayAllMember();
				break;
			case 0:
				System.out.println("작업을 마칩니다.");
				break;
			default :
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
			}
		}while(choice!=0);
	}//End startMember()
	
	
	//전체회원정보를 출력하는 메서드
	public void displayAllMember(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("---------------------------------------------------");
		System.out.println(" ID     이름      전화번호    주소");
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
			System.out.println("자료 출력 완료...");	
			
		} catch (SQLException e) {
			System.out.println("전체 자료 가져오기 실패");
			e.printStackTrace();
		}
	}
	
	//회원정보를 수정하는 메서드
	public void updateMember(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println();
		System.out.print("수정할 회원ID 입력 >> ");
		String memId = scan.next();
		
		int cnt = getMemberCount(memId);
		if(cnt==0){
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			return;
		}
		
		System.out.print("새로운 회원이름 >> ");
		String memName = scan.next();
		
		System.out.print("새로운 회원전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine();
		System.out.print("새로운 회원주소 >> ");
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
				System.out.println(memId + "회원의 정보를 수정했습니다.");
			}
		} catch (SQLException e) {
			System.out.println("회원 정보 수정 실패");
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}
		}
	}
	
	
	//회원정보를 삭제하는 메서드
	public void deleteMember(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println();
		System.out.println("삭제할 회원ID 입력 >> ");
		String memId = scan.next();
		
		int cnt = getMemberCount(memId);
		if(cnt==0){
			System.out.println(memId + "은(는) 없는 회원ID입니다." );
			return;
		}
		
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
			if(cnt>0){
				System.out.println(memId + "회원정보삭제 성공");
			}
			
		} catch (SQLException e) {
			System.out.println("삭제 작업 실패");
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}
		}
		
	}
	
	
	//회원정보를 추가(입력)하는 메서드
	public void insertMember(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요.");
			int cnt = 0;
			String memId = "";
			//회원ID를 입력받아 중복되는지 여부를 검사한다.
			do{
				System.out.println("회원ID >> ");
				memId = scan.next();
				cnt = getMemberCount(memId);
				if(cnt > 0){
					System.out.println(memId + "는 이미 등록된 회원ID입니다.");
					System.out.println("다시 입력하세요.");
				}
			}while(cnt > 0);
			
			System.out.print("회원이름 >> ");
			String memName = scan.next();
			
			System.out.print("회원전화번호 >> ");
			String memTel = scan.next();
			
			scan.nextLine();	//입력버퍼 지우기
			System.out.print("회원주소 >> ");
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
				System.out.println("회원ID가 " + memId + "인 회원 추가완료");
			}
		} catch (SQLException e) {
			System.out.println("자료 추가 실패");
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try {conn.close();} catch (SQLException e2) {}
		}		
	}
	
	
	//회원수를 반환하는 메서드
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
