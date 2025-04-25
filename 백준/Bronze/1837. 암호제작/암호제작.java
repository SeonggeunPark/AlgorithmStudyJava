import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String P = st.nextToken();      // 매우 큰 수 (문자열)
        int K = Integer.parseInt(st.nextToken());

        // 1. 에라토스테네스의 체로 K보다 작은 소수 찾기
        isNotPrime = new boolean[K];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i < K; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < K; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        // 2. 나눠보면서 P가 나누어 떨어지는 소수가 있는지 확인
        for (int i = 2; i < K; i++) {
            if (!isNotPrime[i]) {
                if (mod(P, i) == 0) {
                    System.out.println("BAD " + i);
                    return;
                }
            }
        }

        System.out.println("GOOD");
    }

    // 문자열로 표현된 큰 수 P를 int q로 나눈 나머지를 계산
    private static int mod(String num, int q) {
        int result = 0;
        for (int i = 0; i < num.length(); i++) {
            result = (result * 10 + (num.charAt(i) - '0')) % q;
        }
        return result;
    }
}
