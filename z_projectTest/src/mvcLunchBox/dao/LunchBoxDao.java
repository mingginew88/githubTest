package mvcLunchBox.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import mvcLunchBox.vo.CartVO;
import mvcLunchBox.vo.ContainerVO;
import mvcLunchBox.vo.FoodKindVO;
import mvcLunchBox.vo.FoodVO;
import mvcLunchBox.vo.MemberVO;

public class LunchBoxDao implements ILunchBoxDao{
	private static LunchBoxDao lunchDao = new LunchBoxDao();
	SqlMapClient smc;
	
	private LunchBoxDao() {
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static LunchBoxDao getInstance() {
		if(lunchDao==null) {
			lunchDao = new LunchBoxDao();
		}
		return lunchDao;
	}
	

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String mem_Id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCountMember(String mem_Id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FoodVO> getAllFood() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertFood(FoodVO foodVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFood(FoodVO foodVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFood(String foodNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCountFood(String foodNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FoodKindVO> getAllFoodKind() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertFoodKind(FoodKindVO foodKindVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFoodKind(FoodKindVO foodKindVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFoodKind(String foodKindNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ContainerVO> getAllContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertContainer(ContainerVO containerVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateContainer(ContainerVO containerVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteContainer(String contNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCountContainer(String contNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CartVO> getAllCartList(String mem_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCartList(String cartNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCartList(String cartNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCartList(String cartNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAllCartList(String mem_Id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
