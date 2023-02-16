import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Initial array is: "+Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println("The next permutation is: "+Arrays.toString(arr));
    }

    static void nextPermutation(int[] nums) {
        int pivot, flag, successor = 0;
        flag = 0;
        //flag is where the non-increasing part of the array starts
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                flag = i;
            }
        }
        //System.out.println("Flag: "+flag);
        //pivot is the element before non-increasing part
        pivot = flag - 1;
        //System.out.println("Pivot: "+pivot);
        //If the array is already in the last permutation then the whole array
        //is in decreasing order, so pivot will not exist.
        if (pivot != -1) {
            //Successor is the next greater element of the pivot that is present in the non-increasing part
            for (int j = nums.length - 1; j > pivot; j--) {
                if (nums[pivot] < nums[j]) {
                    successor = j;
                    break;
                }
            }
            swap(nums, pivot, successor);
        }
        //reverse the non-increasing part or the whole array if the flag is 0 i.e. the array is last permutation
        reverse(nums, flag);
    }
    static void swap(int[] nums, int pivot, int successor){
        int temp;
        temp = nums[pivot];
        nums[pivot] = nums[successor];
        nums[successor] = temp;
    }
    static void reverse(int[] nums,int flag){
        int end = nums.length-1;
        while(flag<end){
            swap(nums, flag++, end--);
        }
    }
}

