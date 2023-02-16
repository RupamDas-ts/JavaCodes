import java.util.Scanner;

public class PairOfGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {3,4,5,1,2};
        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();
        System.out.println(findPair(arr,target));
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
        return left;
    }

    static boolean findPair(int[] arr, int target){
        int minIndex, maxIndex;
        int n = arr.length;
        minIndex = findMin(arr);
        //System.out.println(minIndex);
        maxIndex = minIndex - 1;
        while (maxIndex != minIndex){
            if(arr[maxIndex]+arr[minIndex] == target){
                return true;
            }
            if(arr[maxIndex]+arr[minIndex]>target){
                maxIndex = (maxIndex-1+n)%n;
            }
            else
                minIndex = (minIndex+1)%n;
        }
        return false;
    }
}
