import java.util.*;

public class GroupingCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size;
        System.out.print("Enter the number of cards: ");
        size = sc.nextInt();
        int[] cards = new int[size];
        for(int i=0; i<size; i++){
            cards[i] = sc.nextInt();
        }
        System.out.println("The number of groups: "+hasGroupsSizeX(cards));
    }
    public static boolean hasGroupsSizeX(int[] deck) {
        System.out.println(Arrays.toString(deck));
        Arrays.sort(deck);
        System.out.println(Arrays.toString(deck));
        int size = deck[deck.length-1];
        System.out.println(size);
        int[] noc = new int[size+1];
        //int temp;
        for(int i:deck){
            //temp = deck[i];
            noc[i]++;
        }
        System.out.println(Arrays.toString(noc));
        int gcd = -1;
        for(int j=0; j<noc.length; j++){
            if(noc[j]>0) {
                if (gcd == -1) {
                    gcd = noc[j];
                } else {
                    gcd = gcd(gcd, noc[j]);
                }
            }
        }
        System.out.println(gcd);
        if(gcd>1){
            return true;
        }
        return false;
    }
    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
