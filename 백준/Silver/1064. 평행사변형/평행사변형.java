import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();

        // 일직선 여부 확인
        if ((x1 - x2) * (y1 - y3) == (y1 - y2) * (x1 - x3)) {
            System.out.println(-1.0);
            return;
        }

        // 세 변의 길이 계산
        double ab = dist(x1, y1, x2, y2);
        double ac = dist(x1, y1, x3, y3);
        double bc = dist(x2, y2, x3, y3);

        // 세 가지 경우의 둘레 계산
        double p1 = 2 * (ab + ac);
        double p2 = 2 * (ab + bc);
        double p3 = 2 * (ac + bc);

        double max = Math.max(p1, Math.max(p2, p3));
        double min = Math.min(p1, Math.min(p2, p3));

        System.out.printf("%.10f\n", max - min);
    }

    static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
