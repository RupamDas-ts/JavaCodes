//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


import java.io.*;
import java.util.*;
public class SumOfMaxMinOfArray {
        public static void main (String[] args) {

            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();
            while(t-- > 0)
            {
                int n = sc.nextInt();
                int a[] = new int[n + 1];

                for(int i=0;i<n;i++){
                    a[i] = sc.nextInt();
                }

                Solution ob = new Solution();

                System.out.println(ob.findSum(a,n));
            }

        }
    }
// } Driver Code Ends


//User function Template for Java

    class Solution
    {
        public static int findSum(int A[],int N)
        {
            //code here
            MaxMinTournamentMethod obj =
                    new MaxMinTournamentMethod();
            int max = obj.getMinMax(A,0,N-1).max;
            int min = obj.getMinMax(A,0,N-1).min;
            return max+min;
        }
    }

