import java.util.*;
/*
문자열 짧을수록 압축 유리
1부터 N/2까지 글자 잘라가며 브루트포스
*/
class Solution {
    public int solution(String s) {
        int n = s.length();
        int minLen = n;
        
        for (int i=1; i<=n/2; i++) {
            // 앞부터 i개씩 잘라 체크
            int len = 0;
            int curCnt = 1;
            String prev = "";
            for (int j=0; j<n; j+=i) {
                String p = s.substring(j, j+i>n ? n:j+i);
                if (p.equals(prev)) {
                    curCnt+=1;
                } else {
                    len += (curCnt==1) ? prev.length() : prev.length()+String.valueOf(curCnt).length();
                    curCnt = 1;
                    prev = p;
                }
            }
            len += (curCnt==1) ? prev.length() : prev.length()+String.valueOf(curCnt).length();
            
            if (minLen > len) {
                minLen = len;
            }
        }
        return minLen;
    }
}