package zipsearch.service;

import java.util.List;

import zipsearch.dao.IZipSearchDao;
import zipsearch.dao.ZipSearchDaoImpl;
import zipsearch.vo.ZipDataVO;

public class ZipSearchServiceImpl implements IZipSearchService {
	private static ZipSearchServiceImpl zipService;
	private IZipSearchDao zipDao;
	
	private ZipSearchServiceImpl() {
		zipDao = ZipSearchDaoImpl.getInstance();
	}
	
	public static ZipSearchServiceImpl getInstance() {
		if(zipService==null) zipService = new ZipSearchServiceImpl();
		return zipService;
	}
	

	@Override
	public List<ZipDataVO> getSearchDong(String dong) {
		return zipDao.getSearchDong(dong);
	}

	@Override
	public List<ZipDataVO> getSearchZipcode(String zipcode) {
		return zipDao.getSearchZipcode(zipcode);
	}

}
