package Week2;
import java.util.Scanner;

public class LCM 
{  //LCM can be computed with help of gcd as their relation is lcm(a,b) * gcd(a,b) = a*b so if gcd can be calculated lcm will be lcm(a,b) = a*b/gcd(a,b) proved in notes 
  
    
  private static long lcm_opt(int a, int b) {
    if(b == 0)
    {
        return a;
    }
    return lcm_opt(b, a % b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

     long gcd = lcm_opt(a, b);
    //  System.out.println((a*b)/gcd);
     long prd = (long)a * b;  //while multiplying number can be out of boumds of the integer range so calculate in long by type casting and storing in it
     System.out.println(prd/gcd);

  }

    
}
