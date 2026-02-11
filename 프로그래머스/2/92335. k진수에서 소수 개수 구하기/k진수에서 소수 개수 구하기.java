import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String str = convertToBaseK(n, k);
        String[] strs = str.split("0");
        
        int answer = 0;
        
        // 소수 개수 찾기
        for (int i=0; i<strs.length; i++) {
            if (strs[i].equals("")) continue;
            long num = Long.parseLong(strs[i]);
            if (isPrime(num)) {
                answer+=1;
                System.out.println(num);
            }
        }
        
        return answer;
    }
    public boolean isPrime(long n) {
        if (n<=1) return false;
        if (n==2) return true;
        if (n%2==0) return false;
        for (long i=3; i<=Math.sqrt(n); i+=2) {
            if (n%i==0) return false;
        }
        return true;
    }
    public String convertToBaseK(int n, int k) {
        if(k==10) return String.valueOf(n);
        
        String result = "";
        while (n>0) {
            result = n%k + result;
            n /= k;
        }
        return result;
    }
}