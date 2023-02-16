import java.util.Scanner;

public class MaxSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of elements: ");
        int size = sc.nextInt();
        int[] arr =  new int[size];
        System.out.print("Enter the array: ");
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSubArray(arr));
    }
    static int maxSubArray(int[] arr){
        int max_so_far, max_ending_here;
        max_ending_here = 0;
        max_so_far = arr[0];
        for(int i=0; i<arr.length; i++){
            max_ending_here = max_ending_here + arr[i];
            if(max_ending_here > max_so_far){
                max_so_far = max_ending_here;
            }
            if(max_ending_here<0){
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }
}
