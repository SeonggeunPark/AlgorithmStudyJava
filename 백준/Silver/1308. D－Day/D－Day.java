import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int y1, m1, d1, y2, m2, d2;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        y1 = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());
        d1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        y2 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        d2 = Integer.parseInt(st.nextToken());

        // 1000년 이상 차이나면 "gg"
        if (isOverThousand(y1, m1, d1, y2, m2, d2)) {
            System.out.println("gg");
            return;
        }

        long diff = toDays(y2, m2, d2) - toDays(y1, m1, d1);
        System.out.println("D-" + diff);
    }

    static boolean isOverThousand(int y1, int m1, int d1, int y2, int m2, int d2) {
        int ty = y1 + 1000;
        if (ty < y2) return true;
        if (ty > y2) return false;
        if (m1 < m2) return true;
        if (m1 > m2) return false;
        return d1 <= d2; // 같은 달이면 당일 포함 이후면 1000년 이상
    }

    static long toDays(int y, int m, int d) {
        long days = 0;

        // 연도 누적 (1년~y-1년)
        long yPrev = y - 1;
        days += 365L * yPrev;
        days += yPrev / 4 - yPrev / 100 + yPrev / 400;

        // 월 누적
        for (int month = 1; month < m; month++) {
            days += daysInMonth(y, month);
        }

        // 일 누적
        days += d;

        return days;
    }

    static int daysInMonth(int y, int m) {
        switch (m) {
            case 1:  return 31;
            case 2:  return isLeap(y) ? 29 : 28;
            case 3:  return 31;
            case 4:  return 30;
            case 5:  return 31;
            case 6:  return 30;
            case 7:  return 31;
            case 8:  return 31;
            case 9:  return 30;
            case 10: return 31;
            case 11: return 30;
            default: return 31;
        }
    }

    static boolean isLeap(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }
}
