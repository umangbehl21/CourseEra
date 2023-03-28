package Course3.week5;
import java.util.*;

public class ConnectingPoints {

    static class Point {
        public int id;
        public int x;
        public int y;

        public Point(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    static class Edge implements Comparable<Edge> {
        public Point v;
        public Point w;
        public double wt;

        public Edge(Point v, Point w) {
            this.v = v;
            this.w = w;
            this.wt = Math.sqrt((w.x - v.x) * (w.x - v.x) + (w.y - v.y) * (w.y - v.y));
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.wt, o.wt);
        }
    }

    static class UnionFind {              // union find data type

        private final int[] parent;  // parent[i] = parent of i
        private final byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)

        public UnionFind(int n) {
            parent = new int[n];
            rank = new byte[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x)  //2<-3<-4 if we find parent of 4 then it will first call on 3 which is its parent and then 3 wull call on 2 which is 3's parent then 2 will be returned now on the parent[3] = 2 is set as its parent and 2 will be returned and at the end parent[4] = 2 will become direct parent of 4 which was earlier 3 thus making the time complexity linear 
        { 
            if(parent[x] != x)
            {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int a,int b)
        {
            int x = find(a);
            int y = find(b);
            if(x == y) 
            {
                return;
            }  
            if(rank[x] > rank[y])  //when height of node is greater than other make it parent of the shorter tree as if we add shorter tree in longer height lh remain unchanged example 1->2 and 3 now if i make 3 parent of 1 then earlier 2 have to call above 1 height to reach 1 now it will call on 2 height to reach 3 increasing the time on the other hand if i make 1 as parent of 3 then 2 was previously have to call for 1 height and now also it has to call for 1 height so time didnt change so shorter height can accomodate under long tree
            {
                parent[y] = x;
            }
            else if(rank[y] > rank[x])
            {
               parent[x] = y;
            }
            else  //when the height of both the tree are equal then make anyone of them parent but if we are making parent to a node icrease its rank by 1 as the height of the tree will increase on addition of children example on making union of 1,2 they both have height 0 now if i make 1 as parent then 2 will come under it and become its part thus 1 have increase in height by 1
            {
                parent[y] = x;
                rank[x]++;
            }
        }
    }

    private static double minimumDistance(int[] x, int[] y) {
        int n = x.length;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                if (i != j) {
                    pq.add(new Edge(new Point(x[i], y[i], i), new Point(x[j], y[j], j)));
                }
            }
        }

        double wt = 0.0;
        UnionFind unionfind = new UnionFind(n);

        while (!pq.isEmpty()) {
            Edge e = pq.remove();
            Point v = e.v;
            Point w = e.w;
            if (unionfind.find(v.id) != unionfind.find(w.id)) {
                unionfind.union(v.id, w.id);
                wt += e.wt;
            }
        }

        return wt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.format("%.7f", minimumDistance(x, y));
    }
}