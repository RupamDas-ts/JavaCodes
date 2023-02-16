import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String s = sc.nextLine();
        System.out.println(isValid(s));
    }
    static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stk.push(c);
            }
            if(c == ')' || c == '}' || c == ']'){
                if(stk.empty())
                    return false;
                if(c == ')' && stk.peek() == '('){
                    stk.pop();
                }
                else if(c == '}' && stk.peek() == '{'){
                    stk.pop();
                }
                else if(c == ']' && stk.peek() == '['){
                    stk.pop();
                }
                else
                    return false;
            }
        }
        return stk.empty();
    }
}
