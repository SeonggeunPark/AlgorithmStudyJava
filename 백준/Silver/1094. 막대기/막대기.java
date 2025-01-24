import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[] S, pick;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		
		System.out.println(bitmasking(n));
	}
	private static int bitmasking(int n) {
		int ans = 0;
		for (int i=0; i<=6; i++) {
			int bit = 1<<i;
			
			if ((n & bit) == bit) {
				ans += 1;
			}
		}
		
		return ans;
	}
}