package test_object;

class ProductMatrix {
	@SuppressWarnings("null")
	public int[][] productMatrix(int[][] A, int[][] B) {
		int[][] answer = null;
		
		for(int i = 0; i < answer.length; i++){
			for(int j = 0; j < answer[i].length; j++){
				answer[i][j] = A[i][j]*B[i][j] + A[j][i]*B[j][i];
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		ProductMatrix c = new ProductMatrix();
		int[][] a = { { 1, 2 }, { 2, 3 } };
		int[][] b = { { 3, 4 }, { 5, 6 } };
      // 아래는 테스트로 출력해 보기 위한 코드입니다.
      System.out.println("행렬의 곱셈 : " + c.productMatrix(a, b));
	}
}

//
//a b   1 2  5 6
//c d   3 4  7 8
//
// a 1* 5 + 2 *7
// b 1* 6 + 2 *8