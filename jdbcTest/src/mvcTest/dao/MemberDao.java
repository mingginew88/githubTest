package mvcTest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.DBUtil3;
import mvcTest.vo.MemberVO;

public class MemberDao implements IMemberDao{
	private static MemberDao single = new MemberDao();
	
	private MemberDao(){		
	}
	
	public static MemberDao getInstance(){
		if(single==null){
			single = new MemberDao();
		}
		return single;
	}	
	
	//MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr) values( ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		return cnt;
	}
	
	//매개변수로 받은 회원ID와 일치하는 자료를 삭제하는 메서드
	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from mymember where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		return cnt;
	}
	
	
	//하나의 MemberVO객체 자료를 이용하여 DB update하는 메서드
	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "update mymember set mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memVo.getMem_name());
			pstmt.setString(2, memVo.getMem_tel());
			pstmt.setString(3, memVo.getMem_addr());
			pstmt.setString(4, memVo.getMem_id());
			
			cnt = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}		
		return cnt;
	}
	
	
	//myMember테이블의 전체 자료를 가져와 List에 담아서 반환하는 메서드
	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from myMember ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				//각각의 레코드들을 MemberVO에 Setting한 후 List에 추가한다.
				MemberVO mv = new MemberVO();
				
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));				
				memList.add(mv);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			memList = null;
		}finally {			
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		return memList;
	}

	
	//주어진 회원ID와 일치하는 회원수를 반환하는 메서드
	@Override
	public int getCountMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {			
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}		
		return cnt;
	}
	
	
	public int getCountMemName(String memName){
		Connection conn = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) cnt from mymember where mem_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memName);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {			
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		return cnt;
	}
	
	
	
	public int getCountMemTel(String memTel){
		Connection conn = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) cnt from mymember where mem_tel = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memTel);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		return cnt;
	}
	
	
	public int getCountMemAddr(String memAddr){
		Connection conn = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) cnt from mymember where mem_addr like '%' || ? || '%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memAddr);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		return cnt;
	}

	
	@Override
	public List<MemberVO> getMemInfoId(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		List<MemberVO> memList = new ArrayList<MemberVO>();
		MemberVO mv = new MemberVO();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
				
			while(rs.next()){	
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));
				memList.add(mv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		
		return memList;
	}
	

	@Override
	public List<MemberVO> getMemInfoName(String memName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> memList = new ArrayList<MemberVO>();
		MemberVO mv = new MemberVO();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember where mem_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memName);
			rs = pstmt.executeQuery();
				
			while(rs.next()){	
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));
				memList.add(mv);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		
		return memList;
	}

	
	@Override
	public List<MemberVO> getMemInfoTel(String memTel) {
		Connection conn = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		List<MemberVO> memList = new ArrayList<MemberVO>();
		MemberVO mv = new MemberVO();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember where mem_tel = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memTel);
			rs = pstmt.executeQuery();
				
			while(rs.next()){	
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));
				memList.add(mv);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		
		return memList;
	}

	
	@Override
	public List<MemberVO> getMemInfoAddr(String memAddr) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> memList = new ArrayList<MemberVO>();
		MemberVO mv = new MemberVO();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember where mem_addr like '%' || ? || '%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memAddr);
			rs = pstmt.executeQuery();
				
			while(rs.next()){
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));
				memList.add(mv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
		}
		
		return memList;
	}

	@Override
	public List<MemberVO> getSearchMember(Map<String, String> searchMap) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		String op = " = ";
		String data = searchMap.get("searchData");

		if(searchMap.get("searchField").equals("mem_addr")){
			op = " like ";
			data = "%" + data + "%";
		}
		
		String sql = "select * from mymember where " + searchMap.get("searchField") + op + "?";
		
		try {
			conn = DBUtil3.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				MemberVO mvo = new MemberVO();
				mvo.setMem_id(rs.getString("mem_id"));
				mvo.setMem_name(rs.getString("mem_name"));
				mvo.setMem_tel(rs.getString("mem_tel"));
				mvo.setMem_addr(rs.getString("mem_addr"));
				
				memList.add(mvo);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
			memList = null;
		}
		
		return memList;
	}
	
	
	
	

	

	
	
	
}
