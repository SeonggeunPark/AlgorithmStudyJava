import java.util.*;

class Solution {
    public String solution(String p) {
        if (check(p)) return p;
        // 반복 시작
        String answer = make(p);
        return answer;
    }
    public String make(String w) {
        if (w.equals("")) return "";
        
        // 분리
        int cnt = 0;
        for (int i=0; i<w.length(); i++) {
            char c = w.charAt(i);
            if(c == '(') {
                cnt += 1;
            } else {
                cnt -= 1;
            }
            if (cnt!=0) continue;
            
            String u = w.substring(0,i+1);
            String v = w.substring(i+1, w.length());
            if (check(u)) {
                return u+make(v);
            } else {
                String res = "("+make(v)+")";
                u = u.substring(1, i);
                String tmp = "";
                for (int j=0; j<u.length(); j++) {
                    tmp += u.charAt(j)=='(' ? ')' : '(';
                }
                return res+tmp;
            }
        }
        return "";
    }
    // 괄호 체크 메서드
    public boolean check(String p) {
        Stack<Character> st = new Stack<>();
        int open = 0;
        int close = 0;
        for (int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            if (c=='(') {
                open += 1;
                st.push(c);
            } else {
                if (st.isEmpty() || st.peek()!='(') {
                    return false;
                }
                st.pop();
            }
        }
        
        return true;
    }
}