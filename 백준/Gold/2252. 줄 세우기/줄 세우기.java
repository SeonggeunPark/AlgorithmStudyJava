import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] adjList;
    static int[] inDegree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        init(); // 변수 선언 및 초기화 메서드
        wisangSort(); // 위상정렬
        print(); // 출력 메서드
    }

    // 변수 선언 및 초기화 메서드
    static void init() throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 비교 횟수

        adjList = new ArrayList[N + 1]; // 인접 리스트
        inDegree = new int[N + 1]; // 진입 차수

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v); // u -> v 간선 추가
            inDegree[v]++; // v의 진입 차수 증가
        }
    }

    // 위상정렬 수행 메서드
    private static void wisangSort() {
        Queue<Integer> q = new LinkedList<>();

        // 진입 차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll(); // 큐에서 뽑기
            sb.append(curr).append(' '); // 스트링빌더에 추가
            
            // curr와 인접한 노드들에 대해 진입 차수를 감소시키고 0이 되면 큐에 추가
            for (int neighbor : adjList[curr]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
    }

    // 출력 메서드
    private static void print() {
        System.out.println(sb);
    }
}
