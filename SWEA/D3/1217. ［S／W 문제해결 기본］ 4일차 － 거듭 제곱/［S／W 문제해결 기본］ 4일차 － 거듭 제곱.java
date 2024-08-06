import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t=1; t<=10; t++) {
			int T = sc.nextInt();
			int base = sc.nextInt();
			int exponent = sc.nextInt();
			
			System.out.println("#" + t + " " + power(base, exponent));
			
		}
	}
	
	static int power(int b, int e) {
		if (e == 1) return b;
			
		return b * power(b, e-1);
	}
}
