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
		//ibatis를 이용하여 DB자료를 처리하는 작업 순서
		
		try {
			//1. ibatis의 환경설정 파일을 읽어와 실행시킨다.
			//(SqlMapConfig.xml파일)
			
			//1-1. xml문서 읽어오기
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			
			//1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 ibatis객체(SqlMapClient객체)를 생성한다.
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();//Reader객체닫기
			
			//2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
			
			//2-1. insert작업연습
//			System.out.println("insert작업 시작...");
//			
//			// 1) 저장할 테이터를 VO객체에 담는다.
//			MemberVO mvo = new MemberVO();
//			mvo.setMem_id("d001");
//			mvo.setMem_name("강감찬");
//			mvo.setMem_tel("010-1234-1234");
//			mvo.setMem_addr("대전시 서구 월평동");
//			
//			// 2) SqlMapClient객체 변수를 이용하여 해당 쿼리문을 호출해 실행한다.
//			// 형식) smc.insert("namespace값.id값", 파라미터클래스)
//			// ==> 반환값 : 작업성공하면 null이 반환된다.
//			Object obj = smc.insert("memberTest.insertMember", mvo);
//			if(obj == null){
//				System.out.println("Insert작업 성공");
//			}else {
//				System.out.println("Insert작업 실패");
//			}
			
			System.out.println("===========================================");
			
//			//2-2 update작업 연습
//			System.out.println("update작업 시작...");
//			
//			//update할 데이터 셋팅
//			MemberVO mvo2 = new MemberVO();
//			mvo2.setMem_id("d001");
//			mvo2.setMem_name("홍수환");
//			mvo2.setMem_tel("010-9999-9999");
//			mvo2.setMem_addr("대전시 유성구 봉명동");
//			
//			//update()메서드를 이용하여 실행한다.
//			//반환값 : 성공한 레코드 수
//			int cnt = smc.update("memberTest.updateMember", mvo2);
//			if(cnt>0){
//				System.out.println("Update작업 성공");
//			}else{
//				System.out.println("Update작업 실패");
//			}
			
			System.out.println("===========================================");
			
			//2-3 delete작업 연습
//			System.out.println("Delete작업 시작...");			
//			
//			int cnt = smc.delete("memberTest.deleteMember", "d001");
//			if(cnt>0){
//				System.out.println("Delete작업 성공");
//			}else {
//				System.out.println("Delete작업 실패");
//			}
			
			System.out.println("===========================================");
			
			//2-4 select작업 연습
			
//			//1) select한 결과가 여러개의 레코드일 경우
//			//queryForList()메서드를 이용한다.
//			//반환값이 List가 된다.
//			System.out.println("select 연습 (결과가 여러개일 경우)...");
//			List<MemberVO> memList = smc.queryForList("memberTest.getAllMember");
//			
//			for (MemberVO mv : memList) {
//				System.out.println("ID : " + mv.getMem_id());
//				System.out.println("이름 : " + mv.getMem_name());
//				System.out.println("전화번호 : " + mv.getMem_tel());
//				System.out.println("주소 : " + mv.getMem_addr());
//			}
//			System.out.println("출력 끝...");
			
			//2)select한 결과가 1개의 레코드일 경우
			//queryForObject()메서드를 이용한다.
			//반환값 : resultClass에 지정한 객체
			System.out.println("select 연습 시작(결과가 1개일 경우)...");
			
			MemberVO mv2 = (MemberVO) smc.queryForObject("memberTest.getMember", "d001");
			
			System.out.println("ID : " + mv2.getMem_id());
			System.out.println("이름 : " + mv2.getMem_name());
			System.out.println("전화번호 : " + mv2.getMem_tel());
			System.out.println("주소 : " + mv2.getMem_addr());
			
			System.out.println("출력 끝...");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
