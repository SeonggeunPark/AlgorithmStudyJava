import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices .length;
        int[] answer = new int[len];
        
        Stack<Integer> st = new Stack<>();
         
        for (int i=0; i<len; i++) {
            while (!st.isEmpty() && prices[i] < prices[st.peek()]) {
                int prev = st.pop();
                answer[prev] = i - prev;
            }
            st.push(i);
        }
        
        while (!st.isEmpty()) {
            int prev = st.pop();
            answer[prev] = len - 1 - prev;
        }
        
        return answer;
    }
}