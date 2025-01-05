import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		boolean[] isremoved = new boolean[N+1]; // 스택에서 제거된 수인지 체크
		int top = 0;
		for (int n : arr) {
			// (1) top < n : n까지 push 후 1번 pop & isremoved 체크
			if (top < n) {
				for (int i=top+1; i<=n; i++) {
					if (!isremoved[i]) {
						sb.append('+').append('\n');
					}
					top += 1;
				}
				sb.append('-').append('\n');
				isremoved[top] = true;
				while (isremoved[top]) {
					top -= 1;
				}
			} 
			// (2) top == n : 스택에서 이미 제거된 수인지 아닌지 체크
			else if (top == n) {
				// (2)-1 : 이미 스택에서 제거된 수이면 NO 출력
				if (isremoved[n]) {
					System.out.println("NO");
					return;
				}
				// (2)-2 : 아직 제거된 수 아니면 1번 pop & isremoved 체크
				else {
					sb.append('-').append('\n');
					isremoved[top] = true;
					while (isremoved[top]) {
						top -= 1;
					}
				}
			}
			// (3) top > n : NO 출력 후 종료
			else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(sb);
	}
}
