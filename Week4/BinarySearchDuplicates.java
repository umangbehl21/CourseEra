package Week4;
import java.io.*;
import java.util.*;

public class BinarySearchDuplicates {

    static int binarySearch(int[] a, int start,int end,int find) 
    {
        if(start > end)
        {
            return -1;
        }
        int mid = (start + end)/2;
        if(a[mid] == find)
        {
            int j = mid;
            while(j >= 0 && a[j] == find)  //for knowing the index of the first occurence of number to find as we have to find first occurence it will always be found in the region behind the find so until we are getting the same element as find we decrement until we get some distinct element and then we return index + 1 which will be the first occurence of our find
            {
                j = j-1;
            }
            return j + 1;
        }
        else if(a[mid] > find)
        {
            return binarySearch(a, start, mid-1, find);
        }
        else 
        {
            return binarySearch(a, mid + 1, end, find);
        }

    }
    static int BinaryHelper(int a[],int find)
    {
        return binarySearch(a, 0,a.length-1,find);
    }
    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(BinaryHelper(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
