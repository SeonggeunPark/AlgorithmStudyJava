import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2차원 배열 생성 없이 바로 StringBuilder로 뽑아내는 방법으로
 * 나름 효율적이었다고 생각했지만, 배열은 애초에 빨라서 실행시간과 크게 연관이 없는 것으로 보임
 * 처음 값을 입력받을 때부터 열과 행을 뒤집어 받은 후 그대로 출력하면
 * 덜 헷갈리고 더 쉽게 풀수 있었음. 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] arr = br.readLine().toCharArray();
		int r = 0, c = 0;
		int n = arr.length;
		
		// r의 최대값은 n의 제곱근
		r = (int) Math.sqrt(n);
		// 조건 맞는 r, c 중 가장 큰 r값 찾기
		// n의 제곱근부터 1씩 줄여가며 나누어 떨어지는 값 찾으면 break
		for (r = (int) Math.sqrt(n); r >= 1; r--) {
			if (n % r == 0) {
				c = n / r;
				break;
			}
		}

		// 0행부터 순서대로 뽑기 위해
		// 0부터 r개씩 건너뛰면서 문자 추출.
		// 1부터 r개씩 건너뛰며 추출 
		// ...
		for (int i = 0; i < r; i++) {
			for (int j = i; j < n; j+=r) {
				sb.append(arr[j]);
			}
		}
		
		System.out.println(sb.toString());
	}
}
