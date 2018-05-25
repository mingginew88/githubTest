package mvcTest.service;

import java.util.List;
import java.util.Map;

import mvcTest.vo.MemberVO;

/**
 * Service객체는 DAO에 구현된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고, 받아온 자료를 Controller에 보내주는 역할을 수행한다.
 * 
 * Service는 Dao의 메서드와 같은 구조를 갖는다.
 * @author PC17
 *
 */

public interface IMemberService {

	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param - memVo DB에 insert할 자료가 저장된 MemberVO객체
	 * @return - DB작업이 성공하면 1이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int insertMember(MemberVO memVo);
	
	
	/**
	 * 회원ID를 매개변수로 받아서 그 회원 정보를 삭제하는 메서드
	 * @param memId - 삭제할 회원ID
	 * @return - 삭제성공시 1, 삭제실패시 0 반환
	 */	
	public int deleteMember(String memId);
	
	
	/**
	 * 하나의 MemberVO자료를 이용하여 DB의 자료를 update하는 메서드
	 * @param memVo - update할 회원 정보가 들어있는 MemberVO객체
	 * @return - 수정작업 성공시 1, 수정작업 실패시 0
	 */
	public int updateMember(MemberVO memVo);
	
	
	/**
	 * DB의 mymember테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드
	 * @return - MemberVO를 레코드 개수만큼 갖고있는 List를 반환
	 */
	public List<MemberVO> getAllMember();
	
	
	/**
	 * 매개변수로 주어진 회원ID와 일치하는 회원 수를 반환하는 메서드
	 * @param memId - 검색할 회원ID
	 * @return - 검색된 회원 수 반환
	 */
	public int getCountMember(String memId);	
		
	
	/**
	 * 매개변수로 주어진 회원이름과 일치하는 회원 수를 반환하는 메서드
	 * @param memName -검색할 회원이름
	 * @return - 검색된 회원 수 반환
	 */
	public int getCountMemName(String memName);
	
	
	/**
	 * 매개변수로 주어진 회원이름과 일치하는 회원 수를 반환하는 메서드
	 * @param memTel - 검색할 회원전화번호
	 * @return - 검색된 회원 수 반환
	 */
	public int getCountMemTel(String memTel);
	
	
	/**
	 * 매개변수로 주어진 회원이름과 일치하는 회원 수를 반환하는 메서드
	 * @param memAddr - 검색할 회원주소
	 * @return - 검색된 회원 수 반환
	 */
	public int getCountMemAddr(String memAddr);
	
	
	/**
	 * 매개변수 회원ID와 일치하는 회원의 정보를 반환하는 메서드
	 * @param memId
	 * @return
	 */
	public List<MemberVO> getMemInfoId(String memId);
	
	
	/**
	 * 매개변수 회원이름과 일치하는 회원의 정보를 반환하는 메서드
	 * @param memName
	 * @return
	 */
	public List<MemberVO> getMemInfoName(String memName);
	
	
	/**
	 * 매개변수 회원전화번호와 일치하는 회원의 정보를 반환하는 메서드
	 * @param memTel
	 * @return
	 */
	public List<MemberVO> getMemInfoTel(String memTel);
	
	
	/**
	 * 매개변수 회원주소의 일부분이 일치하는 회원의 정보들을 반환하는 메서드
	 * @param memAddr
	 * @return
	 */
	public List<MemberVO> getMemInfoAddr(String memAddr);
	
	
	/**
	 * 매개변수로 주어진 Map의 'searchField'키 값에는 검색할 필드명이 'searchData' 키값에는 검색할 단어가 셋팅되어 있다.
	 * 이 매개변수를 이용하여 검색하는 메서드
	 * @param searchMap
	 * @return - 검색된 회원List 반환
	 */
	public List<MemberVO> getSearchMember(Map<String, String> searchMap);
	

}
