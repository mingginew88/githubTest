package mvcLunchBox.vo;

public class FoodKindVO {
	
	//���� ������ ��ȣ�� ���� �ʿ��غ��δ�. 
	private int foodKindNum;		//�޴��з��ڵ� 0 , 1 , 2
	private String foodKindName;	//��, �� , ����	
	
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
