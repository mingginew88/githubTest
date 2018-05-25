package student.vo;

public class StudentVO {
	private int std_num;
	private String std_name;
	private int std_kor;
	private int std_eng;
	private int std_mat;
	
	
	//alt + shift + s => c
	public StudentVO() {}
	
	
	//alt + shift + s => o
	public StudentVO(int std_num, String std_name, int std_kor, int std_eng, int std_mat) {
		super();
		this.std_num = std_num;
		this.std_name = std_name;
		this.std_kor = std_kor;
		this.std_eng = std_eng;
		this.std_mat = std_mat;
	}


	//alt + shift + s => r
	public int getStd_num() {
		return std_num;
	}
	public void setStd_num(int std_num) {
		this.std_num = std_num;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public int getStd_kor() {
		return std_kor;
	}
	public void setStd_kor(int std_kor) {
		this.std_kor = std_kor;
	}
	public int getStd_eng() {
		return std_eng;
	}
	public void setStd_eng(int std_eng) {
		this.std_eng = std_eng;
	}
	public int getStd_mat() {
		return std_mat;
	}
	public void setStd_mat(int std_mat) {
		this.std_mat = std_mat;
	}

}



/*
	각 패키지 만들고 DB에서 테이블 생성, 시퀀스 등등 하고
	각 인터페이스 클래스 생성 후
	xml 파일 dao에 생성
	SqlMapConfig.xml 에 sqlmap으로 미리작성해둔 쿼리문 연결 (ibatis)  (관련 ibatis jar파일 넣어준다)
	DaoImpl 에가서 싱글톤 적용 하고 오버라이드 된 메서드들을 작성해준다.
	Service로 넘어간다. 싱글톤 생성해준다.
	main 패키지에 Main과 fxml문서와 fxml과 짝이되는 controller도 생성해준다.
	main 패키지에 처음 띄어주는 창과 연결되는 각 fxml문서와 그에 맞는 controller들을 생성해준다.
	각 fxml에 가서 씬빌더로 작업해준다.
	씬빌더에서 컨트롤러 설정하고 view-showsampleController ... - full 전체 가져와서 controller에 복붙
	
*/





