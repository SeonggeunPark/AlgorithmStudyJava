import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long ans = 0;
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] sumA = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			int num = Integer.parseInt(st.nextToken());
			sumA[i] = sumA[i-1] + num;
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] sumB = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=m; i++) {
			int num = Integer.parseInt(st.nextToken());
			sumB[i] = sumB[i-1] + num;
		}
		
		Map<Integer, Integer> mapA = new HashMap<>();
		Map<Integer, Integer> mapB = new HashMap<>();
		for (int i=0; i<=n-1; i++) {
			for (int j=i+1; j<=n; j++) {
				int sum = sumA[j]-sumA[i];
				mapA.put(sum, mapA.getOrDefault(sum, 0)+1);
			}
		}
		for (int i=0; i<=m-1; i++) {
			for (int j=i+1; j<=m; j++) {
				int sum = sumB[j]-sumB[i];
				mapB.put(sum, mapB.getOrDefault(sum, 0)+1);
			}
		}
		
		for (int A : mapA.keySet()) {
			int B = T-A;
			if (!mapB.containsKey(B)) continue;
			ans += (long) mapA.get(A)*mapB.get(B);
		}
		
		System.out.println(ans);
	}
}
