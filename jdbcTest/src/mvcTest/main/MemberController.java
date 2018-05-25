package mvcTest.main;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import mvcTest.service.IMemberService;
import mvcTest.service.MemberService;
import mvcTest.vo.MemberVO;


/*
기존의 메뉴에 '5.자료검색'메뉴를 추가한다.
이 '자료검색'메뉴를 선택하면 아래와 같은 부메뉴가 출력된다.

검색할 메뉴를 선택하세요.
1. ID검색     2. 이름검색     3.전화번호     4. 주소검색
검색 선택 >>

검색할 ID 입력 >>

위의 메뉴에서 선택된 검색을 진행하는 프로그램을 완성하시오.
('ID'와 '이름',  '전화번호'는 정확히 일치하는 정보가 검색되도록 하고 '주소'는 일부분만 입력해도 검색되도록한다.)
 */

public class MemberController {	
	private Scanner scan;
	private IMemberService memService;	//Service객체를 저장할 변수선언
	
	//생성자에서 Service객체를 생성한다.
	public MemberController(){
		scan = new Scanner(System.in);
		memService = MemberService.getInstance();
	}
	
	public static void main(String[] args) {
		new MemberController().startMember();
	}
	
	
	public int displayMenu(){
		System.out.println("===== 작업 선택 =====");
		System.out.println("-------------------");
		System.out.println("1. 자료입력");
		System.out.println("2. 자료삭제");
		System.out.println("3. 자료수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 자료 검색");
		System.out.println("0. 작업 끝");
		System.out.println("-------------------");
		System.out.println(" 작업선택 >>");
		int choice  = scan.nextInt();
		
		return choice;
	}
	
