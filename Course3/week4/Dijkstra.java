package week4;
import java.util.*;

public class Dijkstra {
   static class pair implements Comparable<pair>
    {
        int src = 0;
        int wsf = 0;
        public pair(int src,int wsf)
        {
            this.src = src;
            this.wsf = wsf;
        }
        public int compareTo(pair p)
        {
            return this.wsf - p.wsf;
        }
    }
    private static long distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pair p = new pair(s, 0);
        boolean visited[] = new boolean[adj.length];
        pq.add(p);
        while(!pq.isEmpty())
        {
            pair front = pq.remove();
            visited[front.src] = true;
            if(front.src == t)
            {
                return front.wsf;
            }
            int i = 0;
            for(int nbr : adj[front.src])
            {
                if(!visited[nbr])
                {
                    pair p1 = new pair(nbr, front.wsf + cost[front.src].get(i));
                    pq.add(p1);
                }
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

