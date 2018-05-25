package mymember.service;

import java.util.List;

import mymember.vo.MyMemberVO;

public interface IMyMemberService {
	
	/**
	 * 모든 회원정보를 리스트로 출력
	 * @return
	 */
	public List<MyMemberVO> getSearchAllMember();
	
	
	/**
	 * 회원을 추가하는 메서드
	 * @param memVo
	 * @return 추가 성공시1 추가 실패시0
	 */
	public int addMember(MyMemberVO memVo);
	
	
	/**
	 * 회원정보를 수정하는 메서드	
	 * @param memVo
	 * @return 추가 성공시1 추가 실패시0
	 */
	public int updateMember (MyMemberVO memVo);
	
	
	/**
	 * 회원정보를 삭제하는 메서드
	 * @param mem_id
	 * @return 추가 성공시1 추가 실패시0
	 */
	public int deleteMember (String mem_id);
	
	
	/**
	 * 회원ID가 동일한 사람을 찾는 메서드
	 * @param mem_id
	 * @return
	 */
	public int getCountMember(String mem_id);
	

}
