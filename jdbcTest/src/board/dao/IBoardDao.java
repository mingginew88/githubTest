package board.dao;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;

public interface IBoardDao {
	
	/**
	 * ��ü �Խ����� ����� �� �� �ִ� �޼���
	 * @return - ��ü �Խ��� ���
	 */
	public List<BoardVO> boardList();
	
	
	/**
	 * �Խ��� ��ȣ�� �´� �Խñ��� ���� �޼���
	 * @param board_no �Խ��� ��ȣ
	 * @return - �Խ��� ��ȣ�� �ش��ϴ� �Խñ�
	 */
	public List<BoardVO> showDetailBoard(int board_no);
	
	

	public boolean writeNewBoard(Map<String, String> boardMap);
	
	

	public boolean updateBoard(Map<Object, Object> boardMap, int input);
	
	
	/**
	 * �Խñ��� �����ϴ� �޼���
	 * @param board_no
	 * @return - ���� ���� ����()
	 */
	public boolean deleteBoard(int board_no);
	
	
	/**
	 * �Խ��� ��ȣ�� �ش��ϴ� �Խñ��� ������ ���� �޼���
	 * @param board_no
	 * @return - �Խñ��� ���� (�����ϸ� 1 �������������� 0 ��ȯ)
	 */
	public int countBoard(int board_no);
	

}
