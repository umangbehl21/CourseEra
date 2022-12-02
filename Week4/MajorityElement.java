package Week4;
import java.util.*;
import java.io.*;

public class MajorityElement {
    private static void getMajorityElement(int[] a, int left, int right) {
        if(right <= left)
        {
            return;
        }
       int mid = (left + right)/2;
       getMajorityElement(a, left, mid);
       getMajorityElement(a, mid + 1, right);
       mergeTwoSorted(a,left,right);
    }
    private static void mergeTwoSorted(int a[],int left,int right)
    {
        int mid = (left + right)/2;
        int i = left;
        int j = mid + 1;
        int ans[] = new int[right - left + 1];
        int k = 0;
        while(i <= mid && j <= right)
        {
            if(a[j] > a[i])
            {
                ans[k] = a[i];
                k++;
                i++;
            }
            else 
            {
                ans[k] = a[j];
                k++;
                j++;
            }
        }
        while(i <= mid)
        {
            ans[k] = a[i];
            i++;
            k++;
        }
        while(j <= right)
        {
            ans[k] = a[j];
            j++;
            k++;
        }
        for(int si = 0;si<ans.length;si++)
        {
            a[si + left] = ans[si];
        }



    }
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        getMajorityElement(a, 0, a.length - 1);
        for(int i = 0;i<a.length;i++)
        {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> elem : map.entrySet())
        {
            if(elem.getValue() > max)
            {
                max = elem.getValue();
            }
        }
        if(max > a.length/2)
        {
            System.out.println(1);
        }
        else 
        {
            System.out.println(0);
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

