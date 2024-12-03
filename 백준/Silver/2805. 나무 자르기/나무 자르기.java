import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] trees;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxHeight = 0;

        // 나무의 높이를 입력받고, 최대 높이를 구함
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        // 이진 탐색을 위한 low, high 설정
        int low = 0;
        int high = maxHeight;
        int answer = 0;

        // 이진 탐색으로 적절한 높이를 찾음
        while (low <= high) {
            int mid = (low + high) / 2;
            long totalWood = getWood(mid); // mid 높이에서 자른 나무의 양

            if (totalWood >= M) {
                answer = mid;  // 더 높은 높이를 시도해보기 위해 높이를 올림
                low = mid + 1;
            } else {
                high = mid - 1;  // 더 낮은 높이를 시도해보기 위해 높이를 내림
            }
        }

        System.out.println(answer);
    }

    // 주어진 높이 h에서 자른 나무의 양을 계산하는 함수
    private static long getWood(int height) {
        long wood = 0;
        for (int tree : trees) {
            if (tree > height) {
                wood += tree - height;
            }
        }
        return wood;
    }
}
