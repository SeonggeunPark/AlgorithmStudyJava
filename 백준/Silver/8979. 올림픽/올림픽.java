import java.util.*;

public class Main {
    static class Nation implements Comparable<Nation> {
        int number;
        int gold, silver, bronze;

        public Nation(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold != o.gold)
                return o.gold - this.gold;
            if (this.silver != o.silver)
                return o.silver - this.silver;
            return o.bronze - this.bronze;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 나라 수
        int K = sc.nextInt(); // 등수를 알고 싶은 나라 번호

        Nation[] nations = new Nation[N];

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int g = sc.nextInt();
            int s = sc.nextInt();
            int b = sc.nextInt();
            nations[i] = new Nation(num, g, s, b);
        }

        Arrays.sort(nations);

        int rank = 1;
        int[] ranks = new int[N + 1]; // 나라 번호 기준 등수 저장
        ranks[nations[0].number] = rank;

        for (int i = 1; i < N; i++) {
            Nation prev = nations[i - 1];
            Nation curr = nations[i];

            if (curr.gold == prev.gold && curr.silver == prev.silver && curr.bronze == prev.bronze) {
                ranks[curr.number] = rank; // 동점
            } else {
                rank = i + 1;
                ranks[curr.number] = rank;
            }
        }

        System.out.println(ranks[K]);
    }
}
