package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.DBUtil3;
import board.vo.BoardVO;

public class BoardDao implements IBoardDao{

	@Override
	public List<BoardVO> boardList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select board_no, board_title, board_writer, to_char(board_data,'YY-MM-DD') as board_data, board_content from jdbc_board";
			stmt = conn.createStatement();
			rs =stmt.executeQuery(sql);		
			
			while(rs.next()){
				BoardVO boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_data(rs.getString("board_data"));
				boardVo.setBoard_content(rs.getString("board_content"));
				boardList.add(boardVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			boardList = null;
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		
		return boardList;
	}

	
	@Override
	public List<BoardVO> showDetailBoard(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		BoardVO boardVo = new BoardVO();
		
		try {			
			conn = DBUtil3.getConnection();
			String sql = "select board_no, board_title, board_writer, to_char(board_data,'YY-MM-DD') as board_data, board_content from jdbc_board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			while(rs.next()){				
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_data(rs.getString("board_data"));
				boardVo.setBoard_content(rs.getString("board_content"));
				
				boardList.add(boardVo);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}		
		return boardList;		
	}

	
	@Override
	public boolean writeNewBoard(Map<String, String> boardMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		boolean chk_success = false;
		
		
		try {			
			conn = DBUtil3.getConnection();
			String sql = "insert into jdbc_board (board_no, board_title, board_writer, to_char(board_data), board_content) values (?, ?, ?, sysdate, ?)";
			pstmt = conn.prepareStatement(sql);
			
			String maxNum = "select max(board_no) from jdbc_board";
			stmt =conn.createStatement();
			rs = stmt.executeQuery(maxNum);		
			
			int num = 0;
			if(rs.next()){
				num = rs.getInt("max(board_no)");
			}
			num++;	
			
			pstmt.setInt(1, num);
			pstmt.setString(2, boardMap.get("board_title"));
			pstmt.setString(3, boardMap.get("board_writer"));			
			pstmt.setString(4, boardMap.get("board_content"));
			
			pstmt.executeUpdate();
			chk_success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		
		return chk_success;
	}

	@Override
	public boolean updateBoard(Map<Object, Object> boardMap, int input) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean chk_success = false;		
		
		try {
			if(input==1){
				conn = DBUtil3.getConnection();
				String sql = "update jdbc_board set board_title = ?, board_data = sysdate where board_no = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, (String)boardMap.get("board_title"));
				pstmt.setInt(2, (Integer)boardMap.get("board_no"));
				
				pstmt.executeUpdate();
				chk_success =true;	
			}else if(input==2){
				conn = DBUtil3.getConnection();
				String sql = "update jdbc_board set board_content = ?, board_data = sysdate where board_no = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, (String)boardMap.get("board_content") );
				pstmt.setInt(2, (Integer)boardMap.get("board_no"));
				
				pstmt.executeUpdate();
				chk_success =true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}		
		return chk_success;
	}

	
	@Override
	public boolean deleteBoard(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean chk_success = false;	
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from jdbc_board where board_no = ? ";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		
		chk_success = true;		
		return chk_success;
	}

	@Override
	public int countBoard(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
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
