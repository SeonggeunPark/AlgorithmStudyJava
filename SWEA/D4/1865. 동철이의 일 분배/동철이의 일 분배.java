import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * N명이 N개의 일을 각각 성공할 확률이 모두 다르므로 N*N 배열 생성
 * 1부터 N까지 나열하는 가능한 모든 순열 조합을 구한 후 해당하는 확률을 곱하여
 * 최종 확률을 구함. 그 중 최대값을 찾아 출력
 * 
 * 1. 순열 조합으로 작서앟였으나 실행시간 초과되어 순열 배열을 생성하는 과정을 생략한 재귀함수를 사용
 * 2. 재귀함수도 실행시간 초과되었으나, 재귀 과정에서 max의 확률보다 같거나 작으면 더이상 연산이 필요 없음을
 * 	  발견하여 해당 부분을 가지치기하여 해결함
 */
public class Solution {
	static int[][] workChance;
	static int N;
	static int[] order;
	static double max;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			// 중복된 경우의 수를 막기 위한 방문 배열 생성
			visited = new boolean[N];
			// N*N 배열 생성하여 각각 확률 입력
			workChance = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					workChance[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 최대값 초기화
			max = 0;
			// 순열 생성 및 확률 계산 메서드 호출
			makeOrder(0, 1);
			// 출력
			System.out.printf("#%d %6f\n", t, max*100 );
		}
	}

	// 순열 만드는 메서드
	static void makeOrder(int k, double chance) {
		// 지금까지 구한 확률이 max보다 작으면 
		// 나머지가 다 100%여도 max를 넘을 수 없으므로 종료
		if (chance<=max) return;
		// 마지막 직원까지 모두 일 맡으면 최종 확률 계산
		if (k >= N) {
			max = chance;
			return;
		}
		
		double beforeChance = chance;
		// 재귀를 통해 순열을 생성
		// i번 직원이 1번 일 할 때, 2번 일 할 떄 .... N번 일 할 때
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				chance *= (double)workChance[k][i] / 100;
				visited[i] = true;
				makeOrder(k+1, chance);
				chance = beforeChance;
				visited[i] = false;
			}
		}
	}

}
