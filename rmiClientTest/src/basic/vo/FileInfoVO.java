package basic.vo;

import java.io.Serializable;

public class FileInfoVO implements Serializable{
	private String filename;  //파일 이름이 저장될 변수
	private byte[] filedata;  //파일 내용이 저장될 변수
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getFiledata() {
		return filedata;
	}
	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
	}

	
	
}
