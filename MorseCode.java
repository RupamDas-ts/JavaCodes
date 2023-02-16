import java.util.*;

public class MorseCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of words: ");
        int size = sc.nextInt();
        String[] words = new String[size];
        String temp=null;
        for(int i=0;i<size;i++){
            System.out.print("Enter the "+i+" th word: ");
            temp = sc.next();
            temp = temp.replaceAll("\\s",""); //removing white spaces
            temp = temp.toLowerCase();  //turning to lower case
            words[i] = temp;
            //System.out.println("");
        }
        System.out.println("No of unique morse code: "+uniqueMorseRepresentations(words));
    }
    public static int uniqueMorseRepresentations(String[] words){
        int count=0;

        int size = words.length;
        String word,morse;
        Set<String> morse_Set = new HashSet<String>();

        for(int i=0; i<size; i++){
            word = words[i];
            morse = getMorse(word);
            morse_Set.add(morse);
        }

        count = morse_Set.size();
        //System.out.println(morse_Set);
        return count;
    }
    public static String getMorse(String w){
        int size1 = w.length();
        String temp1, morse1 = "";
        for(int i = 0; i< size1; i++){
            temp1 = charToMorse(w.charAt(i));
            morse1 = morse1 + temp1;
        }
        return morse1;
    }
     public static String charToMorse(char letter){
        switch (letter){
            case 'a':
                return ".-";
            case 'b':
                return "-...";
            case 'c':
                return "-.-.";
            case 'd':
                return "-..";
            case 'e':
                return ".";
            case 'f':
                return "..-.";
            case 'g':
                return "--.";
            case 'h':
                return "....";
            case 'i':
                return "..";
            case 'j':
                return ".---";
            case 'k':
                return "-.-";
            case 'l':
                return ".-..";
            case 'm':
                return "--";
            case 'n':
                return "-.";
            case 'o':
                return "---";
            case 'p':
                return ".--.";
            case 'q':
                return "--.-";
            case 'r':
                return ".-.";
            case 's':
                return "...";
            case 't':
                return "-";
            case 'u':
                return "..-";
            case 'v':
                return "...-";
            case 'w':
                return ".--";
            case 'x':
                return "-..-";
            case 'y':
                return "-.--";
            case 'z':
                return "--..";
            default:
                return null;
        }
    }
}
