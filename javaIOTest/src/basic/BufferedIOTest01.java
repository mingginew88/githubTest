package basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//일반적으로 문자기반으로 사용하되 그림이나 이러한 문자가 아닌경우에 바이트기반으로 사용하는것이 적합하다.

public class BufferedIOTest01 {
	public static void main(String[] args) {
		//입출력의 성능 향상을 위해 Buffered 스트림을 이용한다.
		try {
			//출력용 기반이 되는 스트림 생성
			FileOutputStream fout = new FileOutputStream("D:/D_Other/bufferTest.txt");
			
			//버퍼의 크기가 5인 버퍼스트림 객체 생성
			//버퍼의 크기를 지정하지 않으면 기본값으로 8192로 설정된다.
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for (int i = '1'; i <='9'; i++) {
				bout.write(i);	//버퍼를 이용한 자료 출력		
			}
			bout.flush();	//작업을 종료하기 전에는 버퍼에 남아있는 데이터를 모두 출력해 주어야하는데 그 때 flush()메서드를 사용한다.
			
			//버퍼의 크기만큼 임시저장 후에 옮겨주기때문에 버퍼의 크기보다 작게 남아있는 데이터는 옮겨지지않을수 있다.
			//close()를 통해서 데이터들이 다 나올수도있지만 안나오는경우도 생긴다.
			//그렇기때문에 flush()를 사용해서 비워주어야한다.
			
			bout.close();	//스트림 닫기 (보조스트리만 닫아도 된다)
			System.out.println("작업 끝...");
			
		} catch (IOException e) {
		}
	}

}
