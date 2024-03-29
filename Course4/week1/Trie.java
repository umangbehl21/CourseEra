package Course4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Trie {
    class FastScanner {
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

    List<Map<Character, Integer>> buildTrie(String[] patterns) {
        List<Map<Character, Integer>> trie = new ArrayList<Map<Character, Integer>>();
        Map<Character,Integer> root = new LinkedHashMap<>();
        trie.add(root);
        for(String pattern : patterns) 
        {
            Map<Character,Integer> cur = root;
            for(int i = 0;i<pattern.length();i++)
            {
                Character curch = pattern.charAt(i);
                Set<Character> checkincurr = cur.keySet();
                if(checkincurr.contains(curch)) //if our current root contains current character in the trie then we don't have to make new node just move to that already inserted character 
                {
                    cur = trie.get(cur.get(curch));
                }
                else 
                {
                    Map<Character,Integer> toadd = new LinkedHashMap<>();
                    trie.add(toadd);
                    cur.put(curch, trie.size()-1); //when first node after root is added trie size is already 1 as root is added outside the loop and then adding another node after root node its index should be 1 so first newnode is added size of trie then become 2 then size - 1 index is allocated to the newnode
                    cur = toadd;

                }

            }

        }
        return trie;
    }

    static public void main(String[] args) throws IOException {
        new Trie().run();
    }

    public void print(List<Map<Character, Integer>> trie) {
        for (int i = 0; i < trie.size(); ++i) {
            Map<Character, Integer> node = trie.get(i);
            for (Map.Entry<Character, Integer> entry : node.entrySet()) {
                System.out.println(i + "->" + entry.getValue() + ":" + entry.getKey());
            }
        }
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        int patternsCount = scanner.nextInt();
        String[] patterns = new String[patternsCount];
        for (int i = 0; i < patternsCount; ++i) {
            patterns[i] = scanner.next();
        }
        List<Map<Character, Integer>> trie = buildTrie(patterns);
        print(trie);
    }
}
 