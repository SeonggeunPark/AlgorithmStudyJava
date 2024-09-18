import java.util.HashMap;
import java.util.Scanner;

/*
 * 동적프로그래밍 문제.
 * 물품의 무게와 가치를 저장하고
 * 1번째 물품을 고려했을 때 최적해부터 구한 후
 * 순차적으로 N번째 물품까지 모두 고려했을 때 최적해를 구해나가는 방식
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		// map 배열을 생성, 각 물품의 무게와 값 저장
		HashMap<String, Integer>[] goods = new HashMap[N+1];
		for (int i=1; i<=N; i++) {
			goods[i] = new HashMap<>();
			goods[i].put("W", sc.nextInt());
			goods[i].put("V", sc.nextInt());
		}
		
		// 최적해를 저장하기 위한 배열 생성
		int[][] dp = new int[N+1][K+1];
		
		//1번째 물건만 고려하는 경우부터 N번쨰 무게까지 모두 고려
		for (int i=1; i<=N; i++) {
			// 임시 무게 w가 1일 때부터 최대무게 K까지 각 무게별 최적해 구하기
			for (int w=1; w<=K; w++) {
				// 임시 무게가 현재 고려하려는 물건 무게보다 같거나 크면
				if (goods[i].get("W") <= w) {
					// 이전 물건 고려할 때 현재 무게의 최적해 vs 추가하지 않은 무게의 최적해에서 현재 가치를 더한 것
					dp[i][w] = Math.max(dp[i-1][w-goods[i].get("W")]+goods[i].get("V"), dp[i-1][w]);
				}
				// 임시 무게가 현재 고려하려는 물건 무게보다 작으면
				else {
					dp[i][w] = dp[i-1][w];	// 이전 물건 고려할 때의 최적해가 현재 최적해
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
