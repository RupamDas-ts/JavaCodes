import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinBracketReversal {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        System.out.println(MinBracketReversalSolution.countBracketReversals(br.readLine().trim()));

    }
}

 class MinBracketReversalSolution {

    public static int countBracketReversals(String input) {
        //Your code goes here
        Stack<Character> stack = new Stack<>();
        int len = input.length();
        if(len == 1){
            return -1;
        }
        for(int i = 0; i<len; i++){
            if(input.charAt(i) == '{'){
                stack.push(input.charAt(i));
            }
            else if(input.charAt(i) == '}'){
                stack.pop();
            }
        }
        if(stack.size()%2 == 0){
            return stack.size()/2;
        }
        return -1;
    }

}