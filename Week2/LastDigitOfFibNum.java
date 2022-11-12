package Week2;
import java.util.*;
public class LastDigitOfFibNum {
    
    private static long getFibonacciLastDigitNaive(int n) {
        long arr[] = new long[n+1]; 
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2;i<arr.length;i++)
        {
            arr[i] = (arr[i-1] + arr[i-2]) % 10;  //we are not storing the complete number after addition but we are storing the last digit of it only 
        }
        return arr[n] % 10; 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 1 || n == 0)
        {
            System.out.println(n);
        }
        else 
        {
        long c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
        }
    }

}
