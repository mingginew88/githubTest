package mvcLunchBox.vo;

public class FoodKindVO {
	
	//음식 종류의 번호가 따로 필요해보인다. 
	private int foodKindNum;		//메뉴분류코드 0 , 1 , 2
	private String foodKindName;	//밥, 국 , 반찬	
	
	public int getFoodKindNum() {
		return foodKindNum;
	}
	public void setFoodKindNum(int foodKindNum) {
		this.foodKindNum = foodKindNum;
	}
	public String getFoodKindName() {
		return foodKindName;
	}
	public void setFoodKindName(String foodKindName) {
		this.foodKindName = foodKindName;
	}	
}
