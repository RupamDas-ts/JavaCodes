import java.util.Locale;
import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str ={"flower","flow","flight"};
        System.out.println("Longest common Prefix: "+longestCommonPrefix(str));
    }
    static String longestCommonPrefix(String[] strs){
        if(strs.length == 1)
            return strs[0];
        String PreFix = "";
        String temp1 = strs[0];
        for(int i = 1; i< strs.length; i++){
            String temp2 = strs[i];
            PreFix = "";
            if(temp1 == null){
                return "";
            }
            for(int j=0; j<temp1.length() && j<temp2.length(); j++){
                if(temp1.charAt(j) == temp2.charAt(j)){
                    PreFix = PreFix+temp1.charAt(j);
                }else {
                    break;
                }
            }
            temp1 = PreFix;
        }
        return PreFix;
    }
}
