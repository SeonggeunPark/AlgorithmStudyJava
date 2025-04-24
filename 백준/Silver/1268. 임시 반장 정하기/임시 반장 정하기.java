import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] classes = new int[N][5];

        // 반 정보 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                classes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxFriends = 0;
        int leader = 0;

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            int count = 0;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                for (int k = 0; k < 5; k++) {
                    if (classes[i][k] == classes[j][k]) {
                        count++;
                        break;
                    }
                }
            }

            if (count > maxFriends) {
                maxFriends = count;
                leader = i;
            }
        }

        // 학생 번호는 1부터 시작하므로 +1
        System.out.println(leader + 1);
    }
}