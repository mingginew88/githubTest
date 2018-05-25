package scoretest.service;

import java.util.List;

import scoretest.dao.IScoreDataDao;
import scoretest.dao.ScoreDataDaoImpl;
import scoretest.vo.ScoreDataVO;

public class ScoreDataServiceImpl implements IScoreDataService {
	private static ScoreDataServiceImpl scoreService;
	private IScoreDataDao scoreDao;
	
	private ScoreDataServiceImpl() {
		scoreDao = ScoreDataDaoImpl.getInstance();
	}
	
	public static ScoreDataServiceImpl getInstance() {
		if(scoreService==null) {
			scoreService = new ScoreDataServiceImpl();
		}
		return scoreService;
	}

	@Override
	public List<ScoreDataVO> getSearchAllScore() {
		return scoreDao.getSearchAllScore();
	}

	@Override
	public int addScore(ScoreDataVO scoreVo) {
		return scoreDao.addScore(scoreVo);
	}

	@Override
	public int updateScore(ScoreDataVO scoreVo) {
		return scoreDao.updateScore(scoreVo);
	}

	@Override
	public int deleteScore(int std_num) {
		return scoreDao.deleteScore(std_num);
	}
	
	
	

}
