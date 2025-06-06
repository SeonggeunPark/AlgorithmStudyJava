import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 과일 개수
        int L = sc.nextInt(); // 초기 길이

        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = sc.nextInt();
        }

        Arrays.sort(fruits); // 오름차순 정렬

        for (int i = 0; i < N; i++) {
            if (fruits[i] <= L) {
                L++; // 먹을 수 있으면 길이 증가
            } else {
                break; // 더 이상 먹을 수 없음
            }
        }

        System.out.println(L);
    }
}
