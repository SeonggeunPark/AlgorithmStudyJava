import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        for (int n : arr) {
            if (st.size()<=0) st.push(n);
            if (st.peek()==n) continue;
            st.push(n);
        }

        int[] answer = new int[st.size()];
        for (int i=st.size()-1; i>=0; i--) {
            answer[i] = st.pop();
        }
        return answer;
    }
}