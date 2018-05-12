package g_exception;

public class Exception04 {
	
	public static void main(String[] args) {
		try {
			StartInstall();
			copyFiles();
			deleteFile();
		} catch (Exception e) {
			System.out.println("인스톨실패");
			
		}finally{			//파일 입출력시에 많이 사용
			deleteFile();
		}
		
	}
	
	static void StartInstall(){
		
	}
	
	static void copyFiles(){
		
	}
	
	static void deleteFile(){
		
	}
	
	
	

}
