import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[len];
        
        for (int i=0; i<len; i++) {
            int cur = prices[i];
            while (!st.isEmpty() && prices[st.peek()]>cur) {
                int idx = st.pop();
                answer[idx] = i-idx;
            }
            st.push(i);
        }
        
        while (!st.isEmpty()) {
            int idx = st.pop();
            answer[idx] = len-idx-1;
        }
        
        return answer;
    }
}