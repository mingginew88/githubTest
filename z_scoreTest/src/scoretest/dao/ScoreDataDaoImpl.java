package scoretest.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import scoretest.vo.ScoreDataVO;

public class ScoreDataDaoImpl implements IScoreDataDao {
	private static ScoreDataDaoImpl scoreDao;
	private SqlMapClient smc;
	
	private ScoreDataDaoImpl() {
		Reader rd;
		
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static ScoreDataDaoImpl getInstance() {
		if(scoreDao==null) {
			scoreDao = new ScoreDataDaoImpl();
		}
		return scoreDao;
	}

	@Override
	public List<ScoreDataVO> getSearchAllScore() {
		List<ScoreDataVO> scoreList = null;
		try {
			scoreList = smc.queryForList("scoredata.getSearchAllScore");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scoreList;
	}

	@Override
	public int addScore(ScoreDataVO scoreVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("scoredata.addScore", scoreVo);
			if(obj==null) {
				cnt = 1;
			} else {
				cnt = 0;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateScore(ScoreDataVO scoreVo) {
		int cnt = 0;
		try {
			cnt = smc.update("scoredata.updateScore", scoreVo);				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteScore(int std_num) {
		int cnt = 0;
		try {
			cnt = smc.delete("scoredata.deleteScore", std_num);			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return cnt;
	}
	
	
	
	
	
	

}
