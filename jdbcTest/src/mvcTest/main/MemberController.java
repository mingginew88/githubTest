package mvcTest.main;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import mvcTest.service.IMemberService;
import mvcTest.service.MemberService;
import mvcTest.vo.MemberVO;


/*
������ �޴��� '5.�ڷ�˻�'�޴��� �߰��Ѵ�.
�� '�ڷ�˻�'�޴��� �����ϸ� �Ʒ��� ���� �θ޴��� ��µȴ�.

�˻��� �޴��� �����ϼ���.
1. ID�˻�     2. �̸��˻�     3.��ȭ��ȣ     4. �ּҰ˻�
�˻� ���� >>

�˻��� ID �Է� >>

���� �޴����� ���õ� �˻��� �����ϴ� ���α׷��� �ϼ��Ͻÿ�.
('ID'�� '�̸�',  '��ȭ��ȣ'�� ��Ȯ�� ��ġ�ϴ� ������ �˻��ǵ��� �ϰ� '�ּ�'�� �Ϻκи� �Է��ص� �˻��ǵ����Ѵ�.)
 */

public class MemberController {	
	private Scanner scan;
	private IMemberService memService;	//Service��ü�� ������ ��������
	
	//�����ڿ��� Service��ü�� �����Ѵ�.
	public MemberController(){
		scan = new Scanner(System.in);
		memService = MemberService.getInstance();
	}
	
	public static void main(String[] args) {
		new MemberController().startMember();
	}
	
	
	public int displayMenu(){
		System.out.println("===== �۾� ���� =====");
		System.out.println("-------------------");
		System.out.println("1. �ڷ��Է�");
		System.out.println("2. �ڷ����");
		System.out.println("3. �ڷ����");
		System.out.println("4. ��ü �ڷ� ���");
		System.out.println("5. �ڷ� �˻�");
		System.out.println("0. �۾� ��");
		System.out.println("-------------------");
		System.out.println(" �۾����� >>");
		int choice  = scan.nextInt();
		
		return choice;
	}
	
