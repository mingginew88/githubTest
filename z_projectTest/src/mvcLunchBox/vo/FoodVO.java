package mvcLunchBox.vo;

public class FoodVO {
	private String foodNum;		//�����ڵ��ȣ 	pk
	private int foodKind;		//��������(�з�) 	fk
	private String foodName;	//���ĸ�
	private int foodPrice;		//���İ���
	private int foodQty;		//���ļ���(���)
	private String recMenu;		//��õ�޴�	
	
	
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
