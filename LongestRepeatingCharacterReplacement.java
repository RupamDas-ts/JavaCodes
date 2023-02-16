import java.util.HashMap;
import java.util.Scanner;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String s = sc.nextLine();
        System.out.println("Enter the no of replacements: ");
        int k = sc.nextInt();
        System.out.println(characterReplacement(s,k));
    }
    static int characterReplacement(String s, int k) {
        int max_f = 0, max_length = 0, l = 0;
        int[] count = new int[26];
        for(int r = 0; r<s.length(); r++){
            count[s.charAt(r)-'A']++;
            int b = count[s.charAt(r) - 'A'];
            max_f = Math.max(max_f, b); //Max Frequency char

            while(r-l+1-max_f > k) {
                count[s.charAt(l)-'A']--;
                l++;
            }

            max_length = Math.max(max_length, r-l+1);
        }
        return max_length;
    }
}
