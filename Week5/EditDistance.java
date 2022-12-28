package Week5;
import java.util.*;

public class EditDistance {
  public static int EditDistanceDp(String s, String t) {
        int s1 = s.length();
        int s2 = t.length();
        int DP[][] = new int[s1+1][s2+1];
        for(int j = 0;j<=s2;j++)
        {
            DP[0][j] = j; 
        }
        for(int i = 0;i<=s1;i++)
        {
            DP[i][0] = i;
        }
        for(int i = 1;i<=s1;i++)
        {
            for(int j = 1;j<=s2;j++)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                {
                    DP[i][j] = DP[i-1][j-1];
                }
                else 
                {
                    DP[i][j] = 1 + Math.min(DP[i-1][j-1],Math.min(DP[i][j-1], DP[i-1][j]));
                }
            }
        }
        return DP[s1][s2];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistanceDp(s, t));
  }

}
