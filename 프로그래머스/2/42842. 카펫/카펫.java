/*
    3가지 조건 이용
    1) 둘레 길이 = (b가로+b세로)*2 = brown + 4
    2) yellow = yellow 넓이 = y가로 * y세로 = (b가로-2) * (b세로-2)
    3) b가로 >= b세로
*/
class Solution {
    public int[] solution(int brown, int yellow) {
        // b가로 + b세로 (갈색 타일은 항상 짝수임)
        int bSum = (brown+4) / 2;
        
        int height = bSum / 2;
        int width = bSum - height;
        
        while (height > 0 && yellow != (width-2) * (height-2)) {
            width += 1;
            height -= 1;
        }
        
        return new int[]{width, height};
    }
}