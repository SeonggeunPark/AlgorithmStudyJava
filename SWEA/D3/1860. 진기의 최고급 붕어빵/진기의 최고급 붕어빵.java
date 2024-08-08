import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		out :
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] customers = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				customers[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(customers);

			int newFish = 0;
			int remainFish = 0;
			int givenTime = 0;
			
			if (customers[0]<M) {
				System.out.printf("#%d %s\n", t, "Impossible");
				continue out;
			}
			remainFish = customers[0] / M * K - 1 ;
			givenTime = customers[0] % M;
			
			for (int i = 1; i < N; i++) {
				// 누적 시간
				givenTime = givenTime + customers[i] - customers[i - 1];
				// 그 시간까지 만들 수 있는 붕어빵 수
				newFish = givenTime / M * K;
				// 누적 붕어빵 수에 더하기
				remainFish = remainFish + newFish;
				// 누적 시간 빼기
				givenTime = givenTime % M;
				// 남은붕어빵 없으면 종료
				if (remainFish < 1) {
					System.out.printf("#%d %s\n", t, "Impossible");
					continue out;
				}
				// 붕어빵 서빙
				remainFish--;
			}
			
			System.out.printf("#%d %s\n", t, "Possible");
		}
	}
}
