package Week5;
import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int ways[] = new int[n+1];
        ways[0] = 0;
        ways[1] = 0;
        for(int i = 2;i<ways.length;i++)
        {
            int op1 = ways[i-1];
            int op2 = Integer.MAX_VALUE;
            int op3 = Integer.MAX_VALUE;
            if(i % 2 == 0)
            {
                op2 = ways[i/2];
            }
            if(i % 3 == 0)
            {
                op3 = ways[i/3];
            }
            ways[i] = Math.min(op1, Math.min(op2, op3)) + 1;
        }
        int i = n;
        while (i >= 1) {
            sequence.add(i);
            if (i % 2 == 0 && ways[i/2] + 1 == ways[i]) {  //if a number like 12 is divisible by both 2 and 3 by dividing by 2 we get 6 and by dividing by 3 we get 4 suppose that on ways[4] -> 2 steps are there to make 4 and on ways of 6 suppose 3 steps are there to make 6 now if we don't check if ways[12/3] + 1 == ways[12] means previous subproblem + 1 is not equal to current problem then we might reduce i to 6 by dividing by 2 and add 2 in arraylist but our minimum was computed with the help of subproblem 4 so we check thaby adding one in our subproblem we make min steps for current problem or not 
                i /= 2;
            } else if (i % 3 == 0 && ways[i/3] + 1 == ways[i]) {
                i /= 3;
            } else {
                i -= 1;
            }
        }
        Collections.reverse(sequence); //reverse the order of element to specified list
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
