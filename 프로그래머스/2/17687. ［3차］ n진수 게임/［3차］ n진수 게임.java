import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int limit = m*t-(m-p);
        StringBuilder sb = new StringBuilder();
        int num=0;
        while (sb.length()<limit) {
            sb.append(convertToBaseK(num++, n));            
        }
        String candid = sb.toString();
        
        for (int i=p-1; i<limit; i+=m) {
            answer.append(candid.charAt(i));
        }
        return answer.toString();
    }
    public String convertToBaseK(int n, int k) {
        if (k == 10) return String.valueOf(n);
        if (n==0) return "0";
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            if (n%k>=10) {
                sb.append((char)(n%k+('A'-10)));
            } else {
                sb.append(n % k);
            }
                
            
            n /= k;
        }
        return sb.reverse().toString();
    }
}