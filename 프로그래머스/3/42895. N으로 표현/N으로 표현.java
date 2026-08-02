import java.util.*;
/*
*/
class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] sets = new Set[9];
        for (int i=1; i<=8; i++) {
            sets[i] = new HashSet<>();
            sets[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
            for (int div = 1; div<=i/2; div++) {
                int l = div;
                int r = i-div;
                for (int left:sets[l]) {
                    for (int right:sets[r]) {
                        sets[i].add(left+right);
                        if (left-right>0)
                            sets[i].add(left-right);
                        else
                            sets[i].add(right-left);
                        sets[i].add(left*right);
                        if(right!=0 && left%right==0)
                            sets[i].add(left/right);
                        if(left!=0 && right%left==0)
                            sets[i].add(right/left);
                    }
                }
            }
            if(sets[i].contains(number)) return i;            
    }
    return -1;
}
}