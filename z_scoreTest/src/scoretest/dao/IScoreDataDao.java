package scoretest.dao;

import java.util.List;

import scoretest.vo.ScoreDataVO;

public interface IScoreDataDao {
	
	/**
	 * ��� ����� ������ �����ִ� �޼���
	 * @return ����List(�̸�, �����, �����, ���м���)
	 */
	public List<ScoreDataVO> getSearchAllScore();
	
	/**
	 * �ѻ���� ������ �߰��ϴ� �޼���
	 * @param scoreVo
	 * @return �߰� ������ 1 ���н� 0
	 */
	public int addScore(ScoreDataVO scoreVo);
	
	/**
	 * �ѻ���� ������ �����ϴ� �޼���
	 * @param scoreVo
	 * @return ���� ������ 1 ���н� 0
	 */
	public int updateScore(ScoreDataVO scoreVo);
	
	/**
	 * �ѻ���� ������ �����ϴ� �޼���
	 * @param std_name
	 * @return ���� ������ 1 ���н� 0
	 */
	public int deleteScore(int std_num);
	
	

}
