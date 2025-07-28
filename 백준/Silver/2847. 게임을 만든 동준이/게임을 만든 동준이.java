import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        // 뒤에서부터 탐색
        for (int i = N - 2; i >= 0; i--) {
            if (scores[i] >= scores[i + 1]) {
                int diff = scores[i] - (scores[i + 1] - 1);
                count += diff;
                scores[i] = scores[i + 1] - 1;  // 점수 감소
            }
        }

        System.out.println(count);
    }
}
