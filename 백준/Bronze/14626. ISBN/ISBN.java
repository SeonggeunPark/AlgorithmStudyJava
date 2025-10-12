import java.io.*;
import java.util.*;

public class Main {
	static char[] input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        int sum=0;
        int bIdx = -1;
        int m = input[input.length-1]-'0';
        for (int i=0; i<input.length-1;i++) {
        		if (input[i]=='*') {
        			bIdx = i;
        			continue;
        		}
        		if (i%2==0) {
        			sum += input[i]-'0';
        		} else {
        			sum += 3*(input[i]-'0');
        		}
        }
        
        int k = (10 - ((sum + m) % 10)) % 10;
        
        if (bIdx%2==0) {
        		System.out.println(k);
        } else {
        		System.out.println((7 * k) % 10);
        }
    }
}
