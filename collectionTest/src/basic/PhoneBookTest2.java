package basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
	Scanner�� �ڷ� �Է°��� ����
	
	- next(), next�ڷ����̸�()���� �޼������ ȭ��Ʈ�����̽�(����Ű, ��Ű, ����)�� �������� �����͸� �����ؼ� �Է¹޴´�.
	- �Է��� �����͵��� ������ ����Ǳ� ���� �Է¹��ۿ� ���� ���� �Ŀ� ó���ȴ�.
	
	- nextLine() => �Է¹��ۿ� �ִ� ��� �����͸� �����´�.(����Ű���� �о�´�.)
	
	- ��ȭ��ȣ ������ ����� ���ϸ� : "D:/D_Other/phoneBook.dat"
	- �� ���α׷��� ���۵Ǹ� �켱 ��ȭ��ȣ ������ �о�� phoneBookMap�� �����Ѵ�.
	- 6.��ȭ��ȣ ���� ����޴��� �����ϸ� Map�� �ִ� ������ ���Ϸ� �����Ѵ�.
 */


public class PhoneBookTest2 {
	private Scanner scan;
	private HashMap<String, Phone2> phoneBookMap;
	
	public PhoneBookTest2(){
		scan = new Scanner(System.in);
		phoneBookMap = new HashMap<String, Phone2>();
	}
	
	//�޴��� ����ϰ� ���õ� �޴� ��ȣ�� ��ȯ�ϴ� �޼���
	public int getMenu(){
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println(" 1. ��ȭ��ȣ ���");
		System.out.println(" 2. ��ȭ��ȣ ����");
		System.out.println(" 3. ��ȭ��ȣ ����");
		System.out.println(" 4. ��ȭ��ȣ �˻�");
		System.out.println(" 5. ��ȭ��ȣ ��ü ���");
		System.out.println(" 6. ��ȭ��ȣ ���� ����");
		System.out.println(" 0. ���α׷� ����");
		System.out.println("-----------------------------");
		System.out.print("   ��ȣ �Է� >>  ");
		int num = scan.nextInt();
		return num;
	}
	
	//���α׷��� �۾��� �����ϴ� �޼���
	public void start(){		
		readData();	
		
		System.out.println("=============================");
		System.out.println("��ȭ��ȣ ���� ���α׷�");
		System.out.println("=============================");
		
		while(true){
			int menuNum = getMenu();
			
			switch (menuNum) {
			case 1:	
				insert();	//����ϴ� �޼���
				break;
			case 2:	
				update();	//�����ϴ� �޼���
				break;
			case 3:
				delete();	//�����ϴ� �޼���
				break;
			case 4:
				search();	//�˻��ϴ� �޼���
				break;
			case 5:
				displayAll();	//��ü�ڷ� ����ϴ� �޼���
				break;
			case 6:
				savaData();	//��ȭ��ȣ ���� ����
				break;				
			case 0:		//���α׷� ����
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
			}					
		}
	}
	//====================================
	
	//���ο� ��ȭ��ȣ ������ ����ϴ� �޼���
	//�̹� ��ϵ� ����� ��ϵ��� �ʴ´�.
	public void insert(){
		System.out.println("����� ���ο� ��ȭ��ȣ ������ �Է��ϼ���.");
		System.out.print("�̸� >> ");
		String name = scan.next();
		
		//�Է��� �̸��� ��ϵǾ����� �˻�
		if(phoneBookMap.containsKey(name)){
			System.out.println(name + "���� �̹� ��ϵ� ����Դϴ�.");
			return;
		}
		
		System.out.println("��ȭ��ȣ >> ");
		String tel = scan.next();
		
		scan.nextLine();		//�Է¹����� ������ ����ִ� ������ �Ѵ�.
		System.out.println("�ּ� >> ");
		String addr = scan.nextLine();
		
		//�Է��� ������ Map�� �߰��Ѵ�.
//		phoneBookMap.put(name, new Phone2(name, addr, tel));
		Phone2 p = new Phone2(name, addr, tel);
		phoneBookMap.put(name, p);
		
	}
	//====================================
	
