import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		int idx = 0 ;
		for (int i=1; i<=9; i++) {
			int n = sc.nextInt();
			if (max < n) {
				max = n;
				idx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(idx);
	}
}
