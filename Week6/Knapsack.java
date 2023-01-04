package Week6;
import java.util.*;

public class Knapsack {
    static int optimalWeight(int Total, int[] Quantity) {   //total is the total capacity of bag and quantity is the array having number of items 
        int storage[][] = new int[Quantity.length + 1][Total + 1]; //on rows we keep the record of the num of quantity and on column we keep record of weight till a particular index 
        for(int j = 0;j<=Total;j++)
        {
            storage[0][j] = 0;
        }
        for(int i = 0;i<= Quantity.length;i++)
        {
            storage[i][0] = 0;
        }
        for(int i = 1;i<storage.length;i++)
        {
            for(int j = 1;j<storage[0].length;j++)
            {
                if(j >= Quantity[i-1])
                {
                    int first = storage[i-1][j];
                    int second = Quantity[i-1] + storage[i-1][j-Quantity[i-1]]; //current quantity + if some weight is left along with few items then also add that in current loot for i,j or number of gold,weight 
                    storage[i][j] = Math.max(first, second);
                }
                else 
                {
                    storage[i][j] = storage[i-1][j]; 
                }
            }
        }
        return storage[Quantity.length][Total];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Total, n;
        Total = scanner.nextInt();
        n = scanner.nextInt();
        int[] quantity = new int[n];
        for (int i = 0; i < n; i++) {
            quantity[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(Total, quantity));
    }
}

