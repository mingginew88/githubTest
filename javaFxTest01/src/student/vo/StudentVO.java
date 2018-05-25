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
	�� ��Ű�� ����� DB���� ���̺� ����, ������ ��� �ϰ�
	�� �������̽� Ŭ���� ���� ��
	xml ���� dao�� ����
	SqlMapConfig.xml �� sqlmap���� �̸��ۼ��ص� ������ ���� (ibatis)  (���� ibatis jar���� �־��ش�)
	DaoImpl ������ �̱��� ���� �ϰ� �������̵� �� �޼������ �ۼ����ش�.
	Service�� �Ѿ��. �̱��� �������ش�.
	main ��Ű���� Main�� fxml������ fxml�� ¦�̵Ǵ� controller�� �������ش�.
	main ��Ű���� ó�� ����ִ� â�� ����Ǵ� �� fxml������ �׿� �´� controller���� �������ش�.
	�� fxml�� ���� �������� �۾����ش�.
	���������� ��Ʈ�ѷ� �����ϰ� view-showsampleController ... - full ��ü �����ͼ� controller�� ����
	
*/





