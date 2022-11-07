
import java.util.*;

public class StressTesting {  //by this type of technique we genrate random testcase to compare two solutions for the same problem and detect any type of failure in wrong test case
    public static long FastMaximumPairwise(ArrayList<Integer> arr)
    {
        long fmax = Integer.MIN_VALUE;
        long smax = Integer.MIN_VALUE;
        for(int i = 0;i<arr.size();i++)
        {
           if(arr.get(i) >= fmax) //if there are duplicate elements in array like 7,6,7 then fmax will be 7 but smax will be 6 which creates wrong answer inserting = to we ensure that the same number is again assigned as first max and previous same number will be then assigned to the second max you can remove = to see the wrong result or the difference in the result between the slow and the fast solution 
           {
            smax = fmax;
            fmax = arr.get(i);
           } 
           if(arr.get(i) > smax && arr.get(i) < fmax)
           {
              smax = arr.get(i);
           }
        }
        return (long)smax * fmax;
    }
    public static long SlowMaximumPairwise(ArrayList<Integer> arr)
    {
        int n = arr.size();
        long max = 0;
        for(int i = 0;i<n;i++)
        {
            for(int j = i+1;j<n;j++)
            {
                long pr = (long)arr.get(i) * arr.get(j);
                if(pr > max)
                {
                    max = pr;
                }
            }
            
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random(); //An instance of this class is used to generate a stream of pseudo-random numbers. 
        int upperbound = Integer.MAX_VALUE;
        while(true)
        {
            long n = (((rand.nextInt(upperbound))%10) + 2); //rand.nextInt(upperlimit) is the function that generates pseudo random numbers from starting limit 0 till the ending limit or upperbound specified in the round braces by doing modulus with 1000 remainder or random number will be less than 1000 for example 999 % 1000 will be 999 which gives us larger test cases  on the other hand if we want to generate smaller test casee we modulus with % 10 example 999 % 10 will be 9 so we get larger test case if modulus increases from tens place to thousands  
            System.out.println("n"+n);  //total numbers in ArrayList will be equal to 1 
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i < n;i++)
            {
                arr.add((rand.nextInt(upperbound)) % 10); //adding random numbers in the arraylist 
            }
            for(int i = 0;i<n;i++)
            {
                System.out.print(arr.get(i)+" ");
            }
            long res1 = SlowMaximumPairwise(arr);
            long res2 = FastMaximumPairwise(arr);
            if(res1 != res2)  //if the result of the above burtte force solution and optimal solution does'nt match means there is some mistak in one of them dry run for that test case and compare your own calculated answer and check which solution is giving correct
            {
                System.out.println("wrong answer"+" "+ res1+" "+res2+" ");
                break;
            }
            else 
            {
                System.out.println("ok");
            }
        }
    
    }

}
