package mvcLunchBox.dao;

import java.util.List;

import mvcLunchBox.vo.CartVO;
import mvcLunchBox.vo.ContainerVO;
import mvcLunchBox.vo.FoodKindVO;
import mvcLunchBox.vo.FoodVO;
import mvcLunchBox.vo.MemberVO;

public interface ILunchBoxDao {
	
	public List<MemberVO> getAllMember();
	
	public int insertMember(MemberVO memVo);
	
	public int updateMember(MemberVO memVo);
	
	public int deleteMember(String mem_Id);
	
	public int getCountMember(String mem_Id);
	
	public List<FoodVO> getAllFood();
	
	public int insertFood(FoodVO foodVo);
	
	public int updateFood(FoodVO foodVo);
	
	public int deleteFood(String foodNum);
	
	public int getCountFood(String foodNum);	//�޼������簡ġ����?
	
	public List<FoodKindVO> getAllFoodKind();
	
	public int insertFoodKind(FoodKindVO foodKindVo);
	
	public int updateFoodKind(FoodKindVO foodKindVo);
	
	//FoodKindVO �ѹ� �ִ°� �����ϸ� ���� �޴� �Ű������� ����
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

}
