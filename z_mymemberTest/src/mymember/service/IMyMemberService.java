package mymember.service;

import java.util.List;

import mymember.vo.MyMemberVO;

public interface IMyMemberService {
	
	/**
	 * ��� ȸ�������� ����Ʈ�� ���
	 * @return
	 */
	public List<MyMemberVO> getSearchAllMember();
	
	
	/**
	 * ȸ���� �߰��ϴ� �޼���
	 * @param memVo
	 * @return �߰� ������1 �߰� ���н�0
	 */
	public int addMember(MyMemberVO memVo);
	
	
	/**
	 * ȸ�������� �����ϴ� �޼���	
	 * @param memVo
	 * @return �߰� ������1 �߰� ���н�0
	 */
	public int updateMember (MyMemberVO memVo);
	
	
	/**
	 * ȸ�������� �����ϴ� �޼���
	 * @param mem_id
	 * @return �߰� ������1 �߰� ���н�0
	 */
	public int deleteMember (String mem_id);
	
	
	/**
	 * ȸ��ID�� ������ ����� ã�� �޼���
	 * @param mem_id
	 * @return
	 */
	public int getCountMember(String mem_id);
	

}
