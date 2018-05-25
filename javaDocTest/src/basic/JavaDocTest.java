package basic;


/**
 * 
 * @author PC17
 * @version 1.0
 * <p>이 영역안에 설명글을 작성하는데 HTML태그를 사용하여 작성할 수 있다.<br><br>
 * 파일명 : JavaDocTest.java<br>
 * 설  명 : JavaDoc문서를 작성하기 위한 연습용 Inerface<br><br>
 * </p> 
 *
 */
public interface JavaDocTest {
	
	/**
	 * 메서드명 : methodTest
	 * 설    명 : 반환값이 없는 메서드
	 * @param a 첫번째 매개변수 (정수형)
	 * @param b 두번째 매개변수 (정수형)
	 */
	public void methodTest(int a, int b);
	
	
	/**
	 * 메서드명 : methodAdd
	 * 설    명 : 2개의 파라미터의 덧셈 결과를 반환한다.
	 * @param x 첫번째 정수형 변수
	 * @param y 두번째 정수형 변수
	 * @return 처리된 결과를 정수형으로 반환한다.
	 */
	public int methodAdd(int x, int y);
	
	
	/**
	 * 메서드명 : methodSub
	 * 설    명 : 매개변수는 없고 정수형 반환값이 있는 메서드
	 * @return 정수형으로 반환된다.
	 */
	public int methodSub();

}
