import java.util.Scanner;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.print("Enter the size: ");
        size = sc.nextInt();
        System.out.println("Enter the array element: ");
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target: ");
        int target = sc.nextInt();
        System.out.println(search(arr,target));
    }
    static int search(int[] nums, int target){
        int n = nums.length;
        int lo = 0, hi = n-1, mid;
        while(lo<hi){
            mid=(hi+lo)/2;
            if(nums[mid]>nums[hi])
                lo = mid+1;
            else
                hi = mid;
        }
        int rot = lo, realmid;
        System.out.println(rot);
        hi = n-1;
        lo = 0;
        while(lo<=hi){
            mid = (hi+lo)/2;
            realmid = (mid+rot)%n;
            if(nums[realmid]==target)
                return realmid;
            if(nums[realmid]>target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
        }

        /*
        if(nums[0] == target){
            return 0;
        }
        if(nums[nums.length-1] == target){
            return nums.length-1;
        }
        int index = divide_conquer_search(nums,0,nums.length-1,target);
        return index;
         */

    /*
    static int divide_conquer_search(int[] nums,int start,int end,int target){
        if(start<end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[start] < target) {
                divide_conquer_search(nums,start,mid,target);
            }
            if(nums[end] > target){
                divide_conquer_search(nums,mid,end,target);
            }
        }
        return -1;
    }
     */
}
