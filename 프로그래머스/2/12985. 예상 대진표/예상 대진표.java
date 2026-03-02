import java.util.*;
// 오른쪽부터 같지않은 자리수만큼 라운드 거친다.
class Solution
{
    public int solution(int n, int a, int b)
    {
        String A = treatNum(Integer.toBinaryString(a-1));
        String B = treatNum(Integer.toBinaryString(b-1));
        
        for (int i=0; i<20; i++) {
            if (A.charAt(i)!=B.charAt(i)) {
                return 20-i;
            }
        }

        return 0;
    }
    public String treatNum(String n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<20-n.length(); i++) {
            sb.append('0');
        }
        return sb.toString()+n;
    }
}