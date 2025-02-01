import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] map;
	static int N;
	static List<int[]> teacherPos;
	static boolean isPossible;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N+1][N+1];
		teacherPos = new ArrayList<>();
		isPossible = false;
		
		// 맵 입력받기
		for (int r=1; r<=N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=1; c<=N; c++) {
				map[r][c] = st.nextToken().charAt(0);
				// 선생님 위치 기록
				if (map[r][c] == 'T') {
					teacherPos.add(new int[] {r, c});
				}
			}
		}
		
		// 장애물 배치 & 학생 발각 여부 확인
		placeObstacles(0);
		
		if (isPossible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	// 장애물 배치 & 학생 발각 여부 확인
	private static void placeObstacles(int cnt) {
		if (cnt >= 3) {
//			for (int r=1; r<=N; r++) {
//				System.out.println(Arrays.toString(map[r]));
//			}
//			System.out.println();
			// 배치 완료되면 발각 여부를 확인
			checkSafety();
			return;
		}
		
		for (int r=1; r<=N; r++) {
			for (int c=1; c<=N; c++) {
				if (map[r][c] == 'X') {
					map[r][c] = 'O';
					placeObstacles(cnt+1);
					map[r][c] = 'X';
				}
				if (isPossible) return;
			}
		}
	}

	private static void checkSafety() {
		// 선생님 위치 기준으로 탐색
		for (int[] curr : teacherPos) {
			out: for (int dir=0; dir<4; dir++) {
				for (int i=1; i<N; i++) {
					int nr = curr[0]+(dr[dir]*i);
					int nc = curr[1]+(dc[dir]*i);
					
					if (nr<1 || nr>N || nc<1 || nc>N) continue;
					// 장애물이면 해당 방향 탐색 종료
					if (map[nr][nc] == 'O') {
						continue out;
					}
					// 학생 발각되면 바로 작업 종료
					if (map[nr][nc] == 'S') {
						return;
					}
				}
			}
		}
		// 모두 통과하면 안전한 것
		isPossible = true;
	}
}
