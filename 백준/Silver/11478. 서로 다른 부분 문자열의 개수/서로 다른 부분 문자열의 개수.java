import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Set<String> set = new HashSet<>();;
		
		int len = str.length();
		for (int i=0; i<len; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j=i; j<len; j++) {
				sb.append(str.charAt(j));
				set.add(sb.toString());
			}
		}
		
		System.out.println(set.size());
	}
}