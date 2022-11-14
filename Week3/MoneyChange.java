package Week3;
import java.util.*;
public class MoneyChange {  //represent an amount with the denominations of coins example $10 and denominations to make it are 5 , 6 , 1 these are the coins which can be used and there are unlimited availability of these coins
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //1,5,10
        int count = 0;
        while(n > 0)
        {
            if(n >=10)
            {
                n = n-10;
                count++;
            }
            else if(n >=5)
            {
                n = n-5;
                count++;
            }
            else 
            {
                n = n-1;
                count++;
            }
        }
        System.out.println(count);

    }
}
