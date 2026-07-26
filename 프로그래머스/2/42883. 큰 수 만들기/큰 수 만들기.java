import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> st = new Stack<>();
        int removed = 0;
        for (int i=0; i<number.length(); i++) {
            int num = number.charAt(i) - '0';
            
            while (removed < k && !st.isEmpty() && st.peek()<num) {
                st.pop();
                removed+=1;
            }
            
            st.push(num);
        }
        String answer = "";
        while (!st.isEmpty()) {
            int num = st.pop();
            if (removed>=k) {
                answer = num+answer;
            } else {
                removed+=1;
            }
            
        }
        return answer;
    }
}
