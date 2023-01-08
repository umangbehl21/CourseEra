package Course2.week1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

public class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        boolean flag = false;
        boolean empty = false;
        int emptycl = 0;
        int clpos = 0;
        Stack<Bracket> stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            Bracket b1 = new Bracket(next, position);
            if (next == '(' || next == '[' || next == '{') {
                stack.add(b1);
            }

            if (next == ')' || next == ']' || next == '}') {
                if(stack.isEmpty())
                {
                   emptycl = position;
                   empty = true;
                   break;
                }
                else 
                {
                Bracket b2 = stack.pop();
                if(b2.type == '(' && next != ')' || b2.type == '{' && next != '}' ||b2.type == '[' && next != ']')
                {
                    flag = true;
                    clpos = position;
                    break;
                }
            }
        }
        }
        if(empty == true)
        {
            System.out.println(emptycl + 1);
        }
        else if(flag == true)
        {
            System.out.println(clpos + 1);
        }
        else if(!stack.isEmpty())
        {
            Bracket b = stack.pop();
            System.out.println(b.position + 1);
        }
        else 
        {
            System.out.println("Success");
        }
        // Printing answer, write your code here
    }
}

