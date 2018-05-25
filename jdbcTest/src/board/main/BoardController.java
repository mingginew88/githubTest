package board.main;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import board.service.BoardService;
import board.service.IBoardService;
import board.vo.BoardVO;

public class BoardController {
	private IBoardService boardService;
	private Scanner sc;	
	
	public BoardController() {
		boardService = new BoardService();
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new BoardController().start();
	}	
	
	public void start(){		
		while(true){
			sc = new Scanner(System.in);
			List<BoardVO> boardList = boardService.boardList();
			
			System.out.println("�ܼ� �Խ��� ����Ʈ");
			System.out.println("=============================================");
			System.out.println("��ȣ      ����      �ۼ���           ��¥");
			System.out.println("=============================================");
			for (BoardVO bv : boardList) {
				System.out.println(bv.getBoard_no() + "\t" + bv.getBoard_title() + "\t" + bv.getBoard_writer() + "\t" + bv.getBoard_data());
			}		
			System.out.println("=============================================");
			
			System.out.println("1. �󼼺��� 2. ���۾��� 3. �Խñ� ���� 4. �Խñ� ����");
			
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			
			switch (input) {
			case 1:
				showDetailBoard();
				break;
			case 2: 
				writeNewBoard();
				break;
			case 3:
				updateBoard();
				break;
			case 4:
				deleteBoard();
				break;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
		}
	}
	
	
	public void showDetailBoard(){
		sc = new Scanner(System.in);
		List<BoardVO> boardList = boardService.boardList();
		
		System.out.println("�ܼ� �Խ��� ����Ʈ");
		System.out.println("=============================================");
		System.out.println(" ��ȣ                ����                 �ۼ���              ��¥");
		System.out.println("=============================================");
		for (BoardVO bv : boardList) {
			System.out.println(bv.getBoard_no() + "\t" + bv.getBoard_title() + "\t" + bv.getBoard_writer() + "\t" + bv.getBoard_data());
		}		
		System.out.println("=============================================");
		
		int board_no = 0;
		int cnt = 0;
		try {
			board_no = sc.nextInt();
			cnt = boardService.countBoard(board_no);
			
			if(cnt == 0){
				System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ��Է����ּ���.");
			}						
		} catch (InputMismatchException e) {
			System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ��Է����ּ���.");
		}		
		
		List<BoardVO> boardListNo = boardService.showDetailBoard(board_no);
		
		System.out.println("�Խ��� �� ���� ����");
		System.out.println("=============================================");
		for (BoardVO bv : boardListNo) {
			System.out.println("��   ȣ : " + board_no);
			System.out.print("��   �� : " + bv.getBoard_title());	
			System.out.println("\t �۾��� : " + bv.getBoard_writer());			
			System.out.println("��   �� : -------------------------------------");
			System.out.println(bv.getBoard_content());
			System.out.println("---------------------------------------------");
			System.out.println(bv.getBoard_data());
		}
		System.out.println("=============================================");		
	}
	
	public void writeNewBoard(){		
		sc = new Scanner(System.in);
		
		System.out.println("���۾���");
		System.out.println("=============================================");
		System.out.print("��  �� : ");		
		String board_title = sc.nextLine();	
		System.out.print("�ۼ��� : ");
		String board_writer = sc.next();					
		System.out.print("��  �� : ");
		sc.nextLine();
		String board_content = sc.nextLine();
		Map<String, String> boardMap = new HashMap<String, String>();
		boardMap.put("board_title", board_title);
		boardMap.put("board_writer", board_writer);
		boardMap.put("board_content", board_content);
		boolean result = boardService.writeNewBoard(boardMap);
		System.out.println("=============================================");
		if(result){
			System.out.println("������ ��ϵǾ����ϴ�.");			
		}else{
			System.out.println("���� ��� ����");
		}
	
	}
	
	public void updateBoard(){
		while(true){
			sc = new Scanner(System.in);			
			System.out.println("�Խñ� ���� �۾�");
			System.out.println("=============================================");
			System.out.print("������ �Խñ� ��ȣ �Է� >> ");
			Map<Object, Object> boardMap = new HashMap<Object, Object>();
			
			int board_no = 0;
			int cnt = 0;
			try {
				board_no = sc.nextInt();
				cnt = boardService.countBoard(board_no);
				if(cnt==0){
					System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				}
			} catch (InputMismatchException e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			boardMap.put("board_no", board_no);
			
			System.out.println("1. ������ 2. �۳���");
			int input2 = 0;
			try {
				input2 = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
			String board_title;
			String board_content;
			boolean result = false;
			
			if(input2 == 1){
				System.out.print("������ �������� �Է����ּ���. >> ");
				sc.nextLine();
				board_title = sc.nextLine();
				boardMap.put("board_title",board_title);
				result = boardService.updateBoard(boardMap, 1);
				
			}else if(input2 ==2){
				System.out.println("������ �۳����� �Է����ּ���. >>");
				sc.nextLine();
				board_content =sc.nextLine();
				boardMap.put("board_content", board_content);
				result = boardService.updateBoard(boardMap, 2);				
			}
			
			if(result){
				System.out.println("�� ������ �����Ͽ����ϴ�.");
			}else {
				System.out.println("�� ���� ����");
			}			
			break;
		}	
	}	
	
	public void deleteBoard(){
		while(true){
			sc = new Scanner(System.in);
			System.out.println("�Խñ� ���� �۾�");
			System.out.println("=============================================");
			System.out.println("������ �Խñ� ��ȣ �Է� >> ");
			int board_no = 0;
			int cnt = 0;
			try {
				board_no = sc.nextInt();
				cnt = boardService.countBoard(board_no);
				if(cnt==0){
					System.out.println("������ �Խñ��� �����ϴ�.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ��Է����ּ���.");
				continue;
			}
			boolean result = boardService.deleteBoard(board_no);
			if(result){
				System.out.println("���� ����");
			}else{
				System.out.println("���� ����");
			}
			System.out.println("=============================================");		
			break;
		}	
	}
}
