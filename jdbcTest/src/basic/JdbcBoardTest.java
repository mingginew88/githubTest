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
			System.out.println("1. �󼼺��� 2. ���۾��� 3. �Խñ� ���� 4. �Խñ� ����");
			
			int input = 0;			
			try {
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
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
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
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
			
			System.out.println("�ܼ� �Խ��� ����Ʈ");
			System.out.println("=============================================");
			System.out.println("��ȣ      ����      �ۼ���           ��¥");
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
				System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ��Է����ּ���.");
			}
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);			
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("�Խ��� �� ���� ����");
				System.out.println("=============================================");
				System.out.println("��   ȣ : " + rs.getInt("board_no"));
				System.out.print("��   �� : " + rs.getString("board_title"));
				System.out.println("\t �۾��� : " + rs.getString("board_writer"));
				System.out.println("��   �� : -------------------------------------");
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
						
			System.out.println("���۾���");
			System.out.println("=============================================");
			System.out.print("��  �� : ");
			String board_title = sc.nextLine();
			
			System.out.print("�ۼ��� : ");
			String board_writer = sc.next();	
						
			System.out.print("��  �� : ");
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
			System.out.println("������ ��ϵǾ����ϴ�.");
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
			System.out.println("�Խñ� ���� �۾�");
			System.out.println("=============================================");
			System.out.print("������ �Խñ� ��ȣ �Է� >> ");
			
			int input = 0;
			try {
				input = sc.nextInt();
				int cnt = findBoardNo(input);
				if(cnt == 0){
					System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ��Է����ּ���.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			System.out.println("1. ������ 2. �۳���");
			int input2 = 0;
			try {
				input2 = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
			String board_title;
			String board_content;
			if(input2 == 1){
				System.out.print("������ �������� �Է����ּ���. >> ");
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
				System.out.println("������ �۳����� �Է����ּ���. >>");
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
			System.out.println("�Խñ� ���� �۾�");
			System.out.println("=============================================");
			System.out.println("������ �Խñ� ��ȣ �Է� >> ");
			int input = 0;
			try {
				input = sc.nextInt();			
				int cnt = findBoardNo(input);
				if(cnt == 0){
					System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ��Է����ּ���.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ��Է����ּ���.");
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
			
			System.out.println("�����Ǿ����ϴ�.");
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



