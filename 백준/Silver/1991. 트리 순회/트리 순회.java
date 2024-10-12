import java.util.Scanner;

class Node {
    char data;
    Node left, right;

    Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static Node[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 노드 개수
        tree = new Node[26];  // 노드가 알파벳 대문자이므로 26 크기 배열

        for (int i = 0; i < N; i++) {
            char parent = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);

            if (tree[parent - 'A'] == null) {
                tree[parent - 'A'] = new Node(parent);
            }

            // 왼쪽 자식이 '.'이 아닐 경우
            if (left != '.') {
                tree[parent - 'A'].left = new Node(left);
                tree[left - 'A'] = tree[parent - 'A'].left;  // 저장
            }

            // 오른쪽 자식이 '.'이 아닐 경우
            if (right != '.') {
                tree[parent - 'A'].right = new Node(right);
                tree[right - 'A'] = tree[parent - 'A'].right; // 저장
            }
        }

        // 전위 순회
        preorder(tree[0]);
        System.out.println();

        // 중위 순회
        inorder(tree[0]);
        System.out.println();

        // 후위 순회
        postorder(tree[0]);
        System.out.println();
    }

    // 전위 순회 (Preorder: Root -> Left -> Right)
    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회 (Inorder: Left -> Root -> Right)
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    // 후위 순회 (Postorder: Left -> Right -> Root)
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}
