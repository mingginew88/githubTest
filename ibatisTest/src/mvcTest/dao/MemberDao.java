package mvcTest.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import mvcTest.vo.MemberVO;

public class MemberDao implements IMemberDao{
	private static MemberDao single = new MemberDao();
	SqlMapClient smc;
	
	private MemberDao(){
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static MemberDao getInstance(){
		if(single==null){
			single = new MemberDao();
		}
		return single;
	}
		
	//MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;		
		
		try {			
			Object obj = smc.insert("memberTest.insertMember", memVo);			
			if(obj==null){
				cnt=1;
			}else{
				cnt=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	//매개변수로 받은 회원ID와 일치하는 자료를 삭제하는 메서드
	@Override
	public int deleteMember(String memId) {		
		int cnt = 0;
		
		try {			
			cnt = smc.delete("memberTest.deleteMember", memId);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	//하나의 MemberVO객체 자료를 이용하여 DB update하는 메서드
	@Override
	public int updateMember(MemberVO memVo) {		
		int cnt = 0;
		
		try {			
			cnt = smc.update("memberTest.updateMember", memVo);
		} catch (SQLException e) {
			e.printStackTrace();			
		} 		
		return cnt;
	}
	
	
	//myMember테이블의 전체 자료를 가져와 List에 담아서 반환하는 메서드
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

	
	//주어진 회원ID와 일치하는 회원수를 반환하는 메서드
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
		
		if (searchMap.get("searchField").equals("mem_addr")) {
			str += "getAddrSearchMember";			
		}else{
			str += "getSearchMember";
		}
		
		try {
			memList = smc.queryForList(str, searchMap);
		} catch (SQLException e) {
			e.printStackTrace();
			memList = null;
		}		
		return memList;
	}
	
	
}
