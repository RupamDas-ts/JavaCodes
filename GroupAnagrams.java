import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        char[] temp;
        for(int i=0; i< strs.length; i++){
            temp = strs[i].toCharArray();
            Arrays.sort(temp);
            if(!map.containsKey(Arrays.toString(temp))){
                map.put(Arrays.toString(temp),new ArrayList<>());
            }
            map.get(Arrays.toString(temp)).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
