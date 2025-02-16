import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		for (int i=0; i<str.length()/2; i++) {
			if (str.charAt(i) != str.charAt(str.length()-i-1)) {
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(1);
	}
}
