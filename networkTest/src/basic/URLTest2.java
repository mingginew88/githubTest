package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class URLTest2 {
	
	//URLConnectionŬ���� ==> ���ø����̼ǰ� URL���� ��� ������ ���� �߻�Ŭ����
	
	//Ư�� ������ ������ ���� ���� ����ϱ�
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/index.html");
		
		//URLConnection��ü ���ϱ�
		URLConnection urlCon = url.openConnection();
		
		System.out.println("Header ���� ���");
		System.out.println("--------------");
		System.out.println();
		//Header���� ���ϱ�
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();
		
		//Header�� Ű�� ���ϱ�
		Iterator<String> it = headerMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next(); // Ű�� ���
			
			// Ű���� Ű���� ������ �� ���
			System.out.println(key + " ==> " + headerMap.get(key));
		}
		
		System.out.println("===================================================");
		
		//�ش� ȣ��Ʈ�� ���� ���� ��������(index.html����)
		/*
		//���1 ==> URLConnection��ü�� getInputStream() �̿��ϱ�
		
		//������ �о���� ���� ��Ʈ�� ����
		InputStream is = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		//�������
		while(true) {
			String str = br.readLine();
			if(str==null) { //������ �о����� Ȯ��
				break;
			}
			
			System.out.println(str);
		}
		
		//��Ʈ�� �ݱ�
		br.close();
		*/
		
		//---------------------------------------------
		//���2 ==> URL��ü�� openStream() �̿��ϱ�
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		//�������
		while(true) {
			String str = br.readLine();
			if(str==null) { //������ �о����� Ȯ��
				break;
			}
			
			System.out.println(str);
		}
		
		//��Ʈ�� �ݱ�
		br.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
