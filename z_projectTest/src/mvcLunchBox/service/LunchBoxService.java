package mvcLunchBox.service;

import java.util.List;

import mvcLunchBox.dao.ILunchBoxDao;
import mvcLunchBox.dao.LunchBoxDao;
import mvcLunchBox.vo.CartVO;
import mvcLunchBox.vo.ContainerVO;
import mvcLunchBox.vo.FoodKindVO;
import mvcLunchBox.vo.FoodVO;
import mvcLunchBox.vo.MemberVO;

public class LunchBoxService implements ILunchBoxService{
	private static LunchBoxService LBService = new LunchBoxService();
	private ILunchBoxDao lunchDao;
	
	public LunchBoxService() {
		lunchDao = LunchBoxDao.getInstance();
	}

	@Override
	public List<MemberVO> getAllMember() {
		return lunchDao.getAllMember();
	}

	@Override
	public int insertMember(MemberVO memVo) {
		return lunchDao.insertMember(memVo);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return lunchDao.updateMember(memVo);
	}

	@Override
	public int deleteMember(String mem_Id) {
		return lunchDao.deleteMember(mem_Id);
	}

	@Override
	public int getCountMember(String mem_Id) {
		return lunchDao.getCountMember(mem_Id);
	}

	@Override
	public List<FoodVO> getAllFood() {
		return lunchDao.getAllFood();
	}

	@Override
	public int insertFood(FoodVO foodVo) {
		return lunchDao.insertFood(foodVo);
	}

	@Override
	public int updateFood(FoodVO foodVo) {
		return lunchDao.updateFood(foodVo);
	}

	@Override
	public int deleteFood(String foodNum) {
		return lunchDao.deleteFood(foodNum);
	}

	@Override
	public int getCountFood(String foodNum) {
		return lunchDao.getCountFood(foodNum);
	}

	@Override
	public List<FoodKindVO> getAllFoodKind() {
		return lunchDao.getAllFoodKind();
	}

	@Override
	public int insertFoodKind(FoodKindVO foodKindVo) {
		return lunchDao.insertFoodKind(foodKindVo);
	}

	@Override
	public int updateFoodKind(FoodKindVO foodKindVo) {
		return lunchDao.updateFoodKind(foodKindVo);
	}

	@Override
	public int deleteFoodKind(String foodKindNum) {
		return lunchDao.deleteFoodKind(foodKindNum);
	}

	@Override
	public List<ContainerVO> getAllContainer() {
		return lunchDao.getAllContainer();
	}

	@Override
	public int insertContainer(ContainerVO containerVo) {
		return lunchDao.insertContainer(containerVo);
	}

	@Override
	public int updateContainer(ContainerVO containerVo) {
		return lunchDao.updateContainer(containerVo);
	}

	@Override
	public int deleteContainer(String contNum) {
		return lunchDao.deleteContainer(contNum);
	}

	@Override
	public int getCountContainer(String contNum) {
		return lunchDao.getCountContainer(contNum);
	}

	@Override
	public List<CartVO> getAllCartList(String mem_Id) {
		return lunchDao.getAllCartList(mem_Id);
	}

	@Override
	public int addCartList(String cartNum) {
		return lunchDao.addCartList(cartNum);
	}

	@Override
	public int updateCartList(String cartNum) {
		return lunchDao.updateCartList(cartNum);
	}

	@Override
	public int deleteCartList(String cartNum) {
		return lunchDao.deleteCartList(cartNum);
	}

	@Override
	public int deleteAllCartList(String mem_Id) {
		return lunchDao.deleteAllCartList(mem_Id);
	}

}










