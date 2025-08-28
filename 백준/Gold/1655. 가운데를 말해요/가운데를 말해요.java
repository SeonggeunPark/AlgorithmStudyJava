import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static int N;

    static PriorityQueue<Integer> maxHeap;  // 최대힙 (작은 수들의 절반)
    static PriorityQueue<Integer> minHeap; // 최소힙 (큰 수들의 절반)

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            insert(x);
            sb.append(maxHeap.peek()).append('\n'); // 항상 아래 중앙값 출력
        }

        System.out.print(sb);
    }

    private static void init() throws IOException {
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine().trim());
        maxHeap  = new PriorityQueue<>(Collections.reverseOrder()); 
        minHeap = new PriorityQueue<>();                           
    }

    private static void insert(int n) {
        // maxheap을 우선으로 담기
        if (maxHeap.isEmpty() || n <= maxHeap.peek()) maxHeap.offer(n);
        else minHeap.offer(n);

        if (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
        if (maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll());

        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int a = maxHeap.poll(), b = minHeap.poll();
            maxHeap.offer(b);
            minHeap.offer(a);
        }
    }
}