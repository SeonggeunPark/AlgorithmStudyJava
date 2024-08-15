
/* 1번째 시도
 * 개미가 (p, q) 좌표에서 시작, 초기엔 시간당 (+1, +1) 이동.
 * 이동하다 
 * x한계선에 부딪히면 (-1, +1)이동
 * y한계선에 부딪히면 (+1, -1) 이동
 * x, y 한계선에 부딪히면 (-1, -1) 이동할 것이므로
 * 이동할 때마다 상하좌우 확인하여 한계선을 확인하고,
 * 확인된 한계선의 좌표 이동값만 -1로 바꿔줌.
 */

/* 2번째 시도
 * (1) 메모리 초과문제 발생.
 * 	  1. 매번 사방을 탐색하는 대신, 이동할 부분만 검사하는 방향으로 변경하였으며
 * 	  2. 굳이 map 배열이 필요하지 않아 map 배열 제거함
 * (2) 개선 후 시간 초과 발생.
 * 	  time이 최대 2억이므로 for문을 사용하면 안될 것이라고 판단.
 * 	  1. time을 최대 좌표값으로 나눴을 때 
 * 		 몫이 짝수이면 => 2바퀴 돌고 제자리로 돌아오고, 이동량은 그대로 +1
 *       몫이 홀수이면 => 1바퀴 돌아 원래 자리의 대칭점으로 이동. 이동량은 반대인 -1
 *    2. time을 좌표값으로 나눈 나머지만큼 이동해주면 최종 위치값이 된다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 상하좌우 확인용 배열
//		int[] dr = { -1, 1, 0, 0 };
//		int[] dc = { 0, 0, -1, 1 };
		// 시간당 이동량
		int[] move = { 1, 1 };
		// 개미 현재위치 변수
		int r, c;
		// 개미가 이동할 위치 변수
		int nr, nc;
		// 좌표상으로 개미의 이동 가능 범위가 x : 0 ~ w, y : 0 ~ h 이므로
		// => 배열로는 w+1행 h+1열 지도 생성해야 함
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		// 개미 위치 입력받음
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		// 시간 입력
		int time = Integer.parseInt(br.readLine());
		// 몫이 짝수이면 다시 제자리로 돌아온 것과 같음
		if (time / w % 2 == 0) {
			// 제자리에서 (+1 * 나머지) 만큼 이동
			r = r + (time % w) > w ? w - (r + (time % w) - w) : r + (time % w);
		// 몫이 홀수이면 원래 자리의 대칭점으로 이동한 것과 같음
		} else {
			// 대칭점에서 (-1 * 나머지) 만큼 이동
			r = r + (time % w - w) < 0 ? - (r + (time % w - w)) : r + (time % w - w);
		}
		// y좌표도 동일하게 이동 처리
		if (time / h % 2 == 0) {
			c = c + (time % h) > h ? h - (c + (time % h) - h) : c + (time % h);
		} else {
			c = c + (time % h - h) < 0 ? - (c + (time % h - h)) : c + (time % h - h);
		}
		
		// time이 최대 2억이기 때문에 for문 사용 시 시간 초과 발생한 것으로 예상됨
//		for (int t = 1; t <= time; t++) {
//			// 이동할 곳 탐색
//			nr = r + move[0];
//			nc = c + move[1];
//			// nr값이 범위를 넘으면 => 이동량 (-1, 1)
//			if (nr < 0 || nr > w) move[0] *= -1;
//			// nc값이 범위를 넘으면 => 이동량 (1, -1)
//			if (nc < 0 || nc > h) move[1] *= -1;
//			// 개미 이동
//			r += move[0];
//			c += move[1];
//		}

				// time시간 후 개미 위치 출력
				System.out.println(r + " " + c);
	}
}
