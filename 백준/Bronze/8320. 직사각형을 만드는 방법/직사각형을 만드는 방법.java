import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0;
		// 1개일 때 : n / 1가지
		// 2개 : 2*2부터 2*3, 2*4, ... , 2*(n/2)가까지
		// x개 : x*x부터 x*(n.x)
		for (int i=1; i*i<=n; i++) {
			for (int j=i; j <= n/i; j++) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
