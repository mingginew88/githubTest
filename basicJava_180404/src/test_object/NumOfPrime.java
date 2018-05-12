package test_object;

import java.util.Vector;

class NumOfPrime {
	int numberOfPrime(int n) {
		int result = 0;			
		
		while(n > 1){
			for(int i =2; i <= n; i++ ){
				if(n%i == 0){
					break;
				}else{
					result += 1;
				}
			}			
			n--;
		}
		return result;
	}

	public static void main(String[] args) {
		NumOfPrime prime = new NumOfPrime();
		System.out.println( prime.numberOfPrime(10));
	}

}