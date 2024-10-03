import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 0행부터 N-1행까지 순차적으로 재귀함수를 통해 채워 나가는 방식
 * 열 중복을 제외하기 위해 cVisited배열을 만들어 관리
 * 대각선 겹치는 것을 확인하기 위해 1차원 배열(pos) 생성하여 각 행에
 * 퀸이 위치한 열 번호를 저장 및 확인 
 */

public class Main {
	static int[][] board;
	static int cnt;
	static int N;
	static boolean[] cVisited;	// 열 방문체크
	// 각 행에 퀸이 위치한 열 번호 저장
	// ex) pos[0] = 2 >> 0행 2열에 퀸 배치
	static int[] pos;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


			N = Integer.parseInt(br.readLine());
			
			cnt = 0;
			board = new int[N][N]; // 체스판 초기화
			cVisited = new boolean[N];	// 열 방문체크 배열 초기화
			pos = new int[N];	// 행별 퀸 위치 체크
			
			for (int c=0; c<N; c++) {
				// 0행 c열에 퀸 배치
				pos[0] = c;
				// c열 방문 체크
				cVisited[c] = true;
				// 1행부터 재귀 작업
				dfs(1);
				// 재귀 후 c열 방문 체크 해제
				cVisited[c] = false;
			}
			System.out.println(cnt);
	}
	// 행 내려가면서 배치
	static void dfs(int r) {
		// 기저조건
		// r이 N까지 모두 배치되었으므로 경우의수 cnt +1 추가
		if (r >= N) {
			cnt++;
			return;
		}

		// 재귀
		out: 
		for (int c=0; c<N; c++) {
			// 아직 방문 안한 열인지 확인
			if (cVisited[c]) continue;
			// 대각선 걸치는지 확인
			for (int i=0; i<r; i++) {
				// |x2-x1| == |y2-y1|이면 대각선 관계
				if (Math.abs(i-r) == Math.abs(pos[i]-c)) {
					continue out;
				}
			}
			// 행, 열 안겹치고 대각선도 안겹치면 위치 가능
			// 방문체크
			cVisited[c] = true;
			// 위치기록
			pos[r] = c;
			// 재귀들어감
			dfs(r+1);
			// 방문체크 해제
			cVisited[c] = false;
		}
	}
}
