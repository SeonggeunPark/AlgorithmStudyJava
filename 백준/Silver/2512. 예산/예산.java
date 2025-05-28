import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        // 1) 모든 요청 총액이 예산 이내면, 최대 요청액 그대로 반환
        long sumAll = 0;
        for (int x : arr) sumAll += x;
        if (sumAll <= M) {
            System.out.println(arr[N - 1]);
            return;
        }

        // 2) 이진 탐색으로 최적의 상한액 찾기
        int low = 0;
        int high = arr[N - 1];
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            long total = 0;
            for (int x : arr) {
                total += Math.min(x, mid);
            }

            if (total <= M) {
                answer = mid;      // 이 값은 가능
                low = mid + 1;     // 더 큰 값도 시도
            } else {
                high = mid - 1;    // 너무 커서 줄여야 함
            }
        }

        System.out.println(answer);
    }
}
