
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] belt = new int[N*2];
        for (int i = 0; i < N*2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] robot = new boolean[N];
        int stage = 0;

        while (true) {
            stage++;

            // 1-1. 벨트 회전
            int tmp = belt[(N*2)-1];
            for (int i = (N*2)-1; i > 0 ; i--) {
                belt[i] = belt[i-1];
            }
            belt[0] = tmp;

            // 1-2. 로봇 회전
            for (int i = N-1; i > 0; i--) {
                robot[i] = robot[i-1];
            }
            robot[0] = false;

            robot[N-1] = false;     // 로봇 제거

            // 2. 로봇만 앞으로 이동
            for (int i = N-1; i >0; i--) {
                if (robot[i-1] && !(robot[i]) && belt[i]>0) {
                    robot[i] = robot[i-1];
                    robot[i-1] = false;
                    belt[i]--;
                }
            }
            robot[N-1] = false;     // 로봇 제거

            // 3. 로봇 올리기
            if (!robot[0] && belt[0]>0) {
                robot[0] = true;
                belt[0]--;
            }

            // 4. 종료 조건 확인
            int cnt = 0;
            for (int i = 0; i < (N*2); i++) {
                if (belt[i] == 0) {
                    cnt++;

                    if (cnt >= K) {
                        break;
                    }
                }
            }
            if (cnt >= K) {
                break;
            }

        }

        System.out.println(stage);
    }

}