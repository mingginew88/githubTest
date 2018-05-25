package mymember.service;

import java.util.List;
import java.util.Map;

import mymember.vo.MemberVO;


/**
 * 
 * Service��ü�� DAO�� ������ �޼��带 ���ϴ� �۾��� �°�
 * ȣ���Ͽ� ����� �޾ƿ���, �޾ƿ� �ڷḦ Controller����
 * �����ִ� ������ �����Ѵ�.
 * 
 * Service�� DAO�� �޼���� ���� ������ ���´�. 
 * 
 * @author SAM
 *
 */

public interface IMemberService {
	/**
	 * MemberVO�� ����� �ڷḦ DB�� insert�ϴ� �޼���
	 * 
	 * @param - memVo DB�� insert�� �ڷᰡ ����� MemberVO��ü
	 * @return - DB�۾��� �����ϸ� 1�̻��� ���� ��ȯ�ǰ� 
	 * 			�����ϸ� 0�� ��ȯ�ȴ�.
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * ȸ��ID�� �Ű������� �޾Ƽ� �� ȸ�� ������ �����ϴ� �޼���
	 * 
	 * @param memId - ������ ȸ��ID
	 * @return - ���� ������ 1, ���� ���н� 0 ��ȯ
	 */
	public int deleteMember(String memId);
	
	/**
	 * �ϳ��� MemberVO�ڷḦ �̿��Ͽ� DB�� �ڷḦ update�ϴ� �޼���
	 * 
	 * @param memVo - update�� ȸ�� ������ ��� �ִ� MemberVO��ü 
	 * @return - �����۾� ������ 1, �����۾� ���н� 0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * DB�� mymember���̺��� ��ü ���ڵ带 �����ͼ� List�� ��Ƽ�
	 * ��ȯ�ϴ� �޼���
	 * 
	 * @return - MemberVO�� ���ڵ� ������ŭ ���� �ִ� List�� ��ȯ
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * �Ű������� �־��� ȸ��ID�� ��ġ�ϴ� ȸ�� ���� ��ȯ�ϴ� �޼���
	 * 
	 * @param memId - �˻��� ȸ��ID
	 * @return - �˻��� ȸ�� �� ��ȯ
	 */
	public int getCountMember(String memId);
	
	
	/**
	 * �Ű������� �־��� Map�� 'searchField' Ű������ �˻��� �ʵ����
	 * 'searchData' Ű������ �˻��� �ܾ ���õǾ� �ִ�.
	 * �� �Ű������� �̿��Ͽ� �˻��ϴ� �޼���
	 * 
	 * @param searchMap
	 * @return - �˻��� ȸ��List ��ȯ
	 */
	public List<MemberVO> getSearchMember(Map<String, String> searchMap);
	

}
