import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T, N, ans;
	static int[] docs; // 등수별로 지원자 번호 저장
	static int[] interviews;	// 지원자 번호 별로 등수 저장
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			init();
			
			int min = interviews[docs[1]]; // 최고등수 초기화
			for (int i=2; i<=N; i++) {
				if (interviews[docs[i]] < min) {
					ans += 1;
					min = Math.min(interviews[docs[i]], min);
				}
			}
			
			System.out.println(ans);
		}
		
	}

	private static void init() throws IOException {
		ans = 1;
		N = Integer.parseInt(br.readLine());
		docs = new int[N+1];
		interviews = new int[N+1];
		for (int i=1; i<=N; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			int doc = Integer.parseInt(st.nextToken());
			int interview = Integer.parseInt(st.nextToken());
			
			docs[doc] = i;
			interviews[i] = interview;
		}
	}
}
