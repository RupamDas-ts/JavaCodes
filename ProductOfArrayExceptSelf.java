import java.util.Arrays;
import java.util.Scanner;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter the size of the array: ");
        size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the the array Elements: ");
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Product of array except self: "+ Arrays.toString(productExceptSelf(arr)));
    }
    static int[] productExceptSelf(int[] nums){
        int[] product = new int[nums.length];
        int p=1, zeros=0, zeroInd=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zeros++;
                zeroInd = i;
            }
            if(zeros<=2){
                if(nums[i]!=0){
                    p = p*nums[i];
                }
            }else{
                break;
            }
        }
        if(zeros>1){
            return product;
        }else if(zeros == 1){
            product[zeroInd] = p;
            return product;
        }else{
            for(int j=0; j<nums.length; j++){
                product[j] = p / nums[j];
            }
            return product;
        }
    }

}
