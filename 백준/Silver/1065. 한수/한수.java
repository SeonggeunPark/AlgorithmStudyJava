import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(counter(N));
    }

    private static int counter(int n) {
        // 1 ~ 99까지는 모두 한수
        if (n < 100) {
            return n;
        }

        int cnt = 99; // 1 ~ 99까지는 모두 한수이므로 99부터 시작
        for (int i = 100; i <= n; i++) {
            int digit_100 = i / 100;   // 백의 자리
            int digit_10 = (i / 10) % 10; // 십의 자리
            int digit_1 = i % 10;       // 일의 자리

            // 각 자릿수의 차이가 동일하면 한수
            if (digit_10 - digit_100 == digit_1 - digit_10) {
                cnt++;
            }
        }

        return cnt;
    }
}
