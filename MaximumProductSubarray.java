import java.util.Scanner;
import java.util.*;
public class MaximumProductSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of elements: ");
        int size = sc.nextInt();
        int[] arr =  new int[size];
        System.out.print("Enter the array: ");
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxProduct(arr));
    }
//    static int max(int a, int b){
//        return (a > b) ? a : b;
//    }
//    static int min(int a, int b){
//        return (a < b) ? a : b;
//    }
    static int maxProduct(int[] nums){
        int result = nums[0];
        int curr_max = nums[0];
        int curr_min = nums[0];

        for(int i=1; i< nums.length; i++){
            int temp = curr_max*nums[i];
            curr_max = Math.max(Math.max(nums[i],curr_max*nums[i]),curr_min*nums[i]);
            curr_min = Math.min(Math.min(nums[i],temp),curr_min*nums[i]);
            result = Math.max(result,curr_max);
        }
        return result;
    }
}
