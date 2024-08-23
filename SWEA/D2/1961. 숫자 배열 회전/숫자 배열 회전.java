import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 배열을 90도, 180도, 270도 회전하여 각각 만들어 출력할 수도 있지만,
 * 출력 형태가 한 행에 모두 출력되는 형태이고, 메모리와 처리속도를 고려하여
 * 배열 생성 없이 인덱스 규칙을 이용하여 바로 출력할 수 있도록 함. 
 * arr[r][c] = arr_90[c][N-1-r] = arr_180[N-1-r][N-1-c] = arr_270[N-1-c][r]
 */

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(t).append(' ').append('\n');
			
			int N = Integer.parseInt(br.readLine());
			int[][] arr= new int[N][N];
			
			for (int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r=0; r<N; r++) {
				// 90도 회전한 배열의 첫 행 => 원본 배열의 첫 열 
				for (int c=0; c<N; c++) {
					sb.append(arr[N-1-c][r]);
				}
				sb.append(' ');

				// 180도 회전한 배열의 첫 행 => 원본 배열의  마지막 행
				for (int c=0; c<N; c++) {
					sb.append(arr[N-1-r][N-1-c]);
				}
				sb.append(' ');
				// 270도 회전한 배열의 첫 행 => 원본 배열의 마지막 열
				for (int c=0; c<N; c++) {
					sb.append(arr[c][N-1-r]);
				}
				sb.append('\n');
			}
			System.out.print(sb);
		}
	}
}
