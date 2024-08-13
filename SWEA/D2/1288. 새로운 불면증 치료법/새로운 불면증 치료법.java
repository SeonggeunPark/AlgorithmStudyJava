import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 각 자리수를 추출하여 체크하는 while문에서 조건을 num>=0으로 걸어 무한 반복됨
// 최종 출력값도 마지막으로 센 양의 번호를 출력해야하는데 잘못 읽고 i값을 출력함
// 문제를 잘 읽자
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			boolean[] check = new boolean[10];
			int N = Integer.parseInt(br.readLine());

			int i=1;
			int num;
			out: while (true) {
				num = N * i;
				// 각 자리수에 해당하는 boolean배열에 true 처리
				// num이 0이 될때까지 1의자리 수 추출하고 10을 나누고 반복
				while (num > 0) {
					check[num % 10] = true;		// 1의자리 추출
					num = num / 10;				// 10으로 나누어 1의자리 제거
				}
				// 모든 수를 다 확인했는지 체크
				for (int idx = 0; idx < 10; idx++) {
					// 체크안한 것 있으면 다음 반복으로 넘어감
					if (!check[idx]) {
						i++;
						continue out;
					}
				}
				// 모두 체크되면 반복문을 빠져나감
				break;
			}
			// 최종 i값 출력
			System.out.printf("#%d %d\n", t, i*N);
		}
	}
}

