package board.service;

import java.util.List;
import java.util.Map;

import board.dao.BoardDao;
import board.dao.IBoardDao;
import board.vo.BoardVO;

public class BoardService implements IBoardService{
	
private IBoardDao boardDao;	//DAO객체를 저장할 변수 선언
	
	//생성자에서 DAO객체를 생성한다.
	public BoardService() {
		boardDao = new BoardDao();
	}
	
	
	@Override
	public List<BoardVO> boardList() {
		return boardDao.boardList();
	}	
	
	@Override
	public List<BoardVO> showDetailBoard(int board_no) {
		return boardDao.showDetailBoard(board_no);
	}

	@Override
	public boolean writeNewBoard(Map<String, String> boardMap) {
		return boardDao.writeNewBoard(boardMap);
	}

	@Override
	public boolean updateBoard(Map<Object, Object> boardMap, int input) {
		return boardDao.updateBoard(boardMap, input);
	}

	@Override
	public boolean deleteBoard(int board_no) {
		return boardDao.deleteBoard(board_no);
	}

	@Override
	public int countBoard(int board_no) {
		return boardDao.countBoard(board_no);
	}



	

}
