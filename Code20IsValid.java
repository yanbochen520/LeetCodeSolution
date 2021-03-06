import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @Author: ybchen
 * @Date: 2020/11/11 17:00
 */
public class Code20IsValid {


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] chs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : chs) {
            if (isLeftParenthesis(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()||!isMatch(stack.pop(),ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatch(char left, char right) {

        return left == '(' && right == ')' || left == '[' && right == ']' || left == '{' && right == '}';

    }


    public static boolean isLeftParenthesis(char ch) {

        return ch == '(' || ch == '[' || ch == '{';

    }

    /**
     *This approach can nearly pass all the test cases,but will cause failure in such ([)] item
     * @param s
     * @return
     */

    public boolean isValidVer2(String s){
        if(s==null||s.length()==0){
            return true;
        }
        char[] chs=s.toCharArray();
        int count1=0,count2=0,count3=0;
        for(char ch:chs){
            switch (ch) {
                case '(':
                    count1 = count1 + 1;
                    break;
                case ')':
                    count1 = count1 - 1;
                    break;
                case '{':
                    count2 = count2 + 1;
                    break;
                case '}':
                    count2 = count2 - 1;
                    break;
                case '[':
                    count3 = count3 + 1;
                    break;
                case ']':
                    count3 = count3 - 1;
                    break;
            }
            if(count1<0||count2<0||count3<0){
                return false;
            }
        }
        return count1==0&&count2==0&&count3==0;
    }








}
