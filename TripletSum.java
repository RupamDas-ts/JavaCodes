import java.util.Arrays;

public class TripletSum {
    public static void main(String[] args) {
        int[] arr = {2, -5, 8, -6, 0, 5, 10, 11, -3};
        System.out.println(tripletSum(arr,10));
    }
    public static int tripletSum(int[] arr, int num){
        int len = arr.length;
        int sum = 0, count = 0;
        if(len < 3){
            return 0;
        }
        Arrays.sort(arr);
        for(int i=0; i<len-2; i++){
            sum = num - arr[i];
            int start = i+1;
            int end = len-1;
            while(start < end){
                if(arr[start] + arr[end] == sum){
                    count++;
                    if(arr[start] == arr[start+1]){
                        count++;
                    }
                    if(arr[end] == arr[end-1]){
                        count++;
                    }
                    start++;
                    end--;
                }else if(arr[start] + arr[end] < sum){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return count;
    }
}
