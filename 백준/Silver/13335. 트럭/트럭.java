import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[][] trucks = new int[n][2]; // 0: 무게 1: 다리 위 남은시간
		for (int i=0; i<n; i++) {
			trucks[i][0] = Integer.parseInt(st.nextToken());
		}
		int bidx = 0;
		int bridgeCnt = 0;
		int widx = 0;
		int sum = 0;
		int time = 0;
		while (bidx < n) {
			// 다리 위 트럭 이동
			if (bridgeCnt > 0 && bidx < n) {
				for (int i=bidx; i<bidx+bridgeCnt; i++) {
					trucks[i][1] -= 1;
					// 다리 이동 완료
					if (trucks[i][1] <= 0) {
						sum -= trucks[i][0];
						bridgeCnt -= 1;
						bidx += 1;
					}
				}
			}
			// 다리 전 트럭 이동
			if (widx < n && sum+trucks[widx][0] <= l) {
				bridgeCnt += 1;
				sum += trucks[widx][0];
				trucks[widx][1] = w;
				widx += 1;
			}
			
			// 시간 흐름
			time += 1;
		}
		
		System.out.println(time);
	}
}