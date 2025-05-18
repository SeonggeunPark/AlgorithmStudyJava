import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        // 1) 정방향 LIS 계산
        int[] lis = new int[N];
        for (int i = 0; i < N; i++) {
            lis[i] = 1;  // 자기 자신만 있을 때 길이 1
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // 2) 역방향 LIS 계산 (뒤에서 앞으로)
        int[] revLis = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            revLis[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i] && revLis[j] + 1 > revLis[i]) {
                    revLis[i] = revLis[j] + 1;
                }
            }
        }

        // 3) 두 값을 합쳐서 바이토닉 길이 계산
        int answer = 0;
        for (int i = 0; i < N; i++) {
            // arr[i]가 두 수열에 중복 포함되므로 -1
            answer = Math.max(answer, lis[i] + revLis[i] - 1);
        }

        System.out.println(answer);
    }
}
