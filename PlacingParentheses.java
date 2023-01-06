import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
       char ch[] = exp.toCharArray();

       char sign[] = new char[ch.length/2];
       int numrows = (ch.length/2) + 1;
       int numcols = (ch.length/2) + 1;
       long minbox[][] = new long[numrows][numcols];
       long maxbox[][] = new long[numrows][numcols];
       int getdigit = 0;
       for(int i = 0;i<numrows;i++)
       {
            char c = ch[getdigit];
            minbox[i][i] = Character.getNumericValue(c);
            maxbox[i][i] = Character.getNumericValue(c);  
            getdigit = getdigit+2;
       }
       int getsign = 1;
       for(int i = 0;getsign<ch.length;i++)
       {
          sign[i] = ch[getsign];
          getsign += 2;  
       }
       for(int e = 1;e < numrows;e++)
       {
          for(int f = 0;f<numrows-e;f++)
          {
             int j = e + f;
             long bigsmall[] = FindMinandMax(f,j,sign,minbox,maxbox);
             maxbox[f][j] = bigsmall[0];
             minbox[f][j] = bigsmall[1];
          }
       }
       return maxbox[0][numrows-1];
    }

    private static long[] FindMinandMax(int f, int j, char[] sign, long[][] minbox, long[][] maxbox) {
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        for(int z = f;z<j;z++)
        {
            long op1 = eval(maxbox[f][z], maxbox[z+1][j], sign[z]);
            long op2 = eval(maxbox[f][z], minbox[z+1][j], sign[z]);
            long op3 = eval(minbox[f][z], maxbox[z+1][j], sign[z]);
            long op4 = eval(minbox[f][z], minbox[z+1][j], sign[z]);
            max =  Math.max(max,Math.max(op1,Math.max(op2, Math.max(op3, op4))));
            min = Math.min(min,Math.min(op1,Math.min(op2, Math.min(op3, op4))));
        }
        return new long[] {max,min}; 
    }
    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}


