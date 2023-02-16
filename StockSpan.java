import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StockSpan {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }

        String[] values = br.readLine().trim().split(" ");

        for(int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(values[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] input = takeInput();

        int[] output = SolutionStockSpan.stockSpan(input);

        printArray(output);

    }
}

class SolutionStockSpan {

    public static int[] stockSpan(int[] price) {
        //Your code goes here
        int len = price.length;
        if(len == 0){
            return price;
        }
        int[] span = new int[len];
        span[0] = 1;
        if(len == 1){
            return span;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i<len; i++){
            int count = 1, j = i-1;
            while(j>=0 && price[i] > price[j]){
                count++;
                j--;
            }
            span[i] = count;
        }
        return span;
    }

}