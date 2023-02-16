import java.util.Arrays;
import java.util.Scanner;

public class RepeatAndMissingNumberArray {
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
        //repeatedNumber(arr);
        System.out.println(Arrays.toString(repeatedNumber(arr)));
    }
    static int[] repeatedNumber(final int[] A){
        int[] nos = new int[2];
        int indicator = 0, sum = 0;
        for(int i = 0; i<A.length-2; i++){
            //temp = A[i];
            if(indicator == 0){
                for(int j=i+1; j<A.length-1; j++){
                    if(A[i]==A[j]){
                        nos[0] = A[j];
                        System.out.println(A[j]);
                        break;
                    }
                    indicator = 1;
                }
            }
            sum = sum + A[i];
            System.out.println(sum);
        }
        sum = sum - nos[0];
        sum = (A.length*(A.length+1))/2 - sum;
        nos[1] = sum;
        return nos;
    }
}
