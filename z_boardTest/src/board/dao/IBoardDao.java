package board.dao;

import java.util.List;

import board.vo.BoardVO;

public interface IBoardDao {
	
	/**
	 *  전체 게시글을 보여준다.
	 * @return
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 게시판에 게시글을 추가한다.
	 * @param boardVo
	 * @return 등록성공시 1 실패시 0
	 */
	public int addNewBoard(BoardVO boardVo);
	
	/**
	 * 게시글을 수정한다.
	 * @param boardVo
	 * @return 수정성공시 1 실패시 0
	 */
	public int updateBoard(BoardVO boardVo);
	
	/**
	 * 해당 게시글을 삭제한다.
	 * @param board_no
	 * @return 삭제성공시 1 실패시 0
	 */
	public int deleteBoard(int board_no);

}
