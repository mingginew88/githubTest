package basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
	������ ������ ��ü ������ ����ϴ� ����
 */

public class FileTest03 {
	public static void main(String[] args) {
		
		File testFile = new File("D:/D_Other");
		displayFileList(testFile);
		
	}
	
	
//������ ����(���丮)�� ���Ե� ���ϰ� ���丮 ����� �����ִ� �޼���
	public static void displayFileList(File dir){
		System.out.println("[" + dir.getAbsolutePath() +"] ���丮 ����");
		
		File[] files = dir.listFiles();		//���丮 ���� ��� ���� ��� �о����
		
		//���� ����� '����'�� index���� ����� List
		ArrayList<Integer> subList = new ArrayList<Integer>();
		
		//��¥ ���� ����
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		for (int i = 0; i < files.length; i++) {
			String attr = "";		//���� �Ӽ��� ������ ����(�б�, ����, ����, ���丮)
			String size = "";		//���� ũ�⸦ ���ڿ��� ������ ����
			
			if(files[i].isDirectory()){
				attr = "<DIR>";
				subList.add(i);		//���� ���丮�� �ε������� list�� �߰�
			}else{
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" : "";
				attr += files[i].canWrite() ? "W" : "";
				attr += files[i].isHidden() ? "H" : "";
			}
			System.out.printf("%s %5s %12s %s\n", df.format(new Date(files[i].lastModified())), attr, size, files[i].getName());
		}//for
		
		int dirNum = subList.size();		//���� ���丮 ���� ���ϱ�
		int fileNum = files.length - dirNum;		//���� ������ ���ϱ�
		
		System.out.println(fileNum + "���� ����," + dirNum + "���� ���丮");
		System.out.println();
		
		//���ȣ���� �̿��ؼ� ���� ������ ������ �о�´�.
		for (int i = 0; i < subList.size(); i++) {
			displayFileList(files[subList.get(i)]); 		//��� ȣ��
		}
	}
}


//��ǻ�� �ȿ��� ���Ǵ� ���α׷��� �������� �����Ͱ� ������(�Է�) ������(���)�� �����Ѵ�. 


