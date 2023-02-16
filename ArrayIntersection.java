import java.util.Arrays;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] arr1 = {3,1,2,3};
        int[] arr2 = {3,4,2,2,3};
        intersection(arr1,arr2);
    }
    public static void intersection(int[] arr1, int[] arr2) {
        //Your code goes here
        int len1 = arr1.length;
        int len2 = arr2.length;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0, j=0; i<len1 && j<len2;){
            if(arr1[i] == arr2[j]){
                System.out.print(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i]>arr2[j]){
                j++;
            }
            else{
                i++;
            }
        }
    }
}
