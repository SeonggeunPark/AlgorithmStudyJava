import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 탑의 수
		int N = Integer.parseInt(br.readLine());
		// 탑 배치
		int[] arr = new int[N];
		// 정답 배열
		int[] ans = new int[N];
		// 가장 가까운 높은 탑의 인덱스를 저장해두기 위한 스택
		Stack<Integer> stack = new Stack<>();
		// 탑 높이 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 탐색 시작
		for (int i=0; i<N; i++) {
			int currTowerHeight = arr[i];
			// 나보다 높은 탑이 나올 때까지 스택 조회
			while(!stack.isEmpty()) {
				int popTowerIdx = stack.pop();
				if (currTowerHeight >= arr[popTowerIdx]) continue;
				// 나보다 큰 탑 나옴
				ans[i] = popTowerIdx+1;
				stack.push(popTowerIdx);
				break;
			}
			
			stack.push(i);
		}
		
		for (int i=0; i<N; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}