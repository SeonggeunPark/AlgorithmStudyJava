import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		Set<String> set = new HashSet<>();;
		
//		int cases = (1 << arr.length) - 1;
//		for (int i=1; i<=cases; i++) {
//			String tmp = "";
//			for (int idx=arr.length-1; idx>=0; idx--) {
//				int digit = (1 << idx);
//				if ((i & digit) == digit) {
//					tmp += arr[arr.length-1-idx]; 
//				}
//			}
//			System.out.println(tmp);
//			set.add(tmp);
//		}
		int len = arr.length;
		for (int i=0; i<len; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j=i; j<len; j++) {
				sb.append(arr[j]);
				set.add(sb.toString());
			}
		}
		
		System.out.println(set.size());
	}
}
