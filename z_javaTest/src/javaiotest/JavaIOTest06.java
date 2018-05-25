package javaiotest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class JavaIOTest06 {
	public static void main(String[] args) {
		Member mem1 = new Member("ȫ�浿", 40, "����");
		Member mem2 = new Member("�̼���", 30, "�λ�");
		Member mem3 = new Member("���е�", 20, "�뱸");
		Member mem4 = new Member("������", 10, "����");
		
		try {
			FileOutputStream fos = new FileOutputStream("D:/D_Other/memObj.bin");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(mem1);
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			System.out.println("�����۾��Ϸ�");
			
			oos.close();			
			
			FileInputStream fis = new FileInputStream("D:/D_Other/memObj.bin");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			Object obj = null;
			
			while((obj=ois.readObject()) != null){
				Member mem = (Member)obj;
				System.out.println("�̸� : " + mem.getName());
				System.out.println("���� : " + mem.getAge());
				System.out.println("�ּ� : " + mem.getAddr());
				System.out.println("-------------------");
			}	
			
			ois.close();
			
		} catch (IOException | ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
	}
}



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