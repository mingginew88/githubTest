package basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreamTest {
	public static void main(String[] args) {
		
		Member mem1 = new Member("ȫ�浿", 40, "����");
		Member mem2 = new Member("�̼���", 20, "�λ�");
		Member mem3 = new Member("������", 30, "����");
		Member mem4 = new Member("������", 50, "��õ");
		
		//��ü�� ���Ͽ� �����ϱ�
		try {
			//��¿� ��Ʈ�� ��ü ����
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:/D_Other/memObj.bin")));
			
			//���� �۾�(���Ͽ� �����ϱ�)
			oos.writeObject(mem1);
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			
			System.out.println("���� �۾� �Ϸ�...");
			oos.close();		//��Ʈ���ݱ�
			
			//����� ��ü �о����
			
			//�Է¿� ��Ʈ����ü ����			
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("D:/D_Other/memObj.bin")));
			
			Object obj = null;		//�о�� ��ü�� ������ ����
			
			while((obj=ois.readObject()) != null){
				// �о�� �����͸� ������ ��ü������ ��ȯ�� �� ����Ѵ�.
				Member mem = (Member)obj;
				System.out.println("�̸� : " + mem.getName());
				System.out.println("���� : " + mem.getAge());
				System.out.println("�ּ� : " + mem.getAddr());
				System.out.println("-------------------");
			}			
			ois.close();	//��Ʈ���ݱ�
			
		} catch (IOException | ClassNotFoundException e) {}
	}
}

//����� Ŭ���� �����(����ȭ�� ������ Ŭ���� �����)
class Member implements Serializable{
	private String name;
	private int age;
	private String addr;
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
