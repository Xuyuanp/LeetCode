import java.util.Stack;

/**
 * Created by xuyuanp on 5/31/14.
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null)
            return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (!stack.empty() && stack.pop() == '(')
                        break;
                    else
                        return false;
                case ']':
                    if (!stack.empty() && stack.pop() == '[')
                        break;
                    else
                        return false;
                case '}':
                    if (!stack.empty() && stack.pop() == '{')
                        break;
                    else
                        return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
    }
}
