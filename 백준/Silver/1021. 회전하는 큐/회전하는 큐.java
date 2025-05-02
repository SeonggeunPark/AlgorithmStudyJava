import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean[] arr;
	static int front, end, cnt, N, M, remain;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N];
		for (int i=0; i<N; i++) {
			arr[i] = true;
		}
		front = 0;	// 회전 큐의 맨 앞 위치
		end = N-1;	// 회전 큐의 맨 끝 위치
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken())-1;
			
			cnt += calMinDist(target);	// 목표 숫자를 맨 앞에 위치시키기 위한 최소 거리 구하기
			if (i == M-1) break;	// 모두 다 돌았으면 작업 종료
			// 타겟 숫자 뽑기
			arr[target] = false;
			// 찾은 후에는 맨 앞, 끝 인덱스를 갱신
			front = (target + 1)%N;
			while(!arr[front]) {
				front = (front+1)%N;
			}
			end = (front-1+N)%N;
			while(!arr[end]) {
				end = (end-1+N)%N;
			}
		}
		
		System.out.println(cnt);
	}

	private static int calMinDist(int target) {
		int rCnt = 0;
		int lCnt = 0;
		int tmpIdx = front;
		// 오른쪽으로 갈 때
		while(tmpIdx != target) {
			do {
				tmpIdx = (tmpIdx+1)%N;
			} while(!arr[tmpIdx]);
			rCnt += 1;
		}
		tmpIdx = front;
		// 왼쪽으로 갈 때
		while(tmpIdx != target) {
			do {
				tmpIdx = (tmpIdx-1+N)%N;
			} while(!arr[tmpIdx]);
			lCnt += 1;
		}
		return Math.min(rCnt, lCnt);
	}
}