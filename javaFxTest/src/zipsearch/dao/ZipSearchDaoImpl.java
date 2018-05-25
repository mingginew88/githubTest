package zipsearch.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import zipsearch.vo.ZipDataVO;

public class ZipSearchDaoImpl implements IZipSearchDao {
	private static ZipSearchDaoImpl zipDao;		//싱글톤 사용
	private SqlMapClient smc;		//ibatis 사용하기위해
	
	private ZipSearchDaoImpl() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ZipSearchDaoImpl getInstance() {
		if(zipDao==null) zipDao = new ZipSearchDaoImpl();
		return zipDao;
	}
	
	

	@Override
	public List<ZipDataVO> getSearchDong(String dong) {
		List<ZipDataVO> zipList = null;
		try {
			zipList = smc.queryForList("zipSearch.getSearchDong", dong);
		} catch (SQLException e) {
			zipList = null;
			e.printStackTrace();
		}
		return zipList;
	}

	@Override
	public List<ZipDataVO> getSearchZipcode(String zipcode) {
		List<ZipDataVO> zipList = null;
		try {
			zipList = smc.queryForList("zipSearch.getSearchZipcode", zipcode);
		} catch (SQLException e) {
			zipList = null;
			e.printStackTrace();
		}
		return zipList;
	}

}
