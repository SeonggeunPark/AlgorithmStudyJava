import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 필요한 기타줄 개수
		int M = Integer.parseInt(st.nextToken()); // 브랜드 수

		int minPackage = Integer.MAX_VALUE;
		int minOne = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int six = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());

			minPackage = Math.min(minPackage, six);
			minOne = Math.min(minOne, one);
		}

		// 세 가지 경우 비교
		int cost1 = (N / 6) * minPackage + (N % 6) * minOne;           // 패키지 + 낱개 혼합
		int cost2 = ((N + 5) / 6) * minPackage;                        // 패키지만 사용 (남는 낱개 포함)
		int cost3 = N * minOne;                                       // 전부 낱개로

		int answer = Math.min(cost1, Math.min(cost2, cost3));
		System.out.println(answer);
	}
}
