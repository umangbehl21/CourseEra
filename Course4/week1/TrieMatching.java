package Course4.week1;
import java.io.*;
import java.util.*;

class Node
{
	public static final int Letters =  4;
	public static final int NA = -1;
	public int next [];

	Node ()
	{
		next = new int [Letters];
		Arrays.fill (next, NA);
	}
	public boolean isleaf()
	{
		for(int i = 0;i<next.length;i++)
		{
			if(next[i] != NA)
			{
				return false;
			}
		}
		return true;
	}
}

public class TrieMatching implements Runnable {
	int letterToIndex (char letter)
	{
		switch (letter)
		{
			case 'A': return 0;
			case 'C': return 1;
			case 'G': return 2;
			case 'T': return 3;
			default: assert (false); return Node.NA;
		}
	}

	List <Integer> solve (String text, int n, List <String> patterns) {
		List <Integer> result = new ArrayList <Integer> ();

	    int idx = 0;
		List<Node> trie = buildtriehelper(patterns.toArray(new String[0])); //converting list to array string[0] don't means it will have 0th index its index will be equal to the number of index of list
		while(!text.isEmpty())
		{
			if(triematching(text,trie))
			{
				result.add(idx);
			}
			text = text.substring(1);
			idx++;
		}

		return result;
	}

	private boolean triematching(String text, List<Node> trie) {
		int i = 0; //used to travel over pattern is incremented when a character of pattern matches with text then it is incremented to check next one
		char curch = text.charAt(0);
		Node curNode = trie.get(0); //root node
		while(true)
		{
			int idx = curNode.next[letterToIndex(curch)];
			if(curNode.isleaf())
			{
				return true;
			}
			else if(curNode.next[letterToIndex(curch)] != Node.NA)
			{
				curNode = trie.get(idx);
				if(i + 1 < text.length())
				{
					curch = text.charAt(++i);
				}
				else 
				{
					return curNode.isleaf();
				}
			}
			else 
			{
				return false;
			}
		}
	}

	private List<Node> buildtriehelper(String[] patterns) {
		List<Node> trie = new ArrayList<Node>();
		Node root = new Node();
		trie.add(root);
		for(String pattern : patterns)
		{
			Node currNode = root;
			for(int i = 0;i<pattern.length();i++)
			{
			  char curch = pattern.charAt(i);
			  int idx = currNode.next[letterToIndex(curch)];
			  if(idx != Node.NA)  //if already that character is attached to root or present in the trie
			  {
				currNode = trie.get(idx);
			  }
			  else 
			  {
				Node newnode = new Node();
				trie.add(newnode);
				currNode.next[letterToIndex(curch)] = trie.size() - 1;
				currNode = newnode; 
			  }


			}

		}
		return trie;

	}

	public void run () {
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
			String text = in.readLine ();
		 	int n = Integer.parseInt (in.readLine ());
		 	List <String> patterns = new ArrayList <String> ();
			for (int i = 0; i < n; i++) {
				patterns.add (in.readLine ());
			}

			List <Integer> ans = solve (text, n, patterns);

			for (int j = 0; j < ans.size (); j++) {
				System.out.print ("" + ans.get (j));
				System.out.print (j + 1 < ans.size () ? " " : "\n");
			}
		}
		catch (Throwable e) {
			e.printStackTrace ();
			System.exit (1);
		}
	}

	public static void main (String [] args) {
		new Thread (new TrieMatching()).start ();
	}
}
