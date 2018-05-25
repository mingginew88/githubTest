package basic;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MemberIbatisTest {
	public static void main(String[] args) {
		//ibatis�� �̿��Ͽ� DB�ڷḦ ó���ϴ� �۾� ����
		
		try {
			//1. ibatis�� ȯ�漳�� ������ �о�� �����Ų��.
			//(SqlMapConfig.xml����)
			
			//1-1. xml���� �о����
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			
			//1-2. ������ �о�� Reader��ü�� �̿��Ͽ� ���� �۾��� ������ ibatis��ü(SqlMapClient��ü)�� �����Ѵ�.
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();//Reader��ü�ݱ�
			
			//2. ������ SQL���� �´� �������� ȣ���ؼ� ���ϴ� �۾��� �����Ѵ�.
			
			//2-1. insert�۾�����
//			System.out.println("insert�۾� ����...");
//			
//			// 1) ������ �����͸� VO��ü�� ��´�.
//			MemberVO mvo = new MemberVO();
//			mvo.setMem_id("d001");
//			mvo.setMem_name("������");
//			mvo.setMem_tel("010-1234-1234");
//			mvo.setMem_addr("������ ���� ����");
//			
//			// 2) SqlMapClient��ü ������ �̿��Ͽ� �ش� �������� ȣ���� �����Ѵ�.
//			// ����) smc.insert("namespace��.id��", �Ķ����Ŭ����)
//			// ==> ��ȯ�� : �۾������ϸ� null�� ��ȯ�ȴ�.
//			Object obj = smc.insert("memberTest.insertMember", mvo);
//			if(obj == null){
//				System.out.println("Insert�۾� ����");
//			}else {
//				System.out.println("Insert�۾� ����");
//			}
			
			System.out.println("===========================================");
			
//			//2-2 update�۾� ����
//			System.out.println("update�۾� ����...");
//			
//			//update�� ������ ����
//			MemberVO mvo2 = new MemberVO();
//			mvo2.setMem_id("d001");
//			mvo2.setMem_name("ȫ��ȯ");
//			mvo2.setMem_tel("010-9999-9999");
//			mvo2.setMem_addr("������ ������ ����");
//			
//			//update()�޼��带 �̿��Ͽ� �����Ѵ�.
//			//��ȯ�� : ������ ���ڵ� ��
//			int cnt = smc.update("memberTest.updateMember", mvo2);
//			if(cnt>0){
//				System.out.println("Update�۾� ����");
//			}else{
//				System.out.println("Update�۾� ����");
//			}
			
			System.out.println("===========================================");
			
			//2-3 delete�۾� ����
//			System.out.println("Delete�۾� ����...");			
//			
//			int cnt = smc.delete("memberTest.deleteMember", "d001");
//			if(cnt>0){
//				System.out.println("Delete�۾� ����");
//			}else {
//				System.out.println("Delete�۾� ����");
//			}
			
			System.out.println("===========================================");
			
			//2-4 select�۾� ����
			
//			//1) select�� ����� �������� ���ڵ��� ���
//			//queryForList()�޼��带 �̿��Ѵ�.
//			//��ȯ���� List�� �ȴ�.
//			System.out.println("select ���� (����� �������� ���)...");
//			List<MemberVO> memList = smc.queryForList("memberTest.getAllMember");
//			
//			for (MemberVO mv : memList) {
//				System.out.println("ID : " + mv.getMem_id());
//				System.out.println("�̸� : " + mv.getMem_name());
//				System.out.println("��ȭ��ȣ : " + mv.getMem_tel());
//				System.out.println("�ּ� : " + mv.getMem_addr());
//			}
//			System.out.println("��� ��...");
			
			//2)select�� ����� 1���� ���ڵ��� ���
			//queryForObject()�޼��带 �̿��Ѵ�.
			//��ȯ�� : resultClass�� ������ ��ü
			System.out.println("select ���� ����(����� 1���� ���)...");
			
			MemberVO mv2 = (MemberVO) smc.queryForObject("memberTest.getMember", "d001");
			
			System.out.println("ID : " + mv2.getMem_id());
			System.out.println("�̸� : " + mv2.getMem_name());
			System.out.println("��ȭ��ȣ : " + mv2.getMem_tel());
			System.out.println("�ּ� : " + mv2.getMem_addr());
			
			System.out.println("��� ��...");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
