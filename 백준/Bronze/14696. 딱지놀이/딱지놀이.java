
/*
 * 1. 별 개수 2. 동그라미 개수 3. 네모 개수 4. 세모 개수
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 라운드 수
		int N = Integer.parseInt(br.readLine());
		// A의 점수, B의 점수 저장할 변수
		int aScore, bScore;
		// A의 승 수, B의 승 수 저장
		int aWins = 0, bWins = 0;
		
		// 라운드 수만큼 반복
		for (int n=1; n<=N; n++) {
			// A, B 점수 초기화
			aScore = 0;
			bScore = 0;
			
			st = new StringTokenizer(br.readLine());
			// A가 낸 딱지의 그림 수
			int a = Integer.parseInt(st.nextToken());
			// 그림 수만큼 반복
			for (int i=0; i<a; i++) {
				aScore += convertScore(Integer.parseInt(st.nextToken())); 
			}
			
			st = new StringTokenizer(br.readLine());
			// B가 낸 딱지 그림 수
			int b = Integer.parseInt(st.nextToken());
			// 그림 수만큼 반복
			for (int i=0; i<b; i++) {
				bScore += convertScore(Integer.parseInt(st.nextToken()));
			}
			
			if (aScore>bScore) {
				System.out.println("A");
			} else if (aScore<bScore) {
				System.out.println("B");
			} else {
				System.out.println("D");
			}
		}		
	}
	
	static int convertScore(int shape) {
		if (shape == 1) {
			return 1;
		} else if (shape == 2) {
			return 2 * 100;
		} else if (shape == 3) {
			return 3 * 10000;
		} else {
			return 4 * 1000000;
		}
	}
}
