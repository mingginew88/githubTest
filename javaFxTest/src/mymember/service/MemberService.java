package mymember.service;

import java.util.List;
import java.util.Map;

import mymember.dao.IMemberDao;
import mymember.dao.MemberDao;
import mymember.vo.MemberVO;


public class MemberService implements IMemberService {
	private static MemberService memSerive = new MemberService();
	
	private IMemberDao memDao;  // DAO객체를 저장할 변수 선언
	
	// 생성자에서 DAO객체를 생성한다.
	private MemberService() {
		//memDao = new MemberDao();
		memDao = MemberDao.getInstance();
	}
	
	public static MemberService getInstance(){
		if(memSerive==null){
			memSerive = new MemberService();
		}
		return memSerive;
	}

	// 각 메서드들은 각각의 기능에 맞는 DAO의 메서드롤 호출하면 된다.
	
	@Override
	public int insertMember(MemberVO memVo) {
		return memDao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return memDao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return memDao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return memDao.getAllMember();
	}

	@Override
	public int getCountMember(String memId) {
		return memDao.getCountMember(memId);
	}

	@Override
	public List<MemberVO> getSearchMember(Map<String, String> searchMap) {
		return memDao.getSearchMember(searchMap);
	}

}
