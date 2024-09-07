import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static char[][] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		next: for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			// 2차원 배열 생성 & 입력
			arr = new char[N][N];
			for (int r = 0; r < N; r++) {
				arr[r] = br.readLine().toCharArray();
			}
			int startR = -1;
			int startC = -1;
			int cnt = 0;
			// #으로 시작하는 좌표, 한 변의 길이(cnt) 구하기
			out: for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == '#') {
						startR = r;
						startC = c;
						cnt++;
						for (int i = c + 1; i < N; i++) {
							if (arr[r][i] == '.')
								break out;
							cnt++;
						}
						break out;
					}
				}
			}
			// 정사각형이 모두 막혀있는지 확인
			if (!findSquare(startR, startC, cnt) || startR == -1) {
				System.out.println("#" + t + " " + "no");
				continue next;
			}
			// 모두 막혀있다면, 나머지 칸은 모두 '.'인지 확인
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (startR <= r && r < startR + cnt && startC <= c && c < startC + cnt)
						continue;
					if (arr[r][c] == '#') {
						System.out.println("#" + t + " " + "no");
						continue next;
					}
				}
			}
			System.out.println("#" + t + " " + "yes");
		}
	}

	static boolean findSquare(int startR, int startC, int cnt) {
		for (int r = startR; r < startR + cnt; r++) {
			for (int c = startC; c < startC + cnt; c++) {
				if (arr[r][c] != '#') {
					return false;
				}
			}
		}
		return true;
	}
}
