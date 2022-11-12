package Week2;
import java.util.*;
public class GCD 
{
  private static long gcd_opt(int a, int b) {  //by euclidian algorithm proved in notes 
     if(b == 0)
     {
        return a;
     }
    return gcd_opt(b, a % b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    if(a > b)
    System.out.println(gcd_opt(a, b));
    else 
    System.out.println(gcd_opt(b, a));
  }
}

    
