import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramChecking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String1: ");
        String s1 = sc.nextLine();
        System.out.println("Enter the String2: ");
        String s2 = sc.nextLine();
        System.out.println(isAnagram(s1,s2));
    }
    static boolean isAnagram(String s, String t) {
//        if(s.length()==0 && t.length()==0)
//            return true;
//        if(s.length() == 0 || t.length() == 0)
//            return false;
//        if(s.length() != t.length())
//            return false;
//
//        Map<Character, Integer> dict = new HashMap<>();
//        for(char c : s.toCharArray())
//            dict.put(c,dict.getOrDefault(c,0)+1);
//
//        int count;
//        for (char c : t.toCharArray()){
//            count = dict.getOrDefault(c,0);
//            if(count==0)
//                return false;
//            dict.put(c,count-1);
//        }
//        return true;
        if(s.length()==0 && t.length()==0)
            return true;
        if(s.length() == 0 || t.length() == 0)
            return false;
        if(s.length() != t.length())
            return false;
        int[] arr = new int[26];
        for(int i =0; i < s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i =0; i < t.length(); i++){
            if(arr[t.charAt(i)-'a']==0)
                return false;
            arr[t.charAt(i)-'a']--;
        }
        return true;
    }
}
