import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int next = 0;
        int curW = 0;

        int len = truck_weights.length;
        Queue<int[]> bridge = new ArrayDeque<>();

        while (next < len || !bridge.isEmpty()) {

            while (!bridge.isEmpty() && bridge.peek()[1] <= answer) {
                int[] out = bridge.poll();
                curW -= truck_weights[out[0]];
            }

            if (next < len && curW + truck_weights[next] <= weight && bridge.size() < bridge_length) {
                bridge.offer(new int[]{next, answer + bridge_length});
                curW += truck_weights[next];
                next++;
                answer++;
            } else {
                if (!bridge.isEmpty()) {
                    answer = Math.max(answer, bridge.peek()[1]);
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }
}
