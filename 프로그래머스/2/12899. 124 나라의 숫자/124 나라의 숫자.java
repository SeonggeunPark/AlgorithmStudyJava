import java.util.*;

class Solution {
    int[] nums = {1, 2, 4};

    public String solution(int n) {
        return makeNum(n);
    }

    public String makeNum(int n) {

        if (n <= 3) {
            return String.valueOf(nums[n - 1]);
        }

        int mod = n % 3;

        if (mod == 0) {
            return makeNum(n / 3 - 1) + "4";
        } else if (mod == 1) {
            return makeNum(n / 3) + "1";
        } else {
            return makeNum(n / 3) + "2";
        }
    }
}