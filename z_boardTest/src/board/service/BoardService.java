package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.dao.IBoardDao;
import board.vo.BoardVO;

public class BoardService implements IBoardService {
	private static BoardService boardService = new BoardService();
	private IBoardDao boardDao;
	
	private BoardService() {
		boardDao = BoardDao.getInstance();
	}
	
	public static BoardService getInstance() {
		if(boardService==null) {
			boardService = new BoardService();
		}
		return boardService;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return boardDao.getAllBoard();
	}

	@Override
	public int addNewBoard(BoardVO boardVo) {
		return boardDao.addNewBoard(boardVo);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		return boardDao.updateBoard(boardVo);
	}

	@Override
	public int deleteBoard(int board_no) {
		return boardDao.deleteBoard(board_no);
	}
	
	

}
