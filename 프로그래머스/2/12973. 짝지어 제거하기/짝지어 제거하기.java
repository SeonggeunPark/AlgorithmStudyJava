import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<Character>();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek()!=c) stack.push(c);
            else stack.pop();
        }
        return stack.size()>0 ? 0 : 1;
    }
}