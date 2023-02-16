import java.util.Scanner;

public class ArrayEquilibriumIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 3, 10, -10, 4, 2, 9};
        System.out.println(arrayEquilibriumIndex(arr));
    }
    public static int arrayEquilibriumIndex(int[] arr){
        //Your code goes here
        int len = arr.length, index = -1;
        if(len <= 2){
            return index;
        }
        int sumLeft = 0, sumRight = 0;
        for(int i=1; i<len; i++){
            sumRight += arr[i];
        }
        for(int i=1; i<len-1; i++){
            sumLeft = sumLeft + arr[i-1];
            sumRight = sumRight - arr[i];
            if(sumLeft == sumRight){
                return i;
            }
        }
        return -1;
    }
}
