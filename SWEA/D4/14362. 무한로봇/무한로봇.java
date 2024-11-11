import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	// 우하좌상
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int max;
	static char[] comm;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			comm = br.readLine().toCharArray();
			max = 0;
			// x, y, dir
			int[] curr = new int[] { 0, 0, 0 };

			out: for (int i = 0; i < 4; i++) { // 4바퀴 돌린다
				for (char c : comm) {	// 하나씩 꺼내서 수행한다
					if (c == 'S') {
						curr[0] = curr[0] + dx[curr[2]];
						curr[1] = curr[1] + dy[curr[2]];
					} else if (c == 'L') {
						curr[2] = curr[2] - 1 < 0 ? 3 : curr[2] - 1;
					} else {
						curr[2] = curr[2] + 1 > 3 ? 0 : curr[2] + 1;
					}
					double dist = Math.pow(curr[0], 2) + Math.pow(curr[1], 2); 
					
					max = (int) Math.max(max, dist);
				}
				
				if (curr[0]==0 && curr[1] ==0) {
					break out;
				}
			}
			if (curr[0]==0 && curr[1] ==0) {
				System.out.println("#"+(t)+" "+max);
			} else {
				System.out.println("#"+(t)+" "+"oo");
			}
		}

	}
}
