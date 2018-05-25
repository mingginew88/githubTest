package board.service;

import java.util.List;


import java.util.Map;

import board.vo.BoardVO;

public interface IBoardService {
	
	/**
	 * 전체 게시판의 목록을 볼 수 있는 메서드
	 * @return - 전체 게시판 목록
	 */
	public List<BoardVO> boardList();	
	
	
	/**
	 * 게시판 번호에 맞는 게시글을 보는 메서드
	 * @param board_no 게시판 번호
	 * @return - 게시판 번호에 해당하는 게시글
	 */
	public List<BoardVO> showDetailBoard(int board_no);
	
	
	/**
	 * 
	 * @param boardMap 
	 * @return
	 */
	public boolean writeNewBoard(Map<String, String> boardMap);
	
	
	/**
	 * 
	 * @param boardMap
	 * @param input
	 * @return
	 */
	public boolean updateBoard(Map<Object, Object> boardMap, int input);
	
	
	/**
	 * 게시글을 삭제하는 메서드
	 * @param board_no
	 * @return - 삭제 성공 여부()
	 */
	public boolean deleteBoard(int board_no);
	
	
	/**
	 * 게시판 번호에 해당하는 게시글의 개수를 세는 메서드
	 * @param board_no
	 * @return - 게시글의 개수 (존재하면 1 존재하지않으면 0 반환)
	 */
	public int countBoard(int board_no);	

}
