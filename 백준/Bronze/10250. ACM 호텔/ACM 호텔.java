import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            int H = sc.nextInt(); // 호텔 층 수
            int W = sc.nextInt(); // 호텔 방 개수 (사용되지 않음)
            int N = sc.nextInt(); // 손님 번호
            
            int floor = (N % H == 0) ? H : (N % H); // 층 번호
            int room = (N / H) + (N % H == 0 ? 0 : 1); // 호수
            
            System.out.printf("%d%02d\n", floor, room);
        }
        sc.close();
    }
}
