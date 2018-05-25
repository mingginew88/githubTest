package javaiotest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JavaIOTest01 {
	public static void main(String[] args) {
		//File��ü ����
		//new File(String ���϶Ǵ� ���)
		
		File file = new File("D:/D_Other");
		
		System.out.println(file.getName());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println();
		
		File file2 = new File(file, "test.txt");
		System.out.println(file2.getName());
		System.out.println("����? : " + file2.isFile());
		System.out.println("���丮? : " + file2.isDirectory());
		System.out.println("������ ũ�� : " + file2.length());
		System.out.println();
		
		
		//���丮(����) ����
		File file3 = new File("D:/D_Other/������");
		if(file3.mkdir()){
			//���� ���� �� ó������
			System.out.println(file3.getName() + "���� ����� ����");
		}else{
			//����� �������� �� ó������
			System.out.println(file3.getName() + "���� ����� ����");
		}
		System.out.println();
		
		
		File file4 = new File("D:/D_Other/test/java/src");
		if(file4.mkdirs()){
			//���� ���� �� ó������
			System.out.println(file4.getName() + "����� ����");
		}else{
			//����� �������� �� ó������
			System.out.println(file4.getName() + "����� ����");
		}
		System.out.println();
		
		File file5 = new File("D:/D_Other/������");		
		
		if(file5.exists()){		//�ش� �����̳� ���丮�� ���� ������ true
			System.out.println(file5.getPath() + "�� �����մϴ�.");
			if(file5.isFile()){
				System.out.println("�̰��� �����Դϴ�.");
			}else if(file5.isDirectory()){
				System.out.println("�̰��� �����Դϴ�.");
			}
		}else{
			System.out.println(file5.getAbsolutePath() + "�� �����ϴ�.");
			if(file5.mkdir()){
				System.out.println("���� ����� ����");
			}else{
				System.out.println("���� ����� ����");
			}
		}
		
		
		File testFile = new File("D:/D_Other");
		displayFileList(testFile);
		//������ ������ ��ü���� ���	
		
	}
	
	public static void displayFileList(File dir){
		System.out.println("[" + dir.getAbsolutePath() + "]");
		
		File[] files = dir.listFiles();
		
		ArrayList<Integer> subList = new ArrayList<Integer>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		for (int i = 0; i < files.length; i++) {
			String attr = "";
			String size = "";
			
			if(files[i].isDirectory()){
				attr = "<DIR>";
				subList.add(i);
			}else{
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" : "";
				attr += files[i].canWrite() ? "W" : "";
				attr += files[i].isHidden() ? "H" : "";
			}
			System.out.printf("%s %5s %12s %s\n", sdf.format(new Date(files[i].lastModified())), attr, size, files[i].getName());
		}
		
		int dirNum = subList.size();
		int fileNum = files.length - dirNum;
		
		System.out.println(fileNum + "���� ����, " + dirNum + "���� ���丮");
		System.out.println();
		
		for (int i = 0; i < subList.size(); i++) {
			displayFileList(files[subList.get(i)]);
		}
	}
}
