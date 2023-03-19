package week1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnected {
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
       boolean visited[] = new boolean[adj.length];
       for(int i = 0;i<adj.length;i++)
       {
          if(!visited[i])
          {
              dfs(adj,visited,i);   
          }
       }
       ArrayList<Integer> graph2[] = new ArrayList[adj.length];
       for(int i = 0;i<graph2.length;i++)
       {
        graph2[i] = new ArrayList<>(); 
       }
       for(int i = 0;i<adj.length;i++)
       {
          for(int e : adj[i])
          {
            graph2[e].add(i);
          }
       }
       boolean visited2[] = new boolean[adj.length];
       int total = 0;
       while(!st.isEmpty())
       {
        int front = st.pop();
        if(!visited2[front])
        {
            dfs2(visited2,graph2,front);
            total++;
        }
       }
       return total;

    }
    private static void dfs2(boolean[] visited2, ArrayList<Integer>[] graph2,int front) {
        visited2[front] = true;
        for(int nbr : graph2[front])
        {
            if(!visited2[nbr])
            dfs2(visited2, graph2, nbr);
        }
    }
    static Stack<Integer> st = new Stack<>();

    private static void dfs(ArrayList<Integer>[] adj, boolean[] visited,int src) 
    {
        visited[src] = true;
        for(int nbr : adj[src])
        {
            if(!visited[nbr])
            {
                dfs(adj,visited,nbr);
            }
        }
        st.add(src);
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
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}


