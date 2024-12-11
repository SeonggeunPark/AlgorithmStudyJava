import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		int arr[][] = new int[N][3];
		int dp_min[][] = new int[N][3];
		int dp_max[][] = new int[N][3];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp_min[0][0] =  arr[0][0];
		dp_min[0][1] =  arr[0][1];
		dp_min[0][2] =  arr[0][2];
		dp_max[0][0] =  arr[0][0];
		dp_max[0][1] =  arr[0][1];
		dp_max[0][2] =  arr[0][2];
		
		for (int i=1; i<N; i++) {
			dp_min[i][0] = Math.min(dp_min[i-1][0], dp_min[i-1][1])+arr[i][0];
			dp_min[i][1] = Math.min(dp_min[i-1][2], Math.min(dp_min[i-1][0], dp_min[i-1][1]))+arr[i][1];
			dp_min[i][2] = Math.min(dp_min[i-1][1], dp_min[i-1][2])+arr[i][2];
			dp_max[i][0] = Math.max(dp_max[i-1][0], dp_max[i-1][1])+arr[i][0];
			dp_max[i][1] = Math.max(dp_max[i-1][2], Math.max(dp_max[i-1][0], dp_max[i-1][1]))+arr[i][1];
			dp_max[i][2] = Math.max(dp_max[i-1][1], dp_max[i-1][2])+arr[i][2];
		}
		
		int min = Math.min(dp_min[N-1][2], Math.min(dp_min[N-1][0], dp_min[N-1][1]));
		int max = Math.max(dp_max[N-1][2], Math.max(dp_max[N-1][0], dp_max[N-1][1]));
		
		System.out.println(max+" "+min);
		
	}
}
