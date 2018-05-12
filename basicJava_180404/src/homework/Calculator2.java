package homework;

import java.util.Scanner;

public class Calculator2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		String y = sc.next();
		int z = sc.nextInt();
		
		Operation op = new Operation();
		int result = 0;
		
		if(y.equals("+")) {
			result = op.add(x, z);	
			System.out.println(result);
		}
		
		
		
		
		
		
	}

}
