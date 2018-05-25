package scoretest.dao;

import java.util.List;

import scoretest.vo.ScoreDataVO;

public interface IScoreDataDao {
	
	/**
	 * 모든 사람의 성적을 보여주는 메서드
	 * @return 성적List(이름, 국어성적, 영어성적, 수학성적)
	 */
	public List<ScoreDataVO> getSearchAllScore();
	
	/**
	 * 한사람의 성적을 추가하는 메서드
	 * @param scoreVo
	 * @return 추가 성공시 1 실패시 0
	 */
	public int addScore(ScoreDataVO scoreVo);
	
	/**
	 * 한사람의 성적을 수정하는 메서드
	 * @param scoreVo
	 * @return 수정 성공시 1 실패시 0
	 */
	public int updateScore(ScoreDataVO scoreVo);
	
	/**
	 * 한사람의 성적을 삭제하는 메서드
	 * @param std_name
	 * @return 삭제 성공시 1 실패시 0
	 */
	public int deleteScore(int std_num);
	
	

}
