import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        boolean visited[] = new boolean[adj.length];
            reachhelper(adj,x, visited);
            if(visited[x] && visited[y])
            {
                return 1;
            }
            else 
            {
                return 0;
            }
        }


    private static void reachhelper(ArrayList<Integer>[] adj, int src,boolean[] visited) {
        visited[src] = true;
        for(int nbr : adj[src])
        {
            if(!visited[nbr])
            {
                reachhelper(adj,nbr, visited);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

