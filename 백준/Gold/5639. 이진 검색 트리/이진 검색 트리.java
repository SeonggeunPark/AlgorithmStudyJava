import java.io.*;
import java.util.*;

public class Main {
	static class Tree {
		Node root;
		public Tree(Node root) {
			this.root = root;
		}
		void add (Node newNode) {
			findChild(newNode, this.root);
		}
		private void findChild(Main.Node newNode, Main.Node cur) {
			if (newNode.num < cur.num) {
				if (cur.left != null) {
					findChild(newNode, cur.left);
				} else {
					cur.left = newNode;
					return;
				}
			} else {
				if (cur.right != null) {
					findChild(newNode, cur.right);
				} else {
					cur.right = newNode;
					return;
				}
			}
		}
	}
	static class Node{
		int num;
		Node left;
		Node right;
		public Node () {};
		public Node (int num) {
			this.num = num;
			this.left = null;
			this.right = null;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Node root = new Node(sc.nextInt());
		Tree tree = new Tree(root);
		while(sc.hasNextInt()) {
			int num = sc.nextInt();
			tree.add(new Node(num));
		}
		postOrder(tree, tree.root);
	}
	private static void postOrder(Main.Tree tree, Node cur) {
		if (cur.left!=null) {
			postOrder(tree, cur.left);
		}
		if (cur.right!=null) {
			postOrder(tree, cur.right);
		}
		System.out.println(cur.num);
	}
}