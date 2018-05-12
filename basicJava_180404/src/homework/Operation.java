package homework;

class Operation {	
		
		int add(int num1, int num2) {
			int result = num1 + num2;		
			return result;		
		}
		
		int subtract(int num1, int num2) {
			int result = num1 - num2;
			return result;
		}
		
		long multiply(int num1, int num2) {
			long result = num1 * num2;
			return result;
		}
		
		float divide(int num1, int num2) {
			float result =(int)(100f*num1/num2 + 0.5)/100f;
			if(num2 == 0) {
				return 0;
			}
			return result;
		}
		
		int remainder(int num1, int num2) {
			int result = num1%num2;
			return result;
		}
		
		
		
}
