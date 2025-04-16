import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // 손님의 수
        HashSet<Integer> set = new HashSet<>(); // 이미 사용 중인 컴퓨터 좌석 번호 저장
        int count = 0; // 거절당한 손님 수

        for (int i = 0; i < n; i++) {
            int seat = sc.nextInt();
            if (set.contains(seat)) {
                count++; // 이미 앉은 자리면 거절
            } else {
                set.add(seat); // 빈 자리면 저장
            }
        }

        System.out.println(count);
    }
}
