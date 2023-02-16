/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.print("Enter the no of test case: ");
        int i = sc.nextInt();
        int size;
        int[] arr,revArr;
        for(int x=1; x<=i; x++){
            //System.out.print("Enter the number of elements for test case "+x);
            size = sc.nextInt();
            if(size<100){
                arr = new int[size];
                for(int y=size-1; y>=0; y--){
                    arr[y] = sc.nextInt();
                }
                for (int z =0; z<size; z++) {
                    System.out.print(arr[z]+" ");
                }
/*          for (int y =0; y<size; y++) {
                arr[y] = sc.nextInt();
            }
            //System.out.println("The array is: "+Arrays.toString(arr));
            //System.out.println("Reverse of the string is: "+ Arrays.toString(reverse(arr,size)));
            revArr = reverse(arr,size);
            for (int z =0; z<size; z++) {
                System.out.print(revArr[z]+" ");
            }
*/
            }
        }
    }
/*
    static int[] reverse(int[] arr, int size){
        int temp;
        int front = 0, back = size-1;
        for(int count=1; count<=size/2; count++){
            temp = arr[front];
            arr[front] = arr[back];
            arr[back]=temp;
            front++;
            back--;
        }
        return arr;
    }
*/
}