package Week2;



import java.util.Scanner;

public class NthFibNum {
      private static long calc_fib(int n) {
        int arr[] = new int[n + 1]; //for 4th fibonnaci number we need the 4th index if i give 4 storage then 3rd index will be the last 
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2;i<arr.length;i++)
        {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
        }
    
      public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n == 0 || n == 1)
        {
          System.out.println(n);
        }
        else
        {
        System.out.println(calc_fib(n));
        }
      }
    }
    
