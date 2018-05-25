package mymember.service;

import java.util.List;
import java.util.Map;

import mymember.dao.IMemberDao;
import mymember.dao.MemberDao;
import mymember.vo.MemberVO;


public class MemberService implements IMemberService {
	private static MemberService memSerive = new MemberService();
	
	private IMemberDao memDao;  // DAO��ü�� ������ ���� ����
	
	// �����ڿ��� DAO��ü�� �����Ѵ�.
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

	// �� �޼������ ������ ��ɿ� �´� DAO�� �޼���� ȣ���ϸ� �ȴ�.
	
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
