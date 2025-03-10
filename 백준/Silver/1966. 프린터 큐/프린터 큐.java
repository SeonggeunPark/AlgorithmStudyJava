import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int priority;
        int index;

        public Node(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서 개수
            int m = Integer.parseInt(st.nextToken()); // 찾고자 하는 문서 위치

            Queue<Node> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Node(priority, i));
                pq.add(priority);
            }

            int printOrder = 0;
            while (!queue.isEmpty()) {
                Node current = queue.poll();

                if (current.priority == pq.peek()) { // 가장 높은 우선순위 문서 출력
                    pq.poll();
                    printOrder++;

                    if (current.index == m) { // 우리가 찾는 문서라면 출력
                        System.out.println(printOrder);
                        break;
                    }
                } else {
                    queue.add(current); // 우선순위가 낮으면 다시 대기열로 이동
                }
            }
        }
    }
}
