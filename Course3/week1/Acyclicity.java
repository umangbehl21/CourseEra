package week1;
import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        boolean visited[] = new boolean[adj.length];
        boolean dfsvisited[] = new boolean[adj.length];
        boolean check[] = new boolean[1];
       for(int i = 0;i< adj.length;i++)
       {
          for(int src : adj[i])
          {
             if(visited[src] == false)
             {
                checkcycle(adj,src,visited,dfsvisited,check);
             }
          }
       }
       if(check[0])
       {
          return 1;
       }
       else 
         return 0;
    }

    private static void checkcycle(ArrayList<Integer>[] adj, int src, boolean[] visited, boolean[] dfsvisited,boolean check[]) 
    {
        visited[src] = true;
        dfsvisited[src] = true;
        for(int nbr : adj[src])
        {
            if(visited[nbr] && dfsvisited[nbr])
            {
                 check[0] = true;
                 return;
            }
            else if(!visited[nbr])
            {
                checkcycle(adj, nbr, visited, dfsvisited,check);
            }
        }
        dfsvisited[src] = false;

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
        }
        System.out.println(acyclic(adj));
    }
}

