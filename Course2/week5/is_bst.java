package Course2.week5;
import java.util.*;
import java.io.*;

public class is_bst {

    static class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static class IsBST {
        static class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            // Implement correct algorithm here
            if(nodes==0){
                return true;
            }
            return isBSTHelper(0,Integer.MIN_VALUE,Integer.MIN_VALUE);
        }

        boolean isBSTHelper(int x,int Min,int Max){
            if(x==-1){
                return true;
            }
            if(Min!=Integer.MIN_VALUE && tree[x].key<=Min){
                return false;
            }
            if(Max!= Integer.MIN_VALUE && tree[x].key>=Max){
                return false;
            }
            boolean res = isBSTHelper(tree[x].left,Min,tree[x].key);
            boolean res1 = isBSTHelper(tree[x].right,tree[x].key,Max);
            return res && res1;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}

