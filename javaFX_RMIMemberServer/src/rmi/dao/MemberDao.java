package rmi.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import rmi.vo.MemberVO;

public class MemberDao implements IMemberDao {
	
	private static MemberDao memDao = new MemberDao();
	private SqlMapClient smc;
	
	
	private  MemberDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static MemberDao getInstance(){
		if(memDao==null){
			memDao = new MemberDao();
		}
		return memDao;
	}
	

	// MemberVO�� ����� �ڷḦ DB�� insert�ϴ� �޼���
	// ��ȯ�� ==> 1 : insert����, 0 : insert����
	@Override
	public int insertMember(MemberVO memVo) {
		
		int cnt = 0;
		
		try {
			Object obj = smc.insert("memberTest.insertMember", memVo);
			if(obj==null){
				cnt = 1;
			}else{
				cnt = 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		}
		
		return cnt;
	}

	
	// �Ű������� ���� ȸ��ID�� ��ġ�ϴ� �ڷḦ �����ϴ� �޼���
	@Override
	public int deleteMember(String memId) {
		
		int cnt = 0;
		
		try {
			cnt = smc.delete("memberTest.deleteMember", memId); 
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		}
		
		return cnt;
	}

	// �ϳ��� MemberVO��ü �ڷḦ �̿��Ͽ� DB update�ϴ� �޼���
	@Override
	public int updateMember(MemberVO memVo) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("memberTest.updateMember", memVo);
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} 
		
		return cnt;
	}

	// MyMember���̺��� ��ü �ڷḦ ������ List�� ��Ƽ� ��ȯ�ϴ� �޼���
	@Override
	public List<MemberVO> getAllMember() {
		
		List<MemberVO> memList = null;
		
		try {
			memList = smc.queryForList("memberTest.getAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
			memList = null;
		} 
		
		
		return memList;
	}

	// �־��� ȸ��ID�� ��ġ�ϴ� ȸ������ ��ȯ�ϴ� �޼���
	@Override
	public int getCountMember(String memId) {
		
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("memberTest.getCountMember", memId);			
			
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		}
		
		
		return cnt;
	}


	@Override
	public List<MemberVO> getSearchMember(Map<String, String> searchMap) {
		
		List<MemberVO> memList = null;
		
		
		String str = "memberTest.";
		
		if(searchMap.get("searchField").equals("mem_addr")){
			str += "getAddrSearchMember";
		}else{
			str += "getSearchMember";
		}
		
		try{
			memList = smc.queryForList(str, searchMap);
			
		} catch (SQLException e) {
			e.printStackTrace();
			memList = null;
		}
			
		
		return memList;
	}

	
}








