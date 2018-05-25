package mvcLunchBox.vo;

public class ContainerVO {
	private String contNum;		//용기번호
	private String contKind;	//용기사이즈 소,중,대	
	private int contQty;		//용기수량(재고)
	
	
	public String getContNum() {
		return contNum;
	}
	public void setContNum(String contNum) {
		this.contNum = contNum;
	}
	public String getContKind() {
		return contKind;
	}
	public void setContKind(String contKind) {
		this.contKind = contKind;
	}
	public int getContQty() {
		return contQty;
	}
	public void setContQty(int contQty) {
		this.contQty = contQty;
	}
}
