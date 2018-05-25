package mvcLunchBox.vo;

public class FoodVO {
	private String foodNum;		//음식코드번호 	pk
	private int foodKind;		//음식종류(분류) 	fk
	private String foodName;	//음식명
	private int foodPrice;		//음식가격
	private int foodQty;		//음식수량(재고)
	private String recMenu;		//추천메뉴	
	
	
	public String getFoodNum() {
		return foodNum;
	}
	public void setFoodNum(String foodNum) {
		this.foodNum = foodNum;
	}
	public int getFoodKind() {
		return foodKind;
	}
	public void setFoodKind(int foodKind) {
		this.foodKind = foodKind;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public int getFoodQty() {
		return foodQty;
	}
	public void setFoodQty(int foodQty) {
		this.foodQty = foodQty;
	}
	public String getRecMenu() {
		return recMenu;
	}
	public void setRecMenu(String recMenu) {
		this.recMenu = recMenu;
	}	
	
}
