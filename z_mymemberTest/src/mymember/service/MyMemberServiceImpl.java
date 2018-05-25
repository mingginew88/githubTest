package mymember.service;

import java.util.List;

import mymember.dao.IMyMemberDao;
import mymember.dao.MyMemberDaoImpl;
import mymember.vo.MyMemberVO;

public class MyMemberServiceImpl implements IMyMemberService {
	private static MyMemberServiceImpl memService;
	private IMyMemberDao memDao;
	
	private MyMemberServiceImpl() {
		memDao = MyMemberDaoImpl.getInstance();
	}
	
	public static MyMemberServiceImpl getInstance() {
		if(memService==null) {
			memService = new MyMemberServiceImpl();
		}
		return memService;
	}
	
	

	@Override
	public List<MyMemberVO> getSearchAllMember() {
		return memDao.getSearchAllMember();
	}

	@Override
	public int addMember(MyMemberVO memVo) {
		return memDao.addMember(memVo);
	}

	@Override
	public int updateMember(MyMemberVO memVo) {
		return memDao.updateMember(memVo);
	}

	@Override
	public int deleteMember(String mem_id) {
		return memDao.deleteMember(mem_id);
	}

	@Override
	public int getCountMember(String mem_id) {
		return memDao.getCountMember(mem_id);
	}

}
