import java.util.ArrayList;
import java.util.Scanner;

public class NegativeCycle {
    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        long path[] = new long[adj.length];
        for(int i = 1;i<path.length;i++)
        {
            path[i] = Integer.MAX_VALUE;
        }
        for(int i = 1;i<=adj.length-1;i++)
        {
            for(int j = 0;j<adj.length;j++)
            {
                for(int k = 0;k<adj[j].size();k++)
                {
                    int nbr = adj[j].get(k);
                    if(path[j] + cost[j].get(k) < path[nbr])
                    {
                        path[nbr] = path[j] + cost[j].get(k);
                    }
                }
            }

        }
        for(int j = 0;j<adj.length;j++)
            {
                for(int k = 0;k<adj[j].size();k++)
                {
                    int nbr = adj[j].get(k);
                    if(path[j] + cost[j].get(k) < path[nbr])
                    {
                       return 1;
                    }
                }
            }
            return 0;
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
        System.out.println(negativeCycle(adj, cost));
    }
}


