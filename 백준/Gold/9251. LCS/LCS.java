import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        // DP 배열 선언: dp[i][j]는 str1의 i번째 문자까지와 str2의 j번째 문자까지의 LCS 길이를 저장
        int[][] dp = new int[len1 + 1][len2 + 1];

        // DP 테이블 채우기
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;  // 문자가 같을 때
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // 문자가 다를 때
                }
            }
        }

        // 결과 출력 (LCS의 길이)
        System.out.println(dp[len1][len2]);
    }
}
