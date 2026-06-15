import java.util.*;

class Solution {
    public int solution(int[] nums) {     
        Map<Integer, Integer> dict = new HashMap<>();
        for (int num : nums) dict.put(num, dict.getOrDefault(num, 0)+1);
        return dict.keySet().size()>=nums.length/2 ? nums.length/2 : dict.keySet().size(); 
    }
}