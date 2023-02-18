package Course2.week2;
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        // long[] nextFreeTime = new long[numWorkers];
        // for (int i = 0; i < jobs.length; i++) {
        //     int duration = jobs[i];
        //     int bestWorker = 0;
        //     for (int j = 0; j < numWorkers; ++j) {
        //         if (nextFreeTime[j] < nextFreeTime[bestWorker])
        //             bestWorker = j;
        //     }
        //     assignedWorker[i] = bestWorker;
        //     startTime[i] = nextFreeTime[bestWorker];
        //     nextFreeTime[bestWorker] += duration;
        // }
        PriorityQueue<slave> pendingnodes = new PriorityQueue<>(numWorkers,new slavecomparator());
        for(int i = 0;i<numWorkers;i++)
        {
            pendingnodes.add(new slave(i));
        }
        int i = 0;
        while(i < jobs.length)
        {
            slave pop = pendingnodes.remove();
            assignedWorker[i] = pop.index;
            startTime[i] = pop.nft;
            pop.nft += jobs[i];
            pendingnodes.add(pop);
            i++;
        }
        
    }
    class slave 
    {
        int index;
        long nft; //next available time 
        public slave(int id)
        {
            this.index = id;
            this.nft = 0;
        }
        
    }
    class slavecomparator implements Comparator<slave>
    {
        public int compare(JobQueue.slave o1, JobQueue.slave o2) {
            if(o1.nft == o2.nft)
            {
                return o1.index - o2.index;
            }
            else 
            {
               return (int)(o1.nft - o2.nft);
            }
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
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
