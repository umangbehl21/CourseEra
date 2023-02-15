import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        if(swaps.size() !=0)
        {
            for (Swap swap : swaps) {
              out.println(swap.index1 + " " + swap.index2);
            }
        }
    }

    private void downheapify(int data[],int i) {
    int minidx = i;
    int n = data.length;
    int lc = 2 * i + 1;
    int rc = 2 * i + 2;
    if(lc < n && data[lc] < data[minidx])
    {
        minidx = lc;
    }
    if(rc < n && data[rc] < data[minidx])
    {
        minidx = rc;
    }
    if(minidx != i)
    {
        swaps.add(new Swap(i, minidx));
        int temp = data[i];
        data[i] = data[minidx];
        data[minidx] = temp;
        downheapify(data, minidx);
        
    }
    //   for (int i = 0; i < data.length; ++i) {
    //     for (int j = i + 1; j < data.length; ++j) {
    //       if (data[i] > data[j]) {
    //         swaps.add(new Swap(i, j));
    //         int tmp = data[i];
    //         data[i] = data[j];
    //         data[j] = tmp;
    //       }
    //     }
    //   }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    private void generateSwaps() {
        swaps = new ArrayList<Swap>();
        int n = data.length;
        for(int i = n/2-1;i>=0;i--)
        {
            downheapify(data,i);
        }
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

