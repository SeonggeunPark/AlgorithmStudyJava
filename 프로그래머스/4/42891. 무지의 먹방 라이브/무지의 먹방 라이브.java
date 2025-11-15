import java.util.*;
/*
남은음식 수 < k => 1바퀴는 무조건 돌아야 함 전체 -1
len/k = 바퀴수
len%k = 나머지
1. 바퀴 수만큼 전체 빼주기
2. 음수인 원소는 양수인 원소에 순차로 빼주기
3. 모두 음수가 되면 -1 리턴
4. 양수가 있으면 나머지

*/

class Solution {
    public class Food implements Comparable<Food>{
        int num;
        int time;
        public Food(int num, int time) {
            this.num = num;
            this.time = time;
        }
        
        @Override
        public int compareTo(Food o) {
            return this.time - o.time;
        }
    }
    public int solution(int[] food_times, long k) {
        int len = food_times.length;
        
        long total = 0;
        for (int t : food_times) total += t;
        if (total <= k) return -1;
        
        Food[] foods = new Food[len];
        for (int i=0; i<len; i++) {
            foods[i] = new Food(i, food_times[i]);
        }
        Arrays.sort(foods);
        
        int idx = 0;
        long prevTime = 0;
        
        while (idx < len) {
            long thick = foods[idx].time-prevTime;
            int remain = len-idx;
            long spend = thick*remain;

            if (spend <= k) {
                k -= spend;
                prevTime = foods[idx].time;
            } else {
                break;
            }
            idx++;
        }
        
        List<Food> remainFoods = new ArrayList<>();
        for (int j = idx; j < len; j++) {
            remainFoods.add(foods[j]);
        }
        remainFoods.sort(Comparator.comparingInt(f -> f.num));
        
        int i = (int) (k % remainFoods.size());
        return remainFoods.get(i).num+1;
    }
}