	//작업을 시작하는 메서드
	public void startMember(){
		int choice;
		do{
			choice = displayMenu();
			switch(choice){
			case 1: //자료입력
				insertMember();
				break;
			case 2: //자료삭제
				deleteMember();
				break;
			case 3: //자료수정
				updateMember();
				break;
			case 4: //전체자료 출력
				displayAllMember();
				break;
			case 5:	//자료검색
				selectMemInfo();
				break;
			case 0:
				System.out.println("작업을 마칩니다.");
				break;
			default :
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
			}
		}while(choice!=0);
	}//End startMember()
	
	
	//전체회원정보를 출력하는 메서드
	public void displayAllMember(){		
		List<MemberVO> memList = memService.getAllMember();
		
		int size=0;
		if(memList!=null){
			size = memList.size();
		}
		System.out.println("총회원 수 : " + size + "명");
		System.out.println("---------------------------------------------------");		
		System.out.println(" ID     이름      전화번호    주소");
		System.out.println("---------------------------------------------------");	
		if(memList==null||size==0){
			System.out.println("출력할 회원이 없습니다.");
		}else{
			for (MemberVO mv : memList) {
				System.out.println(mv.getMem_id() + "\t" + mv.getMem_name() + "\t" + mv.getMem_tel() + "\t" + mv.getMem_addr());
			}			
		}
		System.out.println("---------------------------------------------------");
		System.out.println("자료 출력 완료...");
	}
	
	
	//회원정보를 수정하는 메서드
	public void updateMember(){		
		System.out.println();
		System.out.print("수정할 회원ID 입력 >> ");
		String memId = scan.next();
		
		int cnt = memService.getCountMember(memId);
		if(cnt==0){
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			return;
		}
		
		System.out.print("새로운 회원이름 >> ");
		String memName = scan.next();
		
		System.out.print("새로운 회원전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine();
		System.out.print("새로운 회원주소 >> ");
		String memAddr = scan.nextLine();		
		
		//입력받은 자료를 MemberVO객체에 셋팅한다.
		MemberVO mv = new MemberVO();
		mv.setMem_id(memId);
		mv.setMem_name(memName);
		mv.setMem_tel(memTel);
		mv.setMem_addr(memAddr);
		
		cnt = memService.updateMember(mv);
		
		if(cnt > 0){
			System.out.println(memId + "님의 회원의 정보를 수정했습니다.");
		}else{
			System.out.println("수정 작업 실패");
		}
	}
	
	
	//회원정보를 삭제하는 메서드
	public void deleteMember(){		
		System.out.println();
		System.out.println("삭제할 회원ID 입력 >> ");
		String memId = scan.next();
		
		int cnt = memService.getCountMember(memId);
		if(cnt==0){
			System.out.println(memId + "은(는) 없는 회원ID입니다." );
			return;
		}
		cnt = memService.deleteMember(memId);
		
		if(cnt>0){
			System.out.println(memId + "님의 회원정보삭제 성공");
		}else{
			System.out.println("삭제 작업 실패");
		}
	}
	
	
	//회원정보를 추가(입력)하는 메서드
	public void insertMember(){		
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		int cnt = 0;
		String memId = "";
		//회원ID를 입력받아 중복되는지 여부를 검사한다.
		do{
			System.out.println("회원ID >> ");
			memId = scan.next();
			cnt = memService.getCountMember(memId);
			if(cnt > 0){
				System.out.println(memId + "는 이미 등록된 회원ID입니다.");
				System.out.println("다시 입력하세요.");
			}
		}while(cnt > 0);
		
		System.out.print("회원이름 >> ");
		String memName = scan.next();
		
		System.out.print("회원전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine();	//입력버퍼 지우기
		System.out.print("회원주소 >> ");
		String memAddr = scan.nextLine();	
		
		//입력받은 자료들을 MemberVO객체에 셋팅한다.
		MemberVO mv = new MemberVO();
		mv.setMem_id(memId);
		mv.setMem_name(memName);
		mv.setMem_tel(memTel);
		mv.setMem_addr(memAddr);
		
		//insert작업을 수행하는 Service의 메서드 호출
		cnt = memService.insertMember(mv);
		
		if(cnt>0){
			System.out.println(memId + "님의 회원 정보 insert 성공");
		} else {
			System.out.println("insert 작업 실패");
		}		
	}
	
	
	public void selectMemInfo(){		
		int input = 0;
		String field = "";
		String data = "";
		
		do{
			scan = new Scanner(System.in);
			System.out.println("검색할 메뉴를 선택하세요.");
			System.out.println("1. ID검색     2. 이름검색     3.전화번호     4. 주소검색   5. 뒤로가기");
			System.out.print("검색 선택 >>");			
			input = scan.nextInt();			
			switch(input){			
				case 1:		//ID검색	
					field = "mem_id";
					System.out.println("검색할 ID 입력 >> ");
					data = scan.next();
					break;
				case 2:		//이름검색
					field = "mem_name";
					System.out.println("검색할 이름 입력 >> ");
					data = scan.next();
					break;
				case 3:		//전화번호
					field = "mem_tel";
					System.out.println("검색할 전화번호 입력 >> ");
					data = scan.next();
					break;
				case 4:		//주소검색
					field = "mem_addr";
					System.out.println("검색할 주소 입력 >> ");
					scan.nextLine();
					data = scan.nextLine();
					break;
				case 5:		//뒤로가기
					return;
				default:
					System.out.println("잘못입력하였습니다. 다시 입력해주세요.");
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
		System.out.println("검색된 회원 수 : " + size + "명");
		System.out.println("---------------------------------------------------");		
		System.out.println(" ID     이름      전화번호    주소");
		System.out.println("---------------------------------------------------");	
		for (MemberVO mv : memList) {
			System.out.println(mv.getMem_id() + "\t" + mv.getMem_name() + "\t" + mv.getMem_tel() + "\t" + mv.getMem_addr());
		}
	}//End selectMemInfo()
	
	
//	//회원ID를 통해 회원정보 검색
//	public void selectMemInfoID(){	
//		while(true){
//			scan = new Scanner(System.in);
//			String memId ="";
//			int cnt = 0;			
//			do{
//				System.out.print("검색할 ID 입력 >> ");
//				memId = scan.next();				
//				cnt = memService.getCountMember(memId);
//				if(cnt == 0){
//					System.out.println("검색한 회원의 정보가 없습니다.");					
//				}
//			}while(cnt==0);
//			
//			List<MemberVO> memList = memService.getMemInfoId(memId);
//			System.out.println("---------------------------------------------------");		
//			System.out.println(" ID     이름      전화번호    주소");
//			System.out.println("---------------------------------------------------");	
//			for (MemberVO mv : memList) {
//				System.out.println(mv.getMem_id() + "\t" + mv.getMem_name() + "\t" + mv.getMem_tel() + "\t" + mv.getMem_addr());
//			}
//			break;
//		}
//	}//End selectMemInfoID()
//	
//	//회원이름을 통해 회원정보 검색
//	public void selectMemInfoName(){
//		while(true){
//			scan = new Scanner(System.in);
//			String memName ="";
//			int cnt = 0;
//			do{
//				System.out.print("검색할 이름 입력 >> ");
//				memName = scan.next();
//				cnt = memService.getCountMemName(memName);
//				if(cnt == 0){
//					System.out.println("검색한 회원의 정보가 없습니다.");					
//				}
//			}while(cnt==0);
//			
//			List<MemberVO> memList = memService.getMemInfoName(memName);
//			System.out.println("---------------------------------------------------");		
//			System.out.println(" ID     이름      전화번호    주소");
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
//				System.out.print("검색할 전화번호 입력 >> ");
//				memTel = scan.next();
//				cnt = memService.getCountMemTel(memTel);
//				if(cnt == 0){
//					System.out.println("검색한 회원의 정보가 없습니다.");					
//				}
//			}while(cnt==0);
//			
//			List<MemberVO> memList = memService.getMemInfoTel(memTel);
//			System.out.println("---------------------------------------------------");		
//			System.out.println(" ID     이름      전화번호    주소");
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
//				System.out.print("검색할 주소 입력 >> ");
//				memAddr = scan.nextLine();
//				cnt = memService.getCountMemAddr(memAddr);
//				if(cnt == 0){
//					System.out.println("검색한 회원의 정보가 없습니다.");	
//				}
//			}while(cnt==0);
//			
//			List<MemberVO> memList = memService.getMemInfoAddr(memAddr);
//			System.out.println("---------------------------------------------------");		
//			System.out.println(" ID     이름      전화번호    주소");
//			System.out.println("---------------------------------------------------");	
//			for (MemberVO mv : memList) {
//				System.out.println(mv.getMem_id() + "\t" + mv.getMem_name() + "\t" + mv.getMem_tel() + "\t" + mv.getMem_addr());
//			}
//			break;
//		}
//	}
	

	
}
