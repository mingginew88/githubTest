package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import board.vo.BoardVO;

public class BoardDao implements IBoardDao {
	private static BoardDao boardDao = new BoardDao();
	private SqlMapClient smc;
	
	private BoardDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDao getInstance() {
		if(boardDao==null) {
			boardDao = new BoardDao();
		}
		return boardDao;
		
	}


	@Override	
	public List<BoardVO> getAllBoard() {
		List<BoardVO> boardList = null;
		try {
			boardList = smc.queryForList("Board.getAllBoard");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return boardList;		
	}

	@Override
	public int addNewBoard(BoardVO boardVo) {
		Object obj = null;
		
		int cnt = 0;
		try {
			obj = smc.insert("Board.addNewBoard", boardVo);  
			if(obj==null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		
		int cnt = 0;		
		try {
			cnt = smc.update("Board.updateBoard", boardVo);
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} 		
		return cnt;
	}

	@Override
	public int deleteBoard(int board_no) {

		int cnt = 0;		
		try {
			cnt = smc.delete("Board.deleteBoard", board_no); 
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		}		
		return cnt;
	}

	
	
	
	
	

}
