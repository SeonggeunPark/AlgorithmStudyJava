
public class Main {
	static boolean[] arr = new boolean[10001];
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		d(1);
		for (int i=2; i<10000; i++) {
			if (!arr[i]) d(i);
		}
		
		for (int i=1; i<10000; i++) {
			if (!arr[i]) sb.append(i).append('\n');
		}
		System.out.print(sb);
	}
	static void d(int k) {
		if (k>10000) return;
		int sum = 0;
		sum += k;
		
		while (k>0) {
			sum += k%10;
			k /= 10;
		}
		if (sum<10000) arr[sum] = true;
		d(sum);
	}
}
