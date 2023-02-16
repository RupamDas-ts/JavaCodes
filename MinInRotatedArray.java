import java.util.Scanner;

public class MinInRotatedArray {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size;
//        System.out.print("Enter the size: ");
//        size = sc.nextInt();
//        System.out.println("Enter the array element: ");
//        int[] arr = new int[size];
//        for(int i=0; i<size; i++) {
//            arr[i] = sc.nextInt();
//        }
        int[] arr = {3,4,5,1,2};
        System.out.println("The smallest element: "+findMin(arr));
    }
    static int findMin(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int mid;
        while(left<right){
            mid = (left+right)/2;
            if(nums[mid]>nums[right]){
                //smallest lies in the left part
                 left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}
