import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int preV;		// 현재속도
		int incV;		// 가속도
		int decV;		// 감속도
		int totalD;		// 총 이동거리
		int command;	// 명령값
		
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			preV = 0;	// 현재속도 0으로 시작
			totalD = 0;	// 총 이동거리 0으로 시작
			
			int N = sc.nextInt();
			for (int n = 1; n<=N; n++) {
				command = sc.nextInt();
				if (command == 1) {		// 가속 명령 시
					incV = sc.nextInt();
					preV += incV;	// 현재 속도 증가
					totalD += preV;	// 총 이동거리 += 현재속도(m/s) * 1초
				} else if (command == 2) {	// 감속 명령 시
					decV = sc.nextInt();	
					preV -= decV;			// 현재속도 감소
					if (preV < 0) preV = 0;	// 0보다 작으면 속도 0으로 재설정
					totalD += preV;			// 총 이동거리 += 현재속도(m/s) * 1초
				} else {
					totalD += preV;
				}
				
			}
			System.out.println("#" + t + " " + totalD);
			
		}
	}
}
