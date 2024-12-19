import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 비내림차순이어야 하므로, 배열 입력받은 후 정렬하고 조합 작업 시작해야 함.
 * 배열을 오름차순으로 정렬하고, 0번 인덱스부터 선택할지 안할지 탐색.
 * 최종 수열 완성 시 이미 존재하는지 여부 확인.
 * 
 * 시간복잡도 개선을 위해 배열로 관리.
 */

public class Main {
	static int N, M;
	static int[] arr;
	static int[] tmp;
	static String[] pick;
	static int size;
	static StringBuilder sb;
	static StringBuilder ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		ans = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N]; // 원본 배열
		tmp = new int[M]; // 숫자 조합 배열
		pick = new String[6435]; // 최종 출력할 조합 (최대크기인 8C4 = 70)

		size = 0; // 최종 출력할 조합 배열의 크기

		// 배열 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr); // 배열 오름차순 정렬

		combination(0, 0); // 조합 시작

		System.out.println(ans);
	}

	private static void combination(int aidx, int tidx) {
	    // 기저조건: tidx가 M에 도달했을 때
	    if (tidx == M) {
	        for (int n : tmp) {
	            sb.append(n).append(' '); // 공백을 추가해서 숫자를 구분
	        }

	        // 중복 여부 확인
	        for (int i = 0; i < size; i++) {
	            if (pick[i].equals(sb.toString())) {
	                sb.delete(0, sb.length());
	                return;
	            }
	        }

	        // 중복 없다면 arr배열에 추가 후 정답 출력
	        pick[size++] = sb.toString();

	        ans.append(sb).append('\n');

	        sb.delete(0, sb.length());
	        return;
	    }

	    // 불완전 선택 (무시): aidx가 N 이상이면 더 이상 선택할 수 없음
	    if (aidx >= N) {
	        return;
	    }

	    // 재귀 호출부
	    for (int i = aidx; i < N; i++) {
	        tmp[tidx] = arr[i]; // tidx는 M을 넘지 않음
	        combination(i, tidx + 1); // i를 그대로 넘기므로 중복 조합 허용
	    }
	}

}