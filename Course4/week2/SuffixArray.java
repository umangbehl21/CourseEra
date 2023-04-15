package Course4.week2;

import java.util.*;
import java.io.*;

public class SuffixArray {  //suffix array holds starting position of each suffix

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

    static class Suffix implements Comparable<Suffix> {
        String suffix;
        int startidx;

        Suffix(String suffix, int startidx) {
            this.suffix = suffix;
            this.startidx = startidx; //startidx is the startindex where suffix is starting 
        }

        @Override
        public int compareTo(Suffix o) {
            return suffix.compareTo(o.suffix);  //comparing on the basis of string 
        }
    }

    // Build suffix array of the string text and
    // return an int[] ansult of the same length as the text
    // such that the value ansult[i] is the index (0-based)
    // in text where the i-th lexicographically smallest
    // suffix of text starts.
    public int[] computeSuffixArray(String text) {
        List<Suffix> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            list.add(new Suffix(text.substring(i), i));  //making a suffix by adding current text in it and its index of occurence then sorting the string we have to return the index at which that suffix was started
        }
        Collections.sort(list);
        int[] ans = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            ans[i] = list.get(i).startidx;   //startidx is the startindex where suffix is starting 
        }
        return ans;
    }


    static public void main(String[] args) throws IOException {
        new SuffixArray().run();
    }

    public void print(int[] x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        int[] SuffixArray = computeSuffixArray(text);
        print(SuffixArray);
    }
}

