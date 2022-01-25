package arrayPractice;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedExpressionsCheck {
    public static void main(String[] args){
        String [] arr={"{(a},b)","{)(a,b}","{(a,b)}"};
        for(String s: braces(arr)){
            System.out.println(s);
        }
    }

    static String[] braces(String[] values) {
        String[] result = new String[values.length];
        for(int i=0;i<values.length;i++){
            result[i] = calculate(values[i]);
        }
        return result;

    }

    static String calculate(String expr){
        Deque<Character> stack
                = new ArrayDeque<>();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // IF current current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return "NO";
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return "NO";
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return "NO";
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return "NO";
                    break;
            }
        }

        if(stack.isEmpty()){
            return "YES";
        }else{
            return "NO";
        }

    }
}
