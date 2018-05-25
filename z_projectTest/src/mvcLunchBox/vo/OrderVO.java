package mvcLunchBox.vo;

import java.util.ArrayList;

public class OrderVO {
	private String orderNum;	//�ֹ��ڵ��ȣ
	private String mem_Id;		//�ֹ� �� ȸ�����̵�
	private String tempAddress;	//������ �ּҺ����Ҷ� ȸ���� �Է��� �� �ִ� �ӽ��ּ�
	private String payCompYn;	//�����ϷῩ��	
	private int price;	//�ֹ��� ������ �ѱݾ�
	private ArrayList<FoodVO> orderProducts = new ArrayList<FoodVO>();		//�ֹ��� �Ϸ�� ���ö� ����Ʈ
	
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getMem_Id() {
		return mem_Id;
	}
	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}
	public String getTempAddress() {
		return tempAddress;
	}
	public void setTempAddress(String tempAddress) {
		this.tempAddress = tempAddress;
	}
	public String getPayCompYn() {
		return payCompYn;
	}
	public void setPayCompYn(String payCompYn) {
		this.payCompYn = payCompYn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ArrayList<FoodVO> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(ArrayList<FoodVO> orderProducts) {
		this.orderProducts = orderProducts;
	}	
	
}
