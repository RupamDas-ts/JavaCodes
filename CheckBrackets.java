import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CheckBrackets {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        String expression = br.readLine().trim();
        System.out.println(SolutionBrackets.checkRedundantBrackets(expression));
    }
}

class SolutionBrackets {

//    public static boolean checkRedundantBrackets(String expression) {
//        if(!expression.contains("(") && !expression.contains(")") ){
//            return false;
//        }
//        Stack<Character> stack = new Stack<>();
//        int len = expression.length();
//        for(int i=0; i<len; i++){
//            if(expression.charAt(i) == ')'){
//                int count = 0;
//                if(stack.empty()){
//                    return true;
//                }
//                while(stack.peek()!='(' && !stack.isEmpty()){
//                    stack.pop();
//                    count++;
//                }
//                if(count <= 1 || stack.peek() != '('){
//                    return true;
//                }
//                stack.pop();
//            }
//            else {
//                stack.push(expression.charAt(i));
//            }
//        }
//        if(stack.isEmpty()){
//            return false;
//        }
//        return true;
//    }
//}
public static boolean checkRedundantBrackets(String expression) {
//    if(!expression.contains("(") && !expression.contains(")") ){
//        return false;
//    }
    Stack<Character> stack = new Stack<>();
    int len = expression.length();
    for(int i=0; i<len; i++){
        if(expression.charAt(i) == ')'){
            int count = 0;
//            if(stack.empty()){
//                return true;
//            }
            while(stack.peek()!='('){
                stack.pop();
                count++;
            }
            if(count <= 1){
                return true;
            }
            stack.pop();
        }
        else if(expression.charAt(i) == '('){
            while(expression.charAt(i) != ')'){
                stack.push(expression.charAt(i));
                i++;
            }
            i--;
        }
    }
//    if(stack.isEmpty()){
//        return false;
//    }
    return false;
}
}