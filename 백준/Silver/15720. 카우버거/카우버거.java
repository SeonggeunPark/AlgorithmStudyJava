import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 버거 수
        int M = sc.nextInt(); // 사이드 수
        int K = sc.nextInt(); // 음료 수

        List<Integer> burgers = new ArrayList<>();
        List<Integer> sides = new ArrayList<>();
        List<Integer> drinks = new ArrayList<>();

        for (int i = 0; i < N; i++) burgers.add(sc.nextInt());
        for (int i = 0; i < M; i++) sides.add(sc.nextInt());
        for (int i = 0; i < K; i++) drinks.add(sc.nextInt());

        // 가격 내림차순 정렬
        burgers.sort(Collections.reverseOrder());
        sides.sort(Collections.reverseOrder());
        drinks.sort(Collections.reverseOrder());

        int total = 0;
        int discountTotal = 0;
        int setCount = Math.min(N, Math.min(M, K));

        for (int i = 0; i < N; i++) total += burgers.get(i);
        for (int i = 0; i < M; i++) total += sides.get(i);
        for (int i = 0; i < K; i++) total += drinks.get(i);

        for (int i = 0; i < setCount; i++) {
            int sum = burgers.get(i) + sides.get(i) + drinks.get(i);
            discountTotal += sum * 0.9;
        }

        for (int i = setCount; i < N; i++) discountTotal += burgers.get(i);
        for (int i = setCount; i < M; i++) discountTotal += sides.get(i);
        for (int i = setCount; i < K; i++) discountTotal += drinks.get(i);

        System.out.println(total);
        System.out.println(discountTotal);
    }
}
