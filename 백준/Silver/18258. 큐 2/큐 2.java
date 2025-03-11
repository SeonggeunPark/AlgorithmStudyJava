import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 빠른 출력

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();

            switch (com) {
                case "push":
                    q.addLast(Integer.parseInt(st.nextToken())); // 뒤에 추가
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? "-1\n" : q.pollFirst() + "\n"); // 앞에서 제거
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    sb.append(q.isEmpty() ? "-1\n" : q.getFirst() + "\n");
                    break;
                case "back":
                    sb.append(q.isEmpty() ? "-1\n" : q.getLast() + "\n");
                    break;
            }
        }
        System.out.print(sb); // 출력 최적화
    }
}
