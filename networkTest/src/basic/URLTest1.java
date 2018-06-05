package basic;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLTest1 {
	
	//URL Ŭ���� ==> ���ͳݿ� �����ϴ� �������� �ڿ��� ������ �� �ִ� �ּ�
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		URL url = new URL("http", "ddit.or.kr", 80, "index.html?ttt=123#test");
		
		System.out.println("protocol : " + url.getProtocol());
		System.out.println("host : " + url.getHost());
		System.out.println("port : " + url.getPort());
		System.out.println("path : " + url.getPath());
		System.out.println("file : " + url.getFile());
		System.out.println("query : " + url.getQuery());
		System.out.println("anchor : " + url.getRef());
		System.out.println();
		
		System.out.println(url.toExternalForm());
		System.out.println(url.toString());
		System.out.println(url.toURI().toString());
	}

}
