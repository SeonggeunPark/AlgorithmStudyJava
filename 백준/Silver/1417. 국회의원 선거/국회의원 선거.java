import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int dasom = sc.nextInt(); // 다솜이 표 수

        // 다솜이를 제외한 나머지 후보들의 표를 최대 힙으로 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i < N; i++) {
            pq.add(sc.nextInt());
        }

        int count = 0;
        while (!pq.isEmpty() && pq.peek() >= dasom) {
            int maxVote = pq.poll();
            maxVote--;       // 1등 후보의 표에서 1표 빼서
            dasom++;         // 다솜이에게 줌
            pq.add(maxVote); // 뺀 표 수 다시 넣음
            count++;
        }

        System.out.println(count);
    }
}
