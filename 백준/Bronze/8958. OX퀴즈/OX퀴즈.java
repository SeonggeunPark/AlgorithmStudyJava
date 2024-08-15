import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 실행속도 향상을 위해 BufferedReader 사용
 * 입력받아 char 배열에 각각 저장.
 * sum과 cnt 0점으로 초기화한 후 시작하고, 앞에서부터 1개씩 배열 값을 읽어온다.
 * O가 나오면 cnt += 1 한 후 총점인 sum에 cnt를 누적
 * X가 나오면 cnt = 0 초기화
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt;
		int sum;
		// 테스트케이스 입력
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			// 작업 전 cnt와 sum 변수 초기화
			cnt = 0;
			sum = 0;
			// char배열에 OX값 입력
			char[] OX = br.readLine().toCharArray();
			// 점수 산정 시작
			for (int i=0; i<OX.length; i++) {
				char c = OX[i];
				// O일 때 cnt누적 후 sum값에 합산
				if (c == 'O') {
					cnt++;
					sum += cnt;
				// X일 때 cnt누적을 초기화
				} else {
					cnt = 0;
				}
			}
			System.out.println(sum);
		}
	}
}
