import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();      // 대문자 A~Z
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'A']++;

        int oddIdx = -1, oddCnt = 0;
        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) { oddCnt++; oddIdx = i; }
        }
        if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < cnt[i] / 2; k++) left.append((char)('A' + i));
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        if (oddIdx != -1) ans.append((char)('A' + oddIdx));
        ans.append(new StringBuilder(left).reverse());

        System.out.println(ans.toString());
    }
}
