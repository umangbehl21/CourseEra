import java.util.*;
public class CarFueling {
    //PROBLEM STATEMENT
/*Suppose a person is making a travel plan driving from city 1 to city n, where n>1. Following a route that will go
*through cities 2 through n-1 in between. The person knows the mileages between two adjacent cities and knows how
*many miles a full tank of gasoline can travel. Based on this information, the problem is to minimize the number of
*many miles a full tank of gasoline can travel. Based on this information, the problem is to minimize the number of 
stops for filling up the gas tank, assuming there is exactly one gas station in each of the cities.*/

//ALGORITHM USED:

/*find_gas_stops(): current position = start position; while (current position < end position) compute the position 
at which car will run out of gas.
 if (that position < end position) then find closest gas station before reaching that position. 
 output fill up gas at that gas station. 
current position = that gas station location else current position = end position;  reached */

//EXPLANATION
/*nput: A car which can travel at most L kms with full tank, a source point A, a destination point B and n gas station 
at distances x1, x2, x3.. xn in kms from A along the path from A to B.
Output: The minimum number of refills to get from A to B, besides refill at A. 
This program has loop nested within another loop. So it seems to have O(n*n) run-time.
But, the run time of the program is O(n) as • 
CurrentRefills can be at most n+1(one-by-one) • numRefills can be at most n(one-by-one) • So, there will be at most n+1 operations • O(n+1) => O(n)*/

   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int destination = sc.nextInt();
    int FuelCapacity = sc.nextInt();
    int n = sc.nextInt();
    int stops[] = new int[n+2]; //as we have added the inital source and destination the size of array increased by 2
    stops[0] = 0; //initial source at which tank was full 
    stops[stops.length-1] = destination;
    for(int i = 1 ;i<stops.length-1;i++) // adding elements from 1st index as initial source is on the 0th index and adding till the second last index of the stops as on the last destination is added 
    {
        stops[i] = sc.nextInt();
    }
    int tn = stops.length-1;  //tn is made because we take the next element of array and subtract it from last refill so if array have 6 length we should stop at 4 to prevent index out of bound if we stop at 5 then loop will tray to acces index 6 which is not present
    int findrefill = 0;
    int lastrefill = 0;
    int numberOfRefill = 0;
    boolean flag = false;
    while(findrefill < tn)
    {
        lastrefill = findrefill;
        while(findrefill < tn && stops[findrefill + 1] - stops[lastrefill] <= FuelCapacity)
        {
            findrefill = findrefill + 1;
        }
        if(findrefill == lastrefill)
        {
            flag = true;
            break;
        }
        if(findrefill < tn)
        {
            numberOfRefill +=1;
        }

    }
    if(flag == true)
    {
        System.out.println(-1);
    }
    else 
    {
        System.out.println(numberOfRefill);
    }

   }
}
