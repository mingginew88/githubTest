package rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import rmi.vo.MemberVO;




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

public interface IMemberService extends Remote{
	/**
	 * MemberVO�� ����� �ڷḦ DB�� insert�ϴ� �޼���
	 * 
	 * @param - memVo DB�� insert�� �ڷᰡ ����� MemberVO��ü
	 * @return - DB�۾��� �����ϸ� 1�̻��� ���� ��ȯ�ǰ� 
	 * 			�����ϸ� 0�� ��ȯ�ȴ�.
	 */
	public int insertMember(MemberVO memVo) throws RemoteException;
	
	/**
	 * ȸ��ID�� �Ű������� �޾Ƽ� �� ȸ�� ������ �����ϴ� �޼���
	 * 
	 * @param memId - ������ ȸ��ID
	 * @return - ���� ������ 1, ���� ���н� 0 ��ȯ
	 */
	public int deleteMember(String memId) throws RemoteException;
	
	/**
	 * �ϳ��� MemberVO�ڷḦ �̿��Ͽ� DB�� �ڷḦ update�ϴ� �޼���
	 * 
	 * @param memVo - update�� ȸ�� ������ ��� �ִ� MemberVO��ü 
	 * @return - �����۾� ������ 1, �����۾� ���н� 0
	 */
	public int updateMember(MemberVO memVo) throws RemoteException;
	
	/**
	 * DB�� mymember���̺��� ��ü ���ڵ带 �����ͼ� List�� ��Ƽ�
	 * ��ȯ�ϴ� �޼���
	 * 
	 * @return - MemberVO�� ���ڵ� ������ŭ ���� �ִ� List�� ��ȯ
	 */
	public List<MemberVO> getAllMember() throws RemoteException;
	
	/**
	 * �Ű������� �־��� ȸ��ID�� ��ġ�ϴ� ȸ�� ���� ��ȯ�ϴ� �޼���
	 * 
	 * @param memId - �˻��� ȸ��ID
	 * @return - �˻��� ȸ�� �� ��ȯ
	 */
	public int getCountMember(String memId) throws RemoteException;
	
	
	/**
	 * �Ű������� �־��� Map�� 'searchField' Ű������ �˻��� �ʵ����
	 * 'searchData' Ű������ �˻��� �ܾ ���õǾ� �ִ�.
	 * �� �Ű������� �̿��Ͽ� �˻��ϴ� �޼���
	 * 
	 * @param searchMap
	 * @return - �˻��� ȸ��List ��ȯ
	 */
	public List<MemberVO> getSearchMember(Map<String, String> searchMap) throws RemoteException;
	

}
