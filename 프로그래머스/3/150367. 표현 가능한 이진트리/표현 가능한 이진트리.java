/*
자식 중 더미가 아닌게 있으면 더미 안됨.
분할정복?
*/
import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            String tree = Long.toBinaryString(numbers[i]);
            // 길이를 2^n-1개로 맞추기
            for (int j=1; j<=Math.pow(10, 15); j = (j << 1)) {
                if (tree.length() < j) {
                    while (tree.length() < j-1) {
                        tree = "0"+tree;                        
                    }
                    break;
                }
            }
            isPossible = true;
            check(0, tree.length()-1, tree);
            // 분할정복
            answer[i] = isPossible ? 1 : 0;
        }
        return answer;
    }
    boolean isPossible;
    public int check(int s, int e, String tree) {
        if (!isPossible) return 1;
        if (s>=e) {
            return tree.charAt(s)-'0' == 0 ? 0 : 1;
        }
        // 현재 root가 0이면서, 서브트리에 1인게 하나라도 있으면 불가능한 트리.
        int mid = (s+e)/2;
        int root = tree.charAt(mid)-'0';
        int left = check(s,mid-1, tree);
        int right = check(mid+1, e, tree);
        
        if (!isPossible) return 1;
        if (root==0 && (left==1 || right==1)) {
               isPossible = false;
        }
        
        if (left==0 && right==0 && root==0) return 0;
        else return 1;
    }
}