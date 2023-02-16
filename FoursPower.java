import java.util.Scanner;

public class FoursPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n;
        n = sc.nextInt();
        isPowerOfFour(n);
    }
    public static boolean isPowerOfFour(int n) {
        if(n==1){
            return true;
        }else if(n < 4){
            return false;
        }else{
            int t = getPower(n);
            System.out.println(t);
            if(t==1){
                return true;
            }
        }
        return false;
    }
    public static int getPower(int n){
        if(n == 1){
            return 1;
        }
        if(n%4 == 0){
            return getPower(n/4);
            //System.out.println(n);
        }
        return 0;
    }
}
