package basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


import util.DBUtil3;

public class JdbcBoardTest {
	Scanner sc;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public static void main(String[] args) {
		new JdbcBoardTest().start();
	}	
	
	public void start(){
		
		while(true){
			sc = new Scanner(System.in);
			consoleList();
			System.out.println("1. 상세보기 2. 새글쓰기 3. 게시글 수정 4. 게시글 삭제");
			
			int input = 0;			
			try {
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
			
			switch (input) {
			case 1:
				showDetailBoard();
				break;
			case 2: 
				writeNewBoard();
				break;
			case 3:
				updateBoard();
				break;
			case 4:
				deleteBoard();
				break;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
		}
	}
	
	public void consoleList(){
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board";
			stmt = conn.createStatement();
			rs =stmt.executeQuery(sql);
			
			System.out.println("콘솔 게시판 리스트");
			System.out.println("=============================================");
			System.out.println("번호      제목      작성자           날짜");
			System.out.println("=============================================");
			while(rs.next()){
				int board_no = rs.getInt("board_no");
				String board_title = rs.getString("board_title");
				String board_writer = rs.getString("board_writer");
				String board_data = rs.getString("board_data");			
				System.out.println(board_no + "\t" + board_title + "\t" + board_writer + "\t" + board_data);
			} 
			System.out.println("=============================================");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
	}
	
	public void showDetailBoard(){
		try {
			sc = new Scanner(System.in);
			consoleList();
			
			int input = 0;			
			try {
				input = sc.nextInt();				
			} catch (InputMismatchException e) {
				System.out.println("잘못입력하였습니다. 다시입력해주세요.");
			}
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);			
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("게시판 상세 내용 보기");
				System.out.println("=============================================");
				System.out.println("번   호 : " + rs.getInt("board_no"));
				System.out.print("제   목 : " + rs.getString("board_title"));
				System.out.println("\t 글쓴이 : " + rs.getString("board_writer"));
				System.out.println("내   용 : -------------------------------------");
				System.out.println(rs.getString("board_content"));
				System.out.println("---------------------------------------------");
				System.out.println(rs.getString("board_data"));
				System.out.println("=============================================");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}		
	}
	
	public void writeNewBoard(){
		try {
			sc = new Scanner(System.in);
			conn = DBUtil3.getConnection();
			String sql = "insert into jdbc_board (board_no, board_title, board_writer, board_data, board_content) values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			String maxNum = "select max(board_no) from jdbc_board";
			stmt =conn.createStatement();
			rs = stmt.executeQuery(maxNum);		
			
			int num = 0;
			if(rs.next()){
				num = rs.getInt("max(board_no)");				
			}
			num++;
			
//			String number = "create sequence board_no start with 1 increment BY 1 maxvalue 1000";
//			stmt = conn.createStatement();			
//			rs = stmt.executeQuery(number);
						
			System.out.println("새글쓰기");
			System.out.println("=============================================");
			System.out.print("제  목 : ");
			String board_title = sc.nextLine();
			
			System.out.print("작성자 : ");
			String board_writer = sc.next();	
						
			System.out.print("내  용 : ");
			sc.nextLine();
			String board_content = sc.nextLine();
			
			
			Date date = new Date();
			SimpleDateFormat todayDate = new SimpleDateFormat ("yyyy-MM-dd");
			
			pstmt.setInt(1, num);
			pstmt.setString(2, board_title);
			pstmt.setString(3, board_writer);
			pstmt.setString(4, todayDate.format(date));
			pstmt.setString(5, board_content);
			
			pstmt.executeUpdate();			
			System.out.println("새글이 등록되었습니다.");
			System.out.println("=============================================");	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		
	}
	
	public void updateBoard(){
		while(true){
			sc = new Scanner(System.in);
			Date date = new Date();
			SimpleDateFormat todayDate = new SimpleDateFormat ("yyyy-MM-dd");
			System.out.println("게시글 수정 작업");
			System.out.println("=============================================");
			System.out.print("수정할 게시글 번호 입력 >> ");
			
			int input = 0;
			try {
				input = sc.nextInt();
				int cnt = findBoardNo(input);
				if(cnt == 0){
					System.out.println("잘못입력하였습니다. 다시입력해주세요.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
			System.out.println("1. 글제목 2. 글내용");
			int input2 = 0;
			try {
				input2 = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
			String board_title;
			String board_content;
			if(input2 == 1){
				System.out.print("변경할 글제목을 입력해주세요. >> ");
				board_title = sc.nextLine();						
				try {
					conn = DBUtil3.getConnection();
					String sql = "update jdbc_board set board_title = ?, board_data = ? where board_no = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, board_title);	
					pstmt.setString(2, todayDate.format(date));
					pstmt.setInt(3, input);
					
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
					if(conn!=null) try {conn.close();} catch (SQLException e) {}
				}				
				
			}else if(input2 ==2){
				System.out.println("변경할 글내용을 입력해주세요. >>");
				sc.nextLine();
				board_content =sc.nextLine();		
			
				try {
					conn = DBUtil3.getConnection();
					String sql = "update jdbc_board set board_data = ?, board_content = ? where board_no = ?";
					pstmt = conn.prepareStatement(sql);					
					pstmt.setString(1, todayDate.format(date));
					pstmt.setString(2, board_content);
					pstmt.setInt(3, input);
					
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
					if(conn!=null) try {conn.close();} catch (SQLException e) {}
				}
			}
			break;
		}	
	}	
	
	public void deleteBoard(){		
		while(true){
			sc = new Scanner(System.in);
			System.out.println("게시글 삭제 작업");
			System.out.println("=============================================");
			System.out.println("삭제할 게시글 번호 입력 >> ");
			int input = 0;
			try {
				input = sc.nextInt();			
				int cnt = findBoardNo(input);
				if(cnt == 0){
					System.out.println("잘못입력하였습니다. 다시입력해주세요.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못입력하였습니다. 다시입력해주세요.");
				continue;
			}
			try {
				conn = DBUtil3.getConnection();
				String sql = "delete from jdbc_board where board_no = ? ";
				pstmt.setInt(1, input);
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("삭제되었습니다.");
			System.out.println("=============================================");		
			break;
		}	
	}
	
	public int findBoardNo(int board_no){		
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) as cnt from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			
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



