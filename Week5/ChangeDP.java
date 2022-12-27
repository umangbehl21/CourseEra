package Week5;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int ways[] = new int[m+1];
        int coins[] = new int[3];
        ways[0]= 0;
        coins[0] = 1;
        coins[1] = 3;
        coins[2] = 4;
        for(int i = 1;i<ways.length;i++)
        {
            int min = Integer.MAX_VALUE;
            for(int coin : coins)
            {
                if(coin <= i)
                {
                    if(ways[i-coin] < min)
                    {
                        min = ways[i-coin];
                    }
                }
            }
            ways[i] = min + 1; 
        }
        return ways[m];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

