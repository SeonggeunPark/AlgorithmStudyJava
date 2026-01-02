import java.util.*;

class Solution {

    public String solution(long n, String[] bans) {
        long[] banNums = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            banNums[i] = sToNum(bans[i]);
        }

        Arrays.sort(banNums);

        for (long b : banNums) {
            if (b <= n) n++;
            else break;
        }

        return numToS(n);
    }

    private long sToNum(String s) {
        long num = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = (s.charAt(i) - 'a') + 1;
            num = num * 26 + v;
        }
        return num;
    }

    private String numToS(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            long r = n % 26;
            if (r == 0) {
                r = 26;
                n = (n / 26) - 1;
            } else {
                n = n / 26;
            }
            sb.append((char) ('a' + (int) r - 1));
        }
        return sb.reverse().toString();
    }
}
