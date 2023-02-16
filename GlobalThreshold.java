import java.util.ArrayList;

public class GlobalThreshold {
    public static void main(String[] args) {
        int[] intensity = {0,0,0,0,6,1,5,0,2,2,11,7,0,6};
        float Told,Tnew = 0.0F;
        int sum = 0;
        for(int i : intensity){
            sum = sum + i;
        }
        Tnew = sum/intensity.length;
        //System.out.println(Tnew);
        do{
            int g1 = 0, g2 = 0;
            float m1,m2;
            for(int j =0;j<intensity.length;j++){
                if(j <= Tnew){
                    g1 = g1+intensity[j];
                }
                else {
                    g2 = g2+intensity[j];
                }
            }
            System.out.println(g1);
            System.out.println(g2);
            m1 = Tnew/g1;
            //System.out.println("m1= "+m1);
            int t = (int) (intensity.length-1-Tnew);
            //System.out.println("t= "+t);
            m2 = (float)t/g2;
            //System.out.println("m2= "+m2);
            Told = Tnew;
            Tnew = (float) (0.5*(m1+m2));
        }while (Math.abs(Told - Tnew)>=1);
        System.out.println(Told);
        System.out.println(Tnew);
    }
}
