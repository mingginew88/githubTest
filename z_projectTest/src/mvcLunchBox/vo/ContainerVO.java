package mvcLunchBox.vo;

public class ContainerVO {
	private String contNum;		//����ȣ
	private String contKind;	//�������� ��,��,��	
	private int contQty;		//������(���)
	
	
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
