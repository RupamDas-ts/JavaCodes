import java.util.*;
public class ArraySizeReduction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter the size of the array: ");
        size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the the array Elements: ");
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("The no of integers in the set to remove: "+minSetSize(arr));
    }
    public static int minSetSize(int[] arr){
        Arrays.sort(arr);
        ArrayList<Integer> flags = new ArrayList<>();
        //flags.add(0);
        int temp = arr[0],count = 1;
        for(int i=1; i<arr.length; i++){
            if(temp < arr[i]){
                temp = arr[i];
                flags.add(count);
                count = 1;
            }else {
                count+=1;
            }
        }
        flags.add(count);
        flags.sort(Comparator.reverseOrder());

        int len=flags.get(0),nos=1;
        for(int i=1; i<flags.size(); i++){
            if(len >= arr.length/2){
                return nos;
            }
            len += flags.get(i);
            nos++;
        }
        //System.out.println(flags);
        return nos;
    }
}
