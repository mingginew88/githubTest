package zipsearch.service;

import java.util.List;

import zipsearch.vo.ZipDataVO;

public interface IZipSearchService {
	/**
	 * ���̸��� �Ű������� �޾Ƽ� �ش� ���̸��� ���Ե�
	 * �����ȣ�� �˻��Ͽ� List�� ��ȯ�ϴ� �޼���
	 * @param dong
	 * @return
	 */
	public List<ZipDataVO> getSearchDong(String dong);
	
	/**
	 * �����ȣ�� �Ű������� �޾Ƽ� �ش� �����ȣ�� ���Ե�
	 * �����ȣ���� �˻��Ͽ� List�� ��ȯ�ϴ� �޼���
	 * @param zipcode
	 * @return
	 */
	public List<ZipDataVO> getSearchZipcode(String zipcode);
}
