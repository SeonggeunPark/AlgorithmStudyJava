import java.util.Scanner;

public class Main {
	static boolean[][] map;
	static int N;
	static int br, bc, fr, fc;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 좌표가 1,1부터 시작하므로 배열 크기 N+1로 생성
		map = new boolean[N+1][N+1];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (sc.nextInt() == 1) {
					map[i][j] = true;
				}
			}
		}
		// 시작위치 설정
		fr = br = bc = 1;
		fc = 2;
		cnt = 0;
		dfs(fr, fc, br, bc);
		
		System.out.println(cnt);
	}
	
	static void dfs(int fr, int fc, int br, int bc) {
		
		if(fr == N && fc == N) {
			cnt++;
			return;
		}
		
		// 가로일 때
		if (fr==br && fc-bc==1) {
			// 오른쪽 이동
			// 범위체크
			if (fc+1 <= N && !map[fr][fc+1]) {
				dfs(fr, fc+1, br, bc+1);
			}
			// 대각 이동
			if (fc+1 <= N && fr+1<= N && !map[fr][fc+1] && !map[fr+1][fc+1] && !map[fr+1][fc]) {
				dfs(fr+1, fc+1, br, bc+1);
			}
		  // 세로일 때
		} else if(fc == bc && fr-br==1) {
			// 아래 이동
			if (fr+1 <= N && !map[fr+1][fc]) {
				dfs(fr+1, fc, br+1, bc);
			}
			// 대각 이동
			if (fr+1 <= N && fc+1 <=N && !map[fr+1][fc] && !map[fr+1][fc+1] && !map[fr][fc+1]) {
				dfs(fr+1, fc+1, br+1, bc);
			}
			// 대각일 때
		} else {
			// 오른쪽 이동
			if (fc+1 <= N && !map[fr][fc+1]) {
				dfs(fr, fc+1, br+1, bc+1);
			}
			// 아래 이동
			if (fr+1<=N && !map[fr+1][fc]) {
				dfs(fr+1, fc, br+1, bc+1);
			}
			// 대각 이동
			if (fc+1<=N && fr+1<=N && !map[fr][fc+1] && !map[fr+1][fc+1] && !map[fr+1][fc]) {
				dfs(fr+1, fc+1, br+1, bc+1);
			}
		}
		
	}
}
