package rmi.dao;

import java.util.List;
import java.util.Map;

import rmi.vo.MemberVO;


/**
 * 실제 DB와 연결해서 SQL문을 수행하고, 그 결과를 작성하여
 * Service에 전달하는 DAO의 Interface
 * 
 * @author SAM
 *
 */

public interface IMemberDao {
	
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param - memVo DB에 insert할 자료가 저장된 MemberVO객체
	 * @return - DB작업이 성공하면 1이상의 값이 반환되고 
	 * 			실패하면 0이 반환된다.
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * 회원ID를 매개변수로 받아서 그 회원 정보를 삭제하는 메서드
	 * 
	 * @param memId - 삭제할 회원ID
	 * @return - 삭제 성공시 1, 삭제 실패시 0 반환
	 */
	public int deleteMember(String memId);
	
	/**
	 * 하나의 MemberVO자료를 이용하여 DB의 자료를 update하는 메서드
	 * 
	 * @param memVo - update할 회원 정보가 들어 있는 MemberVO객체 
	 * @return - 수정작업 성공시 1, 수정작업 실패시 0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * DB의 mymember테이블의 전체 레코드를 가져와서 List에 담아서
	 * 반환하는 메서드
	 * 
	 * @return - MemberVO를 레코드 개수만큼 갖고 있는 List를 반환
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 매개변수로 주어진 회원ID와 일치하는 회원 수를 반환하는 메서드
	 * 
	 * @param memId - 검색할 회원ID
	 * @return - 검색된 회원 수 반환
	 */
	public int getCountMember(String memId);
	
	/**
	 * 매개변수로 주어진 Map의 'searchField' 키값에는 검색할 필드명이
	 * 'searchData' 키값에는 검색할 단어가 셋팅되어 있다.
	 * 이 매개변수를 이용하여 검색하는 메서드
	 * 
	 * @param searchMap
	 * @return - 검색된 회원List 반환
	 */
	public List<MemberVO> getSearchMember(Map<String, String> searchMap);
	
}










