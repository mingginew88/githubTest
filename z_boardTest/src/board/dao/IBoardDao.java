package board.dao;

import java.util.List;

import board.vo.BoardVO;

public interface IBoardDao {
	
	/**
	 *  ��ü �Խñ��� �����ش�.
	 * @return
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * �Խ��ǿ� �Խñ��� �߰��Ѵ�.
	 * @param boardVo
	 * @return ��ϼ����� 1 ���н� 0
	 */
	public int addNewBoard(BoardVO boardVo);
	
	/**
	 * �Խñ��� �����Ѵ�.
	 * @param boardVo
	 * @return ���������� 1 ���н� 0
	 */
	public int updateBoard(BoardVO boardVo);
	
	/**
	 * �ش� �Խñ��� �����Ѵ�.
	 * @param board_no
	 * @return ���������� 1 ���н� 0
	 */
	public int deleteBoard(int board_no);

}
