import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Candidate implements Comparable<Candidate>{
		int doc;
		int interview;
		public Candidate() {		}
		
		public Candidate(int doc, int interview) {
			this.doc = doc;
			this.interview = interview;
		}

		@Override
		public int compareTo(Main.Candidate o) {
			return this.doc - o.doc;
		}
	}
	static int T, N, ans;
	static Candidate[] candidates;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			init();
			// 서류등수로 오름차순 정렬
			Arrays.sort(candidates);
			
			int min = 100001; // 최고등수 초기화
			for (Candidate c : candidates) {
//				int doc = c.doc;
				int interview = c.interview;
				
				if (interview < min) {
					ans += 1;
				}
				
				min = Math.min(interview, min);
			}
			
			System.out.println(ans);
		}
		
	}

	private static void init() throws IOException {
		ans = 0;
		N = Integer.parseInt(br.readLine());
		candidates = new Candidate[N];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			candidates[i] = new Candidate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}
}
