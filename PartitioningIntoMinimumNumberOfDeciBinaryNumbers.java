import java.util.*;
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the decimal number: ");
        String deci;
        deci = sc.next();
        System.out.println("The min no of deci-binary needed: "+minPartitions(deci));
    }
    public static int minPartitions(String n){
        int max=0,temp;
//        for(int i=0; i<n.length(); i++){
//            temp = Integer.parseInt(String.valueOf(n.charAt(i)));
//            if(temp>max){
//                max = temp;
//            }
//        }
        for(int i=0; i<n.length(); i++){
            max = Math.max(max,n.charAt(i)-'0');
        }
        return max;
    }
}
