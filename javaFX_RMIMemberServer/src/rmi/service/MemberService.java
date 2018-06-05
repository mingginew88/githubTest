package rmi.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import rmi.dao.IMemberDao;
import rmi.dao.MemberDao;
import rmi.vo.MemberVO;


public class MemberService extends UnicastRemoteObject implements IMemberService {
	private IMemberDao memDao;  // DAO��ü�� ������ ���� ����
	
	public MemberService() throws RemoteException {
		memDao = MemberDao.getInstance();
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
