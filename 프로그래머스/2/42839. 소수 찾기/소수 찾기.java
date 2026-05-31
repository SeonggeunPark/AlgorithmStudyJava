import java.util.*;

class Solution {
    int len, answer;
    Map<Integer,Boolean> check;
    public int solution(String numbers) {
        len = numbers.length();
        check = new HashMap<>();
        answer = 0;
        
        // 완전탐색
        bruteForce(0, 0, new StringBuilder(), numbers);
        
        return answer;
    }
    public boolean checkPrime(int num) {
        if(num<=1) return false;
        for (int i=2; i<= (int) Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public void bruteForce(int idx, int visit, StringBuilder sb, String numbers) {
        // 탐색 종료 시 소수 여부, 기탐색 여부 체크
        if (idx >= len) {
            if (sb.length()<=0) return;
            int num = Integer.parseInt(sb.toString());
            if (check.get(num)!=null) return;
            
            check.put(num, true);
            
            // 소수 체크
            if (checkPrime(num)) {
                answer++;
            }
            return;
        }
        
        // 탐색
        for (int i=0; i<len; i++) {
            // 방문여부 체크
            if ((visit & (1<<i)) == (1<<i)) continue;
            char cur = numbers.charAt(i);
            
            int originLen = sb.length();
            
            // 채택안하는 경우
            bruteForce(idx+1, visit, sb, numbers);
            
            // 채택하는 경우
            bruteForce(idx+1, visit|(1<<i), sb.append(cur), numbers);
            
            sb.setLength(originLen);
        }
    }
}