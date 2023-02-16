import java.util.*;
//import java.util.Map.Entry;
public class PermutationString {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(isPermutation(str1,str2));
    }
    public static boolean isPermutation(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 != len2){
            return false;
        }
        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
        for(int i=0; i<len1; i++){
            if(hashMap.containsValue(str1.charAt(i))){
                hashMap.put(str1.charAt(i),hashMap.get(str1.charAt(i))+1);
            }
            else{
                hashMap.put(str1.charAt(i),1);
            }
        }
        for(int i=0; i<len2; i++){
            if(hashMap.containsKey(str2.charAt(i))){
                if(hashMap.get(str2.charAt(i))==0){
                    return false;
                }
                hashMap.put(str2.charAt(i),hashMap.get(str2.charAt(i))-1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
