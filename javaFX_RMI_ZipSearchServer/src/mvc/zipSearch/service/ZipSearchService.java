package mvc.zipSearch.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import mvc.zipSearch.dao.ZipSearchDao;
import mvc.zipSearch.dao.ZipSearchDaoInf;
import mvc.zipSearch.vo.ZipVO;

public class ZipSearchService extends UnicastRemoteObject implements ZipSearchServiceInf {
//	private static ZipSearchService service = new ZipSearchService();
	private ZipSearchDaoInf dao;
	
	
//	private ZipSearchService() {
//		dao = ZipSearchDao.getInstance();
//	}
	
	public ZipSearchService() throws RemoteException {
		dao = ZipSearchDao.getInstance();
	}
	
//	public static ZipSearchService getInstance() {
//		return service;
//	}
	
	@Override
	public List<ZipVO> zipSearchDong(String dong) throws RemoteException {
		return dao.zipSearchDong(dong);
	}

	@Override
	public List<ZipVO> zipSearchZipCode(String zipCode) throws RemoteException {
		return dao.zipSearchZipCode(zipCode);
	}

}
