package basic.vo;

import java.io.Serializable;


// RMI���� ������ ���޿����� ����� ��ü
// �� ��ü�� ��Ʈ��ũ�� ���ؼ� ���޵Ǳ� ������ ����ȭ�� �ʿ��ϴ�.
// �׷��� Serializable�� ������ ���·� �ۼ��Ѵ�.
public class TestVO implements Serializable{
	private String testId;
	private int testNum;
	
	
	
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public int getTestNum() {
		return testNum;
	}
	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}
	
	
}
