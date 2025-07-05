import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 총 응시자 수
        int k = sc.nextInt(); // 상을 받는 사람 수

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        Arrays.sort(scores); // 오름차순 정렬
        System.out.println(scores[N - k]); // 상을 받는 커트라인 점수
    }
}
