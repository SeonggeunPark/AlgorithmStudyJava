import java.util.*;
/*
- 노드 수: 1~10000
- 같은 레벨은 같은 y값 & 깊이 최대 1000 -> 가질 수 있는 y값은 최대 1000가지
- 부모 후보 중 가장 가까운 노드를 부모로 선택 -> 만약 거리가 같다면?
*/
class Solution {
    class BST {
        private Node root;
        private int size;
        public BST(Node root) {
            this.root = root;
            this.size = 1;
        }
        public void add(Node n) {
            Node cur = root;
            while (cur!=null) {
                if (cur.x<n.x) {
                    if (cur.r != null)
                        cur = cur.r;
                    else {
                        cur.r = n;
                        size++;
                        break;
                    }
                } else {
                    if (cur.l != null)
                        cur = cur.l;
                    else {
                        cur.l = n;
                        size++;
                        break;
                    }
                }
            }
        }
    }
    class Node {
        int x, y, num;
        Node l, r;
        public Node(int x, int y, int num) {
            this.num=num;
            this.x = x;
            this.y = y;
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes= new Node[nodeinfo.length];
        for (int i=0; i<nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        // y 내림차순 정렬
        Arrays.sort(nodes, new Comparator<>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y==o2.y) {
                    return o1.x - o2.x;
                }
                return o2.y-o1.y;
            }
        });
        
        // 이진탐색트리 삽입
        BST bst = new BST(nodes[0]);
        for (int i=1; i<nodeinfo.length; i++) {
            Node node = nodes[i];
            bst.add(node);
        }
        List<Integer>[] res = new ArrayList[2];
        res[0] = new ArrayList<>();
        res[1] = new ArrayList<>();
        
        preOrder(bst.root, res);
        postOrder(bst.root, res);
        
        int[][] answer = new int[2][bst.size];
        for (int i=0; i<bst.size; i++) {
            answer[0][i] = res[0].get(i);
            answer[1][i] = res[1].get(i);
        }
        
        return answer;
    }
    public void preOrder(Node cur, List<Integer>[] res) {
        res[0].add(cur.num);
        if (cur.l!=null)
            preOrder(cur.l, res);
        if (cur.r!=null)
            preOrder(cur.r, res);
    }
    public void postOrder(Node cur, List<Integer>[] res) {
        if (cur.l!=null)
            postOrder(cur.l, res);
        if (cur.r!=null)
            postOrder(cur.r, res);
        res[1].add(cur.num);
    }
}