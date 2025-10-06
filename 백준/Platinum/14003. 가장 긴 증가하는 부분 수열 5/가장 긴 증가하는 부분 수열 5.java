import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] tails;      // 길이별 최소 끝값
    static int[] posLast;    // 길이 pos를 만들었던 'arr 인덱스'
    static int[] prev;       // 수열 복원용: i 이전 원소의 인덱스

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        tails   = new int[N];
        posLast = new int[N];
        prev    = new int[N];
        Arrays.fill(prev, -1);

        int len = 0; // 현재 LIS 길이

        for (int i = 0; i < N; i++) {
            int x = arr[i];

            // lower_bound: 첫 번째로 tails[pos] >= x 가 되는 위치
            int pos = Arrays.binarySearch(tails, 0, len, x);
            if (pos < 0) pos = -(pos + 1);

            tails[pos] = x;
            posLast[pos] = i;               // 길이 pos를 만들었던 마지막 인덱스
            if (pos > 0) prev[i] = posLast[pos - 1]; // 바로 앞 길이의 마지막 인덱스로 연결

            if (pos == len) len++;          // 길이 확장
        }

        // 역추적: 길이 len-1의 마지막 인덱스부터 prev로 따라감
        int cur = posLast[len - 1];
        int[] ans = new int[len];
        for (int k = len - 1; k >= 0; k--) {
            ans[k] = arr[cur];
            cur = prev[cur];
        }

        sb.append(len).append('\n');
        for (int v : ans) sb.append(v).append(' ');
        System.out.println(sb);
    }
}
