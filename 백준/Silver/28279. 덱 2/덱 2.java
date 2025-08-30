import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            switch (t) {
                case 1: { // push_front X
                    int x = Integer.parseInt(st.nextToken());
                    dq.addFirst(x);
                    break;
                }
                case 2: { // push_back X
                    int x = Integer.parseInt(st.nextToken());
                    dq.addLast(x);
                    break;
                }
                case 3: { // pop_front
                    sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append('\n');
                    break;
                }
                case 4: { // pop_back
                    sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append('\n');
                    break;
                }
                case 5: { // size
                    sb.append(dq.size()).append('\n');
                    break;
                }
                case 6: { // empty
                    sb.append(dq.isEmpty() ? 1 : 0).append('\n');
                    break;
                }
                case 7: { // front
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
                    break;
                }
                case 8: { // back
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb.toString());
    }
}
