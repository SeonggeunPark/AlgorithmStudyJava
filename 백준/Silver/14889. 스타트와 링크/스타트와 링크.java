import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] S;
	static int[] start, link;
	static int[] tmp;
	static int sAbility, lAbility;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		init();   // 변수 선언 및 초기화 메서드
		
		combination1(0, 0, 0); // 모든 맵을 탐색하며 넓이와 개수 계산
		
		print(min); // 출력 메서드
	}
	// 변수 선언 및 초기화 메서드
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 인원 수
		
		S = new int[N][N];	// 팀 능력치 배열
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				S[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		start = new int[N/2];
		link = new int[N/2];
		tmp = new int[2];
	}
	// 팀을 나누는 모든 경우의 수를 조합으로 구하는 재귀 메서드
	private static void combination1(int sidx, int lidx, int idx) {
		// start팀 인원 다 찼을 때
		if (sidx >= N/2) {
			// 남은 인원은 link 팀으로!
			for (int i=idx; i<N; i++) {
				link[lidx++] = i;
			}
			min = Math.min(min, caldiff(start, link));
//			System.out.println(Arrays.toString(start));
//			System.out.println(Arrays.toString(link));
//			System.out.println("///////////////////");
			return;
		}
		if (lidx >= N/2) return;
		// link 팀 인원 다 찼을 때
//		if (lidx >= N/2) {
//			// 남은 인원은 start 팀으로!
//			for (int i=idx; i<=N; i++) {
//				start[sidx++] = i;
//			}
//			System.out.println(Arrays.toString(start));
//			System.out.println(Arrays.toString(link));
//			System.out.println("///////////////////");
//			min = Math.min(min, calScore(start, link));
//			return;
//		}

		// start 팀에 배정한다
		start[sidx] = idx;
		combination1(sidx+1, lidx, idx+1);
		// link 팀에 배정한다
		link[lidx] = idx;
		combination1(sidx, lidx+1, idx+1);
	}
	// 두 팀의 능력치 차이를 구하는 메서드
	private static int caldiff(int[] start, int[] link) {
		sAbility = 0;
		lAbility = 0;
		combinationStart(0, 0);
		combinationLink(0, 0);
		return Math.abs(sAbility - lAbility);
	}
	
	private static void combinationStart(int idx, int pick) {
		if (pick >= 2) {
			sAbility += S[tmp[0]][tmp[1]];
			sAbility += S[tmp[1]][tmp[0]];
			return;
		}
		
		if (idx >= N/2) return;
		
		tmp[pick] = start[idx];
		combinationStart(idx+1, pick+1);
		
		combinationStart(idx+1, pick);
	}
	private static void combinationLink(int idx, int pick) {
		if (pick >= 2) {
			lAbility += S[tmp[0]][tmp[1]];
			lAbility += S[tmp[1]][tmp[0]];
			return;
		}
		
		if (idx >= N/2) return;
		
		tmp[pick] = link[idx];
		combinationLink(idx+1, pick+1);
		
		combinationLink(idx+1, pick);
	}
	
	// 출력 메서드
	private static void print(int min) {
		System.out.println(min);
	}
}
