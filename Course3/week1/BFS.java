package week1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[adj.length];
        queue.add(s);
        int size = 0;
        int level = 0;
        while(!queue.isEmpty())
        {
            size = queue.size();
            while(size > 0)
            {
                int front = queue.remove();
                visited[front] = true;
                if(front == t)
                {
                    return level;
                }
                for(int nbr : adj[front])
                {
                    if(!visited[nbr])
                    {
                        queue.add(nbr);
                    }
                }
                size--;
            }
            level++;

        }
        return -1;

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
        System.out.println(distance(adj, x, y));
    }
}

