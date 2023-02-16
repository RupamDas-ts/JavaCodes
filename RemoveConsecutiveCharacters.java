import java.util.Scanner;

public class RemoveConsecutiveCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String s = sc.nextLine();
        System.out.println(removeConsecutiveCharacter(s));
    }
    static String removeConsecutiveCharacter(String S){
        int n = S.length();
        StringBuilder New = new StringBuilder();
        New.append(S.charAt(0));
        char temp = S.charAt(0);
        for (int i = 1; i<n; i++){
            if(temp != S.charAt(i)){
                temp = S.charAt(i);
                New.append(temp);
            }
        }
        return New.toString();
    }
}
