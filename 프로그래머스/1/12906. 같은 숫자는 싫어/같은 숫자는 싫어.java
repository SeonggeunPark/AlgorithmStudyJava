import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        Stack<Integer> st = new Stack<>();        
        for (int i=0; i<len; i++) {
            if (st.isEmpty() || st.peek()!=arr[i]) {
                st.push(arr[i]);
            }
        }
        
        int[] answer = new int[st.size()];
        int idx = st.size()-1;
        while (!st.isEmpty()) {
            answer[idx--] = st.pop();
        }
        return answer;
    }
}