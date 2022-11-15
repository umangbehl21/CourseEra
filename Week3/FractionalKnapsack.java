package Week3;

import java.util.*;

public class FractionalKnapsack {
    static class pair implements Comparable<pair>
    {
        int value = 0;
        int weight = 0;
        double rpw = 0;
        pair(int value,int weight,double rpw)
        {
            this.value = value;
            this.weight = weight;
            this.rpw = rpw;
        }
        @Override
        public int compareTo(pair p1) {
            if(this.rpw > p1.rpw)
            {
                return -1;
            }
            else if(this.rpw < p1.rpw)
            {
                return 1;
            }
            else 
            {
                return 0;
            }
        }

    }
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i = 0;i<values.length;i++)
        {
            double rpw = (values[i] * 1.0)/weights[i];
            pair p1 = new pair(values[i], weights[i],rpw);
            pq.add(p1);
        } 
           
           int j = 0;
        while(!pq.isEmpty())
        {
            values[j] = pq.peek().value;
            weights[j] = pq.peek().weight;
            pq.remove();
            j++;  
        }
        for(int i = 0;i<values.length;i++)
        {
            if(weights[i] <= capacity)
            {
                value += values[i];
                capacity = capacity - weights[i];
            }
            else 
            {
                if(capacity <= 0) break;
                
                value += values[i] * (double)capacity/(weights[i] * 1.0);
                capacity = capacity - weights[i];
                // capacity = 0;
                // break;
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
       System.out.println(getOptimalValue(capacity, values, weights));
    }
} 

