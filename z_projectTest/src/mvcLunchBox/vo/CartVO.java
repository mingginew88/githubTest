package mvcLunchBox.vo;

import java.util.ArrayList;

public class CartVO {	
	private String cartNum;		//주문코드번호
	private String mem_Id;		//주문 한 회원아이디
	private String tempAddress;	//결제시 주소변경할때 회원이 입력할 수 있는 임시주소
	private String payCompYn;	//결제완료여부
	private int price;	//주문한 음식의 총금액
	private ArrayList<FoodVO> cartProducts = new ArrayList<FoodVO>();		//주문이 완료된 도시락 리스트
	
	
	
	public String getCartNum() {
		return cartNum;
	}
	public void setCartNum(String cartNum) {
		this.cartNum = cartNum;
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
	public ArrayList<FoodVO> getCartProducts() {
		return cartProducts;
	}
	public void setCartProducts(ArrayList<FoodVO> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
}
