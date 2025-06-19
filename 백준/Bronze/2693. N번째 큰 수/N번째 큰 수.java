import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr); // 오름차순 정렬
            System.out.println(arr[7]); // 세 번째로 큰 수 = 정렬 후 8번째 수 (index 7)
        }

        sc.close();
    }
}
