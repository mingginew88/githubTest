package zipsearch.service;

import java.util.List;

import zipsearch.vo.ZipDataVO;

public interface IZipSearchService {
	/**
	 * 동이름을 매개변수로 받아서 해당 동이름이 포함된
	 * 우편번호를 검색하여 List로 반환하는 메서드
	 * @param dong
	 * @return
	 */
	public List<ZipDataVO> getSearchDong(String dong);
	
	/**
	 * 우편번호를 매개변수로 받아서 해당 우편번호가 포함된
	 * 우편번호들을 검색하여 List로 반환하는 메서드
	 * @param zipcode
	 * @return
	 */
	public List<ZipDataVO> getSearchZipcode(String zipcode);
}
