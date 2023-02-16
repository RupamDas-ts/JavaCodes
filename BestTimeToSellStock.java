import java.util.Scanner;
public class BestTimeToSellStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] prices =  new int[7];
        System.out.print("Enter the Stock prices: ");
        for(int i=0; i<7; i++){
            prices[i] = sc.nextInt();
        }
        System.out.println(maxProfit(prices));
    }
    static int maxProfit(int[] prices) {
        /*int bp, sp, buyDay = 0;
        bp = prices[0];
        sp = prices[1];
        for(int i=0; i<prices.length; i++){
            if(prices[i]>sp){
                sp = prices[i];
                for (int j=buyDay; j<i; j++){
                    if(prices[j]<bp){
                        bp = prices[i];
                        buyDay = j;
                    }
                }
            }
        }
        return sp-bp;
    }*/
    /*
        int bp, sp, profit = 0, temp = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            bp = prices[i];
            sp = bp;
            for (int j = i + 1; j < prices.length; j++) {
                if (sp < prices[j]) {
                    sp = prices[j];
                }
            }
            temp = sp - bp;
            if (profit < temp) {
                profit = temp;
            }
        }
        return profit;

     */
        int bp = Integer.MAX_VALUE;
        int temp = 0;
        int profit = 0;
        for (int i=0; i<prices.length; i++){
            if(prices[i] < bp){
                bp = prices[i];
            }
            temp = prices[i] - bp;
            if(profit < temp){
                profit = temp;
            }
        }
        return profit;
    }
}
