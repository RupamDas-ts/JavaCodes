import java.util.Locale;
import java.util.Scanner;

public class StringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String sentence = sc.nextLine();
        System.out.println(isPalindrome(sentence));
    }
    static boolean isPalindrome(String s){
        s = s.toLowerCase();
        char startC,endC;
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            startC = s.charAt(start);
            endC = s.charAt(end);
            if(!Character.isLetterOrDigit(startC))
                start++;
            else if(!Character.isLetterOrDigit(endC))
                end--;
            else{
                if(startC!=endC)
                    return false;
                start++;
                end--;
            }
        }

        return true;
    }
}
