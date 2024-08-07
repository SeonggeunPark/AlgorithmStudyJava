import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<>();

		for (int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}

			int i = 1;
			int popItem = queue.peek(); // 초기화

			while (popItem > 0) {
				popItem = queue.poll();	// 빼기
				popItem -= i;			// i만큼 차감
				i = i%5 + 1;			// i값 모듈러연산 + 1
				if (popItem < 0) popItem = 0;	// 0보다 작아지면 0으로 초기화
				queue.add(popItem);		// 다시 넣기
			}
			// 출력
			System.out.print("#" + tc + " ");
			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}
}
