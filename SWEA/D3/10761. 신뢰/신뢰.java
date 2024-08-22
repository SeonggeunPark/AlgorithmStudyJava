import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 로봇이 동시에 버튼을 누를 수는 없으나 미리 이동은 가능함.
 * 서로 다른 복도에 위치하고 미리 이동하기 위해 각 로봇의 순서별 누적시간을 따로 저장
 * 순서대로 스위치를 눌러야 하기 때문에, i번째 순서에서 로봇이 미리 스위치에 도달했더라도,
 * i-1번째 스위치를 누르기 전까지는 대기해야함. 따라서 i번째까지의 소요시간은 i-1번째 소요시간보다 최소 1초 더 소요됨을 이용
 * 2차원 배열을 선언해 로봇 색과 누를 스위치 번호를 저장하고, 해당 순서까지의 소요시간을 함께 저장하여 관리하기로 함.
 * 
 */

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		 
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			// 현재 위치 변수
			int o = 1;
			int b = 1;
			// 각각 누적 시간
			int oTime = 0;
			int bTime = 0;
			// 순서를 담은 배열 [순서][0:로봇색, 1:스위치번호, 2: 해당순서까지 소요시간]
			String[][] order = new String[N][3];
			//누적
			for (int i=0; i<N; i++) {
				order[i][0] = st.nextToken();
				order[i][1] = st.nextToken();
			}
			
			// 첫 순서의 소요시간 계산
			if (order[0][0].equals("O")) {
				// 누적시간 갱신 (스위치위치 - 현재위치 + 스위치누르는시간)
				oTime += Math.abs(o-Integer.parseInt(order[0][1]))+1;
				// 로봇의 현재위치 갱신
				o = Integer.parseInt(order[0][1]);
				// 누적시간을 저장
				order[0][2] = String.valueOf(oTime);
			} else {
				bTime += Math.abs(b-Integer.parseInt(order[0][1]))+1;
				// 로봇의 현재위치 갱신
				b = Integer.parseInt(order[0][1]);
				// 누적시간을 저장
				order[0][2] = String.valueOf(bTime);
			}
			// 2번째부터 소요시간 계산
			for (int i=1; i<N; i++) {
				String robot = order[i][0];
				int snum = Integer.parseInt(order[i][1]);
				if (robot.equals("O")) {
					// 누적시간 갱신 (스위치위치 - 현재위치 + 스위치누르는시간)
					oTime += Math.abs(o-snum)+1;
					// 이전 순서의 누적시간보다 작거나 같으면 누적시간 +1
					if (Integer.parseInt(order[i-1][2])>=oTime) {
						oTime = Integer.parseInt(order[i-1][2])+1;
					}
					// 현재까지의 누적시간을 저장
					order[i][2] = String.valueOf(oTime);
					// 로봇의 현재위치 갱신
					o = snum;
				} else {
					// 누적시간 갱신 (스위치위치 - 현재위치 + 스위치누르는시간)
					bTime += Math.abs(b-snum)+1;
					// 이전 순서의 누적시간보다 작거나 같으면 누적시간 +1
					if (Integer.parseInt(order[i-1][2])>=bTime) {
						bTime = Integer.parseInt(order[i-1][2])+1;
					}
					// 현재까지의 누적시간을 저장
					order[i][2] = String.valueOf(bTime);
					// 로봇의 현재위치 갱신
					b = snum;
				}
			}
			
			System.out.println("#"+t+" " + Integer.parseInt(order[N-1][2]));
		}
	}
}
