package mymember.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import mymember.vo.MyMemberVO;

public class MyMemberDaoImpl implements IMyMemberDao {
	//½Ì±ÛÅæ »ý¼º
	private static MyMemberDaoImpl memDao;
	private SqlMapClient smc;		//ibatis
	
	private MyMemberDaoImpl() {
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MyMemberDaoImpl getInstance() {
		if(memDao==null) {
			memDao = new MyMemberDaoImpl();
		}
		return memDao;
	}
	
	

	@Override
	public List<MyMemberVO> getSearchAllMember() {
		List<MyMemberVO> memList = null;
		try {
			memList = smc.queryForList("myMember.getSearchAllMember");
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}		
		return memList;
	}

	@Override
	public int addMember(MyMemberVO memVo) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("myMember.addMember", memVo);
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
	public int updateMember(MyMemberVO memVo) {		
		int cnt = 0;
		try {
			cnt = smc.update("myMember.updateMember", memVo);				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String mem_id) {
		int cnt = 0;
		try {
			cnt = smc.delete("myMember.deleteMember", mem_id);			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return cnt;
	}
	
	public int getCountMember(String mem_id) {
		int cnt = 0;
		try {
			cnt =  (int) smc.queryForObject("myMember.getCountMember", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;		
	}
	
	
	
	
	
	

}
