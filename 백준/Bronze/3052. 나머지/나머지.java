import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        // 배열을 -1로 초기화 하지 않으면 값이 0으로 자동 초기화됨.
        // 그렇게 될 경우 나머지가 0인 상황에서 중복되는 값으로 인식되어
        // 카운트되지 않는 오류가 발생.
		int[] arr = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		int cnt = 0;
		
		out: for (int i=0; i<10; i++) {
			int n = sc.nextInt() % 42;
			
			for (int j=0; j<=i-1; j++) {
				if (arr[j] == n) {
					continue out;
				}
			}
			arr[i] = n;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
