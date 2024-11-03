import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();

		double day = 1;

		day = (double) (V - B) / (A - B);
		
		if (day%1 > 0) {
			System.out.println((int)day+1);
		} else {
			System.out.println((int)day);
		}
	}
}
