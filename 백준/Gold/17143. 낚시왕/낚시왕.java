import java.io.*;
import java.util.*;

public class Main {
	static class Shark {
		int r, c, s, d, z;
		boolean isAlive;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.isAlive = true;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + ", isAlive=" + isAlive + "]";
		}

	}

	// 상하우좌
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[R + 1][C + 1];
		Shark[] sharks = new Shark[M + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); // 속도
			int d = Integer.parseInt(st.nextToken()); // 방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			
			if (d==1 || d==2) {
				s %= 2*(R-1);
			} else {
				s %= 2*(C-1);
			}

			sharks[i] = new Shark(r, c, s, d, z);
			map[r][c] = i;
		}

		int curC = 0;
		int ans = 0;
		for (int c = 1; c <= C; c++) {
//			for (int i=1; i<=R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			// 낚시꾼 이동하는 순간 낚시
			for (int r = 1; r <= R; r++) {
				if (map[r][c] > 0) {
					ans += sharks[map[r][c]].z;
					sharks[map[r][c]].isAlive = false;
					map[r][c] = 0;
					break;
				}
			}

			int[][] newMap = new int[R + 1][C + 1];
			// 상어 이동
			for (int i = 1; i <= M; i++) {
				Shark s = sharks[i];
				if (!s.isAlive)
					continue;
				// 이동 위치 계산
				int nr = s.r + dr[s.d] * s.s;
				int nc = s.c + dc[s.d] * s.s;

				while (nr < 1 || nr > R || nc < 1 || nc > C) {
					if (nr < 1) {
						nr = 1 + (1 - nr);
						s.d = 2;
					} else if (nr > R) {
						nr = R - (nr - R);
						s.d = 1;
					} else if (nc < 1) {
						nc = 1 + (1 - nc);
						s.d = 3;
					} else if (nc > C) {
						nc = C - (nc - C);
						s.d = 4;
					}
				}

				// 겹치는지 확인
				if (newMap[nr][nc] == 0) {
					newMap[nr][nc] = i;
					s.r = nr;
					s.c = nc;
				} else {
					int j = newMap[nr][nc];
					if (sharks[j].z > s.z) {
						s.isAlive = false;
					} else {
						newMap[nr][nc] = i;
						sharks[j].isAlive = false;
						s.r = nr;
						s.c = nc;
					}
				}
				
				map = newMap;
			}

		}
		System.out.println(ans);
	}
}
