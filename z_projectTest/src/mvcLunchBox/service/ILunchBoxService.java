package mvcLunchBox.service;

import java.util.List;

import mvcLunchBox.vo.CartVO;
import mvcLunchBox.vo.ContainerVO;
import mvcLunchBox.vo.FoodKindVO;
import mvcLunchBox.vo.FoodVO;
import mvcLunchBox.vo.MemberVO;

public interface ILunchBoxService {	
	
	public List<MemberVO> getAllMember();
	
	public int insertMember(MemberVO memVo);
	
	public int updateMember(MemberVO memVo);
	
	public int deleteMember(String mem_Id);
	
	public int getCountMember(String mem_Id);
	
	public List<FoodVO> getAllFood();
	
	public int insertFood(FoodVO foodVo);
	
	public int updateFood(FoodVO foodVo);
	
	public int deleteFood(String foodNum);
	
	public int getCountFood(String foodNum);	//메서드존재가치유무?
	
	public List<FoodKindVO> getAllFoodKind();
	
	public int insertFoodKind(FoodKindVO foodKindVo);
	
	public int updateFoodKind(FoodKindVO foodKindVo);
	
	//FoodKindVO 넘버 주는거 수정하면 여기 받는 매개변수도 수정
	public int deleteFoodKind(String foodKindNum);
	
	public List<ContainerVO> getAllContainer();
	
	public int insertContainer(ContainerVO containerVo);
	
	public int updateContainer(ContainerVO containerVo);
	
	public int deleteContainer(String contNum);
	
	public int getCountContainer(String contNum);
	
	public List<CartVO> getAllCartList(String mem_Id);
	
	public int addCartList(String cartNum);
	
	public int updateCartList(String cartNum);
	
	public int deleteCartList(String cartNum);
	
	public int deleteAllCartList(String mem_Id);
	
	//카트까지 생성... 오더VO관련 메서드 미생성상태
	
	/*
	 필요한 메서드들
	 	전체 고객 정보가져오는 메서드
	 	고객정보 등록하는 메서드	 	
	 	고객정보 수정하는 메서드
	 	고객정보 삭제하는 메서드
	 	고객정보 일치여부 체크하는 메서드
	 	
	 	전체 도시락 메뉴정보 가져오는 메서드
	 	도시락메뉴 추가하는 메서드
	 	도시락메뉴 수정하는 메서드
	 	도시락메뉴 삭제하는 메서드
	 	도시락메뉴 일치여부 체크하는 메서드 ?
	 	
	 	메뉴종류 정보 가져오는 메서드
	 	메뉴종류 추가하는 메서드
	 	메뉴종류 수정하는 메서드
	 	메뉴종류 삭제하는 메서드	 	
	 	
	 	전체 용기 종류정보 가져오는 메서드
	 	용기정보 추가하는 메서드
	 	용기정보 수정하는 메서드
	 	용기정보 삭제하는 메서드
	 	용기정보 일치여부 체크하는 메서드	?
	 	
	 	장바구니에 들어가있는 정보 가져오는 메서드
	 	장바구니정보 추가하는 메서드
	 	장바구니정보 수정하는 메서드
	 	장바구니정보 삭제하는 메서드
	 	장바구니정보 모두 삭제하는 메서드
	 	?
	 	
	 	주문이 끝난 상태의 정보 가져오는 메서드
	 	주문완료정보 추가하는 메서드
	 	주문완료정보 수정하는 메서드
	 	주문완료정보 삭제하는 메서드
	 	?
	 
	 
	 */
	

}
