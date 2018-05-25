package mvcTest.dao;

import java.util.List;
import java.util.Map;

import mvcTest.vo.MemberVO;

/**
 * ���� DB�� �����ؼ� SQL���� �����ϰ�, �� ����� �ۼ��Ͽ� Service�� �����ϴ� DAO�� Interface
 * @author PC17
 *
 */

public interface IMemberDao {	
	
	/**
	 * MemberVO�� ����� �ڷḦ DB�� insert�ϴ� �޼���
	 * @param - memVo DB�� insert�� �ڷᰡ ����� MemberVO��ü
	 * @return - DB�۾��� �����ϸ� 1�̻��� ���� ��ȯ�ǰ� �����ϸ� 0�� ��ȯ�ȴ�.
	 */
	public int insertMember(MemberVO memVo);
	
	
	/**
	 * ȸ��ID�� �Ű������� �޾Ƽ� �� ȸ�� ������ �����ϴ� �޼���
	 * @param memId - ������ ȸ��ID
	 * @return - ���������� 1, �������н� 0 ��ȯ
	 */	
	public int deleteMember(String memId);
	
	
	/**
	 * �ϳ��� MemberVO�ڷḦ �̿��Ͽ� DB�� �ڷḦ update�ϴ� �޼���
	 * @param memVo - update�� ȸ�� ������ ����ִ� MemberVO��ü
	 * @return - �����۾� ������ 1, �����۾� ���н� 0
	 */
	public int updateMember(MemberVO memVo);
	
	
	/**
	 * DB�� mymember���̺��� ��ü ���ڵ带 �����ͼ� List�� ��Ƽ� ��ȯ�ϴ� �޼���
	 * @return - MemberVO�� ���ڵ� ������ŭ �����ִ� List�� ��ȯ
	 */
	public List<MemberVO> getAllMember();
	
	
	/**
	 * �Ű������� �־��� ȸ��ID�� ��ġ�ϴ� ȸ�� ���� ��ȯ�ϴ� �޼���
	 * @param memId - �˻��� ȸ��ID
	 * @return - �˻��� ȸ�� �� ��ȯ
	 */
	public int getCountMember(String memId);
	
	
	/**
	 * �Ű������� �־��� ȸ���̸��� ��ġ�ϴ� ȸ�� ���� ��ȯ�ϴ� �޼���
	 * @param memName -�˻��� ȸ���̸�
	 * @return - �˻��� ȸ�� �� ��ȯ
	 */
	public int getCountMemName(String memName);
	
	
	/**
	 * �Ű������� �־��� ȸ���̸��� ��ġ�ϴ� ȸ�� ���� ��ȯ�ϴ� �޼���
	 * @param memTel - �˻��� ȸ����ȭ��ȣ
	 * @return - �˻��� ȸ�� �� ��ȯ
	 */
	public int getCountMemTel(String memTel);
	
	
	/**
	 * �Ű������� �־��� ȸ���̸��� ��ġ�ϴ� ȸ�� ���� ��ȯ�ϴ� �޼���
	 * @param memAddr - �˻��� ȸ���ּ�
	 * @return - �˻��� ȸ�� �� ��ȯ
	 */
	public int getCountMemAddr(String memAddr);
	
	
	/**
	 * �Ű����� ȸ��ID�� ��ġ�ϴ� ȸ���� ������ ��ȯ�ϴ� �޼���
	 * @param memId
	 * @return
	 */
	public List<MemberVO> getMemInfoId(String memId);
	
	
	/**
	 * �Ű����� ȸ���̸��� ��ġ�ϴ� ȸ���� ������ ��ȯ�ϴ� �޼���
	 * @param memName
	 * @return
	 */
	public List<MemberVO> getMemInfoName(String memName);
	
	
	/**
	 * �Ű����� ȸ����ȭ��ȣ�� ��ġ�ϴ� ȸ���� ������ ��ȯ�ϴ� �޼���
	 * @param memTel
	 * @return
	 */
	public List<MemberVO> getMemInfoTel(String memTel);
	
	
	/**
	 * �Ű����� ȸ���ּ��� �Ϻκ��� ��ġ�ϴ� ȸ���� �������� ��ȯ�ϴ� �޼���
	 * @param memAddr
	 * @return
	 */
	public List<MemberVO> getMemInfoAddr(String memAddr);
	
	
	/**
	 * �Ű������� �־��� Map�� 'searchField'Ű ������ �˻��� �ʵ���� 'searchData' Ű������ �˻��� �ܾ ���õǾ� �ִ�.
	 * �� �Ű������� �̿��Ͽ� �˻��ϴ� �޼���
	 * @param searchMap
	 * @return - �˻��� ȸ��List ��ȯ
	 */
	public List<MemberVO> getSearchMember(Map<String, String> searchMap);
	

}
