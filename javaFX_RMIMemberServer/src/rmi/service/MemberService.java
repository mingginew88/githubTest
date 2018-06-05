package rmi.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import rmi.dao.IMemberDao;
import rmi.dao.MemberDao;
import rmi.vo.MemberVO;


public class MemberService extends UnicastRemoteObject implements IMemberService {
	private IMemberDao memDao;  // DAO객체를 저장할 변수 선언
	
	public MemberService() throws RemoteException {
		memDao = MemberDao.getInstance();
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