	//�۾��� �����ϴ� �޼���
	public void startMember(){
		int choice;
		do{
			choice = displayMenu();
			switch(choice){
			case 1: //�ڷ��Է�
				insertMember();
				break;
			case 2: //�ڷ����
				deleteMember();
				break;
			case 3: //�ڷ����
				updateMember();
				break;
			case 4: //��ü�ڷ� ���
				displayAllMember();
				break;
			case 5:	//�ڷ�˻�
				selectMemInfo();
				break;
			case 0:
				System.out.println("�۾��� ��Ĩ�ϴ�.");
				break;
			default :
				System.out.println("��ȣ�� �߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}while(choice!=0);
	}//End startMember()
	
	
	//��üȸ�������� ����ϴ� �޼���
	public void displayAllMember(){		
		List<MemberVO> memList = memService.getAllMember();
		
		int size=0;
		if(memList!=null){
			size = memList.size();
		}
		System.out.println("��ȸ�� �� : " + size + "��");
		System.out.println("---------------------------------------------------");		
		System.out.println(" ID     �̸�      ��ȭ��ȣ    �ּ�");
		System.out.println("---------------------------------------------------");	
		if(memList==null||size==0){
			System.out.println("����� ȸ���� �����ϴ�.");
		}else{
			for (MemberVO mv : memList) {
				System.out.println(mv.getMem_id() + "\t" + mv.getMem_name() + "\t" + mv.getMem_tel() + "\t" + mv.getMem_addr());
			}			
		}
		System.out.println("---------------------------------------------------");
		System.out.println("�ڷ� ��� �Ϸ�...");
	}
	
	
	//ȸ�������� �����ϴ� �޼���
	public void updateMember(){		
		System.out.println();
		System.out.print("������ ȸ��ID �Է� >> ");
		String memId = scan.next();
		
		int cnt = memService.getCountMember(memId);
		if(cnt==0){
			System.out.println(memId + "��(��) ���� ȸ��ID �Դϴ�.");
			return;
		}
		
		System.out.print("���ο� ȸ���̸� >> ");
		String memName = scan.next();
		
		System.out.print("���ο� ȸ����ȭ��ȣ >> ");
		String memTel = scan.next();
		
		scan.nextLine();
		System.out.print("���ο� ȸ���ּ� >> ");
		String memAddr = scan.nextLine();		
		
		//�Է¹��� �ڷḦ MemberVO��ü�� �����Ѵ�.
		MemberVO mv = new MemberVO();
		mv.setMem_id(memId);
		mv.setMem_name(memName);
		mv.setMem_tel(memTel);
		mv.setMem_addr(memAddr);
		
		cnt = memService.updateMember(mv);
		
		if(cnt > 0){
			System.out.println(memId + "���� ȸ���� ������ �����߽��ϴ�.");
		}else{
			System.out.println("���� �۾� ����");
		}
	}
	
	
	//ȸ�������� �����ϴ� �޼���
	public void deleteMember(){		
		System.out.println();
		System.out.println("������ ȸ��ID �Է� >> ");
		String memId = scan.next();
		
		int cnt = memService.getCountMember(memId);
		if(cnt==0){
			System.out.println(memId + "��(��) ���� ȸ��ID�Դϴ�." );
			return;
		}
		cnt = memService.deleteMember(memId);
		
		if(cnt>0){
			System.out.println(memId + "���� ȸ���������� ����");
		}else{
			System.out.println("���� �۾� ����");
		}
	}
	
	
	//ȸ�������� �߰�(�Է�)�ϴ� �޼���
	public void insertMember(){		
		System.out.println();
		System.out.println("�߰��� ȸ�� ������ �Է��ϼ���.");
		int cnt = 0;
		String memId = "";
		//ȸ��ID�� �Է¹޾� �ߺ��Ǵ��� ���θ� �˻��Ѵ�.
		do{
			System.out.println("ȸ��ID >> ");
			memId = scan.next();
			cnt = memService.getCountMember(memId);
			if(cnt > 0){
				System.out.println(memId + "�� �̹� ��ϵ� ȸ��ID�Դϴ�.");
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		}while(cnt > 0);
		
		System.out.print("ȸ���̸� >> ");
		String memName = scan.next();
		
		System.out.print("ȸ����ȭ��ȣ >> ");
		String memTel = scan.next();
		
		scan.nextLine();	//�Է¹��� �����
		System.out.print("ȸ���ּ� >> ");
		String memAddr = scan.nextLine();	
		
		//�Է¹��� �ڷ���� MemberVO��ü�� �����Ѵ�.
		MemberVO mv = new MemberVO();
		mv.setMem_id(memId);
		mv.setMem_name(memName);
		mv.setMem_tel(memTel);
		mv.setMem_addr(memAddr);
		
		//insert�۾��� �����ϴ� Service�� �޼��� ȣ��
		cnt = memService.insertMember(mv);
		
		if(cnt>0){
			System.out.println(memId + "���� ȸ�� ���� insert ����");
		} else {
			System.out.println("insert �۾� ����");
		}		
	}
	
	
	public void selectMemInfo(){		
		int input = 0;
		String field = "";
		String data = "";
		
		do{
			scan = new Scanner(System.in);
			System.out.println("�˻��� �޴��� �����ϼ���.");
			System.out.println("1. ID�˻�     2. �̸��˻�     3.��ȭ��ȣ     4. �ּҰ˻�   5. �ڷΰ���");
			System.out.print("�˻� ���� >>");			
			input = scan.nextInt();			
			switch(input){			
				case 1:		//ID�˻�	
					field = "mem_id";
					System.out.println("�˻��� ID �Է� >> ");
					data = scan.next();
					break;
				case 2:		//�̸��˻�
					field = "mem_name";
					System.out.println("�˻��� �̸� �Է� >> ");
					data = scan.next();
					break;
				case 3:		//��ȭ��ȣ
					field = "mem_tel";
					System.out.println("�˻��� ��ȭ��ȣ �Է� >> ");
					data = scan.next();
					break;
				case 4:		//�ּҰ˻�
					field = "mem_addr";
					System.out.println("�˻��� �ּ� �Է� >> ");
					scan.nextLine();
					data = scan.nextLine();
					break;
				case 5:		//�ڷΰ���
					return;
				default:
					System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				}
		}while(input < 1 || input > 5);
		
		HashMap<String, String> searchMap = new HashMap<String, String>();
		
		searchMap.put("searchField", field);
		searchMap.put("searchData", data);
		
		List<MemberVO> memList = memService.getSearchMember(searchMap);
		
		int size = 0;
		if(memList!=null){
			size = memList.size();
		}
		System.out.println("�˻��� ȸ�� �� : " + size + "��");
		System.out.println("---------------------------------------------------");		
		System.out.println(" ID     �̸�      ��ȭ��ȣ    �ּ�");
		System.out.println("---------------------------------------------------");	
		for (MemberVO mv : memList) {
			System.out.println(mv.getMem_id() + "\t" + mv.getMem_name() + "\t" + mv.getMem_tel() + "\t" + mv.getMem_addr());
		}
	}//End selectMemInfo()
	
	
//	//ȸ��ID�� ���� ȸ������ �˻�
//	public void selectMemInfoID(){	
//		while(true){
//			scan = new Scanner(System.in);
//			String memId ="";
//			int cnt = 0;			
//			do{
//				System.out.print("�˻��� ID �Է� >> ");
//				memId = scan.next();				
//				cnt = memService.getCountMember(memId);
//				if(cnt == 0){
//					System.out.println("�˻��� ȸ���� ������ �����ϴ�.");					
//				}
//			}while(cnt==0);
//			
//			List<MemberVO> memList = memService.getMemInfoId(memId);
//			System.out.println("---------------------------------------------------");		
//			System.out.println(" ID     �̸�      ��ȭ��ȣ    �ּ�");
//			System.out.println("---------------------------------------------------");	
//			for (MemberVO mv : memList) {
//				System.out.println(mv.getMem_id() + "\t" + mv.getMem_name() + "\t" + mv.getMem_tel() + "\t" + mv.getMem_addr());
//			}
//			break;
//		}
//	}//End selectMemInfoID()
//	
//	//ȸ���̸��� ���� ȸ������ �˻�
//	public void selectMemInfoName(){
//		while(true){
//			scan = new Scanner(System.in);
//			String memName ="";
//			int cnt = 0;
//			do{
//				System.out.print("�˻��� �̸� �Է� >> ");
//				memName = scan.next();
//				cnt = memService.getCountMemName(memName);
//				if(cnt == 0){
//					System.out.println("�˻��� ȸ���� ������ �����ϴ�.");					
//				}
//			}while(cnt==0);
//			
//			List<MemberVO> memList = memService.getMemInfoName(memName);
//			System.out.println("---------------------------------------------------");		
//			System.out.println(" ID     �̸�      ��ȭ��ȣ    �ּ�");
//			System.out.println("---------------------------------------------------");	
//			for (MemberVO mv : memList) {
//				System.out.println(mv.getMem_id() + "\t" + mv.getMem_name() + "\t" + mv.getMem_tel() + "\t" + mv.getMem_addr());
//			}
//			break;
//		}		
//	}//End selectMemInfoName()
//	
//	
//	public void selectMemInfoTel(){
//		while(true){
//			scan = new Scanner(System.in);
//			String memTel ="";
//			int cnt = 0;
//			do{
//				System.out.print("�˻��� ��ȭ��ȣ �Է� >> ");
//				memTel = scan.next();
//				cnt = memService.getCountMemTel(memTel);
//				if(cnt == 0){
//					System.out.println("�˻��� ȸ���� ������ �����ϴ�.");					
//				}
//			}while(cnt==0);
//			
//			List<MemberVO> memList = memService.getMemInfoTel(memTel);
//			System.out.println("---------------------------------------------------");		
//			System.out.println(" ID     �̸�      ��ȭ��ȣ    �ּ�");
//			System.out.println("---------------------------------------------------");	
//			for (MemberVO mv : memList) {
//				System.out.println(mv.getMem_id() + "\t" + mv.getMem_name() + "\t" + mv.getMem_tel() + "\t" + mv.getMem_addr());
//			}
//			break;
//		}
//	}	
//	
//	
//	public void selectMemInfoAddr(){
//		while(true){
//			scan = new Scanner(System.in);
//			String memAddr ="";
//			int cnt = 0;
//			do{
//				System.out.print("�˻��� �ּ� �Է� >> ");
//				memAddr = scan.nextLine();
//				cnt = memService.getCountMemAddr(memAddr);
//				if(cnt == 0){
//					System.out.println("�˻��� ȸ���� ������ �����ϴ�.");	
//				}
//			}while(cnt==0);
//			
//			List<MemberVO> memList = memService.getMemInfoAddr(memAddr);
//			System.out.println("---------------------------------------------------");		
//			System.out.println(" ID     �̸�      ��ȭ��ȣ    �ּ�");
//			System.out.println("---------------------------------------------------");	
//			for (MemberVO mv : memList) {
//				System.out.println(mv.getMem_id() + "\t" + mv.getMem_name() + "\t" + mv.getMem_tel() + "\t" + mv.getMem_addr());
//			}
//			break;
//		}
//	}
	

	
}
