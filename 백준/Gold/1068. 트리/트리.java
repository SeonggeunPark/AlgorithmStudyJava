import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int deleteNode, leafCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] parent = new int[N];
        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = -1;

        // 트리 구성
        for (int i = 0; i < N; i++) {
            parent[i] = sc.nextInt();
            if (parent[i] == -1) {
                root = i;
            } else {
                tree[parent[i]].add(i);
            }
        }

        deleteNode = sc.nextInt();

        if (deleteNode == root) {
            System.out.println(0); // 루트를 삭제하면 리프 노드도 없음
        } else {
            dfs(root);
            System.out.println(leafCount);
        }
    }

    static void dfs(int current) {
        if (current == deleteNode) return;

        List<Integer> children = tree[current];
        boolean isLeaf = true;

        for (int child : children) {
            if (child == deleteNode) continue;
            isLeaf = false;
            dfs(child);
        }

        if (isLeaf) leafCount++;
    }
}
