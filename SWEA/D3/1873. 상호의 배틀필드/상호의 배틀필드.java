import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * shoot 메서드와 move메서드로 나누어 메서드 생성
 * 포탄 이동, 전차 이동 시 효율성을 위해 dr, dc 델타 배열 생성함.
 * shoot 메서드의 while문을 작성하는 과정에서 dr dc를 각각 더해야 하는데
 * dr만 두번 더해 무한 루프로 빠지는 경우 발생함. dr, dc 작성 시 실수 주의
 * 이동 시 배열 범위 벗어나는지 여부도 항상 체크해야함
 */
public class Solution {
	static char[][] map;
	// 현재 위치를 저장할 변수
	static int y, x;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ny, nx;
	static int H, W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];

			// 맵 상태 저장 & 현재 전차 위치 좌표 저장
			for (int r = 0; r < H; r++) {
				char[] tmp = br.readLine().toCharArray();
				for (int c = 0; c < W; c++) {
					map[r][c] = tmp[c];
					if (map[r][c] == '<' || map[r][c] == 'v' || map[r][c] == '^' || map[r][c] == '>') {
						y = r;
						x = c;
					}
				}
			}
//			for (int r=0; r<H; r++) {
//				System.out.println(Arrays.toString(map[r]));
//			}
//			System.out.println(y+", "+x);
			// 명령 입력받아 배열에 저장
			int N = Integer.parseInt(br.readLine());
			// 명령 처리
			char[] cmdArr = br.readLine().toCharArray();
			for (int i = 0; i < N; i++) {
				char c = cmdArr[i];
				if (c=='S') Shoot();
				else Move(c);
			}
			// 출력
			sb.append('#').append(t).append(' ');
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					sb.append(map[r][c]);
				}
				sb.append('\n');
			}
			System.out.print(sb);
		}
		
	}

	static void Shoot() {
//		System.out.println("shoot");
		int idx;
		// 방향 확인
		if (map[y][x] == '^')
			idx = 0;
		else if (map[y][x] == 'v')
			idx = 1;
		else if (map[y][x] == '<')
			idx = 2;
		else
			idx = 3;
		// 포탄 발사
		ny = y + dr[idx];
		nx = x + dc[idx];
//		System.out.println(y+", "+x);
//		System.out.println(idx);
		while (0 <= ny && ny < H && 0 <= nx && nx < W) {
			// 물이거나 평지면 그냥 지나감
			if (map[ny][nx] == '.' || map[ny][nx] == '-') {
				ny += dr[idx];
				nx += dc[idx];
				continue;
			}
			// 벽돌 벽이면 평지로 만든 후 작업 종료
			if (map[ny][nx] == '*') {
				map[ny][nx] = '.';
				break;
			}
			// 벽돌이면 그냥 작업 종료
			if (map[ny][nx] == '#')
				break;
		}
	}
	static void Move(char cmd) {
//		System.out.println("move");
		if (cmd == 'U') {
			// 방향 돌리기
			map[y][x] = '^';
			
			// 평지면 이동하기
			ny = y + dr[0];
			nx = x + dc[0];
			if (0>ny||ny>=H||0>nx||nx>=W) return;
			if (map[ny][nx]=='.') {
				map[ny][nx] = '^';
				map[y][x] = '.';
				y = ny;
				x = nx;
			}
		} else if (cmd == 'D') {
			// 방향 돌리기
			map[y][x] = 'v';
			
			// 평지면 이동하기
			ny = y + dr[1];
			nx = x + dc[1];
			if (0>ny||ny>=H||0>nx||nx>=W) return;
			if (map[ny][nx]=='.') {
				map[ny][nx] = 'v';
				map[y][x] = '.';
				map[y][x] = '.';
				y = ny;
				x = nx;
			}
		} else if (cmd == 'L') {
			// 방향 돌리기
			map[y][x] = '<';
			
			// 평지면 이동하기
			ny = y + dr[2];
			nx = x + dc[2];
			if (0>ny||ny>=H||0>nx||nx>=W) return;
			if (map[ny][nx]=='.') {
				map[ny][nx] = '<';
				map[y][x] = '.';
				map[y][x] = '.';
				y = ny;
				x = nx;
			}
		} else {
			// 방향 돌리기
			map[y][x] = '>';
			
			// 평지면 이동하기
			ny = y + dr[3];
			nx = x + dc[3];
			if (0>ny||ny>=H||0>nx||nx>=W) return;
			if (map[ny][nx]=='.') {
				map[ny][nx] = '>';
				map[y][x] = '.';
				map[y][x] = '.';
				y = ny;
				x = nx;
			}
		}
	}
}
