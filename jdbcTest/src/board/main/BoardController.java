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
			
			System.out.println("콘솔 게시판 리스트");
			System.out.println("=============================================");
			System.out.println("번호      제목      작성자           날짜");
			System.out.println("=============================================");
			for (BoardVO bv : boardList) {
				System.out.println(bv.getBoard_no() + "\t" + bv.getBoard_title() + "\t" + bv.getBoard_writer() + "\t" + bv.getBoard_data());
			}		
			System.out.println("=============================================");
			
			System.out.println("1. 상세보기 2. 새글쓰기 3. 게시글 수정 4. 게시글 삭제");
			
			int input = 0;
			try {
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
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
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
		}
	}
	
	
	public void showDetailBoard(){
		sc = new Scanner(System.in);
		List<BoardVO> boardList = boardService.boardList();
		
		System.out.println("콘솔 게시판 리스트");
		System.out.println("=============================================");
		System.out.println(" 번호                제목                 작성자              날짜");
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
				System.out.println("잘못입력하였습니다. 다시입력해주세요.");
			}						
		} catch (InputMismatchException e) {
			System.out.println("잘못입력하였습니다. 다시입력해주세요.");
		}		
		
		List<BoardVO> boardListNo = boardService.showDetailBoard(board_no);
		
		System.out.println("게시판 상세 내용 보기");
		System.out.println("=============================================");
		for (BoardVO bv : boardListNo) {
			System.out.println("번   호 : " + board_no);
			System.out.print("제   목 : " + bv.getBoard_title());	
			System.out.println("\t 글쓴이 : " + bv.getBoard_writer());			
			System.out.println("내   용 : -------------------------------------");
			System.out.println(bv.getBoard_content());
			System.out.println("---------------------------------------------");
			System.out.println(bv.getBoard_data());
		}
		System.out.println("=============================================");		
	}
	
	public void writeNewBoard(){		
		sc = new Scanner(System.in);
		
		System.out.println("새글쓰기");
		System.out.println("=============================================");
		System.out.print("제  목 : ");		
		String board_title = sc.nextLine();	
		System.out.print("작성자 : ");
		String board_writer = sc.next();					
		System.out.print("내  용 : ");
		sc.nextLine();
		String board_content = sc.nextLine();
		Map<String, String> boardMap = new HashMap<String, String>();
		boardMap.put("board_title", board_title);
		boardMap.put("board_writer", board_writer);
		boardMap.put("board_content", board_content);
		boolean result = boardService.writeNewBoard(boardMap);
		System.out.println("=============================================");
		if(result){
			System.out.println("새글이 등록되었습니다.");			
		}else{
			System.out.println("새글 등록 실패");
		}
	
	}
	
	public void updateBoard(){
		while(true){
			sc = new Scanner(System.in);			
			System.out.println("게시글 수정 작업");
			System.out.println("=============================================");
			System.out.print("수정할 게시글 번호 입력 >> ");
			Map<Object, Object> boardMap = new HashMap<Object, Object>();
			
			int board_no = 0;
			int cnt = 0;
			try {
				board_no = sc.nextInt();
				cnt = boardService.countBoard(board_no);
				if(cnt==0){
					System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				continue;
			}
			boardMap.put("board_no", board_no);
			
			System.out.println("1. 글제목 2. 글내용");
			int input2 = 0;
			try {
				input2 = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
			String board_title;
			String board_content;
			boolean result = false;
			
			if(input2 == 1){
				System.out.print("변경할 글제목을 입력해주세요. >> ");
				sc.nextLine();
				board_title = sc.nextLine();
				boardMap.put("board_title",board_title);
				result = boardService.updateBoard(boardMap, 1);
				
			}else if(input2 ==2){
				System.out.println("변경할 글내용을 입력해주세요. >>");
				sc.nextLine();
				board_content =sc.nextLine();
				boardMap.put("board_content", board_content);
				result = boardService.updateBoard(boardMap, 2);				
			}
			
			if(result){
				System.out.println("글 수정에 성공하였습니다.");
			}else {
				System.out.println("글 수정 실패");
			}			
			break;
		}	
	}	
	
	public void deleteBoard(){
		while(true){
			sc = new Scanner(System.in);
			System.out.println("게시글 삭제 작업");
			System.out.println("=============================================");
			System.out.println("삭제할 게시글 번호 입력 >> ");
			int board_no = 0;
			int cnt = 0;
			try {
				board_no = sc.nextInt();
				cnt = boardService.countBoard(board_no);
				if(cnt==0){
					System.out.println("삭제할 게시글이 없습니다.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못입력하였습니다. 다시입력해주세요.");
				continue;
			}
			boolean result = boardService.deleteBoard(board_no);
			if(result){
				System.out.println("삭제 성공");
			}else{
				System.out.println("삭제 실패");
			}
			System.out.println("=============================================");		
			break;
		}	
	}
}
