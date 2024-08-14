import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int sameP = 0;
	static int treeSize = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int find1 = Integer.parseInt(st.nextToken());
			int find2 = Integer.parseInt(st.nextToken());
			// [노드번호][0: 왼쪽자식노드번호, 1: 오른쪽자식노드번호]
			int[][] tree = new int[v + 1][2];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());

				// 자식노드를 왼쪽부터 채움
				if (tree[parent][0] == 0) {
					tree[parent][0] = child;
				} else
					tree[parent][1] = child;
			}
			
			sb.append("#" + t + " ");
			// 공통조상 & 트리크기 확인
			preOrder(tree, 1, find1, find2);
			sb.append(sameP + " " + treeSize);
			System.out.println(sb.toString());
			sb.delete(0, sb.length());

		}
	}

	// 전위순회
	static boolean preOrder(int[][] tree, int root, int find1, int find2) {
		// 노드번호가 찾고 있는 숫자와 같다면 true 리턴
		if (root == find1 || root == find2) {
			return true;
		}
		// 자식노드가 없다면 false 리턴
		if (tree[root][0] == 0) {
			return false;
		}
		// 자식 노드 하나면 해당 자식노드 확인
		if (tree[root][1] == 0) {
			return preOrder(tree, tree[root][0], find1, find2);
		}
		
		// 자식 노드 두개일 경우 양쪽 자식노드 비교
		boolean left = preOrder(tree, tree[root][0], find1, find2);
		boolean right = preOrder(tree, tree[root][1], find1, find2);
		// (1) 양 쪽 다 true인 경우 => 공통조상 확인 완료
		if (left && right) {
			sameP = root;
			// treeSize 초기화
			treeSize = 0; 
			countTree(tree, root);
			return false;
		// (2) 양 쪽 다 false인 경우 false 리턴
		} else if (left == false && right == false) {
			return false;
		// (3) 둘 중 하나만 true인 경우 true 리턴
		} else {
			return true;
		}
	}

	static void countTree(int[][] tree, int root) {
		// 해당 노드 카운트
		treeSize++;
		// 자식노드가 없다면 작업 종료
		if (tree[root][0] == 0) {
			return;
		}
		// 자식 노드 있으면 모두 확인
		if (tree[root][1] == 0) {
			countTree(tree, tree[root][0]);
		} else {
			countTree(tree, tree[root][0]);
			countTree(tree, tree[root][1]);
		}
	}
}
