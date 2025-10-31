import java.io.*;
import java.util.*;

public class Main {
	static int[] inorder;
	static int[] postorder;
	static int n, pIdx;
	static Tree tree;

	static class Tree {
		Node root;

		public Tree(Main.Node root) {
			super();
			this.root = root;
		}
	}

	static class Node {
		int num;
		Node left;
		Node right;

		public Node(int num) {
			this.num = num;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		inorder = new int[n];
		postorder = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}

		pIdx = n - 1;
		tree = new Tree(new Node(postorder[pIdx]));

		int rootIdx = -1;
		for (int i = 0; i < n; i++) {
			if (inorder[i] == postorder[pIdx]) {
				rootIdx = i;
				pIdx -= 1;
				break;
			}
		}
		find(rootIdx + 1, n - 1, 'r', tree.root);
		find(0, rootIdx - 1, 'l', tree.root);

		// 전위순회
		StringBuilder ans = new StringBuilder();
		preOrder(tree.root, ans);
		
		System.out.println(ans);
	}

	private static void preOrder(Node cur, StringBuilder ans) {
		ans.append(cur.num).append(' ');
		if (cur.left != null)
			preOrder(cur.left, ans);
		if (cur.right != null)
			preOrder(cur.right, ans);
	}

	private static void find(int start, int end, char dir, Node parent) {
		if (pIdx < 0)
			return;
		if (start > end)
			return;

		int rootNode = 0;
		int rootIdx = -1;
		// root 찾기
		for (int i = start; i <= end; i++) {
			if (inorder[i] == postorder[pIdx]) {
				rootNode = inorder[i];
				rootIdx = i;
				pIdx -= 1;
				break;
			}
		}
		
		// 못찾으면 종료
		if (rootNode <= 0) return;
		
		// 찾은 root를 트리에 추가
		Node cur = new Node(rootNode);
		if (dir == 'r') {
			parent.right = cur;
		} else {
			parent.left = cur;
		}

		// root 오른쪽부터 탐색
		find(rootIdx + 1, end, 'r', cur);

		// root 왼쪽
		find(start, rootIdx - 1, 'l', cur);
	}
}
