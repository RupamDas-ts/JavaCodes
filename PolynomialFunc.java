import java.util.*;
public class PolynomialFunc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int degree1[] = new int[n];
        for(int i = 0; i < n; i++){
            degree1[i] = s.nextInt();
        }
        int coeff1[] = new int[n];
        for(int i = 0; i < n; i++){
            coeff1[i] = s.nextInt();
        }
        Polynomial first = new Polynomial();
        for(int i = 0; i < n; i++){
            first.setCoefficient(degree1[i],coeff1[i]);
        }
        n = s.nextInt();
        int degree2[] = new int[n];
        for(int i = 0; i < n; i++){
            degree2[i] = s.nextInt();
        }
        int coeff2[] = new int[n];
        for(int i = 0; i < n; i++){
            coeff2[i] = s.nextInt();
        }
        Polynomial second = new Polynomial();
        for(int i = 0; i < n; i++){
            second.setCoefficient(degree2[i],coeff2[i]);
        }
        int choice = s.nextInt();
        Polynomial result;
        switch(choice){
            // Add
            case 1:
                result = first.add(second);
                result.print();
                break;
            // Subtract
            case 2 :
                result = first.subtract(second);
                result.print();
                break;
            // Multiply
            case 3 :
                result = first.multiply(second);
                result.print();
                break;
        }

    }
}
class Polynomial {
    // int degree, coeff;
    HashMap<Integer, Integer> expression = new HashMap<Integer, Integer>();
    /* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
     *  then corresponding term with specified degree and value is added int the polynomial. If the degree
     *  is already present in the polynomial then previous coefficient is replaced by
     *  new coefficient value passed as function argument
     */
    public void setCoefficient(int degree, int coeff){
        if(expression.containsKey(degree)){
            int temp = expression.get(degree) + coeff;
            expression.put(degree, temp);
        }
        else{
            expression.put(degree,coeff);
        }

    }

    // Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree.
    public void print(){
        TreeMap<Integer, Integer> sorted = new TreeMap<>();

        // Copy all data from hashMap into TreeMap
        sorted.putAll(expression);

        // Display the TreeMap which is naturally sorted
        for (Map.Entry<Integer, Integer> entry : sorted.entrySet())
            System.out.print(entry.getValue()+"x"+ entry.getKey()+" ");
    }


    // Adds two polynomials and returns a new polynomial which has result
    public Polynomial add(Polynomial p){
        Polynomial addResult = new Polynomial();
        HashMap<Integer, Integer> expression2 = p.expression;
        ArrayList<Integer> keys = new ArrayList<Integer>(expression2.keySet());
        for(int i : keys){
            if(expression.containsKey(i)){
                int temp = expression2.get(i) + expression.get(i);
                addResult.setCoefficient(i, temp);
            }
            else{
                int temp = expression2.get(i);
                addResult.setCoefficient(i, temp);
            }
        }
        keys = new ArrayList<Integer>(this.expression.keySet());
        for (int i : keys) {
            if (!expression2.containsKey(i)) {
                addResult.setCoefficient(i, this.expression.get(i));
            }
        }
        return addResult;
    }

    // Subtracts two polynomials and returns a new polynomial which has result
    public Polynomial subtract(Polynomial p){
        Polynomial subResult = new Polynomial();
        // subResult.expression = this.expression;
        HashMap<Integer, Integer> expression2 = p.expression;
        ArrayList<Integer> keys = new ArrayList<Integer>(expression2.keySet());
        for (int i : keys) {
            if (expression.containsKey(i)) {
                int temp = expression.get(i) - expression2.get(i);
                subResult.setCoefficient(i, temp);
            } else {
                int temp = 0 - expression2.get(i);
                subResult.setCoefficient(i, temp);
            }
        }
        keys = new ArrayList<Integer>(this.expression.keySet());
        for(int i : keys){
            if(!expression2.containsKey(i)){
                subResult.setCoefficient(i, this.expression.get(i));
            }
        }
        return subResult;
    }

    // Multiply two polynomials and returns a new polynomial which has result
    public Polynomial multiply(Polynomial p){
        Polynomial multiResult = new Polynomial();
        HashMap<Integer, Integer> expression2 = p.expression;
        ArrayList<Integer> keys2 = new ArrayList<Integer>(expression2.keySet());
        ArrayList<Integer> keys1 = new ArrayList<Integer>(expression.keySet());
        for(int i : keys1){
            for(int j : keys2){
                int tempCoeff = expression.get(i) * expression2.get(j);
                int tempPower = i + j;
                multiResult.setCoefficient(tempPower,tempCoeff);
            }
        }
        return multiResult;
    }

}
