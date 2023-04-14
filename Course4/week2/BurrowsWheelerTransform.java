package Course4.week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BurrowsWheelerTransform {  // BWT is made by recording all the rotations of the strings the appending first character to the last or replacing last character to first position after getting all the strings 
                                        //the last alphabets of all the strings is bwt because it has most repetition of characters in it bwt is used in pattern matching along with first last property to find a specific pattern 
    static class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
    }

    String BWT(String text) {

        StringBuilder ms1 = new StringBuilder(text);  //String builder is muttable string you can add and delete in it
        List<String> rotations = new LinkedList<>();
        rotations.add(text);

        for (int i = 0; i < text.length() - 1; i++) {
            ms1.append(ms1.charAt(0));
            ms1.delete(0, 1);
            rotations.add(ms1.toString());  //adding all the cyclic rotations of the strings 
        }

        Collections.sort(rotations);
        StringBuilder bwt = new StringBuilder();
        for (String st : rotations) {
            bwt.append(st.charAt(text.length() - 1)); // appending the last character of all the strings which is our bwt 
        }

        return bwt.toString();
    }

    static public void main(String[] args) throws IOException {
        new BurrowsWheelerTransform().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        System.out.println(BWT(text));
    }
}