import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int sCnt = 0;
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (c=='(') {
                sCnt+=1;
            } else {
                if (sCnt <= 0) {
                    answer = false;
                    break;
                }
                sCnt-=1;
            }
        }
        if (sCnt!=0) answer = false;
        return answer;
    }
}