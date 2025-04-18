import java.util.*;

public class Main {
    static class Num implements Comparable<Num> {
        int value;  // 실제 값
        int index;  // 원래 위치

        Num(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Num o) {
            return this.value - o.value;  // 값 기준으로 정렬
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        Num[] arr = new Num[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Num(sc.nextInt(), i);
        }

        Arrays.sort(arr);  // 값 기준 정렬

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[arr[i].index] = i;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(P[i] + " ");
        }
    }
}
