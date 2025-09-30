import java.io.*;
import java.util.*;

/*
 *  N : 최대 20
 *  모든 경우의 수 => 4방향 , 5회 = 4^5 = 1,024
 *  브루트포스 가능
 *  
 *  1. dfs로 모든 경우 탐색
 *  2. 시뮬레이션
 *  		-좌: 0행부터, 0열부터
 *  		-우: 0행부터, 3열부터
 *  		-상: 0열부터, 0행부터
 *  		-하: 0열부터, 3행부터
 */
public class Main {
	static final long INF = Long.MAX_VALUE;
	static int N;
	static long min;
	static long[] arr, res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		res = new long[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		min = INF;
		
		for (int i=0; i<N; i++) {
			search(i);
			if (min == 0) break;
		}
		
		Arrays.sort(res);
		System.out.println(res[0]+" "+res[1]+" "+res[2]);
	}
	// i번째 값을 고정픽한 후 남은 2개 고르기
	private static void search(int stdIdx) {
		long stdVal = arr[stdIdx]*-1; // 해당 값에 가장 가까운 값을 찾아야함
		
		int l = 0;
		int r = N-1;
		while (l<r) {
			if (l==stdIdx) {
				l++;
				continue;
			}
			if (r==stdIdx) {
				r--;
				continue;
			}
			long sum = arr[l]+arr[r];
			long diff = sum-stdVal;
			if (min > Math.abs(diff)) {
				min = Math.abs(diff);
				res[0] = arr[stdIdx];
				res[1] = arr[l];
				res[2] = arr[r];
			}
			if (diff>0) {
				r-=1;
			} else if (diff<0) {
				l+=1;
			} else {
				return;
			}
		}
	}
}