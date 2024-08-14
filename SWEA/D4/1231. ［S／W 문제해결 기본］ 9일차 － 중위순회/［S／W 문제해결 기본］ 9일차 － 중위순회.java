import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			char[] tree = new char[N + 1];

			// N만큼 반복
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				// 인덱스 받아 해당 인덱스에 문자 입력
				int idx = Integer.parseInt(st.nextToken());
				tree[idx] = st.nextToken().charAt(0);
				// 자식노드 번호 입력
				for (int n = 2 * idx; n <= 2*idx+1 && n < N+1; n++) {
					st.nextToken();
				}
			}
			System.out.print("#" + t + " ");
			inOrder(tree, 1);
			System.out.println();
		}

	}
	// 중위순회
	static void inOrder(char[] tree, int root) {
		if (root >= tree.length || tree[root]==0) {
			return;
		}
		
		// 왼쪽 자식노드 우선 탐색
		inOrder(tree, root*2);
		// 자기 자신 탐색
		System.out.print(tree[root]);
		// 오른쪽 자식노드 탐색
		inOrder(tree, root*2+1);
	}
	// 후위순회
	static void postOrder(char[] tree, int root) {
		if (root >= tree.length || tree[root]==0) {
			return;
		}
		
		// 왼쪽 자식노드 우선 탐색
		postOrder(tree, root*2);
		// 오른쪽 자식노드 탐색
		postOrder(tree, root*2+1);
		// 자기 자신 탐색
		System.out.print(tree[root]);
	}
	// 전위순회
	static void preOrder(char[] tree, int root) {
		if (root >= tree.length || tree[root]==0) {
			return;
		}
		
		// 자기 자신 탐색
		System.out.print(tree[root]);
		// 왼쪽 자식노드 우선 탐색
		preOrder(tree, root*2);
		// 오른쪽 자식노드 탐색
		preOrder(tree, root*2+1);
	}
	
}
