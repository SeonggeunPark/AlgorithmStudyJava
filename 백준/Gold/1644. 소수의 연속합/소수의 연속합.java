import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> primes = new ArrayList<>();
		boolean[] filter = new boolean[N+1];
		filter[1] = true;
		for (int i=2; i<=Math.sqrt(N); i++) {
			for (int j=i*i; j<=N; j+=i) {
				filter[j] = true;
			}
		}
		for (int i=1; i<=N; i++) {
			if (!filter[i]) {
				primes.add(i);
			}
		}
		int[] sum = new int[primes.size()+1];
		for (int i=1; i<primes.size()+1; i++) {
			sum[i] = primes.get(i-1)+sum[i-1];
		}
		
		int s = 0;
		int e = 1;
		
		int cnt = 0;
		while (s<e && e<sum.length && s<sum.length) {
			int tmpSum = sum[e]-sum[s];
			if (tmpSum < N) {
				e+=1;
			} else if (tmpSum > N) {
				s+=1;
			} else {
				cnt += 1;
				s+=1;
				e+=1;
			}
		}
		
		System.out.println(cnt);
	}
}