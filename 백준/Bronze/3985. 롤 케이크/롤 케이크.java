import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 롤케이크 길이
		int L = Integer.parseInt(br.readLine());
		int[] cake = new int[L];
		// 방청객 수
		int N = Integer.parseInt(br.readLine());
		// 방청객 케이크 받는 조각 수 카운트
		int cnt;
		// 예상 최대값
		int expectMax = 0;
		// 실제 최대값
		int realMax = 0;
		// 예상 최대값을 갖는 방청객 번호 & 실제 최대값을 갖는 방청객 번호
		int expectI = 0, realI = 0;
		
		/* 
		 * 케이크 배열을 L개 만들었으므로, 조각 번호는 0부터 시작한다.
		 * 이 부분을 생각하지 못해 ArrayIndexOutOfBounds 에러 발생함. 
		 */
		// 방청객 수만큼 반복작업
		for (int i = 1; i <= N; i++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			
			// 희망 조각 번호 시작, 끝 입력
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 예상 조각 수 최대값과 방청객 번호를 저장
			if (expectMax < end-start+1) {
				expectI = i;
				expectMax = end-start+1;
			}
			// 케이크 배분
			while (start <= end) {
				// 선점되지 않은 케이크만 배정 후 카운트
				if (cake[start-1] == 0) {
					cake[start-1] = i;
					cnt++;
				}
				start++;
			}
			// 실제 배정된 케이크의 최대값과 방청객 번호 저장
			if (realMax < cnt) {
				realI = i;
				realMax = cnt;
			}
		}
		
		System.out.println(expectI);
		System.out.println(realI);
	}
}