	// ��ȭ��ȣ ������ �����ϴ� �޼���
	public void update(){
		System.out.println();
		System.out.println("������ ��ȭ��ȣ ������ �Է��ϼ���.");
		System.out.println("�̸� >> ");
		String name = scan.next();
		
		if(!(phoneBookMap.containsKey(name))){
			System.out.println(name + "���� ��ϵ��� �ʾҽ��ϴ�.");
			return;
		}
		
		System.out.println("������ ��ȭ��ȣ >> ");
		String tel = scan.next();
		
		System.out.println("������ �ּ� >> ");
		String addr = scan.next();
		
		phoneBookMap.put(name, new Phone2(name, addr, tel));
		System.out.println(name + "���� ���� �����Ϸ�...");
	}
	
	public void displayAll(){
		System.out.println();
		System.out.println("=============================");
		System.out.println("��ȣ    �̸�     ��ȭ��ȣ       �ּ�");
		System.out.println("=============================");
		
		if(phoneBookMap.size()==0){
			System.out.println("��ϵ� ������ �ϳ��� �����ϴ�.");
		}else{
			Set<String> keyset = phoneBookMap.keySet();
			
			Iterator<String> it = keyset.iterator();
			
			int cnt = 0;
			while(it.hasNext()){
				cnt++;
				String name = it.next();
				Phone2 p = phoneBookMap.get(name);
				System.out.println(cnt + "\t" + p.getName() + "\t" + p.getTel() + "\t" + p.getAddr());
			}//while
		}//if
		System.out.println("=============================");
		System.out.println("��� ��...");
	}
	//====================================
	
	//��ȭ��ȣ ������ �����ϴ� �޼���
	public void delete(){
		System.out.println();
		System.out.println("������ ��ȭ��ȣ ������ �Է��ϼ���.");
		System.out.println("�̸� >> ");
		String name = scan.next();
		
		if(!phoneBookMap.containsKey(name)){
			System.out.println(name + "�� �����ʹ� �����ϴ�.");
			return;
		}
		
		phoneBookMap.remove(name);
		
		System.out.println(name + "�� ���� �����Ϸ�...");
	}
	
	//��ȭ��ȣ ������ �˻��ϴ� �޼���
	public void search(){
		System.out.println();
		System.out.println("�˻��� ��ȭ��ȣ ������ �Է��ϼ���.");
		System.out.println("�̸� >> ");
		String name = scan.next();
		
		if(phoneBookMap.containsKey(name)){
			System.out.println(name + "�� �����ʹ� �����ϴ�.");
			return;
		}
		
		Phone2 p = phoneBookMap.get(name);
		System.out.println(name + "���� ��ȭ��ȣ ����");
		System.out.println("��    �� : " + p.getName());
		System.out.println("��ȭ��ȣ : " + p.getTel() );
		System.out.println("��    �� : " + p.getAddr());
		System.out.println("=============================");
		System.out.println("��� ��...");
	}
	
	//��ü��ȭ��ȣ ������ �о���� �޼���
	public void readData(){
		File file = new File("D:/D_Other/phoneBook.dat");
		if(file.exists()){
			try {
				ObjectInputStream ois =new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
				
				Object obj = ois.readObject();
				if(obj==null){
					phoneBookMap = new HashMap<String, Phone2>();
				}else{
					phoneBookMap = (HashMap<String, Phone2>) obj;
				}
				System.out.println("�б� �۾� �Ϸ�");
				System.out.println();
				
			} catch (IOException | ClassNotFoundException e) {
			}
		}		
	}	
	
	//��ü ��ȭ��ȣ ������ �����ϴ� �޼���
	public void savaData(){
		try {
			if(phoneBookMap==null){
				System.out.println("������ �ڷᰡ �����ϴ�.");
				return;
			}
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:/D_Other/phoneBook.dat")));
			
			oos.writeObject(phoneBookMap);
			System.out.println("��ȭ��ȣ ������ �����߽��ϴ�.");			
			oos.close();
		} catch (IOException e) {}
	}

	
	public static void main(String[] args) {	
		new PhoneBookTest2().start();
	}

}

//�ϳ��� ��ȭ��ȣ ���� ��, �̸�, �ּ�, ��ȭ��ȣ�� ������ Ŭ���� ����
class Phone2 implements Serializable{
	private String name;
	private String addr;
	private String tel;
	
	
	public Phone2(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}	
	
	@Override
	public String toString() {
		return "Phone2 [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}
	
}