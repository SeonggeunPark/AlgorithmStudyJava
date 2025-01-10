import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] room = br.readLine().toCharArray();
		int[] count = new int[10];
		
		// 숫자가 나온 횟수를 기록 
		for (char c : room) {
			int num = c-'0';
			count[num] += 1;
		}
		
		// 6과 9 횟수 평탄화
//		int add = count[6]+count[9];
//		if (add%2==0) {
//			count[6] = add/2;
//			count[9] = count[6];
//		} else {
//			count[6] = add/2;
//			count[9] = count[6]+1;
//		}
		
		count[6] = count[9] = (count[6] + count[9] + 1) /2;
		
		// 최대값 찾기
		int max = -1;
		for (int i=0; i<=9; i++) {
			if (count[i] > max) {
				max = count[i];
			}
		}
		
		System.out.println(max);
	}
}
