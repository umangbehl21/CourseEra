package Course2.week1;
import java.util.*;
import java.io.*;

public class StackWithMax {

   static class duo
    {
        int max = 0;
        int val = 0;
        duo(int max,int val)
        {
            this.max = max;
            this.val = val;
        }
    }
    static Stack<duo> stack1 = new Stack<>();
    public static void add(int val)
    {
        if(stack1.isEmpty())
        {
             int max = val;
             int v = val;
             duo d = new duo(max, v);
             stack1.add(d);
        }
        else 
        {
            int v = val;
            int max = Math.max(stack1.peek().max, v);
            duo d = new duo(max, v);
            stack1.add(d);
        }
    }
    public static int max()
    {
        if(stack1.isEmpty())
        {
            return -1;
        }
        return stack1.peek().max;
    }
    public static void pop()
    {
        if(stack1.isEmpty())
        {
            return;
        }
        stack1.pop();
    }
    
    static public void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        for (int qi = 0; qi < queries; ++qi) {
            String operation = sc.next();
            if ("push".equals(operation)) {
                int value = sc.nextInt();
                add(value);
            } else if ("pop".equals(operation)) {
                pop();
            } else if ("max".equals(operation)) {
                System.out.println(max());
            }
        }
    }
}
