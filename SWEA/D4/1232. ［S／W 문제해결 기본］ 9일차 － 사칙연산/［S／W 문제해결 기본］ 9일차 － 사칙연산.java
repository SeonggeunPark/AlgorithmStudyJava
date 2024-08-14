import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// character 문자 배열로 생성하면 두자리 숫자를 문자형으로 반환받기 어려움
// 따라서 String 배열로 생성하였고, parseInt메서드를 이용해 형변환하였음
public class Solution {
	// 해당 조건 만족하기 위해선 후위순회 하여 양쪽 값을 가져온(return) 뒤 연산해야 함
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			// [노드번호][0: 노드내용, 1: 왼쪽자식노드번호, 2: 오른쪽자식노드번호]
			String[][] tree = new String[N + 1][3];

			// 정점 수 N만큼 반복하며 트리 배열 생성 및 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				// 인덱스 받아 해당 인덱스에 문자 입력
				int idx = Integer.parseInt(st.nextToken());
				// 자식노드 번호 입력
				int j=0;
				while (st.hasMoreTokens()) {
	
					tree[idx][j] = st.nextToken();
					j++;
				}
			}
			sb.append("#" + t + " ");
			sb.append((int) postOrder(tree, 1));
			System.out.println(sb.toString());
			sb.delete(0, sb.length());
		}

	}

	// 후위순회 메서드
	static double postOrder(String[][] tree, int root) {
		// 자식노드가 없으면 => 무조건 숫자임
		// 숫자를 위 노드로 반환
		if ((tree[root][1] == null && tree[root][2] == null)) {
			return Integer.parseInt(tree[root][0]);
		}
		// 자식노드 있으면 => 무조건 연산부호임
		// 자식들로부터 값을 받아 연산 수행
		if (tree[root][0].equals("+")) {
			return (postOrder(tree, Integer.parseInt(tree[root][1]))) + (postOrder(tree, Integer.parseInt(tree[root][2])));
		} else if (tree[root][0].equals("-")) {
			return (postOrder(tree, Integer.parseInt(tree[root][1]))) - (postOrder(tree, Integer.parseInt(tree[root][2])));
		} else if (tree[root][0].equals("/")) {
			return (postOrder(tree, Integer.parseInt(tree[root][1]))) / (postOrder(tree, Integer.parseInt(tree[root][2])));
		} else {
			return (postOrder(tree, Integer.parseInt(tree[root][1]))) * (postOrder(tree, Integer.parseInt(tree[root][2])));
		}
		
	}
}
