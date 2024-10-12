import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, root;
	static int[] count;
	static char[][] tree;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		count = new int[N];
		// tree[노드번호][0:자기번호 1:왼쪽자식번호 2:오른쪽자식번호]
		tree = new char[N][3];
		// 트리 입력
		for (int i = 0; i < N; i++) {
			tree[i][0] = sc.next().charAt(0);
			tree[i][1] = sc.next().charAt(0);
			tree[i][2] = sc.next().charAt(0);

			if (tree[i][1] != '.')
				count[tree[i][1] - 'A'] += 1;
			if (tree[i][2] != '.')
				count[tree[i][2] - 'A'] += 1;
		}
		int root = 0;
		for (int i=0;i <N; i++) {
			if (tree[i][0]=='A')
				root = i;
		}
		sb = new StringBuilder();

		preOrder(root);
		sb.append('\n');
		midOrder(root);
		sb.append('\n');
		postOrder(root);

		System.out.println(sb);
	}

	static void preOrder(int root) {
		sb.append(tree[root][0]);
		if (tree[root][1] != '.') {
			for (int i=0;i <N; i++) {
				if (tree[i][0]==tree[root][1])
					preOrder(i);
			}
		}
		if (tree[root][2] != '.') {
			for (int i=0;i <N; i++) {
				if (tree[i][0]==tree[root][2])
					preOrder(i);
			}
		}
	}

	static void midOrder(int root) {
		if (tree[root][1] != '.') {
			for (int i=0;i <N; i++) {
				if (tree[i][0]==tree[root][1])
					midOrder(i);
			}
		}
		sb.append(tree[root][0]);
		if (tree[root][2] != '.') {
			for (int i=0;i <N; i++) {
				if (tree[i][0]==tree[root][2])
					midOrder(i);
			}
		}
	}

	static void postOrder(int root) {
		if (tree[root][1] != '.') {
			for (int i=0;i <N; i++) {
				if (tree[i][0]==tree[root][1])
					postOrder(i);
			}
		}
		if (tree[root][2] != '.') {
			for (int i=0;i <N; i++) {
				if (tree[i][0]==tree[root][2])
					postOrder(i);
			}
		}
		sb.append(tree[root][0]);
	}
}
