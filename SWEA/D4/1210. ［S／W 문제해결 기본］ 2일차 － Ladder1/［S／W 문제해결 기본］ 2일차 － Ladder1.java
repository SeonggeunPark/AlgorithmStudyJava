import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 *	사다리 가장 마지막에서 2를 찾아 거꾸로 올라가는 방식을 사용함
 *	좌, 우에 1이 없을 때까지 상승하고, 1을 발견하면 더이상 1이 없을 때까지 해당 방향으로 이동하고
 *	다시 상승하는 방식
 *	좌 우의 사다리를 찾는 과정에서 계속 Index범위를 -1, 100까지 넘어가는 에러가 발생하여
 *	디버깅이 어려웠음. 처음 작성 당시에 배열 범위를 넘지 않게끔 신중하게 작성할 필요갸 있음 
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());

			boolean[][] ladder = new boolean[100][100];

			// 현재 위치
			int r = 99;
			int c = 0;
			int n=0;
			// 사다리배열에 입력, 마지막 행에서 값이 2인 좌표를 찾으면 위치 저장 후 작업 종료
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					n = Integer.parseInt(st.nextToken());
					if (n == 0)
						continue;
					else if (n == 1) {
						ladder[i][j] = true;
					} else {
						ladder[i][j] = true;
						c = j;
						break;
					}
				}
			}
//			System.out.println(r+", "+c);
			// 0행에 도달할 때까지 작업 시작
			while (r > 0) {
				// 좌우에 사다리 없을 때까지 이동
				while (r>0 && ((c-1<0 || !ladder[r][c-1]) && (c+1>=100 || !ladder[r][c+1]))) {
					r--;
				}
//				System.out.println("상승: "+r+", "+c);
				if (c-1>=0 && ladder[r][c-1]) {
					while (c-1>=0 && ladder[r][c-1]) {
						c--;
					}
//					System.out.println("좌측이동: "+r+", "+c);
				} else {
					while (c+1<100 && ladder[r][c+1]) {
						c++;
					}
//					System.out.println("우측이동: "+r+", "+c);
				}
				r--;
//				System.out.println("이동 후: "+r+", "+c);
			}
			
			System.out.println("#"+t+" "+c);
		}
	}

}
